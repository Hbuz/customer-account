package com.marco.customeraccount.repository;

import com.marco.customeraccount.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The transaction repository used to interact with the related DB table
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
