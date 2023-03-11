package com.marco.customeraccount.repository;

import com.marco.customeraccount.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The account repository used to interact with the related DB table
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<List<Account>> findAccountsByCustomerId(Long customerId);
}
