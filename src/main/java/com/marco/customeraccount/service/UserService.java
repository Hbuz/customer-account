package com.marco.customeraccount.service;

import com.marco.customeraccount.dto.UserDTO;

public interface UserService {

    UserDTO fetchUserInfo(String customerID);
}
