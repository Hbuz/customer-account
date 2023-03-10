package com.marco.customeraccount.util;

import com.marco.customeraccount.dto.UserDTO;
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
}