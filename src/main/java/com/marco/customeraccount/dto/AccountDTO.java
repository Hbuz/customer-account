package com.marco.customeraccount.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marco.customeraccount.model.Customer;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * The account DTO
 */
@Getter
@Setter
@Builder
public class AccountDTO {

    @JsonProperty("customer")
    private Customer customer;

    @JsonProperty("balance")
    private BigDecimal balance;

    @JsonProperty("transactions")
    private List<TransactionDTO> transactions;
}
