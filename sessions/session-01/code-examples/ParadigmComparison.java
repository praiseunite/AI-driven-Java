/**
 * Session 1: Code Example 2
 * Program: ParadigmComparison.java
 * Purpose: Contrasts Structured (Procedural) style vs. Object-Oriented style
 *          side-by-side using an intuitive real-world scenario (Bank Account).
 */
public class ParadigmComparison {

    public static void main(String[] args) {
        System.out.println("=== 1. STRUCTURED / PROCEDURAL APPROACH ===");
        // In structured programming, data and the functions acting on data are separate.
        // Anyone can modify the balance directly from anywhere without safety checks!
        String accountOwner = "Ada Lovelace";
        double accountBalance = 1000.00;

        accountBalance = depositStructured(accountBalance, 250.00);
        System.out.println(accountOwner + "'s balance after deposit: $" + accountBalance);

        // Danger in structured: someone could accidentally set a negative balance directly:
        accountBalance = -9999.00; // No protection!
        System.out.println("Notice: Structured balance unprotected: $" + accountBalance);

        System.out.println("\n=== 2. OBJECT-ORIENTED APPROACH (OOP) ===");
        // In OOP, data (balance) and behavior (deposit/withdraw) are bundled together inside an Object.
        // The data is protected (encapsulated). You cannot corrupt the balance directly.
        BankAccount adaAccount = new BankAccount("Ada Lovelace", 1000.00);
        adaAccount.deposit(250.00);
        adaAccount.displayAccountSummary();

        // Attempting to inject negative money:
        adaAccount.deposit(-500.00); // Handled cleanly by account rules!
    }

    // Structured helper function: Data is passed in from outside
    public static double depositStructured(double balance, double amount) {
        return balance + amount;
    }
}

/**
 * An Object-Oriented representation of a Bank Account.
 * It bundles the data (attributes) and behavior (methods) into a single secure entity.
 */
class BankAccount {
    // Attributes (State) - Private means protected from outside tampering
    private String owner;
    private double balance;

    // Constructor - Initializes the account when created
    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Notice: Initial balance cannot be negative. Set to $0.00.");
        }
    }

    // Behavior (Method) - Regulates how balance can change
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Successfully deposited $" + amount + " for " + owner);
        } else {
            System.out.println("Error: Deposit amount must be positive! Attempted: $" + amount);
        }
    }

    public void displayAccountSummary() {
        System.out.println("--- Account Summary ---");
        System.out.println("Account Holder : " + this.owner);
        System.out.println("Current Balance: $" + this.balance);
    }
}
