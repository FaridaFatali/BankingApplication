package org.example;

import java.util.Scanner;

public class BankingAppWithScanner {
    public static void main(String[] args) {
        String name = "Farida";
        String password = "12345";

        String name1;
        String password1;

        BankAccount obj2 = new BankAccount(name, password);

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your name:");
            name1 = scanner.next();
            System.out.println("Enter your password:");
            password1 = scanner.next();

            if (!name.equals(name1) || !password.equals(password1)) {
                System.out.println("Invalid name or password! Try again.");
                System.out.println();
            } else {
                obj2.showMe();
            }
        }
        while (!name.equals(name1) || !password.equals(password1));
    }
}
