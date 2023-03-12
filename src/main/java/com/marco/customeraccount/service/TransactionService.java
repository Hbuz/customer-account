package com.marco.customeraccount.service;

import com.marco.customeraccount.dto.TransactionDTO;
import com.marco.customeraccount.model.Account;

import java.math.BigDecimal;

public interface TransactionService {

    /**
     * Service to send a transaction
     *
     * @param account     The customer account
     * @param amount      The transaction amount
     * @param description The transaction description
     * @return The transaction sent
     */
    TransactionDTO sendTransaction(Account account, BigDecimal amount, String description);

}
