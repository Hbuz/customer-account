package com.marco.customeraccount.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * The user entity model representing the related DB table
 */
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private String customerID;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    // accounts
}

