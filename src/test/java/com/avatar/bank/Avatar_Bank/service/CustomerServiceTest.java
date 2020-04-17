package com.avatar.bank.Avatar_Bank.service;

import com.avatar.bank.Avatar_Bank.exceptions.ResourceNotFoundException;
import com.avatar.bank.Avatar_Bank.model.Account;
import com.avatar.bank.Avatar_Bank.model.Address;
import com.avatar.bank.Avatar_Bank.model.Customer;
import com.avatar.bank.Avatar_Bank.repository.AccountRepository;
import com.avatar.bank.Avatar_Bank.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CustomerServiceTest {

    @Mock
     CustomerRepository customerRepository;
    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private CustomerService customerService;

    public static List<Customer> customers = new ArrayList<Customer>();

    /*@BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }*/
    @BeforeAll
    public static void setUp(){
        //String firstName, String middleName, String lastName, String phoneNumber, String email, Address address
        Address address = new Address("123 Testing Rd","","Blain","MN","878787");
        Customer customer1 = new Customer("Greg","","Pope","1234567890","email@email.com",address);
        address = new Address("124 Testing Rd","","Blain","MN","878787");
        Customer customer2 = new Customer("Seth","","Pope","1234567892","email@email.com",address);
        address = new Address("125 Testing Rd","","Blain","MN","878787");
        Customer customer3 = new Customer("James","D","Garloc","1234567891","email@email.com",address);
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

    }

    @Test
    void getAllCustomers() {
        Account account = new Account("Individual",2000.0,1);
        when(customerRepository.findAll()).thenReturn(customers);
        List<Customer> customerList = customerService.getAllCustomers();
        assertEquals(3, customerList.size());
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    void getCustomerById() throws ResourceNotFoundException {
        Address address = new Address(1,"123 Testing Rd","","Blain","MN","878787");
        Account account = new Account("Individual",2000.0,1);
        Optional<Customer> repoCustomer = Optional.of(new Customer(1, "Greg", "", "Pope", "1234567890", "email@email.com", address, account));
        when(customerRepository.findById(1)).thenReturn(repoCustomer);
        when(accountRepository.findById(1)).thenReturn(Optional.of(account));

        Customer customer = customerService.getCustomerById(1);

        assertEquals("Greg", customer.getFirstName());
        assertEquals("Pope", customer.getLastName());
        assertEquals("email@email.com", customer.getEmail());
    }

    //this is testing exception
    @Test
    void getCustomerByIdExceptionTest() {
        Address address = new Address(1,"123 Testing Rd","","Blain","MN","878787");
        Account account = new Account("Individual",2000.0,1);
        Optional<Customer> repoCustomer = Optional.of(new Customer(1, "Greg", "", "Pope", "1234567890", "email@email.com", address, account));
        when(customerRepository.findById(1)).thenReturn(repoCustomer);
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            customerService.getCustomerById(1);
        });

        String expectedMessage = "not found customer";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void getCustomerByFirstNameAndLastName() {
    }

    @Test
    void saveOrUpdate() {
    }

    @Test
    void deleteById() {
    }
}