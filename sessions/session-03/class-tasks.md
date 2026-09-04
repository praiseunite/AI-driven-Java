# Session 3: In-Class Practical Tasks 💻

> **Track:** AI-Driven Java Programming (JAVA-I) | **Session 3 Lab**

---

## 🟢 Task 3.1 (Easy): Traffic Signal Controller
**Objective:** Implement a `switch-case` statement handling `"RED"`, `"YELLOW"`, `"GREEN"`, and emergency defaults.

```java
public class TrafficController {
    public static void main(String[] args) {
        String signal = "YELLOW";

        switch (signal.toUpperCase()) {
            case "RED":
                System.out.println("ACTION: Full Brake! Bring vehicle to complete stop.");
                break;
            case "YELLOW":
                System.out.println("ACTION: Decelerate cautiously. Prepare to stop at line.");
                break;
            case "GREEN":
                System.out.println("ACTION: Accelerate and proceed safely through intersection.");
                break;
            default:
                System.out.println("ALERT: Unknown signal! Engaging emergency stop.");
                break;
        }
    }
}
```

---

## 🟡 Task 3.2 (Medium): Number Series Analyzer with `continue`
**Objective:** Use a `for` loop to filter and process even numbers between 1 and 20, calculating sum and average.

```java
public class NumberSeriesAnalyzer {
    public static void main(String[] args) {
        int sumOfEvens = 0;
        int evenCount = 0;

        for (int i = 1; i <= 20; i++) {
            if (i % 2 != 0) {
                continue; // Skip odds
            }
            sumOfEvens += i;
            evenCount++;
        }

        System.out.println("Total Evens : " + evenCount);
        System.out.println("Sum of Evens: " + sumOfEvens);
    }
}
```

---

## 🔴 Task 3.3 (Challenge): 10 x 10 Multiplication Grid & Pattern
**Objective:** Use nested loops to generate a full multiplication grid and an inverted pyramid.

```java
public class PatternGenerator {
    public static void main(String[] args) {
        for (int r = 1; r <= 10; r++) {
            for (int c = 1; c <= 10; c++) {
                System.out.printf("%4d", (r * c));
            }
            System.out.println();
        }
    }
}
```
