package org.example;

import java.time.LocalDateTime;

class Account {
    private long accountNumber;
    private double accountBalance;
    private Category accountType;
    private int customerId;
    private LocalDateTime dateOpened;
    public void setAccountBalance(double newBalance) {
        this.accountBalance = newBalance;
    }
    private Account(long accountNumber, double accountBalance, Category accountType, int customerId, LocalDateTime dateOpened) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountType = accountType;
        this.customerId = customerId;
        this.dateOpened = dateOpened;
    }
    public long getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public Category getAccountType() {
        return accountType;
    }
    public int getCustomerId() {
        return customerId;
    }

    public LocalDateTime getDateOpened() {
        return dateOpened;
    }
    public String toString() {
        return "Account Number: " + accountNumber + ", Balance: " + accountBalance + ", Type: " + accountType;
    }
    public static Account generateAccount(Category accountType, int customerId) {
        // Generate account number and date opened
        long accountNumber = AccountData.getNextAccountNumber();
        LocalDateTime dateOpened = LocalDateTime.now();
        return new Account(accountNumber, 0.0, accountType, customerId, dateOpened);
    }
}