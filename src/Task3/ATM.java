package Task3;
import java.util.Scanner;

public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
    	System.out.println("\nATM Menu:");
        System.out.println("\n1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Quit");
    }

    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount > 0 && this.account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Remaining balance: " + this.account.checkBalance());
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            this.account.deposit(amount);
            System.out.println("Deposit successful. New balance: " + this.account.checkBalance());
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + this.account.checkBalance());
    }

    public void startATM() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
