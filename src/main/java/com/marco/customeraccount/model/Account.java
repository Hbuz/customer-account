package com.marco.customeraccount.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * The account entity model representing the related DB table
 */
@Data
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number")
    @NotNull
    private String accountNumber;

    @Column(name = "balance")
    @NotNull
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private List<Transaction> transactions;
}
