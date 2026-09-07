/**
 * Session 2 — Task 2.3 (Challenge) reference solution
 * Body Mass Index with a truncating cast and a ternary classifier.
 *
 *   BMI = weight(kg) / height(m)^2
 *
 * (int) bmi TRUNCATES — 22.88 becomes 22, it does not round to 23.
 * The healthy band 18.5..24.9 is checked with && (both conditions must hold).
 */
public class BmiCalculator {
    public static void main(String[] args) {
        double weightKg = 72.5;
        double heightM = 1.78;

        double bmi = weightKg / (heightM * heightM);   // 22.88...
        int truncatedBmi = (int) bmi;                  // 22

        boolean isNormalRange = (bmi >= 18.5) && (bmi <= 24.9);
        String evaluation = isNormalRange ? "NORMAL WEIGHT" : "ATTENTION NEEDED";

        System.out.println("=== SMART HEALTH DIAGNOSTIC ===");
        System.out.printf("Weight (kg)        : %.1f%n", weightKg);
        System.out.printf("Height (m)         : %.2f%n", heightM);
        System.out.printf("Exact BMI          : %.2f%n", bmi);
        System.out.printf("Truncated BMI (int): %d%n", truncatedBmi);
        System.out.printf("Health Status      : %s%n", evaluation);
    }
}
