package com.marco.customeraccount.service;

import com.marco.customeraccount.dto.CustomerDTO;

public interface CustomerService {

    /**
     * Service to fetch customer info
     *
     * @param id The customer ID
     * @return the customer info
     */
    CustomerDTO fetchCustomerInfo(Long id);
}
