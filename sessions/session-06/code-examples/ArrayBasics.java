/**
 * Session 6: Code Example 1
 * Program: ArrayBasics.java
 * Purpose: Declaring arrays, .length, indexing (0-based), the traditional for loop
 *          and the enhanced for-each loop, plus the accumulator/max patterns.
 *
 *   javac ArrayBasics.java
 *   java ArrayBasics
 */
public class ArrayBasics {
    public static void main(String[] args) {
        // Create + fill in one step
        int[] scores = {88, 72, 95, 64, 100};

        // An array knows its own size
        System.out.println("Number of scores: " + scores.length);

        // Traditional index loop — use when you need the index i
        System.out.print("By index : ");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
        System.out.println();

        // Enhanced for-each — use when you only need each value
        System.out.print("For-each : ");
        for (int s : scores) {
            System.out.print(s + " ");
        }
        System.out.println();

        // Accumulator + max patterns
        int total = 0;
        int max = scores[0];
        for (int s : scores) {
            total += s;
            if (s > max) max = s;
        }
        double average = (double) total / scores.length;

        System.out.printf("Total = %d, Max = %d, Average = %.2f%n", total, max, average);

        // Valid indexes are 0..length-1
        // System.out.println(scores[5]);  // would throw ArrayIndexOutOfBoundsException: 5
    }
}
