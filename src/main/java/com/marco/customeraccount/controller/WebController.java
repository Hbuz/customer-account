package com.marco.customeraccount.controller;

import com.marco.customeraccount.dto.CustomerDTO;
import com.marco.customeraccount.dto.TransactionDTO;
import com.marco.customeraccount.dto.request.AccountReqDTO;
import com.marco.customeraccount.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/web")
public class WebController {

    private final CustomerService customerService;

    private final AccountController accountController;

    @GetMapping
        public String welcomePage() {
        return "welcome";
    }

    @GetMapping ("/customers")
    public String showAllCustomers(Model model){
        List<CustomerDTO> customers = customerService.fetchAll();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @GetMapping("/customers/{id}")
    public String showCustomerInfo(Model model, @PathVariable Long id) {
        CustomerDTO customerInfo = customerService.fetchCustomerInfo(id);

        List<TransactionDTO> transactions = new ArrayList<>();

        customerInfo.getAccounts().forEach((account -> account.getTransactions()
                .forEach(transaction -> transactions.add(
                        TransactionDTO.builder()
                                .amount(transaction.getAmount())
                                .build()))));

        model.addAttribute("customerId", id);
        model.addAttribute("customerName", customerInfo.getName());
        model.addAttribute("customerSurname", customerInfo.getSurname());
        model.addAttribute("accounts", customerInfo.getAccounts());
        model.addAttribute("transactions", transactions);
        return "customerInfo";
    }

    @PostMapping("/accounts")
    public String openAccount(@ModelAttribute("accountReqDTO") AccountReqDTO accountReqDTO) {
        accountController.openAccount(accountReqDTO);
        return "redirect:/web/customers/" + accountReqDTO.getCustomerID();
    }
}
