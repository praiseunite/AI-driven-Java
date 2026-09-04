/**
 * Session 4: Code Example 2
 * Program: FibonacciAndPalindrome.java
 * Purpose: Consolidates while and for loops with digit extraction math (modulus & integer division).
 */
public class FibonacciAndPalindrome {

    public static void main(String[] args) {
        System.out.println("=== 1. FIBONACCI SEQUENCE (FIRST 10 TERMS) ===");
        int termCount = 10;
        int firstTerm = 0;
        int secondTerm = 1;

        System.out.print("Fibonacci Series: ");
        for (int i = 1; i <= termCount; i++) {
            System.out.print(firstTerm + " ");
            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
        System.out.println();

        System.out.println("\n=== 2. PALINDROME NUMBER VERIFIER ===");
        int originalNumber = 12321;
        int temp = originalNumber;
        int reversedNumber = 0;

        // Mathematical digit reversal using modulus and integer division
        while (temp > 0) {
            int lastDigit = temp % 10;
            reversedNumber = (reversedNumber * 10) + lastDigit;
            temp = temp / 10; // Chops off the last digit
        }

        System.out.println("Original Number : " + originalNumber);
        System.out.println("Reversed Number : " + reversedNumber);
        if (originalNumber == reversedNumber) {
            System.out.println("Result          : PALINDROME CONFIRMED! (Reads identical backwards)");
        } else {
            System.out.println("Result          : NOT A PALINDROME");
        }
    }
}
