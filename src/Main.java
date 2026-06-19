public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Tim");
        BankAccount account2 = new BankAccount("Alex");

        account1.deposit(5000);
        account1.withdraw(100);
        System.out.println("Balance account1: " + account1.getBalance());

        account2.deposit(2000);
        account2.withdraw(1200);
        System.out.println("Balance account2: " + account2.getBalance());

        System.out.println("Transfer money from account1 to account2");
        account1.transfer(account2, 1000);
        System.out.println("Balance account1: " + account1.getBalance());
        System.out.println("Balance account2: " + account2.getBalance());

        System.out.println(account1);
        System.out.println(account2);
    }
}