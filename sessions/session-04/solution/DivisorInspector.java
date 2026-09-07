/**
 * Session 4 — Challenge 4.1 reference solution
 * Print every divisor of n, then decide primality: a number is prime iff it has
 * exactly two divisors (1 and itself). 28 -> 1 2 4 7 14 28 -> 6 divisors -> not prime.
 */
public class DivisorInspector {
    public static void main(String[] args) {
        int n = 28;
        int divisorCount = 0;

        System.out.print("Divisors of " + n + ": ");
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {          // i divides n with no remainder
                System.out.print(i + " ");
                divisorCount++;
            }
        }
        System.out.println();
        System.out.println("Total Divisors: " + divisorCount);
        System.out.println("Is Prime? " + (divisorCount == 2 ? "YES" : "NO"));
    }
}
