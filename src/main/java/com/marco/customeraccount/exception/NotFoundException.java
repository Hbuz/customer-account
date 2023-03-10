package com.marco.customeraccount.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("No customer found");
    }
}