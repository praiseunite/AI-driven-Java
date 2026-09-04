/**
 * Session 4: Code Example 1
 * Program: PrimeNumberEngine.java
 * Purpose: Week 1 Consolidation. Demonstrates loops, decision making (if/else),
 *          boolean flags, and jump statements by checking prime numbers and listing primes up to N.
 */
public class PrimeNumberEngine {

    public static void main(String[] args) {
        int testNumber = 29;
        boolean isPrime = true;

        if (testNumber <= 1) {
            isPrime = false;
        } else {
            // Check divisibility from 2 up to the square root of the number
            for (int divisor = 2; divisor * divisor <= testNumber; divisor++) {
                if (testNumber % divisor == 0) {
                    isPrime = false;
                    break; // Early exit: no need to keep checking!
                }
            }
        }

        System.out.println("=== 1. INDIVIDUAL PRIME CHECK ===");
        System.out.printf("Is %d a prime number? %b%n", testNumber, isPrime);

        System.out.println("\n=== 2. LISTING ALL PRIMES BETWEEN 1 AND 50 ===");
        int primeCount = 0;
        for (int num = 2; num <= 50; num++) {
            boolean primeFlag = true;
            for (int d = 2; d * d <= num; d++) {
                if (num % d == 0) {
                    primeFlag = false;
                    break;
                }
            }
            if (primeFlag) {
                System.out.print(num + " ");
                primeCount++;
            }
        }
        System.out.println("\nTotal primes found between 1 and 50: " + primeCount);
    }
}
