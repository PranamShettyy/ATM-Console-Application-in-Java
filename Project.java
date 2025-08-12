import java.util.*;

class Project {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int balance = 5000;
        int pin = 9964;

        System.out.println("====== Welcome to ABC Bank ATM ======");
        System.out.print("Please enter your 4-digit PIN: ");
        int tpin = sc.nextInt();

        if (pin == tpin) {
            System.out.println("\nSelect an option:");
            System.out.println("1 - Check Balance");
            System.out.println("2 - Withdraw Cash");
            System.out.println("3 - Deposit Cash");
            System.out.println("4 - Change PIN");
            System.out.print("Enter your choice: ");

            int opr = sc.nextInt();

            switch (opr) {
                case 1:
                    System.out.println("\n--- Account Balance ---");
                    System.out.println("Your current balance is: ?" + balance);
                    break;

                case 2:
                    System.out.print("\nEnter withdrawal amount: ?");
                    int withdraw = sc.nextInt();

                    if (withdraw > balance) {
                        System.out.println("Transaction failed: Insufficient funds.");
                    } else if (withdraw <= 0) {
                        System.out.println("Invalid withdrawal amount.");
                    } else {
                        balance -= withdraw;
                        System.out.println("Withdrawal successful.");
                        System.out.println("Amount withdrawn: ?" + withdraw);
                        System.out.println("Remaining Balance: ?" + balance);
                    }
                    break;

                case 3:
                    System.out.print("\nEnter deposit amount: ?");
                    int dep = sc.nextInt();
                    if (dep > 0) {
                        balance += dep;
                        System.out.println("Deposit successful.");
                        System.out.println("New Balance: ?" + balance);
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                    break;

                case 4:
                    System.out.print("\nEnter new 4-digit PIN: ");
                    int newpin = sc.nextInt();
                    if (newpin >= 1000 && newpin <= 9999) {
                        System.out.print("Re-enter new PIN for confirmation: ");
                        int confirmPin = sc.nextInt();
                        if (newpin == confirmPin) {
                            pin = newpin;
                            System.out.println("PIN changed successfully.");
                        } else {
                            System.out.println("PINs do not match. PIN change failed.");
                        }
                    } else {
                        System.out.println("PIN must be exactly 4 digits.");
                    }
                    break;

                default:
                    System.out.println("Invalid selection. Please try again.");
            }

            System.out.println("\nThank you for using ABC Bank ATM.");
        } else {
            System.out.println("Incorrect PIN. Access denied.");
        }

        sc.close();
    }
}
