/**
 * Session 7: Code Example 3
 * Program: AccessDemo.java
 * Purpose: The four access levels on fields/methods, seen from a class in the SAME file
 *          (same package). Try uncommenting the marked line to see the compiler stop you.
 *
 *   javac AccessDemo.java
 *   java AccessDemo
 */
class Account {
    public String owner;          // visible everywhere
    protected double balance;      // visible in this package + subclasses
    double branchCode;             // (default / package-private) visible in this package only
    private String pin;            // visible ONLY inside Account

    Account(String owner, double balance, String pin) {
        this.owner = owner;
        this.balance = balance;
        this.pin = pin;
        this.branchCode = 1001;
    }

    private boolean checkPin(String attempt) {   // private helper
        return pin.equals(attempt);
    }

    public boolean withdraw(double amount, String pinAttempt) {
        if (!checkPin(pinAttempt)) {
            System.out.println("Wrong PIN.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return false;
        }
        balance -= amount;
        return true;
    }
}

public class AccessDemo {
    public static void main(String[] args) {
        Account acc = new Account("Ada", 500.00, "2468");

        System.out.println("owner (public)        : " + acc.owner);
        System.out.println("balance (protected)   : " + acc.balance);   // OK: same package
        System.out.println("branchCode (default)  : " + acc.branchCode); // OK: same package

        // System.out.println(acc.pin);   // <-- uncomment: "pin has private access in Account"

        boolean ok = acc.withdraw(120.00, "2468");
        System.out.println("withdraw ok? " + ok + ", balance now " + acc.balance);
    }
}
