package com.marco.customeraccount.util;

import com.marco.customeraccount.dto.AccountDTO;
import com.marco.customeraccount.dto.CustomerDTO;
import com.marco.customeraccount.dto.TransactionDTO;
import com.marco.customeraccount.model.Account;
import com.marco.customeraccount.model.Customer;
import com.marco.customeraccount.model.Transaction;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Serializer to convert entities to DTOs
 *
 */
@Component
public class ObjectSerializer {

    private static final String PATTERN_FORMAT = "dd-MM-yyyy HH:mm:ss";

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
                .accountNumber(account.getAccountNumber())
                .balance(account.getBalance())
                .build();
    }

    public TransactionDTO toTransactionDTO(Transaction transaction) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT)
                .withZone(ZoneId.systemDefault());

        return TransactionDTO.builder()
                .transactionNumber(transaction.getTransactionNumber())
                .amount(transaction.getAmount())
                .recipient(transaction.getRecipient())
                .description(transaction.getDescription())
                .sendingDate(formatter.format(transaction.getSendingDate()))
                .build();
    }
}