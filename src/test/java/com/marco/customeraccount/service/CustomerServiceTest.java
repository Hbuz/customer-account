package com.marco.customeraccount.service;

import com.marco.customeraccount.exception.CustomerNotFoundException;
import com.marco.customeraccount.exception.ValueNotValidException;
import com.marco.customeraccount.model.Account;
import com.marco.customeraccount.model.Customer;
import com.marco.customeraccount.model.Transaction;
import com.marco.customeraccount.repository.CustomerRepository;
import com.marco.customeraccount.service.impl.CustomerServiceImpl;
import com.marco.customeraccount.util.ObjectSerializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;

//    @Mock
//    AccountRepository accountRepository;

//    @Mock
//    TransactionRepository transactionRepository;

    @InjectMocks
    CustomerServiceImpl customerService;

    @Spy
    ObjectSerializer objectSerializer;

    private Customer customer1;
    private Account account1;
    private List<Account> accountList1;
    private Transaction transaction1;
    private List<Transaction> transactionList1;

    @BeforeEach
    public void setUp() {
        customer1 = new Customer();
        customer1.setName("testName");
        customer1.setSurname("testSurname");

        account1 = new Account();
        account1.setBalance(BigDecimal.ONE);
        accountList1 = new ArrayList<>();
        accountList1.add(account1);

        transaction1 = new Transaction();
        transaction1.setAmount(BigDecimal.ONE);
        transactionList1 = new ArrayList<>();
    }

//    @Test
//    public void whenFetchCustomerInfo_andParamIsValid_thenReturnCustomerInfo() {
//        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer1));
//        when(accountRepository.findAccountsByCustomerId(1L)).thenReturn(Optional.of(accountList1));
//        when(transactionRepository.findTransactionsByAccountId(1L)).thenReturn(Optional.of(transactionList1));
//        CustomerDTO customerDTO = customerService.fetchCustomerInfo(1L);
//
//        assertThat(customerDTO.getName()).isSameAs(customerDTO.getName());
//    }

    @Test
    public void whenGetTicket_andNotFound_thenTriggerException() {

        when(customerRepository.findById(2L)).thenReturn(Optional.empty());

        CustomerNotFoundException thrown = assertThrows(CustomerNotFoundException.class,
                () -> customerService.fetchCustomerInfo(2L));

        assertTrue(thrown.getMessage().contains("No customer found"));
    }

    @Test
    public void whenFetchCustomerInfo_andParamIsNotValid_thenTriggerException() {

        ValueNotValidException thrown = assertThrows(ValueNotValidException.class,
                () -> customerService.fetchCustomerInfo(null));

        assertTrue(thrown.getMessage().contains("The value is not valid"));
    }

    @Test
    public void whenFetchCustomerInfo_andExceptionIsTriggered_thenTriggerException() {

        when(customerRepository.save(any(Customer.class))).thenThrow(RuntimeException.class);

        assertThrows(RuntimeException.class, () -> customerService.fetchCustomerInfo(1L));
    }
}
