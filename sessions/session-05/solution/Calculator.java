/**
 * Session 5 — Task 5.4 reference solution
 * Three methods named multiply. The compiler chooses one by matching the argument
 * count and types at each call site. Return type alone could not distinguish them.
 */
public class Calculator {
    int multiply(int a, int b)          { return a * b; }
    int multiply(int a, int b, int c)   { return a * b * c; }
    double multiply(double a, double b) { return a * b; }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println("multiply(4, 5)      = " + c.multiply(4, 5));
        System.out.println("multiply(2, 3, 4)   = " + c.multiply(2, 3, 4));
        System.out.println("multiply(1.5, 2.0)  = " + c.multiply(1.5, 2.0));
    }
}
