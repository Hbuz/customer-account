package com.marco.customeraccount.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The customer DTO
 */
@Getter
@Setter
@AllArgsConstructor
public class CustomerDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;
}