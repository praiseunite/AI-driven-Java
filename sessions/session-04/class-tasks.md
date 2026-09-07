# Session 4: "Try It Yourself" Hands-on Review Lab 🛠️

> **Module:** JAVA-I-TL4 | **Coverage:** Sessions 1 to 3 Review
> Try each first. Full reference solutions: [solution/solution.html](solution/solution.html)

---

## 🟢 Challenge 4.1: Divisors & Prime Inspector
```java
public class DivisorInspector {
    public static void main(String[] args) {
        int n = 28;
        int divisorCount = 0;
        System.out.print("Divisors of " + n + ": ");
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                divisorCount++;
            }
        }
        System.out.println();
        System.out.println("Total Divisors: " + divisorCount);
        System.out.println("Is Prime? " + (divisorCount == 2 ? "YES" : "NO"));
    }
}
```
**Expected output:**
```
Divisors of 28: 1 2 4 7 14 28
Total Divisors: 6
Is Prime? NO
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

        System.out.println("Number Evaluated : " + original);
        System.out.println("Sum of Cubes     : " + sumOfCubes);
        if (original == sumOfCubes) {
            System.out.println("Result           : ARMSTRONG NUMBER CONFIRMED!");
        } else {
            System.out.println("Result           : NOT AN ARMSTRONG NUMBER");
        }
    }
}
```
**Expected output:**
```
Number Evaluated : 153
Sum of Cubes     : 153
Result           : ARMSTRONG NUMBER CONFIRMED!
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
**Expected output:**
```
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *
```

---

## 🟡 Challenge 4.4: Word Inspector (String methods + loop)
**Objective:** Read a word with `Scanner`; report length, uppercase, first/last char, whether it
contains `"a"`, and whether it is a palindrome (ignoring case).

```java
import java.util.Scanner;

public class WordInspector {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = in.nextLine().trim();

        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }
        boolean isPalindrome = word.equalsIgnoreCase(reversed);

        System.out.println("Length      : " + word.length());
        System.out.println("Upper case  : " + word.toUpperCase());
        System.out.println("First / last: " + word.charAt(0) + " / " + word.charAt(word.length() - 1));
        System.out.println("Contains a? : " + word.toLowerCase().contains("a"));
        System.out.println("Palindrome? : " + isPalindrome);

        in.close();
    }
}
```
**Expected output** (input: `Racecar`):
```
Enter a word: Length      : 7
Upper case  : RACECAR
First / last: R / r
Contains a? : true
Palindrome? : true
```
Run without typing: `printf 'Racecar\n' | java WordInspector`
