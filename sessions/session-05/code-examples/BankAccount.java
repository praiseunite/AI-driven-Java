/**
 * Session 5: Code Example 1
 * Program: BankAccount.java
 * Purpose: A first real class. Shows fields (state), a constructor, methods (behavior),
 *          the `this` keyword, and encapsulation (private balance changed only through
 *          deposit/withdraw). The main method is the "driver" that creates and uses objects.
 *
 *   javac BankAccount.java
 *   java BankAccount
 */
public class BankAccount {

    // --- Fields: the state each BankAccount object carries ---
    private String owner;
    private double balance;          // private: outside code cannot touch it directly

    // --- Constructor: runs when you write `new BankAccount(...)` ---
    public BankAccount(String owner, double openingBalance) {
        this.owner = owner;                 // this.owner = the field; owner = the parameter
        this.balance = Math.max(openingBalance, 0.0);
    }

    // --- Behavior ---
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit must be positive.");
            return;
        }
        balance += amount;
        System.out.printf("%s deposited $%.2f. Balance: $%.2f%n", owner, amount, balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal must be positive.");
        } else if (amount > balance) {
            System.out.printf("%s: insufficient funds for $%.2f (balance $%.2f).%n",
                              owner, amount, balance);
        } else {
            balance -= amount;
            System.out.printf("%s withdrew $%.2f. Balance: $%.2f%n", owner, amount, balance);
        }
    }

    public double getBalance() {      // a "getter" — controlled read access
        return balance;
    }

    // --- Driver ---
    public static void main(String[] args) {
        BankAccount ada = new BankAccount("Ada", 100.00);
        BankAccount bob = new BankAccount("Bob", 40.00);

        ada.deposit(50.00);
        ada.withdraw(30.00);
        bob.withdraw(100.00);       // rejected
        bob.deposit(60.00);

        System.out.printf("Final - Ada: $%.2f, Bob: $%.2f%n",
                          ada.getBalance(), bob.getBalance());
        // ada and bob are independent objects: changing one never affects the other.
    }
}
