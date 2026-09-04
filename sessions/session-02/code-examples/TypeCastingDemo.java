/**
 * Session 2: Code Example 3
 * Program: TypeCastingDemo.java
 * Purpose: Demonstrates Implicit (Widening) conversion and Explicit (Narrowing)
 *          casting, highlighting truncation, character casting, and integer overflow.
 */
public class TypeCastingDemo {

    public static void main(String[] args) {
        System.out.println("=== 1. IMPLICIT (WIDENING) CASTING ===");
        // byte -> short -> int -> long -> float -> double
        // Safe: smaller cup fits into a larger bucket automatically with no data loss!
        int wholeNumber = 42;
        double decimalBucket = wholeNumber; // Automatic widening

        System.out.println("Original int value   : " + wholeNumber);
        System.out.println("Widened double value : " + decimalBucket);

        System.out.println("\n=== 2. EXPLICIT (NARROWING) CASTING ===");
        // double -> float -> long -> int -> short -> byte
        // Risky: pouring a large bucket into a small cup! Requires explicit (type) syntax.
        double precisePi = 3.14159265359;
        int choppedPi = (int) precisePi; // Truncates decimal part! Does not round!

        System.out.println("Original double value: " + precisePi);
        System.out.println("Narrowed int value   : " + choppedPi);

        System.out.println("\n=== 3. CHARACTER & ASCII/UNICODE CASTING ===");
        char letter = 'A';
        int asciiCode = (int) letter; // Character to numeric code (65)
        int secretCode = 66;
        char decodedChar = (char) secretCode; // Numeric code back to char ('B')

        System.out.println("Character 'A' as number : " + asciiCode);
        System.out.println("Number 66 as character  : " + decodedChar);

        System.out.println("\n=== 4. OVERFLOW DEMONSTRATION ===");
        // A byte can only store numbers between -128 and 127
        int bigNumber = 130;
        byte overflowByte = (byte) bigNumber; // Wraps around to -126!
        System.out.println("Original int 130 cast to byte: " + overflowByte + " (Data corrupted by overflow!)");
    }
}
