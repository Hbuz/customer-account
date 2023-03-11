package com.marco.customeraccount.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * The account entity model representing the related DB table
 */
@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "balance")
    @NotNull
    private BigDecimal balance;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private List<Transaction> transactions;
}