interface Payable {
    double calculatePay();
    default String payslip() { return getClass().getSimpleName() + ": $" + String.format("%.2f", calculatePay()); }
}

class SalariedEmployee implements Payable {
    private final double annual;
    SalariedEmployee(double annual) { this.annual = annual; }
    @Override public double calculatePay() { return annual / 12; }
}

class Contractor implements Payable {
    private final double rate, hours;
    Contractor(double rate, double hours) { this.rate = rate; this.hours = hours; }
    @Override public double calculatePay() { return rate * hours; }
}

class Invoice implements Payable {          // not an employee at all — still Payable
    private final double amountDue;
    Invoice(double amountDue) { this.amountDue = amountDue; }
    @Override public double calculatePay() { return amountDue; }
}

public class PayrollDemo {
    public static void main(String[] args) {
        Payable[] toPay = {
            new SalariedEmployee(90000),
            new Contractor(45, 80),
            new Invoice(1250.50)
        };
        double total = 0;
        for (Payable p : toPay) {
            System.out.println(p.payslip());
            total += p.calculatePay();
        }
        System.out.printf("TOTAL: $%.2f%n", total);
    }
}
