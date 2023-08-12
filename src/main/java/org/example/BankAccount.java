package org.example;

import java.util.Scanner;

/**
 * Practice: <a href="https://www.youtube.com/watch?v=wQbEH4tVMJA&list=PLwiuaDJVNC9Cmiw-i9pO668GII1FNuoUP&index=7">...</a>
 * @author Farida Fatali
 * <p>
 * Making a Banking Application in 2 ways:
 * 1. Entering the data
 * 2. Asking from the user
 */

class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cName, String cId) {
        customerName = cName;
        customerId = cId;
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount != 0) {
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("The previous transaction \nWithdrawn: " + Math.abs(previousTransaction) + "$");
        } else {
            System.out.println("No transaction occurred.");
        }
    }

    void showMe() {
        char option;
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Welcome " + customerName + "\nYour ID: " + customerId);
        System.out.println();
        System.out.println("""
                A. Check Balance
                B. Deposit
                C. Withdraw
                D. Previous Transaction
                E. Exit""");

        do {
            System.out.println();
            System.out.println("--------------------------------");
            System.out.println("Enter an option");
            System.out.println("--------------------------------");
            option = scanner.next().charAt(0);

            switch (Character.toUpperCase(option)) {
                case 'A' -> {
                    System.out.println();
                    System.out.println("Balance: " + balance + "$");
                }
                case 'B' -> {
                    System.out.println();
                    System.out.println("Enter an amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                }
                case 'C' -> {
                    System.out.println();
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    if (amount2 > balance) {
                        System.out.println("You don't have enough funds in your balance.");
                    } else {
                        withdraw(amount2);
                    }
                }
                case 'D' -> {
                    System.out.println();
                    getPreviousTransaction();
                }
                case 'E' -> {
                    System.out.println();
                    System.out.println("--------------------------------");
                }
                default -> System.out.println("Invalid Option! Please enter again.");
            }
        } while (Character.toUpperCase(option) != 'E');
        System.out.println("Thank you for using our service!");
    }
}
