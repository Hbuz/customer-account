package com.marco.customeraccount.util;

import com.marco.customeraccount.dto.AccountDTO;
import com.marco.customeraccount.dto.UserDTO;
import com.marco.customeraccount.model.Account;
import com.marco.customeraccount.model.User;
import org.springframework.stereotype.Component;

@Component
public class ObjectSerializer {

    public UserDTO toUserDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getCustomerID(),
                user.getName(),
                user.getSurname()
        );
    }

    public AccountDTO toAccountDTO(Account account) {
        return new AccountDTO(
                account.getUser().getCustomerID(),
                account.getBalance()
        );
    }
}