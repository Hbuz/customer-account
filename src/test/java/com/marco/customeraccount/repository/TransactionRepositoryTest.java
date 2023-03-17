package com.marco.customeraccount.repository;

import com.marco.customeraccount.model.Transaction;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@WebAppConfiguration
@Transactional
public class TransactionRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TransactionRepository transactionRepository;

    private Transaction transaction1;

    @BeforeEach
    public void setUp() {
        transaction1 = new Transaction();
        transaction1.setTransactionNumber("test transaction number");
        transaction1.setAmount(BigDecimal.TEN);
        transaction1.setRecipient("test recipient");
        transaction1.setDescription("test description");
    }

    @Test
    public void whenStoreTransaction_thenReturnTransaction() {

        entityManager.persist(transaction1);
        entityManager.flush();

        Transaction stored = transactionRepository.save(transaction1);

        Assert.assertNotNull(stored);
        Assert.assertEquals(stored.getTransactionNumber(), transaction1.getTransactionNumber());
    }
}
