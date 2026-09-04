/**
 * Session 2: Code Example 1
 * Program: VariableBasics.java
 * Purpose: Demonstrates all 8 Java primitive types and the String reference type,
 *          illustrating memory size, defaults, and appropriate real-world usage.
 */
public class VariableBasics {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       JAVA PRIMITIVE DATA TYPES SHOWCASE         ");
        System.out.println("==================================================");

        // 1. Integer Types (Whole numbers)
        byte userAge = 24;                 // 8-bit (-128 to 127)
        short flightAltitudeFeet = 32000;  // 16-bit (-32,768 to 32,767)
        int countryPopulation = 220000000; // 32-bit (~-2 billion to ~2 billion) - Most common!
        long globalDebtUsd = 315000000000000L; // 64-bit (Requires 'L' or 'l' suffix)

        // 2. Floating-Point Types (Decimals / Real numbers)
        float itemPrice = 19.99f;          // 32-bit (Requires 'f' or 'F' suffix)
        double astronomicalDistance = 149597870.7; // 64-bit - Default for decimals!

        // 3. Character Type (Single 16-bit Unicode character)
        char studentGrade = 'A';
        char currencySymbol = '$';
        char unicodeHeart = '\u2764';      // Heart emoji symbol

        // 4. Boolean Type (True or False only)
        boolean isEnrolled = true;
        boolean hasPassedExam = false;

        // 5. Reference Type: String (A sequence of characters)
        String studentName = "Amara Chukwu";
        String enrolledCourse = "AI-Driven Java Programming";

        // Display all variables
        System.out.println("Student Name     : " + studentName);
        System.out.println("Age (byte)       : " + userAge);
        System.out.println("Grade (char)     : " + studentGrade + " " + unicodeHeart);
        System.out.println("Enrolled (bool)  : " + isEnrolled);
        System.out.println("Course (String)  : " + enrolledCourse);
        System.out.println("Tuition (float)  : " + currencySymbol + itemPrice);
        System.out.println("Population (int) : " + countryPopulation);
        System.out.println("Global Debt(long): $" + globalDebtUsd);
    }
}
