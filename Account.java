package ATMproject;

public class Account {
    private int accountNumber;
    private int pin;
    private double balance;

    public Account(int accountNumber, int pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance;
    }

    public boolean verifyPin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        System.out.println("₹" + amount + " deposited successfully.");
    }

    public void withdraw(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance.");
        }
        balance -= amount;
        System.out.println("₹" + amount + " withdrawn successfully.");
    }
}

