# Session 2: In-Class Practical Tasks 💻

> **Track:** AI-Driven Java Programming (JAVA-I) | **Session 2 Lab**

---

## 🟢 Task 2.1 (Easy): Temperature Conversion Station
**Objective:** Work with `double` variables, practice arithmetic operations without integer truncation, and use `printf` formatting.

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

---

## 🟡 Task 2.2 (Medium): Campus Micro-Loan Calculator
**Objective:** Calculate simple interest, total repayment, and monthly payment installments formatted with `printf`.

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

---

## 🔴 Task 2.3 (Challenge): BMI Metric & Ternary Classifier
**Objective:** Calculate Body Mass Index, demonstrate explicit narrowing type casting, and evaluate health category via ternary operator.

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
