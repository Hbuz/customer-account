package com.marco.customeraccount.repository;

import com.marco.customeraccount.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The user repository used to interact with the related DB table
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
