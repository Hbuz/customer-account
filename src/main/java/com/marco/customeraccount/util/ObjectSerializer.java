package com.marco.customeraccount.util;

import com.marco.customeraccount.dto.AccountDTO;
import com.marco.customeraccount.dto.CustomerDTO;
import com.marco.customeraccount.model.Account;
import com.marco.customeraccount.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class ObjectSerializer {

    public CustomerDTO toCustomerDTO(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getSurname()
        );
    }

    public AccountDTO toAccountDTO(Account account) {
        return new AccountDTO(
                account.getCustomer(),
                account.getBalance()
        );
    }
}