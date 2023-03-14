package com.marco.customeraccount.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * The customer entity model representing the related DB table
 */
@Data
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

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private List<Account> accounts;
}

