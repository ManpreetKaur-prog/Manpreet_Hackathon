package org.example;

class CustomerData {
    private static int customerIdCounter = 1;

    public static int getNextCustomerId() {
        return customerIdCounter++;
    }
}