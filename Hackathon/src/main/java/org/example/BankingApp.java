package org.example;
import java.time.LocalDateTime;
import org.example.Customer;

import java.util.*;

public class BankingApp {
    static Map<Customer, List<Account>> customerAccounts = new HashMap<>();
    static List<Transaction> transactions = new ArrayList<>();
    static Scanner scanner= new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to NatWest Banking");
        System.out.print("Do you want to bank with us? (Yes/No): ");

        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("yes")) {

            System.out.print("Enter your phone number to validate your account: ");
            Long phoneNumberToValidate = scanner.nextLong();
            //System.out.println(phoneNumberToValidate);

            if (validateAccountByPhoneNumber(phoneNumberToValidate)) {

                System.out.println("Account validated. You can proceed with transactions.");
                Customer foundCustomer = null;

                for (Customer customer : customerAccounts.keySet()) {
                    if (customer.getPhoneNumber().equals(phoneNumberToValidate)) {
                        foundCustomer = customer;
                        break;
                    }
                }

                if (foundCustomer != null) {

                    System.out.println("Your Customer Details are:");

                    printCustomerDetails(foundCustomer);

                    System.out.print("Do you want to perform a transaction? (Yes/No): ");
                    choice = scanner.nextLine().toLowerCase();

                    while (choice.equals("yes")) {

                        printTransactionOptions();


                        int transactionOption = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        if (transactionOption == 1) {
                            option1(foundCustomer);

                        } else if (transactionOption == 2) {
                            option2(foundCustomer);

                        } else if (transactionOption == 3) {
                            option3(foundCustomer);

                        }

                        System.out.print("Do you want to perform another transaction? (Yes/No): ");
                        choice = scanner.nextLine().toLowerCase();
                    }
                } else {
                    System.out.println("Account not found. Creating a new account.....");

                    createNewAccount();

                    System.out.println("Account and customer created successfully!");
                }
//                System.out.println("Enter your customer details (First Name, Last Name, Address, City, Phone Number): ");
//            String[] customerDetails = scanner.nextLine().split(",");
//            String firstName = customerDetails[0];
//            String lastName = customerDetails[1];
//            String address = customerDetails[2];
//            String city = customerDetails[3];
//            long phoneNumber = Long.parseLong(customerDetails[4]);
//            Customer customer = Customer.generateCustomer(firstName, lastName, address, city, phoneNumber);
//
//            if (validateAccountByPhoneNumber(phoneNumber)) {
//                System.out.println("Account validated. You can proceed with transactions.");
//                System.out.println("Your Customer Details are:");
//                System.out.println("CustomerID, First Name, Last Name, Address, City, Phone Number, Joining Date");
//                System.out.println(customer.getCustomerId() + ", " + customer.getFirstName() + ", " + customer.getLastName() +
//                        ", " + customer.getAddress() + ", " + customer.getCity() + ", " + customer.getPhoneNumber() +
//                        ", " + customer.getJoiningDate());
//                System.out.print("Do you want to create an account? (Yes/No): ");
//                choice = scanner.nextLine().toLowerCase();
//
//                if (choice.equals("yes")) {
//                    System.out.println("Select the account type from the following:");
//                    System.out.println("1. Savings");
//                    System.out.println("2. Salary");
//                    int accountTypeChoice = scanner.nextInt();
//                    scanner.nextLine(); // Consume newline
//                    Category selectedCategory;
//                    if (accountTypeChoice == 1) {
//                        selectedCategory = new Category(1, "Savings", 3.5); // Example values
//                    } else {
//                        selectedCategory = new Category(2, "Salary", 2.0); // Example values
//                    }
//                    System.out.print("Enter the initial deposit amount: ");
//                    double initialDeposit = scanner.nextDouble();
//                    scanner.nextLine(); // Consume newline
//
//                    // Generate and display account
//                    Account account = Account.generateAccount(selectedCategory, customer.getCustomerId());
//                    account.setAccountBalance(initialDeposit);
//                    System.out.println("Your Account Details are:");
//                    System.out.println("Account Number, Balance, Type, Customer ID, Date Opened");
//                    System.out.println(account.getAccountNumber() + ", " + account.getAccountBalance() + ", " +
//                            account.getAccountType() + ", " + account.getCustomerId() + ", " + account.getDateOpened());
//
//                    // Perform transactions
//                    System.out.print("Do you want to perform a transaction? (Yes/No): ");
//                    choice = scanner.nextLine().toLowerCase();
//
//                    while (choice.equals("yes")) {
//                        System.out.println("Select the following option:");
//                        System.out.println("1. Deposit");
//                        System.out.println("2. Withdraw");
//                        System.out.println("3. Transfer");
//                        int transactionOption = scanner.nextInt();
//                        scanner.nextLine(); // Consume newline
//                        if (transactionOption == 1) {
//                            System.out.print("Enter amount to deposit: ");
//                            double depositAmount = scanner.nextDouble();
//                            scanner.nextLine(); // Consume newline
//
//                            // Perform deposit transaction
//                            Transaction depositTransaction = new Transaction(depositAmount, account.getAccountNumber(), LocalDateTime.now());
//                            transactions.add(depositTransaction);
//                            account.setAccountBalance(account.getAccountBalance() + depositAmount);
//                            System.out.println("Transaction is successful.");
//                        } else if (transactionOption == 2) {
//                            // Withdraw transaction
//                            // ...
//
//                            System.out.println("Transaction is successful.");
//                        } else if (transactionOption == 3) {
//                            // Transfer transaction
//                            // ...
//                            System.out.println("Transaction is successful.");
//                        }
//
//                        System.out.print("Do you want to perform another transaction? (Yes/No): ");
//                        choice = scanner.nextLine().toLowerCase();
//                    }
//                }
//            } else {
//                System.out.println("Account not found. Please provide valid customer details.");
//            }

            }} else {
            System.out.println("Thank you for considering NatWest Banking.");
        }

        scanner.close();
    }
    private static boolean validateAccountByPhoneNumber(Long phoneNumber) {
        System.out.println("Checking.............");
        //try {
        if (phoneNumber == null) {
            System.out.println("Phone number cannot be null.");
            throw new IllegalArgumentException("Phone number cannot be null.");
        }
        String phoneNumberString = String.valueOf(phoneNumber);
        if (phoneNumberString.isEmpty() || !phoneNumberString.matches("\\d+")) {
            System.out.println("Phone number cannot be empty or contain non-numeric characters.");
            throw new IllegalArgumentException("Phone number cannot be empty or contain non-numeric characters.");
        }
        for (Customer customer : customerAccounts.keySet()) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
//        } catch (IllegalArgumentException e) {
//            System.out.println("Error: " + e.getMessage());
//            return false;
//        }
    }

    private static Account findAccountByAccountNumber(long accountNumber) {
        for (List<Account> accounts : customerAccounts.values()) {
            for (Account account : accounts) {
                if (account.getAccountNumber() == accountNumber) {
                    return account;
                }
            }
        }
        return null;
    }

    private static boolean performWithdrawal(Account account, double amount) {
        if (account.getAccountBalance() >= amount) {
            Transaction withdrawalTransaction = new Transaction(-amount, account.getAccountNumber(), LocalDateTime.now());
            transactions.add(withdrawalTransaction);
            account.setAccountBalance(account.getAccountBalance() - amount);
            return true;
        } else {
            System.out.println("Insufficient balance.");
            return false;
        }
    }
    private static void option1(Customer foundCustomer)
    {
        System.out.print("Enter amount to deposit: ");
        double depositAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        Account account = findAccountByAccountNumber(foundCustomer.getCustomerId());

        // Perform deposit transaction
        Transaction depositTransaction = new Transaction(depositAmount, account.getAccountNumber(), LocalDateTime.now());
        transactions.add(depositTransaction);
        account.setAccountBalance(account.getAccountBalance() + depositAmount);
        System.out.println("Transaction is successful.");
    }
    private static boolean performTransfer(Account sourceAccount, Account destinationAccount, double amount) {
        if (sourceAccount.getAccountBalance() >= amount) {
            Transaction transferTransaction = new Transaction(-amount, sourceAccount.getAccountNumber(), LocalDateTime.now());
            transactions.add(transferTransaction);
            sourceAccount.setAccountBalance(sourceAccount.getAccountBalance() - amount);
            destinationAccount.setAccountBalance(destinationAccount.getAccountBalance() + amount);
            return true;
        } else {
            System.out.println("Insufficient balance.");
            return false;
        }
    }


    private static void printCustomerDetails(Customer foundCustomer) {
        System.out.println("CustomerID, First Name, Last Name, Address, City, Phone Number, Joining Date");
        System.out.println(foundCustomer.getCustomerId() + ", " + foundCustomer.getFirstName() + ", " +
                foundCustomer.getLastName() + ", " + foundCustomer.getAddress() + ", " +
                foundCustomer.getCity() + ", " + foundCustomer.getPhoneNumber() + ", " +
                foundCustomer.getJoiningDate());

    }

    private static void createNewAccount() {
        System.out.println("Enter your customer details (First Name, Last Name, Address, City, Phone Number): ");
        String[] customerDetails = scanner.nextLine().split(",");
        String firstName = customerDetails[0];
        String lastName = customerDetails[1];
        String address = customerDetails[2];
        String city = customerDetails[3];
        Long phoneNumber = Long.parseLong(customerDetails[4]);
        Customer newCustomer = Customer.generateCustomer(firstName, lastName, address, city, phoneNumber);
        // Create account
        System.out.println("Select the account type from the following:");
        System.out.println("1. Savings");
        System.out.println("2. Salary");
        int accountTypeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Category selectedCategory;
        if (accountTypeChoice == 1) {
            selectedCategory = new Category(1, "Savings", 3.5); // Example values
        } else {
            selectedCategory = new Category(2, "Salary", 2.0); // Example values
        }
        System.out.print("Enter the initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Account newAccount = Account.generateAccount(selectedCategory, newCustomer.getCustomerId());
        newAccount.setAccountBalance(initialDeposit);

        List<Account> newCustomerAccounts = new ArrayList<>();
        newCustomerAccounts.add(newAccount);
        customerAccounts.put(newCustomer, newCustomerAccounts);
    }

    private static void printTransactionOptions() {
        System.out.println("Select the following option:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
    }

    private static void option3(Customer foundCustomer) {
        System.out.print("Enter amount to transfer: ");
        double transferAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter destination account number: ");
        long destinationAccountNumber = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        // Find destination account and perform transfer transaction
        Account sourceAccount = findAccountByAccountNumber(foundCustomer.getCustomerId());
        Account destinationAccount = findAccountByAccountNumber(destinationAccountNumber);

        if (destinationAccount != null) {
            if (performTransfer(sourceAccount, destinationAccount, transferAmount)) {
                System.out.println("Transaction is successful.");
            }
        } else {
            System.out.println("Destination account not found.");
        }
    }

    private static void option2(Customer foundCustomer) {
        System.out.print("Enter amount to withdraw: ");
        double withdrawalAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        Account account = findAccountByAccountNumber(foundCustomer.getCustomerId());
        // Perform withdrawal transaction
        if (performWithdrawal(account, withdrawalAmount)) {
            System.out.println("Transaction is successful.");
        }
    }
}
