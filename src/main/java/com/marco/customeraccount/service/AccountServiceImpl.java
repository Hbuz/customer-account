package com.marco.customeraccount.service;

import com.marco.customeraccount.dto.AccountDTO;
import com.marco.customeraccount.dto.AccountReqDTO;
import com.marco.customeraccount.model.Account;
import com.marco.customeraccount.model.Customer;
import com.marco.customeraccount.repository.AccountRepository;
import com.marco.customeraccount.repository.CustomerRepository;
import com.marco.customeraccount.util.ObjectSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final ObjectSerializer objectSerializer;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, CustomerRepository customerRepository,
                              ObjectSerializer objectSerializer) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
        this.objectSerializer = objectSerializer;
    }

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

            return objectSerializer.toAccountDTO(account);
        }

        return new AccountDTO();
    }
}
