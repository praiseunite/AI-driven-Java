# Session 9: In-Class Practical Tasks 💻

> **Track:** AI-Driven Java Programming (JAVA-I) | **Session 9 Lab**
> Reference solutions: [solution/solution.html](solution/solution.html)

---

## 🟢 Task 9.1 (Easy): Vehicle Hierarchy (extends, super, override)

```java
class Vehicle {
    protected final String name;
    protected int speed = 0;
    Vehicle(String name) { this.name = name; }
    void accelerate(int d) { speed += d; }
    String describe() { return name + " at " + speed + " km/h"; }
}

class SportsCar extends Vehicle {
    SportsCar(String name) { super(name); }
    @Override void accelerate(int d) { speed += d * 2; }
}

class Truck extends Vehicle {
    private final int cargo;
    Truck(String name, int cargo) { super(name); this.cargo = cargo; }
    @Override String describe() { return super.describe() + " carrying " + cargo + "kg"; }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle[] fleet = { new Vehicle("Sedan"), new SportsCar("Viper"), new Truck("Hauler", 500) };
        for (Vehicle v : fleet) v.accelerate(20);
        for (Vehicle v : fleet) System.out.println(v.describe());
    }
}
```
**Expected output:**
```
Sedan at 20 km/h
Viper at 40 km/h
Hauler at 20 km/h carrying 500kg
```

---

## 🟡 Task 9.2 (Medium): Account Types (override behaviour)

```java
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
        boolean ok = o.withdraw(250);
        System.out.println("Overdraft: withdraw 250 -> " + ok + ", " + o);
    }
}
```
**Expected output:**
```
Savings  : balance $1050.00
Overdraft: withdraw 250 -> true, balance $-150.00
```

---

## 🔴 Task 9.3 (Challenge): `Money` value type (equals / hashCode / toString)

```java
import java.util.Objects;

class Money {
    private final long cents;
    Money(long cents) { this.cents = cents; }
    Money plus(Money other) { return new Money(cents + other.cents); }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        return cents == ((Money) o).cents;
    }
    @Override public int hashCode() { return Objects.hash(cents); }
    @Override public String toString() { return String.format("$%d.%02d", cents / 100, cents % 100); }
}

public class MoneyDemo {
    public static void main(String[] args) {
        Money a = new Money(1250);
        Money b = new Money(1250);
        Money sum = a.plus(new Money(75));

        System.out.println("a           : " + a);
        System.out.println("a == b      : " + (a == b));
        System.out.println("a.equals(b) : " + a.equals(b));
        System.out.println("a + $0.75   : " + sum);
    }
}
```
**Expected output:**
```
a           : $12.50
a == b      : false
a.equals(b) : true
a + $0.75   : $13.25
```
