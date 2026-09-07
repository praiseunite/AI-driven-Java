public class Temperature {
    private Temperature() { }
    public static double cToF(double c) { return c * 9.0 / 5.0 + 32; }
    public static double fToC(double f) { return (f - 32) * 5.0 / 9.0; }
    public static double cToK(double c) { return c + 273.15; }
    public static void main(String[] args) {
        System.out.printf("100C = %.1fF%n", cToF(100));
        System.out.printf("32F  = %.1fC%n", fToC(32));
        System.out.printf("0C   = %.2fK%n", cToK(0));
    }
}
