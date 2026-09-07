/**
 * Session 3 — Task 3.3 (Challenge) reference solution
 * Nested loops: an aligned 10x10 table (%4d pads each number to 4 columns),
 * and an inverted pyramid where the inner loop bound shrinks each outer pass.
 */
public class PatternGenerator {
    public static void main(String[] args) {
        System.out.println("=== 1. 10 x 10 MULTIPLICATION TABLE ===");
        for (int r = 1; r <= 10; r++) {
            for (int c = 1; c <= 10; c++) {
                System.out.printf("%4d", (r * c));
            }
            System.out.println();          // end the row
        }

        System.out.println("\n=== 2. INVERTED NUMBER PYRAMID ===");
        for (int i = 5; i >= 1; i--) {       // outer count shrinks: 5,4,3,2,1
            for (int j = 1; j <= i; j++) {   // inner bound follows i
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
