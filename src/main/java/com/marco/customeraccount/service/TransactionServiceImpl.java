package com.marco.customeraccount.service;

import com.marco.customeraccount.dto.TransactionDTO;
import com.marco.customeraccount.model.Account;
import com.marco.customeraccount.model.Transaction;
import com.marco.customeraccount.repository.TransactionRepository;
import com.marco.customeraccount.util.ObjectSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionServiceImpl implements TransactionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final TransactionRepository transactionRepository;

    private final ObjectSerializer objectSerializer;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, ObjectSerializer objectSerializer) {
        this.transactionRepository = transactionRepository;
        this.objectSerializer = objectSerializer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransactionDTO sendTransaction(Account account, BigDecimal amount) {

        LOGGER.debug("sendTransaction - account:{} | amount:{}", account, amount);

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(amount);

        transaction = transactionRepository.save(transaction);

        return objectSerializer.toTransactionDTO(transaction);
    }

}