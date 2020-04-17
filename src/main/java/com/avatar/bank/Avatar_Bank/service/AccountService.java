package com.avatar.bank.Avatar_Bank.service;

import com.avatar.bank.Avatar_Bank.exceptions.AccountTransactionException;
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
public class AccountService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CustomerRepository customerRepository;

    public Account getAccountById(int id){
        return accountRepository.findById(id).get();
    }

    public List<Account> getAllAccounts(){
        List<Account> accounts = new ArrayList<Account>();
        accountRepository.findAll().forEach(accounts::add);
        return accounts;
    }

    public Account saveOrUpdate(Account account){
        return accountRepository.save(account);
    }

    public void deleteById(int id){
        accountRepository.deleteById(id);
    }

    //this method transfer founds from one account to other.
    public List<Account> transfer(int fromAccountId, int toAccountId, double transferAmount)
            throws ResourceNotFoundException, AccountTransactionException {
        Optional<Account> fromAccountPresent = accountRepository.findById(fromAccountId);
        Optional<Account> toAccountPresent = accountRepository.findById(toAccountId);
        Account fromAccount = fromAccountPresent.orElseThrow(() -> new ResourceNotFoundException("no from account exist"));
        Account toAccount = toAccountPresent.orElseThrow(() -> new ResourceNotFoundException("no to account exist"));
        if (fromAccount.getBalance() < transferAmount) {
            throw new AccountTransactionException("Not enough balance");
        }
        double fromBalance = fromAccount.getBalance()-transferAmount;
        double toBalance= toAccount.getBalance()+transferAmount;
        fromAccount.setBalance(fromBalance);
        toAccount.setBalance(toBalance);
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(fromAccount);
        accounts.add(toAccount);
        return (List<Account>) accountRepository.saveAll(accounts);
    }

}
