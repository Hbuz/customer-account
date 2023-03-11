package com.marco.customeraccount.service;

import com.marco.customeraccount.dto.AccountDTO;
import com.marco.customeraccount.dto.request.AccountReqDTO;
import com.marco.customeraccount.dto.TransactionDTO;
import com.marco.customeraccount.model.Account;
import com.marco.customeraccount.model.Customer;
import com.marco.customeraccount.repository.AccountRepository;
import com.marco.customeraccount.repository.CustomerRepository;
import com.marco.customeraccount.util.ObjectSerializer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    private final TransactionService transactionService;

    private final ObjectSerializer objectSerializer;

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountDTO openAccount(AccountReqDTO accountReqDTO) {

        LOGGER.debug("openAccount - accountReqDTO:{}", accountReqDTO);

        Optional<Customer> customerOpt = customerRepository.findById(accountReqDTO.getCustomerID());
        if (customerOpt.isPresent()) {

            Account account = new Account();
            account.setCustomer(customerOpt.get());
            account.setBalance(accountReqDTO.getInitialCredit());
            account = accountRepository.save(account);

            List<TransactionDTO> transactionDTOs = new ArrayList<>();
            if (accountReqDTO.getInitialCredit() != null &&
                    accountReqDTO.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {

                transactionDTOs.add(transactionService.sendTransaction(account, accountReqDTO.getInitialCredit()));
            }

            AccountDTO accountDTO = objectSerializer.toAccountDTO(account);
            accountDTO.setTransactions(transactionDTOs);

            return accountDTO;
        }

        return AccountDTO.builder().build();
    }
}
