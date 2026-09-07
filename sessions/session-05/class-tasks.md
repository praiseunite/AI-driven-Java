# Session 5: In-Class Practical Tasks 💻

> **Track:** AI-Driven Java Programming (JAVA-I) | **Session 5 Lab**
> Try each first. Full reference solutions: [solution/solution.html](solution/solution.html)

---

## 🟢 Task 5.1 (Easy): The `Rectangle` Class
Two `private` fields, a constructor using `this.`, and two methods that **return** a value.

```java
public class Rectangle {
    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area()      { return width * height; }
    public double perimeter() { return 2 * (width + height); }

    public static void main(String[] args) {
        Rectangle a = new Rectangle(3, 4);
        Rectangle b = new Rectangle(5.5, 2);
        System.out.printf("A: area=%.2f perimeter=%.2f%n", a.area(), a.perimeter());
        System.out.printf("B: area=%.2f perimeter=%.2f%n", b.area(), b.perimeter());
    }
}
```
**Expected output:**
```
A: area=12.00 perimeter=14.00
B: area=11.00 perimeter=15.00
```

---

## 🟡 Task 5.2 (Medium): The `Wallet` Class (Encapsulation)
A `private double balance` that only changes through validating methods.

```java
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
```
**Expected output:**
```
Ada added $15.50 -> $35.50
Ada spent $10.00 -> $25.50
Ada cannot spend $100.00 (only $25.50).
Final balance: $25.50
```

---

## 🔴 Task 5.3 (Challenge): The `Student` Class (Constructor Overloading + `toString`)
Two constructors (one delegates with `this(...)`), a `grade()` that **returns** a letter, a readable `toString()`.

```java
public class Student {
    private String name, track;
    private int score;

    public Student(String name, String track, int score) {
        this.name = name;
        this.track = track;
        this.score = score;
    }

    public Student(String name, String track) {
        this(name, track, 0);
    }

    public void addScore(int delta) { score += delta; }

    public String grade() {
        if (score >= 80) return "A";
        if (score >= 70) return "B";
        if (score >= 50) return "C";
        return "F";
    }

    @Override
    public String toString() {
        return String.format("%s [%s] score=%d grade=%s", name, track, score, grade());
    }

    public static void main(String[] args) {
        Student s1 = new Student("Amara", "AI-Driven Java", 68);
        Student s2 = new Student("Ken", "AI-Driven Java");
        s1.addScore(7);
        s2.addScore(82);
        System.out.println(s1);
        System.out.println(s2);
    }
}
```
**Expected output:**
```
Amara [AI-Driven Java] score=75 grade=B
Ken [AI-Driven Java] score=82 grade=A
```

---

## 🟡 Task 5.4 (Medium): The `Calculator` Class (Method Overloading)
Three methods named `multiply`, distinguished by parameter list.

```java
public class Calculator {
    int multiply(int a, int b)            { return a * b; }
    int multiply(int a, int b, int c)     { return a * b * c; }
    double multiply(double a, double b)   { return a * b; }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println("multiply(4, 5)      = " + c.multiply(4, 5));
        System.out.println("multiply(2, 3, 4)   = " + c.multiply(2, 3, 4));
        System.out.println("multiply(1.5, 2.0)  = " + c.multiply(1.5, 2.0));
    }
}
```
**Expected output:**
```
multiply(4, 5)      = 20
multiply(2, 3, 4)   = 24
multiply(1.5, 2.0)  = 3.0
```
