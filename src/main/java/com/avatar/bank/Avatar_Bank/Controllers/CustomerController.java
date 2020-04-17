package com.avatar.bank.Avatar_Bank.Controllers;

import com.avatar.bank.Avatar_Bank.exceptions.ResourceNotFoundException;
import com.avatar.bank.Avatar_Bank.model.Customer;
import com.avatar.bank.Avatar_Bank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getCustomers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomersById(@PathVariable("id") int id) throws ResourceNotFoundException {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/customer/{firstName}/{lastName}")
    public Customer getCustomersByFullName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) throws ResourceNotFoundException {
        return customerService.getCustomerByFirstNameAndLastName(firstName,lastName);
    }

    @PostMapping("/customer")
    public Customer  addCustomer(@RequestBody Customer customer){
        return customerService.saveOrUpdate(customer);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public void deleteCustomerById(@PathVariable("id") int id){
        customerService.deleteById(id);
    }

    @DeleteMapping("/deleteCustomers")
    public void deleteAllCustomer(){
        customerService.deleteAll();
    }
}

