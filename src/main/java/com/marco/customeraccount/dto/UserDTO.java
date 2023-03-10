package com.marco.customeraccount.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The user DTO
 */
@Getter
@Setter
@AllArgsConstructor
public class UserDTO {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("customer_id")
    private String customerID;
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
}