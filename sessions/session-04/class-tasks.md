# Session 4: "Try It Yourself" Hands-on Review Lab 🛠️

> **Module:** JAVA-I-TL4 | **Coverage:** Sessions 1 to 3 Review

---

## 🟢 Challenge 4.1: Divisors & Prime Inspector
```java
public class DivisorInspector {
    public static void main(String[] args) {
        int n = 28;
        int divisorCount = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                divisorCount++;
            }
        }
        System.out.println("\nTotal Divisors: " + divisorCount);
        System.out.println("Is Prime? " + (divisorCount == 2 ? "YES" : "NO"));
    }
}
```

---

## 🟡 Challenge 4.2: Armstrong Number Detector
```java
public class ArmstrongDetector {
    public static void main(String[] args) {
        int original = 153;
        int temp = original;
        int sumOfCubes = 0;

        while (temp > 0) {
            int digit = temp % 10;
            sumOfCubes += (digit * digit * digit);
            temp /= 10;
        }

        System.out.println("Is Armstrong: " + (original == sumOfCubes));
    }
}
```

---

## 🔴 Challenge 4.3: Diamond Star Pattern
```java
public class DiamondPattern {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= (n - i); s++) System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++) System.out.print("*");
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int s = 1; s <= (n - i); s++) System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++) System.out.print("*");
            System.out.println();
        }
    }
}
```
