/**
 * Session 2 — Task 2.1 (Easy) reference solution
 * Converts a Celsius temperature to Fahrenheit using floating-point division.
 *
 * Key point: writing 9 / 5 (int division) would give 1, breaking the formula.
 * Using 9.0 / 5.0 forces double division so the fraction survives.
 */
public class TemperatureConverter {
    public static void main(String[] args) {
        double celsius = 37.5;                          // human body temperature
        double fahrenheit = (celsius * 9.0 / 5.0) + 32; // 99.5

        System.out.println("=== WEATHER MONITORING SYSTEM ===");
        System.out.printf("Celsius Reading    : %.1f °C%n", celsius);
        System.out.printf("Fahrenheit Reading : %.1f °F%n", fahrenheit);
    }
}
