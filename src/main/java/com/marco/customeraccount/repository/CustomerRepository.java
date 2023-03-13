package com.marco.customeraccount.repository;

import com.marco.customeraccount.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The customer repository used to interact with the related DB table
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}