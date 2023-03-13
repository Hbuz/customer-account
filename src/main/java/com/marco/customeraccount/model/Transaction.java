package com.marco.customeraccount.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * The transaction entity model representing the related DB table
 */
@Data
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_number")
    private String transactionNumber;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "recipient")
    private String recipient;

    @Column(name = "description")
    private String description;

    @CreationTimestamp
    @Column(name = "sending_date")
    private Instant sendingDate;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
