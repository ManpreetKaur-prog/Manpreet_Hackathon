package org.example;

import java.time.LocalDateTime;

class Transaction {
    private double amount;
    private long accountNumber;
    private LocalDateTime date;

    public Transaction(double amount, long accountNumber, LocalDateTime date) {
        this.amount = amount;
        this.accountNumber = accountNumber;
        this.date = date;
    }
    public double getAmount() {
        return amount;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public LocalDateTime getDate() {
        return date;
    }
    public String toString() {
        return "Amount: " + amount + ", Account Number: " + accountNumber + ", Date: " + date;
    }
}

