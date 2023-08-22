package org.example;

class AccountData {
    private static long accountNumberCounter = 1000000000L;

    public static long getNextAccountNumber() {
        return accountNumberCounter++;
    }
}