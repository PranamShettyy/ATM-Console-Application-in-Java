package ATMproject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ATMService {
    private Account account;
    private Scanner scanner = new Scanner(System.in);

    public ATMService(Account account) {
        this.account = account;
    }

    public void start() {
        System.out.println("Welcome to Professional ATM System");

        try {
            System.out.print("Enter your PIN: ");
            int enteredPin = scanner.nextInt();

            if (!account.verifyPin(enteredPin)) {
                System.out.println("Invalid PIN! Access denied.");
                return;
            }

            int choice;
            do {
                showMenu();
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        showBalance();
                        break;
                    case 2:
                        depositMoney();
                        break;
                    case 3:
                        withdrawMoney();
                        break;
                    case 4:
                        System.out.println("Thank you for using ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please select 1-4.");
                }

            } while (choice != 4);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input type! Please enter numbers only.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private void showMenu() {
        System.out.println("\n===== ATM Menu =====");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Select your option: ");
    }

    private void showBalance() {
        System.out.println("Current Balance: ₹" + account.getBalance());
    }

    private void depositMoney() {
        try {
            System.out.print("Enter amount to deposit: ₹");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void withdrawMoney() {
        try {
            System.out.print("Enter amount to withdraw: ₹");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
