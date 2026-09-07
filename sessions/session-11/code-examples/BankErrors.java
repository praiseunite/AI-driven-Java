class InsufficientFundsException extends Exception {   // checked: extends Exception
    InsufficientFundsException(String msg) { super(msg); }
}

class Account {
    private double balance;
    Account(double opening) { this.balance = opening; }

    // Because it can throw a CHECKED exception, the method must declare it
    void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(
                String.format("need $%.2f but balance is $%.2f", amount, balance));
        }
        balance -= amount;
        System.out.printf("withdrew $%.2f, balance $%.2f%n", amount, balance);
    }
}

public class BankErrors {
    public static void main(String[] args) {
        Account acc = new Account(100);
        try {
            acc.withdraw(30);
            acc.withdraw(200);       // throws
            acc.withdraw(10);        // never reached
        } catch (InsufficientFundsException e) {
            System.out.println("declined: " + e.getMessage());
        }
        System.out.println("program continues normally");
    }
}
