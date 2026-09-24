import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * CalculatorStarter.java — Student Starter Scaffold
 * ==================================================
 * AI-Driven Java Programming (JAVA-I) — Aptech Courseware
 * Project: Advanced Java Calculator
 *
 * INSTRUCTIONS FOR STUDENTS:
 *   1. Read PRD.md before writing a single line of code.
 *   2. Work through the milestones in order (1 → 5).
 *   3. Each TODO comment tells you exactly what to implement.
 *   4. This file compiles as-is (stub methods return dummy values).
 *      Fill in each TODO, then re-compile and test.
 *   5. Only look at AdvancedCalculator.java after you've tried!
 *
 * Compile:  javac CalculatorStarter.java
 * Run:      java CalculatorStarter
 */

// ─────────────────────────────────────────────────────────────────────────────
// ✏️  MILESTONE 1, STEP A — Custom Exception  (Session 11)
// ─────────────────────────────────────────────────────────────────────────────
// TODO: Create a class called CalculatorException that extends RuntimeException.
//       It should have ONE constructor that takes a String message and passes
//       it to the parent class via super(message).
//
// Why RuntimeException and not Exception?
//   → RuntimeException is "unchecked": callers don't need to declare it with `throws`.
//     This keeps method signatures clean while still allowing us to catch it.
//
// Hint:  class CalculatorException extends RuntimeException { ... }

class CalculatorException extends RuntimeException {
    // TODO: Add the constructor here
    public CalculatorException(String message) {
        // TODO: call super(message)
        super("Not yet implemented: " + message);  // replace this line
    }
}


// ─────────────────────────────────────────────────────────────────────────────
// ✏️  MILESTONE 3, STEP A — Enum  (Session 10)
// ─────────────────────────────────────────────────────────────────────────────
// TODO: Define an enum called ConversionType with exactly 6 constants:
//         KM_TO_MI, MI_TO_KM, C_TO_F, F_TO_C, KG_TO_LB, LB_TO_KG
//
// An enum is the right tool here because:
//   → The set of conversions is FIXED (we know them all at compile time).
//   → Each name is self-documenting.
//   → switch expressions can be exhaustive over enums.

enum ConversionType {
    // TODO: list the 6 constants separated by commas
    KM_TO_MI   // placeholder — add the other 5!
}


// ─────────────────────────────────────────────────────────────────────────────
// Main Calculator Class  (Session 5 — class design, encapsulation)
// ─────────────────────────────────────────────────────────────────────────────

public class CalculatorStarter {

    // ── Constants ────────────────────────────────────────────────────────────
    private static final int MAX_HISTORY = 10;

    // ── Fields ───────────────────────────────────────────────────────────────
    // TODO (Milestone 1): Declare three private instance fields:
    //   1. double currentValue   — the running result
    //   2. double memory         — the memory slot
    //   3. ArrayDeque<String> history — the operation log
    //
    // Why private? Encapsulation (Session 5): only this class's methods can
    // read or change these values. The caller (main) uses methods like
    // calculate(), memoryStore(), showHistory() — never touching fields directly.
    //
    // Starter stubs (replace/fill in with your own declarations):
    private double currentValue = 0.0;           // TODO: keep private, initialise in constructor
    private double memory       = 0.0;           // TODO: keep private, initialise in constructor
    private final ArrayDeque<String> history = new ArrayDeque<>(); // TODO: init in constructor

    // ── Constructor ──────────────────────────────────────────────────────────
    // TODO (Milestone 1): Write a no-argument constructor that initialises:
    //   currentValue = 0.0
    //   memory       = 0.0
    //   history      = new ArrayDeque<>()
    public CalculatorStarter() {
        // TODO: initialise the three fields here
    }


    // =========================================================================
    // 🟢 MILESTONE 1 — Basic Arithmetic  (Sessions 2, 3, 11)
    // =========================================================================

    /**
     * Performs one arithmetic operation and returns the result.
     *
     * TODO:
     *   1. Use a switch expression (Session 14) on the `op` parameter.
     *   2. Cases: '+', '-', '*', '/'
     *   3. For '/', check if b == 0.0 first. If so, throw CalculatorException.
     *   4. For any other character, throw CalculatorException("Unknown operator...").
     *   5. After computing the result:
     *        a. Build a history string:  "10.0  +  5.0  =  15.0000"
     *        b. Call addToHistory(historyString)
     *        c. Set currentValue = result
     *        d. Return result
     *
     * @param a  first operand
     * @param op operator: '+', '-', '*', '/'
     * @param b  second operand
     * @return the computed result
     */
    public double calculate(double a, char op, double b) {
        // TODO: implement using a switch expression
        return 0.0; // placeholder
    }


    // =========================================================================
    // 🟡 MILESTONE 2A — History Log  (Session 6 — ArrayDeque)
    // =========================================================================

    /**
     * Adds an entry to the history deque.
     *
     * TODO:
     *   1. If history.size() == MAX_HISTORY, call history.pollFirst()
     *      (removes the oldest/head element — keeps the window at max 10)
     *   2. Call history.addLast(entry) to append the new entry.
     *
     * Why ArrayDeque?
     *   → O(1) add to tail and remove from head — perfect for a sliding window.
     */
    private void addToHistory(String entry) {
        // TODO: implement the sliding-window logic
    }

    /**
     * Prints the history log, numbered from 1.
     *
     * TODO:
     *   1. If history.isEmpty(), print "No operations recorded yet." and return.
     *   2. Print a separator line: "── History ──────────────────────────"
     *   3. Loop over history entries with an index counter (start at 1).
     *      Print each as:  " [1]  10.0  +  5.0  =  15.0000"
     *
     * Hint: history is an Iterable, so you can use a for-each loop.
     */
    public void showHistory() {
        // TODO: implement
    }


    // =========================================================================
    // 🟡 MILESTONE 2B — Memory  (Session 5 — private field / encapsulation)
    // =========================================================================

    /**
     * MS — Store currentValue in memory.
     * TODO: Set memory = currentValue, then print a confirmation message.
     */
    public void memoryStore() {
        // TODO
    }

    /**
     * MR — Recall memory into currentValue.
     * TODO: Set currentValue = memory, print the recalled value.
     */
    public void memoryRecall() {
        // TODO
    }

    /**
     * M+ — Add currentValue to memory.
     * TODO: memory += currentValue, print updated memory value.
     */
    public void memoryAdd() {
        // TODO
    }

    /**
     * MC — Clear memory to 0.0.
     * TODO: memory = 0.0, print a confirmation message.
     */
    public void memoryClear() {
        // TODO
    }


    // =========================================================================
    // 🟠 MILESTONE 3 — Unit Conversion  (Sessions 10, 14)
    // =========================================================================

    /**
     * Converts {@code value} using the given ConversionType.
     *
     * TODO:
     *   1. Write a switch expression on `type` with all 6 cases.
     *      Formulas (from PRD.md):
     *        KM_TO_MI : value * 0.621371
     *        MI_TO_KM : value / 0.621371
     *        C_TO_F   : (value * 9.0 / 5.0) + 32.0
     *        F_TO_C   : (value - 32.0) * 5.0 / 9.0
     *        KG_TO_LB : value * 2.20462
     *        LB_TO_KG : value / 2.20462
     *   2. Print the result, e.g.: "✔ 100.0000  [°C → °F]  =  212.0000"
     *   3. Call addToHistory(...) with a descriptive string.
     *   4. Set currentValue = result and return it.
     *
     * @param value  the quantity to convert
     * @param type   which conversion to apply
     * @return the converted value
     */
    public double convert(double value, ConversionType type) {
        // TODO: implement using a switch expression
        return 0.0; // placeholder
    }


    // =========================================================================
    // 🔴 MILESTONE 4 — Statistics  (Session 14 — Streams)
    // =========================================================================

    /**
     * Displays average, max, and sum of all history results.
     *
     * TODO:
     *   1. If history.size() < 2, print "Not enough history..." and return.
     *   2. Convert the deque to a List:
     *        List<String> entries = new ArrayList<>(history);
     *   3. Use entries.stream().mapToDouble(...) to extract the numeric result
     *      from each history string. Each entry ends with "=  <number>", so
     *      split on "=\\s+" and parse the last element.
     *   4. Call .summaryStatistics() to get average, max, and sum in one pass.
     *   5. Print the three statistics, formatted to 4 decimal places.
     *
     * Key Streams used: stream(), mapToDouble(), summaryStatistics()
     */
    public void showStats() {
        // TODO: implement with Streams
    }


    // =========================================================================
    // ⭐ MILESTONE 5 — UI Helpers & Polish
    // =========================================================================

    /**
     * Print the main menu.
     * TODO: Format it nicely. At minimum show:
     *   - A title banner
     *   - Current value and memory value
     *   - The 6 numbered options
     */
    private void showMenu() {
        // TODO: print the formatted menu (see PRD.md Section 4 for the sample)
        System.out.println("=== CALCULATOR ===");
        System.out.printf("Current: %.4f  |  Memory: %.4f%n", currentValue, memory);
        System.out.println("[1] Arithmetic  [2] Convert  [3] Memory  [4] History  [5] Stats  [0] Quit");
        System.out.print("Choice: ");
    }

    /**
     * Format a double value for display.
     * If the value has no fractional part, show it as a whole number.
     * Otherwise show 4 decimal places.
     * Example:  10.0 → "10"   |   3.1416 → "3.1416"
     */
    private static String formatNum(double v) {
        // TODO: implement. Hint: compare v == Math.floor(v)
        return String.format("%.4f", v); // placeholder: always shows 4dp
    }


    // =========================================================================
    // 🟢 MILESTONE 1 — Main Loop  (Sessions 3, 11)
    // =========================================================================

    /**
     * The interactive calculator loop.
     *
     * TODO:
     *   1. Create a Scanner to read from System.in.
     *   2. Use a do-while loop that continues until the user enters 0.
     *   3. Call showMenu() at the start of each iteration.
     *   4. Read the user's choice (parse as int — catch NumberFormatException).
     *   5. Use a switch statement to dispatch to the right feature:
     *        1 → prompt for operands + operator, call calculate()
     *        2 → show conversion sub-menu, call convert()
     *        3 → show memory sub-menu, call the right memory method
     *        4 → call showHistory()
     *        5 → call showStats()
     *        0 → print "Goodbye! 👋" (loop will exit)
     *   6. Wrap the switch in a try/catch for CalculatorException and
     *      NumberFormatException — print the message but keep the loop running.
     *   7. Close the Scanner when done.
     */
    public void run() {
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        System.out.println("Welcome to the Advanced Java Calculator!");
        System.out.println("(Complete the TODO in run() to make this fully interactive)\n");

        // TODO: implement the full do-while loop
        do {
            showMenu();
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
                System.out.println("You chose: " + choice + " — wire this up in the switch!");
            } catch (NumberFormatException e) {
                System.out.println("⚠ Enter a number 0–5.");
            }
        } while (choice != 0);

        System.out.println("Goodbye! 👋");
        sc.close();
    }

    // =========================================================================
    // Entry Point
    // =========================================================================

    /**
     * Creates one CalculatorStarter instance and starts the loop.
     * Keep main() minimal — create and run, nothing else (Session 5).
     */
    public static void main(String[] args) {
        new CalculatorStarter().run();
    }
}
