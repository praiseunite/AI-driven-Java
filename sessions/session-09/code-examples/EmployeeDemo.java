class Employee {
    private final String name;
    private final double baseSalary;
    Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }
    String getName() { return name; }
    double monthlyPay() { return baseSalary / 12; }
    @Override public String toString() {
        return String.format("%s: $%.2f/mo", name, monthlyPay());
    }
}

class Manager extends Employee {
    private final double bonus;
    Manager(String name, double baseSalary, double annualBonus) {
        super(name, baseSalary);          // must be first
        this.bonus = annualBonus;
    }
    @Override double monthlyPay() {
        return super.monthlyPay() + bonus / 12;   // extend, don't replace
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        Employee e = new Employee("Ada", 60000);
        Employee m = new Manager("Bode", 90000, 12000);
        System.out.println(e);
        System.out.println(m);
    }
}
