/**
 * Session 3: Code Example 4
 * Program: MenuLoop.java
 * Purpose: A do-while menu that must show at least once and repeats until the
 *          user chooses Exit. Combines do-while + Scanner (Session 2) + switch.
 *
 * Run:
 *   javac MenuLoop.java
 *   java MenuLoop
 * Or feed choices in without typing:
 *   printf '1\n2\n9\n3\n' | java MenuLoop
 */
import java.util.Scanner;

public class MenuLoop {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1) Say hello  2) Show time left  3) Exit");
            System.out.print("Choose: ");
            choice = in.nextInt();

            switch (choice) {
                case 1 -> System.out.println("Hello!");
                case 2 -> System.out.println("Two hours of class remain.");
                case 3 -> System.out.println("Goodbye.");
                default -> System.out.println("Unknown option, try again.");
            }
        } while (choice != 3);   // repeats until the user picks 3

        in.close();
    }
}
