package Task3;

public class Main {
    public static void main(String[] args) {
        int initialBalance=1000;
        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atmMachine = new ATM(userAccount);

        atmMachine.startATM();
    }
}
