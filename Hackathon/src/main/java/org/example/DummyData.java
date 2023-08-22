package org.example;

import java.util.ArrayList;
import java.util.List;

public class DummyData {
    private static void createDummyData() {
        // Create customer 1
        Customer customer1 = Customer.generateCustomer("Manpreet", "Kaur", "Jalandhar", "Punjab", 1234L);
        Category savingsCategory1 = new Category(1, "Savings", 3.5);
        Category salaryCategory1 = new Category(2, "Salary", 2.0);
        Account account1_1 = Account.generateAccount(savingsCategory1, customer1.getCustomerId());
        Account account1_2 = Account.generateAccount(salaryCategory1, customer1.getCustomerId());
        account1_1.setAccountBalance(10000);
        account1_2.setAccountBalance(5000);
        List<Account> customerAccounts1 = new ArrayList<>();
        customerAccounts1.add(account1_1);
        customerAccounts1.add(account1_2);
        BankingApp.customerAccounts.put(customer1, customerAccounts1);

        // Create customer 2
        Customer customer2 = Customer.generateCustomer("Ranvir", "Singh", "Ludhiana", "Punjab", 5678L);
        Category savingsCategory2 = new Category(1, "Savings", 3.0);
        Category salaryCategory2 = new Category(2, "Salary", 2.5);
        Account account2_1 = Account.generateAccount(savingsCategory2, customer2.getCustomerId());
        Account account2_2 = Account.generateAccount(salaryCategory2, customer2.getCustomerId());
        account2_1.setAccountBalance(15000);
        account2_2.setAccountBalance(8000);
        List<Account> customerAccounts2 = new ArrayList<>();
        customerAccounts2.add(account2_1);
        customerAccounts2.add(account2_2);
        BankingApp.customerAccounts.put(customer2, customerAccounts2);

        // Create customer 3
        Customer customer3 = Customer.generateCustomer("Kartikey", "Jadoun", "Hathras", "UP", 9876L);
        Category savingsCategory3 = new Category(1, "Savings", 2.0);
        Category salaryCategory3 = new Category(2, "Salary", 1.5);
        Account account3_1 = Account.generateAccount(savingsCategory3, customer3.getCustomerId());
        Account account3_2 = Account.generateAccount(salaryCategory3, customer3.getCustomerId());
        account3_1.setAccountBalance(7500);
        account3_2.setAccountBalance(3000);
        List<Account> customerAccounts3 = new ArrayList<>();
        customerAccounts3.add(account3_1);
        customerAccounts3.add(account3_2);
        BankingApp.customerAccounts.put(customer3, customerAccounts3);
    }

    private static void main(String[] args) {
        createDummyData();
        System.out.println("Dummy data created.");
    }
}
