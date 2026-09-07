/**
 * Session 2: Code Example 4
 * Program: OperatorPlayground.java
 * Purpose: Demonstrates arithmetic, integer division, modulus, compound assignment,
 *          pre/post increment, operator precedence, the ternary operator, constants,
 *          and the Math class. No user input, so the output is fully deterministic.
 *
 * Compile & run:
 *   javac OperatorPlayground.java
 *   java OperatorPlayground
 */
public class OperatorPlayground {

    // A constant: UPPER_SNAKE_CASE, cannot be reassigned.
    static final double VAT_RATE = 0.075;

    public static void main(String[] args) {
        System.out.println("=== ARITHMETIC & DIVISION ===");
        int a = 7, b = 2;
        System.out.println("7 / 2   = " + (a / b));        // 3  (integer division)
        System.out.println("7.0 / 2 = " + (7.0 / b));      // 3.5
        System.out.println("17 % 5  = " + (17 % 5));       // 2  (remainder)
        System.out.println("8 is even? " + (8 % 2 == 0));  // true

        System.out.println("\n=== COMPOUND ASSIGNMENT ===");
        int total = 10;
        total += 5;  System.out.println("after += 5 : " + total); // 15
        total -= 3;  System.out.println("after -= 3 : " + total); // 12
        total *= 2;  System.out.println("after *= 2 : " + total); // 24
        total /= 4;  System.out.println("after /= 4 : " + total); // 6
        total %= 4;  System.out.println("after %= 4 : " + total); // 2

        System.out.println("\n=== INCREMENT: PRE vs POST ===");
        int i = 5;
        System.out.println("i++ prints " + (i++) + ", then i = " + i); // prints 5, i = 6
        int j = 5;
        System.out.println("++j prints " + (++j) + ", then j = " + j); // prints 6, j = 6

        System.out.println("\n=== PRECEDENCE ===");
        System.out.println("2 + 3 * 4      = " + (2 + 3 * 4));     // 14
        System.out.println("(2 + 3) * 4    = " + ((2 + 3) * 4));   // 20
        System.out.println("5 > 3 && 2 == 2 = " + (5 > 3 && 2 == 2)); // true

        System.out.println("\n=== TERNARY ===");
        int score = 78;
        String outcome = (score >= 50) ? "PASSED" : "FAILED";
        System.out.println("score 78 -> " + outcome);

        System.out.println("\n=== MATH CLASS ===");
        System.out.println("Math.abs(-7)     = " + Math.abs(-7));      // 7
        System.out.println("Math.pow(2, 10)  = " + Math.pow(2, 10));   // 1024.0
        System.out.println("Math.sqrt(144)   = " + Math.sqrt(144));    // 12.0
        System.out.println("Math.round(2.6)  = " + Math.round(2.6));   // 3
        System.out.println("Math.max(4, 9)   = " + Math.max(4, 9));    // 9

        System.out.println("\n=== CONSTANT + FORMATTING ===");
        double price = 89.95;
        double withTax = price * (1 + VAT_RATE);
        int cents = (int) Math.round(withTax * 100);
        System.out.printf("Price $%.2f + %.1f%% VAT = $%.2f (%d cents)%n",
                          price, VAT_RATE * 100, withTax, cents);
    }
}
