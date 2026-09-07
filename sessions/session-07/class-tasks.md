# Session 7: In-Class Practical Tasks 💻

> **Track:** AI-Driven Java Programming (JAVA-I) | **Session 7 Lab**
> Reference solutions: [solution/solution.html](solution/solution.html)

---

## 🟢 Task 7.1 (Easy): Auto-Numbered ID Cards (static counter)
A `static` field hands out sequential numbers; each card keeps its own `final` number.

```java
class IdCard {
    private static int nextNumber = 1000;
    private final int cardNumber;
    private final String holder;

    IdCard(String holder) {
        this.holder = holder;
        this.cardNumber = nextNumber;
        nextNumber++;
    }

    @Override
    public String toString() { return "Card #" + cardNumber + " - " + holder; }

    static int issued() { return nextNumber - 1000; }
}

public class IdCardDemo {
    public static void main(String[] args) {
        IdCard a = new IdCard("Ada");
        IdCard b = new IdCard("Bob");
        IdCard c = new IdCard("Cal");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println("Total issued: " + IdCard.issued());
    }
}
```
**Expected output:**
```
Card #1000 - Ada
Card #1001 - Bob
Card #1002 - Cal
Total issued: 3
```

---

## 🟡 Task 7.2 (Medium): `Temperature` Utility Class
All-static conversions; `private` constructor.

```java
public class Temperature {
    private Temperature() { }

    public static double cToF(double c) { return c * 9.0 / 5.0 + 32; }
    public static double fToC(double f) { return (f - 32) * 5.0 / 9.0; }
    public static double cToK(double c) { return c + 273.15; }

    public static void main(String[] args) {
        System.out.printf("100C = %.1fF%n", cToF(100));
        System.out.printf("32F  = %.1fC%n", fToC(32));
        System.out.printf("0C   = %.2fK%n", cToK(0));
    }
}
```
**Expected output:**
```
100C = 212.0F
32F  = 0.0C
0C   = 273.15K
```

---

## 🔴 Task 7.3 (Challenge): A Real Package — `com.aptech.geometry`
Put a utility class in a package (folder path must match), use it from a driver via `import`.

`com/aptech/geometry/Shapes.java`:
```java
package com.aptech.geometry;

public class Shapes {
    private Shapes() { }
    public static double circleArea(double r)              { return Math.PI * r * r; }
    public static double rectangleArea(double w, double h) { return w * h; }
    public static double triangleArea(double base, double h) { return 0.5 * base * h; }
}
```

`GeometryApp.java` (parent folder):
```java
import com.aptech.geometry.Shapes;

public class GeometryApp {
    public static void main(String[] args) {
        System.out.printf("Circle r=3        : %.2f%n", Shapes.circleArea(3));
        System.out.printf("Rectangle 4x5     : %.2f%n", Shapes.rectangleArea(4, 5));
        System.out.printf("Triangle b=6 h=8  : %.2f%n", Shapes.triangleArea(6, 8));
    }
}
```

Compile & run:
```
javac GeometryApp.java com/aptech/geometry/Shapes.java
java GeometryApp
```
**Expected output:**
```
Circle r=3        : 28.27
Rectangle 4x5     : 20.00
Triangle b=6 h=8  : 24.00
```

---

## 🟡 Task 7.4 (Medium): `PasswordVault` (access modifiers)
A `private` field and `private` helper the outside cannot reach — only the `public` methods.

```java
class PasswordVault {
    private String password;

    public PasswordVault(String initial) { this.password = initial; }

    private boolean isStrong(String p) {
        return p.length() >= 8 && !p.equalsIgnoreCase("password");
    }

    public boolean changePassword(String current, String next) {
        if (!password.equals(current)) { System.out.println("Current password wrong."); return false; }
        if (!isStrong(next))           { System.out.println("New password too weak."); return false; }
        password = next;
        System.out.println("Password changed.");
        return true;
    }

    public boolean verify(String attempt) { return password.equals(attempt); }
}

public class PasswordVaultDemo {
    public static void main(String[] args) {
        PasswordVault v = new PasswordVault("start123");
        v.changePassword("wrong", "muchbetter1");
        v.changePassword("start123", "short");
        v.changePassword("start123", "muchbetter1");
        System.out.println("verify('muchbetter1') -> " + v.verify("muchbetter1"));
        System.out.println("verify('start123')    -> " + v.verify("start123"));
    }
}
```
**Expected output:**
```
Current password wrong.
New password too weak.
Password changed.
verify('muchbetter1') -> true
verify('start123')    -> false
```
