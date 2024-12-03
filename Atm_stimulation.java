package Projects;

import java.util.Scanner;

public class Atm_stimulation {
    private static double balance = 5000; // Default balance
    private static final int PIN = 1234; // Default PIN

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");
        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (enteredPin == PIN) {
            while (true) {
                System.out.println("\n--- ATM Menu ---");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> checkBalance();
                    case 2 -> depositMoney(scanner);
                    case 3 -> withdrawMoney(scanner);
                    case 4 -> {
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Incorrect PIN. Access denied.");
        }
        scanner.close();
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: ₹" + balance);
    }

    private static void depositMoney(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ₹");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " has been deposited successfully.");
            checkBalance();
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    private static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ₹");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " has been withdrawn successfully.");
            checkBalance();
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }
}

