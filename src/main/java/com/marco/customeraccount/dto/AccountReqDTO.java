package com.marco.customeraccount.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * The account request DTO containing the user information
 */
@Getter
@Setter
public class AccountReqDTO {

    @JsonProperty("customer_id")
    private Long customerID;

    @JsonProperty("initial_credit")
    private BigDecimal initialCredit;
}
