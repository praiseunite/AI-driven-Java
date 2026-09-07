/**
 * Session 3 — Task 3.2 (Medium) reference solution
 * for loop 1..20, skip odds with continue, sum + average the evens.
 * (double) sumOfEvens forces floating-point division for the average.
 */
public class NumberSeriesAnalyzer {
    public static void main(String[] args) {
        int sumOfEvens = 0;
        int evenCount = 0;

        System.out.println("Iterating numbers 1 to 20 (processing evens only):");
        for (int i = 1; i <= 20; i++) {
            if (i % 2 != 0) {
                continue;            // odd -> skip straight to i++
            }
            System.out.print(i + " ");
            sumOfEvens += i;
            evenCount++;
        }

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("Total Even Numbers Found: " + evenCount);
        System.out.println("Sum of All Even Numbers : " + sumOfEvens);
        System.out.printf("Average of Evens        : %.2f%n", (double) sumOfEvens / evenCount);
    }
}
