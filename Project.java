package ATMproject;

public class ATMConsoleApp {
    public static void main(String[] args) {
        // Initialize account with accountNumber, PIN, and starting balance
        Account account = new Account(1001, 1234, 10000.0);

        // Start the ATM Service
        ATMService atmService = new ATMService(account);
        atmService.start();
    }
}

