/**
 * Session 3 — Task 3.4 (Medium) reference solution
 * Up to MAX_TRIES attempts at the PIN. break exits the loop the moment it is right.
 * The boolean 'unlocked' records whether we left the loop by success or by running out.
 *
 * Scripted runs:
 *   printf '1111\n2222\n2026\n' | java PinGate   -> unlocks on the 3rd try
 *   printf '1\n2\n3\n'          | java PinGate   -> card retained
 */
import java.util.Scanner;

public class PinGate {
    public static void main(String[] args) {
        final int CORRECT_PIN = 2026;
        final int MAX_TRIES = 3;

        Scanner in = new Scanner(System.in);
        int tries = 0;
        boolean unlocked = false;

        while (tries < MAX_TRIES) {
            System.out.print("Enter PIN: ");
            int pin = in.nextInt();

            if (pin == CORRECT_PIN) {
                unlocked = true;
                break;
            }
            tries++;
            System.out.println("Wrong PIN. Attempts left: " + (MAX_TRIES - tries));
        }

        if (unlocked) {
            System.out.println("Access granted. Welcome.");
        } else {
            System.out.println("Card retained. Please contact your bank.");
        }
        in.close();
    }
}
