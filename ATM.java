import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ATM {
    private Map<String, Double> accounts;

    public ATM() {
        accounts = new HashMap<>();
    }

    public void openAccount(String userId, double amount) {
        if (!accounts.containsKey(userId)) {
            accounts.put(userId, amount);
        } else {
            throw new RuntimeException("User already exists!");
        }
    }

    public void closeAccount(String userId) {
        if (accounts.containsKey(userId)) {
            double balance = accounts.get(userId);
            if (balance == 0) {
                accounts.remove(userId);
            } else {
                throw new RuntimeException("Please withdraw entirety of balance before closing the account!");
            }
        } else {
            throw new RuntimeException("User not found!");
        }
    }

    public double checkBalance(String userId) {
        if (accounts.containsKey(userId)) {
            return accounts.get(userId);
        } else {
            throw new RuntimeException("User not found!");
        }
    }

    public double depositMoney(String userId, double amount) {
        if (accounts.containsKey(userId)) {
            double balance = accounts.get(userId);
            accounts.put(userId, balance + amount);
            return balance;
        } else {
            throw new RuntimeException("User not found! Ur broke AF!");
        }
    }

    public double withdrawMoney(String userId, double amount) {
        if (accounts.containsKey(userId)) {
            double balance = accounts.get(userId);
            if (balance >= amount) {
                accounts.put(userId, balance - amount);
                return amount;
            } else {
                throw new RuntimeException("Ur Broke AF kid!");
            }
        } else {
            throw new RuntimeException("User not found!");
        }
    }

    public boolean transferMoney(String fromAccount, String toAccount, double amount) {
        if (accounts.containsKey(fromAccount) && accounts.containsKey(toAccount)) {
            {
                double withdrawnAmount = withdrawMoney(fromAccount, amount);
                depositMoney(toAccount, withdrawnAmount);
                return true;
            }
        } else {
            throw new RuntimeException("One or both accounts not found!");
        }
    }

    public void audit() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("AccountAudit.txt"));
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            writer.write(entry.getKey() + ": " + entry.getValue());
            writer.newLine();
        }
        writer.close();
    }
}