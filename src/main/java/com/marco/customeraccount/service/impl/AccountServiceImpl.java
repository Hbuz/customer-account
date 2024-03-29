package com.marco.customeraccount.service.impl;

import com.marco.customeraccount.dto.AccountDTO;
import com.marco.customeraccount.dto.TransactionDTO;
import com.marco.customeraccount.dto.request.AccountReqDTO;
import com.marco.customeraccount.exception.CustomerNotFoundException;
import com.marco.customeraccount.exception.ValueNotValidException;
import com.marco.customeraccount.model.Account;
import com.marco.customeraccount.model.Customer;
import com.marco.customeraccount.repository.AccountRepository;
import com.marco.customeraccount.repository.CustomerRepository;
import com.marco.customeraccount.service.AccountService;
import com.marco.customeraccount.service.TransactionService;
import com.marco.customeraccount.util.AccountUtils;
import com.marco.customeraccount.util.ObjectSerializer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    static final String INIT_TRANS_DESC = "initial credit";

    private final AccountRepository accountRepository;

    private final Validator validator;

    private final CustomerRepository customerRepository;

    private final TransactionService transactionService;

    private final ObjectSerializer objectSerializer;

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountDTO openAccount(AccountReqDTO accountReqDTO) {

        LOGGER.debug("openAccount - accountReqDTO:{}", accountReqDTO);

        if (accountReqDTO == null) {
            throw new ValueNotValidException();
        }

        Set<ConstraintViolation<AccountReqDTO>> violations = validator.validate(accountReqDTO);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<AccountReqDTO> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }

            throw new ConstraintViolationException("Error occurred: " + sb, violations);
        }

        Optional<Customer> customerOpt = customerRepository.findById(accountReqDTO.getCustomerId());
        if (customerOpt.isPresent()) {

            Account account = new Account();
            account.setCustomer(customerOpt.get());
            account.setAccountNumber(AccountUtils.accountNumberGenerator());
            account.setBalance(accountReqDTO.getInitialCredit());
            account = accountRepository.save(account);

            List<TransactionDTO> transactionDTOs = new ArrayList<>();
            if (accountReqDTO.getInitialCredit() != null &&
                    accountReqDTO.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {

                transactionDTOs.add(transactionService.sendTransaction(account,
                        accountReqDTO.getInitialCredit(), INIT_TRANS_DESC));
            }

            AccountDTO accountDTO = objectSerializer.toAccountDTO(account);
            accountDTO.setTransactions(transactionDTOs);

            return accountDTO;
        }

        throw new CustomerNotFoundException(accountReqDTO.getCustomerId());
    }
}
