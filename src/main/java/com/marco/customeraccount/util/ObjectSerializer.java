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
        return CustomerDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .surname(customer.getSurname())
                .build();
    }

    public AccountDTO toAccountDTO(Account account) {
        return AccountDTO.builder()
                .id(account.getId())
                .balance(account.getBalance())
                .build();
    }

    public TransactionDTO toTransactionDTO(Transaction transaction) {
        return TransactionDTO.builder()
                .amount(transaction.getAmount())
                .build();
    }
}