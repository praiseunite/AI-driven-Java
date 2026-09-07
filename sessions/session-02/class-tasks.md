# Session 2: In-Class Practical Tasks 💻

> **Track:** AI-Driven Java Programming (JAVA-I) | **Session 2 Lab**
> Try each task yourself first. Full reference solutions: [solution/solution.html](solution/solution.html)

---

## 🟢 Task 2.1 (Easy): Temperature Conversion Station
**Objective:** Work with `double` variables, avoid the integer-division trap, and format with `printf`.

```java
public class TemperatureConverter {
    public static void main(String[] args) {
        double celsius = 37.5;
        double fahrenheit = (celsius * 9.0 / 5.0) + 32;

        System.out.println("=== WEATHER MONITORING SYSTEM ===");
        System.out.printf("Celsius Reading    : %.1f °C%n", celsius);
        System.out.printf("Fahrenheit Reading : %.1f °F%n", fahrenheit);
    }
}
```

**Expected output:**
```
=== WEATHER MONITORING SYSTEM ===
Celsius Reading    : 37.5 °C
Fahrenheit Reading : 99.5 °F
```

---

## 🟡 Task 2.2 (Medium): Campus Micro-Loan Calculator
**Objective:** Apply a simple-interest formula and format an aligned financial table.

```java
public class LoanCalculator {
    public static void main(String[] args) {
        double principal = 5000.00;
        double annualRate = 6.5;
        int durationYears = 2;

        double totalInterest = (principal * annualRate * durationYears) / 100.0;
        double totalRepayment = principal + totalInterest;
        double monthlyInstallment = totalRepayment / (durationYears * 12);

        System.out.println("========================================");
        System.out.println("     STUDENT LAPTOP LOAN SUMMARY        ");
        System.out.println("========================================");
        System.out.printf("Principal Borrowed : $%10.2f%n", principal);
        System.out.printf("Interest Rate      : %9.1f%%%n", annualRate);
        System.out.printf("Total Interest Fee : $%10.2f%n", totalInterest);
        System.out.printf("Total Repayment    : $%10.2f%n", totalRepayment);
        System.out.printf("Monthly Payment    : $%10.2f%n", monthlyInstallment);
        System.out.println("========================================");
    }
}
```

**Expected output:**
```
========================================
     STUDENT LAPTOP LOAN SUMMARY
========================================
Principal Borrowed : $   5000.00
Interest Rate      :       6.5%
Total Interest Fee : $    650.00
Total Repayment    : $   5650.00
Monthly Payment    : $    235.42
========================================
```

---

## 🔴 Task 2.3 (Challenge): BMI Metric & Ternary Classifier
**Objective:** Combine casting (truncation), relational + logical operators, and the ternary operator.

```java
public class BmiCalculator {
    public static void main(String[] args) {
        double weightKg = 72.5;
        double heightM = 1.78;

        double bmi = weightKg / (heightM * heightM);
        int truncatedBmi = (int) bmi;

        boolean isNormalRange = (bmi >= 18.5) && (bmi <= 24.9);
        String evaluation = isNormalRange ? "NORMAL WEIGHT" : "ATTENTION NEEDED";

        System.out.println("=== SMART HEALTH DIAGNOSTIC ===");
        System.out.printf("Weight (kg)        : %.1f%n", weightKg);
        System.out.printf("Height (m)         : %.2f%n", heightM);
        System.out.printf("Exact BMI          : %.2f%n", bmi);
        System.out.printf("Truncated BMI (int): %d%n", truncatedBmi);
        System.out.printf("Health Status      : %s%n", evaluation);
    }
}
```

**Expected output:**
```
=== SMART HEALTH DIAGNOSTIC ===
Weight (kg)        : 72.5
Height (m)         : 1.78
Exact BMI          : 22.88
Truncated BMI (int): 22
Health Status      : NORMAL WEIGHT
```

---

## 🟡 Task 2.4 (Medium): Interactive Tip Splitter (Scanner)
**Objective:** Read numbers typed by the user, apply a `final` constant, cast with `Math.round`, format currency.

```java
import java.util.Scanner;

public class TipSplitter {
    public static void main(String[] args) {
        final double TIP_RATE = 0.15;
        Scanner in = new Scanner(System.in);

        System.out.print("Bill amount: ");
        double bill = in.nextDouble();

        System.out.print("Number of people: ");
        int people = in.nextInt();

        double tip = bill * TIP_RATE;
        double total = bill + tip;
        double perPerson = total / people;

        System.out.printf("Tip (15%%)   : $%.2f%n", tip);
        System.out.printf("Total       : $%.2f%n", total);
        System.out.printf("Per person  : $%.2f%n", perPerson);
        System.out.printf("Per person  : %d cents%n", Math.round(perPerson * 100));

        in.close();
    }
}
```

**Expected output** (input: `86.40` then `4`):
```
Bill amount: Number of people: Tip (15%)   : $12.96
Total       : $99.36
Per person  : $24.84
Per person  : 2484 cents
```

Run it from a terminal without typing: `printf '86.40\n4\n' | java TipSplitter`
