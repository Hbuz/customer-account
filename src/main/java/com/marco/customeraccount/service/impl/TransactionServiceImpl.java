package com.marco.customeraccount.service.impl;

import com.marco.customeraccount.dto.TransactionDTO;
import com.marco.customeraccount.model.Account;
import com.marco.customeraccount.model.Transaction;
import com.marco.customeraccount.repository.TransactionRepository;
import com.marco.customeraccount.service.TransactionService;
import com.marco.customeraccount.util.ObjectSerializer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final TransactionRepository transactionRepository;

    private final ObjectSerializer objectSerializer;


    /**
     * {@inheritDoc}
     */
    @Override
    public TransactionDTO sendTransaction(Account account, BigDecimal amount) {

        LOGGER.debug("sendTransaction - account:{} | amount:{}", account, amount);

        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(UUID.randomUUID().toString());
        transaction.setAmount(amount);
//        transaction.setRecipient(account.getAccountNumber());
        transaction.setAccount(account);
        transaction.setDescription("initial credit");

        transaction = transactionRepository.save(transaction);

        return objectSerializer.toTransactionDTO(transaction);
    }
}
