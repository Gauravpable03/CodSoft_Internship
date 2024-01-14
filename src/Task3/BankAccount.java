package Task3;

import java.io.*;

public class BankAccount {
    private double balance;
    private String fileName = "C:\\Users\\Admin\\eclipse-workspace\\Codsoft_Intership\\src\\Task3\\AccountBalance.txt";

    public BankAccount(int initialBalance) {
        loadBalance();
    }

    private void loadBalance() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            if (line != null) {
                this.balance = Double.parseDouble(line);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void saveBalance() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(String.valueOf(this.balance));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deposit(double amount) {
        this.balance += amount;
        saveBalance();
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            saveBalance();
            return true;
        } else {
            return false;
        }
    }

    public double checkBalance() {
        return this.balance;
    }
}
