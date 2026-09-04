/**
 * Session 3: Code Example 3
 * Program: NestedLoopsPattern.java
 * Purpose: Demonstrates nested loops (outer loop = rows, inner loop = columns)
 *          by generating a multiplication grid and a triangular star pattern.
 */
public class NestedLoopsPattern {

    public static void main(String[] args) {
        System.out.println("=== 1. MULTIPLICATION TABLE GRID (5 x 5) ===");
        for (int row = 1; row <= 5; row++) {
            for (int col = 1; col <= 5; col++) {
                System.out.printf("%4d", (row * col));
            }
            System.out.println(); // Newline after each row finishes
        }

        System.out.println("\n=== 2. RIGHT-ANGLED STAR TRIANGLE ===");
        int totalRows = 5;
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
