package com.marco.customeraccount.controller;

import com.marco.customeraccount.dto.UserDTO;
import com.marco.customeraccount.exception.NotFoundException;
import com.marco.customeraccount.service.UserService;
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
 * Controller to handle user information
 */
@RestController("UserController")
@RequestMapping(path = "/users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{customerID}")
    public ResponseEntity<UserDTO> fetchUserInfo(@PathVariable("customerID") String customerID) {
        LOGGER.debug("fetchUserInfo - customerID:{}", customerID);

        try {
            UserDTO response = userService.fetchUserInfo(customerID);

            return ok(response);

        } catch (NotFoundException e) {
            LOGGER.error("Failed fetchUserInfo request. Message:{}", e.getMessage());
            return notFound().build();

        } catch (Exception e) {
            LOGGER.error("Failed fetchUserInfo request. Message:{}", e.getMessage());
            return internalServerError().build();

        }
    }
}
