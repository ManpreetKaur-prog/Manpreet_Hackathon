package org.example;

import java.util.*;
import java.time.LocalDateTime;

class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private long phoneNumber;
    private LocalDateTime joiningDate;
    public Customer(int customerId, String firstName, String lastName, String address, String city, long phoneNumber, LocalDateTime joiningDate) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.joiningDate = joiningDate;
    }
    public int getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }
    public String getCity() {
        return city;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDateTime getJoiningDate() {
        return joiningDate;
    }
    public String toString() {
        return "Customer ID: " + customerId + ", Name: " + firstName + " " + lastName + ", City: " + city;
    }
    public static Customer generateCustomer(String firstName, String lastName, String address, String city, Long phoneNumber) {
        // Generate customer ID and joining date
        int customerId = CustomerData.getNextCustomerId();
        LocalDateTime joiningDate = LocalDateTime.now();
        return new Customer(customerId, firstName, lastName, address, city, phoneNumber, joiningDate);
    }
}