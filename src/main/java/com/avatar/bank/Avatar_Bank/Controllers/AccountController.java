package com.avatar.bank.Avatar_Bank.Controllers;

import com.avatar.bank.Avatar_Bank.exceptions.AccountTransactionException;
import com.avatar.bank.Avatar_Bank.exceptions.ResourceNotFoundException;
import com.avatar.bank.Avatar_Bank.model.Account;
import com.avatar.bank.Avatar_Bank.model.TransferForm;
import com.avatar.bank.Avatar_Bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/account/{id}")
    public Account getAccountById(@PathVariable("id") int id){
        return accountService.getAccountById(id);
    }

    @PostMapping("/addAccount")
    public Account  addAccount(@RequestBody Account account){
        return accountService.saveOrUpdate(account);
    }

    @DeleteMapping("/deleteAccount/{id}")
    public void deleteCustomerById(@PathVariable("id") int id){
        accountService.deleteById(id);
    }

    @PutMapping("/transfer")
    public ResponseEntity<List<Account>> transferAmount(@RequestBody TransferForm transferForm) throws ResourceNotFoundException, AccountTransactionException {
        List<Account> accounts = accountService.transfer(transferForm.getFromAccountId(),transferForm.getToAccountId(), transferForm.getAmountToTransfer());
        return new ResponseEntity(accounts, HttpStatus.CREATED);

    }
}
