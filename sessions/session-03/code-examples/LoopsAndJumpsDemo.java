/**
 * Session 3: Code Example 2
 * Program: LoopsAndJumpsDemo.java
 * Purpose: Demonstrates while, do-while, and for loops, plus jump statements (break, continue).
 */
public class LoopsAndJumpsDemo {

    public static void main(String[] args) {
        System.out.println("=== 1. FOR LOOP (KNOWN NUMBER OF ITERATIONS) ===");
        // Count from 1 to 5
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("\n=== 2. WHILE LOOP (ENTRY-CONTROLLED) ===");
        // Executes while condition is true. If condition is false initially, runs 0 times.
        int countdown = 3;
        while (countdown > 0) {
            System.out.println("Rocket launch in T-minus " + countdown + "...");
            countdown--;
        }
        System.out.println("Liftoff! 🚀");

        System.out.println("\n=== 3. DO-WHILE LOOP (EXIT-CONTROLLED) ===");
        // Guaranteed to execute AT LEAST ONCE even if condition is false!
        int attempt = 1;
        do {
            System.out.println("Execution attempt #" + attempt + " (Runs even though condition is immediately false)");
            attempt++;
        } while (attempt < 1); // false!

        System.out.println("\n=== 4. JUMP STATEMENTS: BREAK & CONTINUE ===");
        System.out.println("Looping numbers 1 through 10 with jumps:");
        for (int n = 1; n <= 10; n++) {
            if (n == 4) {
                System.out.println("-> Skipping 4 with 'continue' (Jumps directly to next iteration)");
                continue;
            }
            if (n == 8) {
                System.out.println("-> Halting loop at 8 with 'break' (Terminates loop entirely)");
                break;
            }
            System.out.println("Processing item #" + n);
        }
    }
}
