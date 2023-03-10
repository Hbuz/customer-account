package com.marco.customeraccount.controller;

import com.marco.customeraccount.dto.CustomerDTO;
import com.marco.customeraccount.exception.NotFoundException;
import com.marco.customeraccount.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.*;

/**
 * Controller to handle customer information
 */
@RestController("CustomerController")
@RequestMapping(path = "/api/v1/customers")
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> fetchCustomerInfo(@PathVariable("id") Long id) {
        LOGGER.debug("fetchCustomerInfo - id:{}", id);

        try {
            CustomerDTO response = customerService.fetchCustomerInfo(id);

            return ok(response);

        } catch (NotFoundException e) {
            LOGGER.error("Failed fetchCustomerInfo request. Message:{}", e.getMessage());
            return notFound().build();

        } catch (Exception e) {
            LOGGER.error("Failed fetchCustomerInfo request. Message:{}", e.getMessage());
            return internalServerError().build();

        }
    }
}
