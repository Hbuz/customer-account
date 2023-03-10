package com.marco.customeraccount.service;

import com.marco.customeraccount.dto.AccountDTO;
import com.marco.customeraccount.dto.AccountReqDTO;

/**
 *
 */
public interface AccountService {

    /**
     * Service to open an account
     *
     * @param accountReqDTO The user information to open the account
     * @return the created account
     */
    AccountDTO openAccount(AccountReqDTO accountReqDTO);
}
