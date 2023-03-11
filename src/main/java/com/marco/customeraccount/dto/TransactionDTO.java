package com.marco.customeraccount.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class TransactionDTO {

    @JsonProperty("amount")
    private BigDecimal amount;
}
