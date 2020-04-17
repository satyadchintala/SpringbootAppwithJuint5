package com.avatar.bank.Avatar_Bank.service;

import com.avatar.bank.Avatar_Bank.exceptions.ResourceNotFoundException;
import com.avatar.bank.Avatar_Bank.model.Account;
import com.avatar.bank.Avatar_Bank.model.Customer;
import com.avatar.bank.Avatar_Bank.repository.AccountRepository;
import com.avatar.bank.Avatar_Bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AccountRepository accountRepository;

    public List<Customer> getAllCustomers(){
        List<Customer> customers = new ArrayList<Customer>();
        customerRepository.findAll().forEach(customer ->{
            Optional<Account> accountOptional = accountRepository.findByCustomerId(customer.getCustomerId());
            Account account = (accountOptional.isPresent())? accountOptional.get():(new Account());
            customer.setAccount(account);
            customers.add(customer);
        });
        return customers;
    }

    public Customer getCustomerById(int id) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(id).get();
        Optional<Account> accountOptional = accountRepository.findById(customer.getCustomerId());
        Account account = accountOptional.orElseThrow(() -> new ResourceNotFoundException("not found customer"));
        customer.setAccount(account);
        return customer;
    }

    public Customer getCustomerByFirstNameAndLastName(String firstName, String lastName) throws ResourceNotFoundException {
        Customer customer = customerRepository.findEmployeeByFirstNameAndLastName(firstName,lastName).get();
        Optional<Account> accountOptional = accountRepository.findById(customer.getCustomerId());
        Account account = accountOptional.orElseThrow(() -> new ResourceNotFoundException("not found customer"));
        customer.setAccount(account);
        return customer;
    }

    public Customer saveOrUpdate(Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteById(int id){
        customerRepository.deleteById(id);
    }
    public void deleteAll(){
        customerRepository.deleteAll();
    }

}
