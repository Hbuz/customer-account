package com.marco.customeraccount.service;

import com.marco.customeraccount.dto.UserDTO;
import com.marco.customeraccount.exception.NotFoundException;
import com.marco.customeraccount.model.User;
import com.marco.customeraccount.repository.UserRepository;
import com.marco.customeraccount.util.ObjectSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    private final ObjectSerializer objectSerializer;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ObjectSerializer objectSerializer) {
        this.userRepository = userRepository;
        this.objectSerializer = objectSerializer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDTO fetchUserInfo(String customerID) {

        Optional<User> userOpt = userRepository.findByCustomerID(customerID);
        if (userOpt.isPresent()) {

            LOGGER.debug("User found: {} {}", userOpt.get().getName(), userOpt.get().getSurname());

            return objectSerializer.toUserDTO(userOpt.get());
        }
        throw new NotFoundException();
    }
}
