/**
 * Session 2: Code Example 2
 * Program: OperatorsAndFormatting.java
 * Purpose: Demonstrates arithmetic, relational, logical, assignment operators,
 *          plus formatted printing with printf and format specifiers (%d, %.2f, %s).
 */
public class OperatorsAndFormatting {

    public static void main(String[] args) {
        System.out.println("=== 1. ARITHMETIC OPERATORS & INTEGER DIVISION ===");
        int score1 = 85;
        int score2 = 90;
        int total = score1 + score2;
        int product = 15 * 4;
        int remainder = 29 % 5; // Modulus (Remainder of 29 / 5 is 4)

        // TRAP ALERT: Integer division truncates decimals!
        int intDivision = 7 / 2;       // Evaluates to 3, NOT 3.5!
        double properDivision = 7.0 / 2; // Evaluates to 3.5

        System.out.println("Sum: " + total + ", Product: " + product + ", Remainder (29 % 5): " + remainder);
        System.out.println("7 / 2 (int division)   : " + intDivision);
        System.out.println("7.0 / 2 (float division): " + properDivision);

        System.out.println("\n=== 2. RELATIONAL & LOGICAL OPERATORS ===");
        int attendanceScore = 80;
        int examScore = 72;
        boolean hasGoodAttendance = attendanceScore >= 75; // true
        boolean hasPassedExam = examScore >= 50;           // true

        // Logical AND (&&): Both must be true
        boolean qualifiesForCertificate = hasGoodAttendance && hasPassedExam;

        // Logical OR (||): At least one is true
        boolean needsTutoring = (examScore < 60) || (attendanceScore < 70);

        // Logical NOT (!): Inverts boolean
        boolean isSuspended = !hasGoodAttendance;

        System.out.println("Attendance Good?      : " + hasGoodAttendance);
        System.out.println("Qualifies Certificate?: " + qualifiesForCertificate);
        System.out.println("Needs Extra Tutoring? : " + needsTutoring);
        System.out.println("Is Suspended?         : " + isSuspended);

        System.out.println("\n=== 3. TERNARY OPERATOR ===");
        // Syntax: condition ? valueIfTrue : valueIfFalse
        String status = (examScore >= 50) ? "PASS" : "FAIL";
        System.out.println("Exam Status via Ternary: " + status);

        System.out.println("\n=== 4. FORMATTED OUTPUT WITH printf ===");
        String productName = "AI Developer Laptop";
        double unitPrice = 1299.9954;
        int quantity = 3;
        double subtotal = unitPrice * quantity;
        double taxRate = 0.075;
        double totalWithTax = subtotal * (1 + taxRate);

        // %s = String, %d = integer, %.2f = float/double rounded to 2 decimal places, %n = newline
        System.out.printf("Item Name      : %-25s%n", productName);
        System.out.printf("Unit Price     : $%10.2f%n", unitPrice);
        System.out.printf("Quantity       : %10d%n", quantity);
        System.out.printf("Subtotal       : $%10.2f%n", subtotal);
        System.out.printf("Tax (7.5%%)     : $%10.2f%n", (subtotal * taxRate));
        System.out.println("----------------------------------------");
        System.out.printf("TOTAL CHARGE   : $%10.2f%n", totalWithTax);
    }
}
