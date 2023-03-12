package com.marco.customeraccount.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * The account request DTO containing the user information
 */
@Getter
@Setter
@Builder
public class AccountReqDTO {

    @JsonProperty("customer_id")
    private Long customerId;

    @JsonProperty("initial_credit")
    private BigDecimal initialCredit;
}
