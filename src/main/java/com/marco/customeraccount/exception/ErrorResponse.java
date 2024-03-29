package com.marco.customeraccount.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private HttpStatus status;

    private String message;

    private List<String> details;

}