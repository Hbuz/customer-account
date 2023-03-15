package com.marco.customeraccount.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
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
    @NotEmpty
    private String transactionNumber;

    @Column(name = "amount")
    @PositiveOrZero
    private BigDecimal amount;

    @Column(name = "recipient")
    @NotEmpty
    private String recipient;

    @Column(name = "description")
    @Size(max = 20, message
            = "Description name must max 200 characters")
    private String description;

    @CreationTimestamp
    @Column(name = "sending_date")
    private Instant sendingDate;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
