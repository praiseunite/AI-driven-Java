class BankAccount {
    protected double balance;
    BankAccount(double opening) { this.balance = Math.max(opening, 0); }
    void deposit(double a) { if (a > 0) balance += a; }
    boolean withdraw(double a) {
        if (a > 0 && a <= balance) { balance -= a; return true; }
        return false;
    }
    @Override public String toString() { return String.format("balance $%.2f", balance); }
}

class SavingsAccount extends BankAccount {
    private final double rate;
    SavingsAccount(double opening, double rate) { super(opening); this.rate = rate; }
    void addInterest() { balance += balance * rate; }
}

class OverdraftAccount extends BankAccount {
    private final double limit;
    OverdraftAccount(double opening, double limit) { super(opening); this.limit = limit; }
    @Override boolean withdraw(double a) {
        if (a > 0 && a <= balance + limit) { balance -= a; return true; }
        return false;
    }
}

public class AccountDemo {
    public static void main(String[] args) {
        SavingsAccount s = new SavingsAccount(1000, 0.05);
        s.addInterest();
        System.out.println("Savings  : " + s);

        OverdraftAccount o = new OverdraftAccount(100, 200);
        boolean ok = o.withdraw(250);        // allowed: into the overdraft
        System.out.println("Overdraft: withdraw 250 -> " + ok + ", " + o);
    }
}
