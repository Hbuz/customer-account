package com.marco.customeraccount.service;

import com.marco.customeraccount.dto.CustomerDTO;
import com.marco.customeraccount.exception.NotFoundException;
import com.marco.customeraccount.model.Customer;
import com.marco.customeraccount.repository.CustomerRepository;
import com.marco.customeraccount.util.ObjectSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final CustomerRepository customerRepository;

    private final ObjectSerializer objectSerializer;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ObjectSerializer objectSerializer) {
        this.customerRepository = customerRepository;
        this.objectSerializer = objectSerializer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomerDTO fetchCustomerInfo(Long id) {

        Optional<Customer> customerOpt = customerRepository.findById(id);
        if (customerOpt.isPresent()) {

            LOGGER.debug("Customer found: {} {}", customerOpt.get().getName(), customerOpt.get().getSurname());

            return objectSerializer.toCustomerDTO(customerOpt.get());
        }
        throw new NotFoundException();
    }
}
