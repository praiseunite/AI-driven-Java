public class SafeParser {
    static int parseOrDefault(String s, int fallback) {
        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            System.out.println("  bad number \"" + s + "\" -> using " + fallback);
            return fallback;
        }
    }

    public static void main(String[] args) {
        String[] inputs = {"42", "  17 ", "seven", "-3", ""};
        int total = 0;
        for (String in : inputs) {
            total += parseOrDefault(in, 0);
        }
        System.out.println("Total: " + total);
    }
}
