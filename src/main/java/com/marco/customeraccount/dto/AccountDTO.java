package com.marco.customeraccount.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("customer_id")
    private String customerID;

    @JsonProperty("balance")
    private BigDecimal balance;
}
