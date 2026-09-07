/**
 * Session 5: Code Example 3
 * Program: MethodPlayground.java
 * Purpose: Methods with parameters and return values, void vs returning a value,
 *          and method OVERLOADING (same name, different parameter lists).
 *
 *   javac MethodPlayground.java
 *   java MethodPlayground
 */
public class MethodPlayground {

    // returns a value
    static int square(int n) {
        return n * n;
    }

    // void: does something, returns nothing
    static void banner(String text) {
        System.out.println("==== " + text + " ====");
    }

    // --- Overloading: three methods named add, distinguished by their parameters ---
    static int add(int a, int b) {
        return a + b;
    }

    static int add(int a, int b, int c) {
        return a + b + c;
    }

    static double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        banner("SQUARE");
        int r = square(6);
        System.out.println("square(6) = " + r);

        banner("OVERLOADED add");
        System.out.println("add(2, 3)       = " + add(2, 3));
        System.out.println("add(2, 3, 4)    = " + add(2, 3, 4));
        System.out.println("add(2.5, 3.5)   = " + add(2.5, 3.5));
        // The compiler picks the version whose parameter list matches the call.
    }
}
