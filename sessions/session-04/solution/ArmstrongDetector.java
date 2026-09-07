/**
 * Session 4 — Challenge 4.2 reference solution
 * Digit-extraction pattern: digit = temp % 10; temp /= 10; repeats until temp is 0.
 * Sum the cube of each digit; it's an Armstrong number if that sum equals the original.
 * 153 -> 1 + 125 + 27 = 153. We copy 'original' into 'temp' so we still have the
 * original value to compare against at the end.
 */
public class ArmstrongDetector {
    public static void main(String[] args) {
        int original = 153;
        int temp = original;
        int sumOfCubes = 0;

        while (temp > 0) {
            int digit = temp % 10;
            sumOfCubes += (digit * digit * digit);
            temp /= 10;
        }

        System.out.println("Number Evaluated : " + original);
        System.out.println("Sum of Cubes     : " + sumOfCubes);
        if (original == sumOfCubes) {
            System.out.println("Result           : ARMSTRONG NUMBER CONFIRMED!");
        } else {
            System.out.println("Result           : NOT AN ARMSTRONG NUMBER");
        }
    }
}
