/**
 * Session 2 — Task 2.4 (Medium) reference solution
 * Interactive tip splitter: reads two numbers, applies a constant, formats currency.
 *
 * Note: this task reads a double then an int, and never calls nextLine() afterwards,
 * so the nextInt()/nextLine() trap does not bite here. It WOULD bite if we then asked
 * for a name with nextLine() — we would need a throwaway in.nextLine() first.
 */
import java.util.Scanner;

public class TipSplitter {
    public static void main(String[] args) {
        final double TIP_RATE = 0.15;                 // constant: never changes
        Scanner in = new Scanner(System.in);

        System.out.print("Bill amount: ");
        double bill = in.nextDouble();

        System.out.print("Number of people: ");
        int people = in.nextInt();

        double tip = bill * TIP_RATE;
        double total = bill + tip;
        double perPerson = total / people;

        System.out.printf("Tip (15%%)   : $%.2f%n", tip);
        System.out.printf("Total       : $%.2f%n", total);
        System.out.printf("Per person  : $%.2f%n", perPerson);
        System.out.printf("Per person  : %d cents%n", Math.round(perPerson * 100));

        in.close();
    }
}
