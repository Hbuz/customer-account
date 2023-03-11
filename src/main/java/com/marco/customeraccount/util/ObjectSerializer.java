package com.marco.customeraccount.util;

import com.marco.customeraccount.dto.AccountDTO;
import com.marco.customeraccount.dto.CustomerDTO;
import com.marco.customeraccount.dto.TransactionDTO;
import com.marco.customeraccount.model.Account;
import com.marco.customeraccount.model.Customer;
import com.marco.customeraccount.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class ObjectSerializer {

    public CustomerDTO toCustomerDTO(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getSurname()
        );
    }

    public AccountDTO toAccountDTO(Account account) {
        return AccountDTO.builder()
                .customer(account.getCustomer())
                .balance(account.getBalance())
                .build();
    }

    public TransactionDTO toTransactionDTO(Transaction transaction) {
        return new TransactionDTO(
                transaction.getId(),
                transaction.getAmount()
        );
    }
}