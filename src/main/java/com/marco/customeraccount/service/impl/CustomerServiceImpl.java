package com.marco.customeraccount.service.impl;

import com.marco.customeraccount.dto.AccountDTO;
import com.marco.customeraccount.dto.CustomerDTO;
import com.marco.customeraccount.dto.TransactionDTO;
import com.marco.customeraccount.exception.NotFoundException;
import com.marco.customeraccount.exception.ValueNotValidException;
import com.marco.customeraccount.model.Account;
import com.marco.customeraccount.model.Customer;
import com.marco.customeraccount.model.Transaction;
import com.marco.customeraccount.repository.AccountRepository;
import com.marco.customeraccount.repository.CustomerRepository;
import com.marco.customeraccount.repository.TransactionRepository;
import com.marco.customeraccount.service.CustomerService;
import com.marco.customeraccount.util.ObjectSerializer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    private final ObjectSerializer objectSerializer;


    /**
     * {@inheritDoc}
     */
    @Override
    public CustomerDTO fetchCustomerInfo(Long id) {

        LOGGER.debug("fetchCustomerInfo - id:{}", id);

        if (id == null || id == 0) {
            throw new ValueNotValidException();
        }

        Optional<Customer> customerOpt = customerRepository.findById(id);
        if (customerOpt.isPresent()) {

            List<AccountDTO> accountDTOS = new ArrayList<>();
            List<TransactionDTO> transactionDTOS;

            List<Account> accounts = accountRepository.findAccountsByCustomerId(id).orElse(new ArrayList<>());
            for(Account account: accounts) {

                transactionDTOS = new ArrayList<>();

                List<Transaction> transactions = transactionRepository.findTransactionsByAccountId(account.getId())
                        .orElse(new ArrayList<>());

                for(Transaction transaction: transactions) {
                    transactionDTOS.add(objectSerializer.toTransactionDTO(transaction));
                }

                AccountDTO accountDTO = objectSerializer.toAccountDTO(account);
                accountDTO.setTransactions(transactionDTOS);
                accountDTOS.add(accountDTO);
            }

            LOGGER.debug("Customer found: {} {}", customerOpt.get().getName(), customerOpt.get().getSurname());

            CustomerDTO customerDTO = objectSerializer.toCustomerDTO(customerOpt.get());
            customerDTO.setAccounts(accountDTOS);

            return customerDTO;
        }

        throw new NotFoundException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CustomerDTO> fetchAllCustomers(){
        List<CustomerDTO> customerDTOS = new ArrayList<>();

        List<Customer> customers = customerRepository.findAll();
        customers.forEach(customer -> customerDTOS.add(objectSerializer.toCustomerDTO(customer)));

        return customerDTOS;
    }
}
