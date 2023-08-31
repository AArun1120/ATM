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
            throw new RuntimeException("User already exists");
        }
    }

    public void closeAccount(String userId) {
        if (accounts.containsKey(userId)) {
            double balance = accounts.get(userId);
            if (balance == 0) {
                accounts.remove(userId);
            } else {
                throw new RuntimeException("Please withdraw balance before closing the account");
            }
        } else {
            throw new RuntimeException("User not found"...);
        }
    }
}