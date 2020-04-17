package com.avatar.bank.Avatar_Bank.repository;

import com.avatar.bank.Avatar_Bank.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Integer> {
    Optional<Account> findByCustomerId(int customerId);
}
