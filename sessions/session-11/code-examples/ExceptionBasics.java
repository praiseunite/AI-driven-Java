public class ExceptionBasics {

    static int safeDivide(int a, int b) {
        try {
            int result = a / b;                 // may throw ArithmeticException
            System.out.println("  try: computed " + result);
            return result;
        } catch (ArithmeticException e) {
            System.out.println("  catch: " + e.getMessage());
            return 0;
        } finally {
            System.out.println("  finally: always runs");
        }
    }

    public static void main(String[] args) {
        System.out.println("10 / 2:");
        System.out.println("-> " + safeDivide(10, 2));

        System.out.println("10 / 0:");
        System.out.println("-> " + safeDivide(10, 0));

        // Multiple catch + order (most specific first)
        String[] data = {"42", "oops", null};
        for (String s : data) {
            try {
                int n = Integer.parseInt(s);   // NumberFormatException / NullPointerException
                System.out.println("parsed " + n);
            } catch (NumberFormatException e) {
                System.out.println("not a number: \"" + s + "\"");
            } catch (NullPointerException e) {
                System.out.println("value was null");
            }
        }
    }
}
