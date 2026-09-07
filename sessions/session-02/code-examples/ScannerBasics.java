/**
 * Session 2: Code Example 5
 * Program: ScannerBasics.java
 * Purpose: Read keyboard input with Scanner and show the classic
 *          nextLine()-after-nextInt() trap and its fix.
 *
 * Compile & run:
 *   javac ScannerBasics.java
 *   java ScannerBasics
 *
 * Or feed the answers in without typing (name, age, city):
 *   printf 'Ada Lovelace\n36\nAbuja\n' | java ScannerBasics
 */
import java.util.Scanner;

public class ScannerBasics {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = input.nextLine();          // reads a whole line of text

        System.out.print("Enter your age: ");
        int age = input.nextInt();               // reads one integer

        // THE FIX: consume the leftover newline left behind by nextInt()
        input.nextLine();

        System.out.print("Enter your city: ");
        String city = input.nextLine();          // now this works correctly

        System.out.println();
        System.out.printf("Hi %s from %s!%n", name, city);
        System.out.printf("Next year you will be %d.%n", age + 1);

        input.close();
    }
}
