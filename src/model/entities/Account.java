package model.entities;

import model.exceptions.DomainException;

public class Account {
    private Integer accountNumber;
    private String accountHolder;
    private Double accountBalance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer accountNumber, String accountHolder, Double accountBalance, Double withdrawLimit) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.accountBalance = accountBalance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount) {
        accountBalance += amount;
    }

    public void withdraw(Double amount) throws DomainException {

        if (amount > withdrawLimit) {
            throw new DomainException("The amount exeeds withdraw limit.");

        } else if (amount > accountBalance)  {
            throw new DomainException("Not enough balance.");
        }

        accountBalance -= amount;
    }
}
