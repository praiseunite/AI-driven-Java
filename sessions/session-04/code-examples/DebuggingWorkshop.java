/**
 * Session 4: Code Example 3
 * Program: DebuggingWorkshop.java
 * Purpose: Hands-on debugging exercises covering the top bugs from Sessions 1-3.
 */
public class DebuggingWorkshop {

    public static void main(String[] args) {
        System.out.println("=== WEEK 1 CODE REVIEW & DEBUGGING LAB ===");

        // Case 1: Division Precision
        // BUG: int avg = (80 + 85 + 90) / 4; // Expected 63.75, but gets 63!
        // FIX: Ensure double division:
        double fixedAverage = (80 + 85 + 90) / 4.0;
        System.out.printf("Bug 1 Fixed - Average: %.2f%n", fixedAverage);

        // Case 2: String Equality
        // In Java, comparing Strings with '==' checks memory addresses, NOT content!
        String inputRole = new String("ADMIN");
        // BUG: if (inputRole == "ADMIN") ... may evaluate to false!
        // FIX: Always use .equals() or switch:
        if (inputRole.equals("ADMIN")) {
            System.out.println("Bug 2 Fixed - String compared via .equals(): Role is ADMIN");
        }

        // Case 3: Off-by-one Loop Boundary
        // Want to print 1 to 5:
        // BUG: for (int i = 1; i < 5; i++) prints only 1 to 4!
        // FIX: Use <= or adjust limit:
        System.out.print("Bug 3 Fixed - Counting 1 to 5: ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
