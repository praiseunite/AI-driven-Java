import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;

/**
 * AdvancedCalculator.java — Complete Reference Solution
 * ======================================================
 * AI-Driven Java Programming (JAVA-I) — Aptech Courseware
 * Project: Advanced Java Calculator
 *
 * Concepts demonstrated (Sessions 2–14):
 *   S2  : double arithmetic, Math class
 *   S3  : do-while loop, if/else, switch expression
 *   S5  : class design, private fields, constructor, encapsulation
 *   S6  : ArrayDeque (sliding history window), ArrayList
 *   S10 : enum
 *   S11 : custom exception (CalculatorException), try/catch
 *   S14 : Streams (mapToDouble, average, max, sum), switch expression
 *   S15 : clean code, consistent naming, Javadoc-style comments
 *
 * Compile:  javac AdvancedCalculator.java
 * Run:      java AdvancedCalculator
 */

// ─────────────────────────────────────────────────────────────────────────────
// Custom Exception (Session 11)
// ─────────────────────────────────────────────────────────────────────────────

/**
 * Signals a calculator-specific error (e.g. divide-by-zero, bad input).
 * Extends RuntimeException so callers are NOT forced to declare it,
 * but we still catch it in the main loop for a graceful error message.
 */
class CalculatorException extends RuntimeException {
    public CalculatorException(String message) {
        super(message);
    }
}

// ─────────────────────────────────────────────────────────────────────────────
// Enum for Unit Conversions (Sessions 10, 14)
// ─────────────────────────────────────────────────────────────────────────────

/**
 * The six supported unit-conversion directions.
 * An enum is the right tool here: fixed set of constants,
 * each with a human-readable label, mapped by a switch expression.
 */
enum ConversionType {
    KM_TO_MI,   // kilometres → miles
    MI_TO_KM,   // miles → kilometres
    C_TO_F,     // Celsius → Fahrenheit
    F_TO_C,     // Fahrenheit → Celsius
    KG_TO_LB,   // kilograms → pounds
    LB_TO_KG    // pounds → kilograms
}

// ─────────────────────────────────────────────────────────────────────────────
// Main Calculator Class (Session 5 — class design & encapsulation)
// ─────────────────────────────────────────────────────────────────────────────

/**
 * AdvancedCalculator encapsulates all state and behaviour of the calculator.
 *
 * State (private fields — nobody outside touches these directly):
 *   currentValue — the running result displayed on screen
 *   memory       — a single memory slot (M+/M-/MS/MR/MC)
 *   history      — sliding window of the last MAX_HISTORY operations
 */
public class AdvancedCalculator {

    // ── Constants ────────────────────────────────────────────────────────────
    private static final int MAX_HISTORY = 10;   // sliding-window size

    // ── Fields ───────────────────────────────────────────────────────────────
    private double currentValue;                 // last computed result
    private double memory;                       // memory slot (M button)
    /** Deque lets us efficiently drop the oldest entry when full. */
    private final ArrayDeque<String> history;    // history log (Session 6)

    // ── Constructor ──────────────────────────────────────────────────────────
    /** Initialise with sensible defaults. */
    public AdvancedCalculator() {
        this.currentValue = 0.0;
        this.memory       = 0.0;
        this.history      = new ArrayDeque<>();
    }

    // =========================================================================
    // Feature 1: Basic Arithmetic  (Sessions 2, 3, 11)
    // =========================================================================

    /**
     * Performs a single arithmetic operation.
     *
     * @param a  first operand
     * @param op operator character: '+', '-', '*', '/'
     * @param b  second operand
     * @return   the computed result
     * @throws CalculatorException if op is '/' and b is 0, or op is unrecognised
     */
    public double calculate(double a, char op, double b) {
        double result = switch (op) {                    // switch expression (S14)
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0.0) {
                    // throwing a custom exception (Session 11)
                    throw new CalculatorException("Cannot divide by zero.");
                }
                yield a / b;
            }
            default -> throw new CalculatorException(
                    "Unknown operator '" + op + "'. Use +  -  *  /");
        };

        // Record the operation in history (Session 6 — ArrayDeque)
        String entry = String.format("%s  %c  %s  =  %.4f",
                formatNum(a), op, formatNum(b), result);
        addToHistory(entry);

        currentValue = result;
        return result;
    }

    // =========================================================================
    // Feature 2: Memory (Session 5 — encapsulation / private field)
    // =========================================================================

    /** Save currentValue to the single memory slot. */
    public void memoryStore() {
        memory = currentValue;
        System.out.printf("✔ Stored %.4f in memory.%n", memory);
    }

    /** Add currentValue to memory. */
    public void memoryAdd() {
        memory += currentValue;
        System.out.printf("✔ Memory updated to %.4f.%n", memory);
    }

    /** Load the memory slot into currentValue and display it. */
    public void memoryRecall() {
        currentValue = memory;
        System.out.printf("✔ Recalled from memory: %.4f%n", currentValue);
    }

    /** Zero out the memory slot. */
    public void memoryClear() {
        memory = 0.0;
        System.out.println("✔ Memory cleared.");
    }

    // =========================================================================
    // Feature 3: History Log  (Session 6 — ArrayDeque sliding window)
    // =========================================================================

    /**
     * Adds an operation string to the history.
     * If the deque is already at MAX_HISTORY, remove the oldest entry first.
     * ArrayDeque.addLast() appends to the tail; pollFirst() removes from head.
     */
    private void addToHistory(String entry) {
        if (history.size() == MAX_HISTORY) {
            history.pollFirst();      // drop the oldest entry (sliding window)
        }
        history.addLast(entry);       // append newest entry
    }

    /** Print the history log, numbered from 1. */
    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No operations recorded yet.");
            return;
        }
        System.out.println("── History " + "─".repeat(30));
        int index = 1;
        for (String entry : history) {              // for-each loop (Session 6)
            System.out.printf(" [%d]  %s%n", index++, entry);
        }
    }

    // =========================================================================
    // Feature 4: Unit Conversion  (Sessions 10, 14 — enum + switch expression)
    // =========================================================================

    /**
     * Converts {@code value} according to the given conversion type.
     * The switch expression maps every ConversionType constant to its formula.
     * Result is stored as currentValue.
     *
     * @param value        the quantity to convert
     * @param type         which conversion to apply
     * @return             the converted value
     */
    public double convert(double value, ConversionType type) {
        // switch expression (Session 14) — exhaustive: covers all 6 enum constants
        double result = switch (type) {
            case KM_TO_MI -> value * 0.621371;
            case MI_TO_KM -> value / 0.621371;
            case C_TO_F   -> (value * 9.0 / 5.0) + 32.0;
            case F_TO_C   -> (value - 32.0) * 5.0 / 9.0;
            case KG_TO_LB -> value * 2.20462;
            case LB_TO_KG -> value / 2.20462;
        };

        // Describe the conversion for display
        String label = switch (type) {
            case KM_TO_MI -> "km → mi";
            case MI_TO_KM -> "mi → km";
            case C_TO_F   -> "°C → °F";
            case F_TO_C   -> "°F → °C";
            case KG_TO_LB -> "kg → lb";
            case LB_TO_KG -> "lb → kg";
        };

        System.out.printf("✔ %.4f  [%s]  =  %.4f%n", value, label, result);
        addToHistory(String.format("%.4f [%s] = %.4f", value, label, result));
        currentValue = result;
        return result;
    }

    // =========================================================================
    // Feature 5: Statistics via Streams  (Session 14)
    // =========================================================================

    /**
     * Displays average, max, and sum of all numeric results stored in history.
     *
     * Strategy:
     *   1. Convert the deque to a List for stream access.
     *   2. Parse the result portion (after "= ") from each history entry.
     *   3. Feed into a DoubleStream and collect DoubleSummaryStatistics.
     */
    public void showStats() {
        // Collect history entries into a List so we can stream them (Session 14)
        List<String> entries = new ArrayList<>(history);

        if (entries.size() < 2) {
            System.out.println("Not enough history for statistics (need ≥ 2 operations).");
            return;
        }

        // Map each history entry to the numeric result after "= "
        DoubleSummaryStatistics stats = entries.stream()
                .mapToDouble(entry -> {
                    // Each entry ends with "=  <number>" — split on "=  "
                    String[] parts = entry.split("=\\s+");
                    return Double.parseDouble(parts[parts.length - 1].trim());
                })
                .summaryStatistics();   // one-pass: count, sum, min, max, average

        System.out.println("── Statistics (" + stats.getCount() + " operations) " + "─".repeat(20));
        System.out.printf("  Average : %.4f%n", stats.getAverage());
        System.out.printf("  Maximum : %.4f%n", stats.getMax());
        System.out.printf("  Sum     : %.4f%n", stats.getSum());
    }

    // =========================================================================
    // UI Helpers
    // =========================================================================

    /** Print the main menu header. */
    private void showMenu() {
        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║     ADVANCED JAVA CALCULATOR v1.0    ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.printf(" Current Value : %-10s  Memory : %.4f%n",
                formatNum(currentValue), memory);
        System.out.println();
        System.out.println(" [1] Arithmetic    [2] Unit Convert");
        System.out.println(" [3] Memory        [4] History");
        System.out.println(" [5] Stats         [0] Quit");
        System.out.println();
        System.out.print("Enter choice: ");
    }

    /** Print the unit-conversion sub-menu. */
    private static void showConversionMenu() {
        System.out.println(" Unit Conversions:");
        System.out.println("  [1] km  → miles    [2] miles → km");
        System.out.println("  [3] °C  → °F       [4] °F    → °C");
        System.out.println("  [5] kg  → lbs      [6] lbs   → kg");
        System.out.print(" Choice: ");
    }

    /** Print the memory sub-menu. */
    private static void showMemoryMenu() {
        System.out.println(" Memory Operations:");
        System.out.println("  [1] MS — Store    [2] MR — Recall");
        System.out.println("  [3] M+ — Add      [4] MC — Clear");
        System.out.print(" Choice: ");
    }

    /**
     * Format a double: show as an integer when it has no fractional part,
     * otherwise show four decimal places.  E.g. 10.0 → "10"  |  3.1416 → "3.1416"
     */
    private static String formatNum(double v) {
        return (v == Math.floor(v) && !Double.isInfinite(v))
                ? String.valueOf((long) v)
                : String.format("%.4f", v);
    }

    // =========================================================================
    // Main Application Loop  (Sessions 3, 11)
    // =========================================================================

    /**
     * The primary entry-point logic.
     * Wraps everything in a do-while so the menu always re-displays,
     * and catches CalculatorException to keep running on bad input.
     */
    public void run() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            showMenu();

            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("⚠ Please enter a number (0–5).");
                choice = -1;   // sentinel: re-display the menu
                continue;
            }

            try {
                switch (choice) {

                    // ── [1] Arithmetic ────────────────────────────────────────
                    case 1 -> {
                        System.out.printf("Enter first operand (Enter = use %.4f): ",
                                currentValue);
                        String rawA = sc.nextLine().trim();
                        double a = rawA.isEmpty() ? currentValue
                                                  : Double.parseDouble(rawA);

                        System.out.print("Enter operator (+  -  *  /): ");
                        String opStr = sc.nextLine().trim();
                        if (opStr.length() != 1) {
                            throw new CalculatorException("Type exactly one operator character.");
                        }
                        char op = opStr.charAt(0);

                        System.out.print("Enter second operand: ");
                        double b = Double.parseDouble(sc.nextLine().trim());

                        double result = calculate(a, op, b);
                        System.out.printf("✔ %s %c %s = %.4f%n",
                                formatNum(a), op, formatNum(b), result);
                    }

                    // ── [2] Unit Conversion ───────────────────────────────────
                    case 2 -> {
                        showConversionMenu();
                        int cvChoice = Integer.parseInt(sc.nextLine().trim());

                        // Map 1–6 to ConversionType enum values using ordinal order
                        ConversionType[] types = ConversionType.values();
                        if (cvChoice < 1 || cvChoice > types.length) {
                            throw new CalculatorException("Invalid conversion choice: " + cvChoice);
                        }

                        System.out.print(" Enter value to convert: ");
                        double val = Double.parseDouble(sc.nextLine().trim());
                        convert(val, types[cvChoice - 1]);
                    }

                    // ── [3] Memory ────────────────────────────────────────────
                    case 3 -> {
                        showMemoryMenu();
                        int mChoice = Integer.parseInt(sc.nextLine().trim());
                        switch (mChoice) {
                            case 1 -> memoryStore();
                            case 2 -> memoryRecall();
                            case 3 -> memoryAdd();
                            case 4 -> memoryClear();
                            default -> throw new CalculatorException(
                                    "Invalid memory choice: " + mChoice);
                        }
                    }

                    // ── [4] History ───────────────────────────────────────────
                    case 4 -> showHistory();

                    // ── [5] Stats ─────────────────────────────────────────────
                    case 5 -> showStats();

                    // ── [0] Quit ──────────────────────────────────────────────
                    case 0 -> System.out.println("Goodbye! 👋");

                    default -> System.out.println("⚠ Invalid choice. Enter 0–5.");
                }

            } catch (CalculatorException ce) {
                // Our own error — print friendly message and continue
                System.out.println("⚠ Error: " + ce.getMessage());

            } catch (NumberFormatException nfe) {
                // User typed text where a number was expected
                System.out.println("⚠ Invalid number. Please try again.");
            }

        } while (choice != 0);   // exit when user types 0

        sc.close();
    }

    // =========================================================================
    // Program Entry Point
    // =========================================================================

    /**
     * Creates one AdvancedCalculator instance and starts the interactive loop.
     * Keeping main() minimal is good practice (Session 5).
     */
    public static void main(String[] args) {
        new AdvancedCalculator().run();
    }
}
