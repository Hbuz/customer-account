package com.marco.customeraccount.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class TransactionDTO {

    @JsonProperty("transaction_number")
    private String transactionNumber;

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("recipient")
    private String recipient;

    @JsonProperty("description")
    private String description;

    @JsonProperty("sending_date")
    private String sendingDate;
}
