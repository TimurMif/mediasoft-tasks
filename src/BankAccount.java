import java.time.LocalDateTime;
import java.util.Random;

public class BankAccount {
    private String name = "";
    private int balance = 0;
    private LocalDateTime openingDate = LocalDateTime.now();
    private boolean isBlocked = false;
    private String number = this.generateAccountNumber();

    BankAccount(String name) {
        this.name = name;
    }

    boolean deposit(int amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    boolean withdraw(int amount) {
        if (balance >= amount && amount >= 0) {
            balance -= amount;
            return true;
        }
        return false;
    }

    boolean transfer(BankAccount otherAccount, int amount) {
        if (amount >= 0 && this.balance >= amount) {
            this.balance -= amount;
            otherAccount.deposit(amount);
            return true;
        }
        return false;
    }

    public int getBalance() {
        return balance;
    }

    private String generateAccountNumber() {
        Random random = new Random();
        int num = random.nextInt(100_000_000);
        return String.format("%08d", num);
    }

    @Override
    public String toString() {
        return "BankAccount:\n" +
                "\townerName='" + name + '\n' +
                "\tbalance=" + balance + '\n' +
                "\topeningDate=" + openingDate + '\n' +
                "\tisBlocked=" + isBlocked + '\n' +
                "\tnumber=" + number;
    }
}
