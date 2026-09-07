/**
 * Session 7: Code Example 2
 * Program: MathUtils.java
 * Purpose: A "utility class" — only static methods, no state, no instances.
 *          A private constructor stops anyone writing `new MathUtils()`.
 *          This is exactly how java.lang.Math is built.
 *
 *   javac MathUtils.java
 *   java MathUtils
 */
public class MathUtils {

    private MathUtils() { }        // nobody can instantiate this class

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("max(7, 12)    = " + MathUtils.max(7, 12));
        System.out.println("factorial(5)  = " + MathUtils.factorial(5));
        System.out.println("isPrime(29)   = " + MathUtils.isPrime(29));
        System.out.println("isPrime(30)   = " + MathUtils.isPrime(30));
    }
}
