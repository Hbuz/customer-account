package com.marco.customeraccount.dto;

import com.marco.customeraccount.model.Account;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionReqDTO {

    Account account;

    BigDecimal amount;
}
