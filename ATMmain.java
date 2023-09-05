import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.IOException;

public class ATMmain {
    public static void main(String[] args) {
        ATM atm = new ATM();

        atm.openAccount("user1@example.com", 1000);
        atm.depositMoney("user1@example.com", 500);
        atm.withdrawMoney("user1@example.com", 200);
        atm.transferMoney("user1@example.com", "user2@example.com", 300);

        double balance1 = atm.checkBalance("user1@example.com");
        double balance2 = atm.checkBalance("user2@example.com");

        System.out.println("Balance for user1@example.com: " + balance1);
        System.out.println("Balance for user2@example.com: " + balance2);
    }
}
