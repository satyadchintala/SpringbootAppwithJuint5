package com.avatar.bank.Avatar_Bank.model;

import javax.persistence.*;

@Entity
@Table
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private int accountId;

    @Column(nullable = false)
    private String accountType="individual";

    @Column(nullable = false)
    private double balance=0.0;

    @Column
    private int customerId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Account(){}
    public Account(String accountType, double balance, int customerId) {
        this.accountType = accountType;
        this.balance = balance;
        this.customerId = customerId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

}
