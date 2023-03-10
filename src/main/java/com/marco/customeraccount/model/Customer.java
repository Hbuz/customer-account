package com.marco.customeraccount.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * The customer entity model representing the related DB table
 */
@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    // accounts
}

