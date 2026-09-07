# Session 3: In-Class Practical Tasks 💻

> **Track:** AI-Driven Java Programming (JAVA-I) | **Session 3 Lab**
> Try each task first. Full reference solutions: [solution/solution.html](solution/solution.html)

---

## 🟢 Task 3.1 (Easy): Traffic Signal Controller
**Objective:** A robust `switch-case` over `"RED"`, `"YELLOW"`, `"GREEN"`, `"FLASHING_YELLOW"`, with a `default` emergency stop.

```java
public class TrafficController {
    public static void main(String[] args) {
        String signal = "YELLOW";

        System.out.println("=== AI VEHICLE NAVIGATION SYSTEM ===");
        System.out.println("Detected Signal: " + signal);

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
            case "FLASHING_YELLOW":
                System.out.println("ACTION: Yield right of way and proceed with extreme caution.");
                break;
            default:
                System.out.println("ALERT: Sensor malfunction or unknown signal! Engaging emergency stop.");
                break;
        }
    }
}
```

**Expected output:**
```
=== AI VEHICLE NAVIGATION SYSTEM ===
Detected Signal: YELLOW
ACTION: Decelerate cautiously. Prepare to stop at line.
```

---

## 🟡 Task 3.2 (Medium): Number Series Analyzer with `continue`
**Objective:** `for` loop over 1–20, skip odds with `continue`, sum and average the evens.

```java
public class NumberSeriesAnalyzer {
    public static void main(String[] args) {
        int sumOfEvens = 0;
        int evenCount = 0;

        System.out.println("Iterating numbers 1 to 20 (processing evens only):");
        for (int i = 1; i <= 20; i++) {
            if (i % 2 != 0) {
                continue;
            }
            System.out.print(i + " ");
            sumOfEvens += i;
            evenCount++;
        }

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("Total Even Numbers Found: " + evenCount);
        System.out.println("Sum of All Even Numbers : " + sumOfEvens);
        System.out.printf("Average of Evens        : %.2f%n", (double) sumOfEvens / evenCount);
    }
}
```

**Expected output:**
```
Iterating numbers 1 to 20 (processing evens only):
2 4 6 8 10 12 14 16 18 20
----------------------------------------
Total Even Numbers Found: 10
Sum of All Even Numbers : 110
Average of Evens        : 11.00
```

---

## 🔴 Task 3.3 (Challenge): Multiplication Grid & Number Pyramid
**Objective:** Nested loops — an aligned 10×10 table (`%4d`) and an inverted number pyramid.

```java
public class PatternGenerator {
    public static void main(String[] args) {
        System.out.println("=== 1. 10 x 10 MULTIPLICATION TABLE ===");
        for (int r = 1; r <= 10; r++) {
            for (int c = 1; c <= 10; c++) {
                System.out.printf("%4d", (r * c));
            }
            System.out.println();
        }

        System.out.println("\n=== 2. INVERTED NUMBER PYRAMID ===");
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
```

**Expected output:**
```
=== 1. 10 x 10 MULTIPLICATION TABLE ===
   1   2   3   4   5   6   7   8   9  10
   2   4   6   8  10  12  14  16  18  20
   3   6   9  12  15  18  21  24  27  30
   4   8  12  16  20  24  28  32  36  40
   5  10  15  20  25  30  35  40  45  50
   6  12  18  24  30  36  42  48  54  60
   7  14  21  28  35  42  49  56  63  70
   8  16  24  32  40  48  56  64  72  80
   9  18  27  36  45  54  63  72  81  90
  10  20  30  40  50  60  70  80  90 100

=== 2. INVERTED NUMBER PYRAMID ===
1 2 3 4 5
1 2 3 4
1 2 3
1 2
1
```

---

## 🟡 Task 3.4 (Medium): Retry-Limited PIN Gate (Scanner + while + if)
**Objective:** Up to 3 attempts to enter the right PIN — `while` loop, `final` constant, counter, `break`. This is the exact pattern the Session 3 assignment needs.

```java
import java.util.Scanner;

public class PinGate {
    public static void main(String[] args) {
        final int CORRECT_PIN = 2026;
        final int MAX_TRIES = 3;

        Scanner in = new Scanner(System.in);
        int tries = 0;
        boolean unlocked = false;

        while (tries < MAX_TRIES) {
            System.out.print("Enter PIN: ");
            int pin = in.nextInt();

            if (pin == CORRECT_PIN) {
                unlocked = true;
                break;
            }
            tries++;
            System.out.println("Wrong PIN. Attempts left: " + (MAX_TRIES - tries));
        }

        if (unlocked) {
            System.out.println("Access granted. Welcome.");
        } else {
            System.out.println("Card retained. Please contact your bank.");
        }
        in.close();
    }
}
```

**Expected output** (input `1111`, `2222`, `2026`):
```
Enter PIN: Wrong PIN. Attempts left: 2
Enter PIN: Wrong PIN. Attempts left: 1
Enter PIN: Access granted. Welcome.
```

**Expected output** (input `1`, `2`, `3` — all wrong):
```
Enter PIN: Wrong PIN. Attempts left: 2
Enter PIN: Wrong PIN. Attempts left: 1
Enter PIN: Wrong PIN. Attempts left: 0
Card retained. Please contact your bank.
```

Run without typing: `printf '1111\n2222\n2026\n' | java PinGate`
