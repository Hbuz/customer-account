package com.marco.customeraccount.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * The customer DTO
 */
@Data
@Builder
public class CustomerDTO {

    @JsonIgnore
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("accounts")
    private List<AccountDTO> accounts;
}