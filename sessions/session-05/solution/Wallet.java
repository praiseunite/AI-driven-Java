/**
 * Session 5 — Task 5.2 reference solution
 * Encapsulation: 'balance' is private and can only move through add()/spend(),
 * each of which validates first, so the balance can never go negative.
 */
public class Wallet {
    private String owner;
    private double balance;

    public Wallet(String owner, double opening) {
        this.owner = owner;
        this.balance = Math.max(opening, 0);
    }

    public void add(double amt) {
        if (amt <= 0) { System.out.println("Amount must be positive."); return; }
        balance += amt;
        System.out.printf("%s added $%.2f -> $%.2f%n", owner, amt, balance);
    }

    public void spend(double amt) {
        if (amt <= 0) {
            System.out.println("Amount must be positive.");
        } else if (amt > balance) {
            System.out.printf("%s cannot spend $%.2f (only $%.2f).%n", owner, amt, balance);
        } else {
            balance -= amt;
            System.out.printf("%s spent $%.2f -> $%.2f%n", owner, amt, balance);
        }
    }

    public double getBalance() { return balance; }

    public static void main(String[] args) {
        Wallet w = new Wallet("Ada", 20.00);
        w.add(15.50);
        w.spend(10.00);
        w.spend(100.00);
        System.out.printf("Final balance: $%.2f%n", w.getBalance());
    }
}
