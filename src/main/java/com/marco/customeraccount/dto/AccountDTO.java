package com.marco.customeraccount.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marco.customeraccount.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * The account DTO
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    @JsonProperty("customer")
    private Customer customer;

    @JsonProperty("balance")
    private BigDecimal balance;
}
