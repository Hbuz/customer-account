package com.marco.customeraccount.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * The account DTO
 */
@Getter
@Setter
@Builder
public class AccountDTO {

    @JsonIgnore
    private Long id;

    @JsonProperty("account_number")
    private String accountNumber;

    @JsonProperty("balance")
    private BigDecimal balance;

    @JsonProperty("transactions")
    private List<TransactionDTO> transactions;
}
