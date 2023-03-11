package com.marco.customeraccount.controller;

import com.marco.customeraccount.dto.AccountDTO;
import com.marco.customeraccount.dto.request.AccountReqDTO;
import com.marco.customeraccount.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController("AccountController")
@RequestMapping(path = "/api/v1/accounts")
public class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDTO> openAccount(@RequestBody AccountReqDTO accountReqDTO) {
        LOGGER.debug("openAccount - accountReqDTO:{}", accountReqDTO);

        AccountDTO response = accountService.openAccount(accountReqDTO);

        return ok(response);
    }

}
