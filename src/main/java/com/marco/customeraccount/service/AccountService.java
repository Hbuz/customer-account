package com.marco.customeraccount.service;

import com.marco.customeraccount.dto.AccountDTO;
import com.marco.customeraccount.dto.request.AccountReqDTO;

/**
 * Account services
 *
 */
public interface AccountService {

    /**
     * Service to open an account
     *
     * @param accountReqDTO The customer information to open the account
     * @return the created account
     */
    AccountDTO openAccount(AccountReqDTO accountReqDTO);
}
