package com.marco.customeraccount.service;

import com.marco.customeraccount.dto.CustomerDTO;

public interface CustomerService {

    CustomerDTO fetchCustomerInfo(String customerID);
}
