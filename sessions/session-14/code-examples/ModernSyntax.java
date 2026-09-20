import java.util.Optional;

public class ModernSyntax {

    record Point(int x, int y) {                 // records: immutable data carriers
        double distanceFromOrigin() { return Math.sqrt(x * x + y * y); }
    }

    static String describe(int code) {
        return switch (code) {                    // switch EXPRESSION: yields a value
            case 1, 2, 3 -> "low";
            case 4, 5, 6 -> "mid";
            default      -> "high";
        };
    }

    static Optional<String> lookup(String key) {
        return key.equals("known") ? Optional.of("value-42") : Optional.empty();
    }

    public static void main(String[] args) {
        var p = new Point(3, 4);                  // var: compiler infers Point
        System.out.println("point   : " + p + "  dist=" + p.distanceFromOrigin());
        System.out.println("accessor: x=" + p.x() + " y=" + p.y());

        System.out.println("describe(2) : " + describe(2));
        System.out.println("describe(5) : " + describe(5));
        System.out.println("describe(99): " + describe(99));

        String text = """
            line one
            line two
            """;                                  // text block
        System.out.print(text);

        System.out.println("lookup(known)   : " + lookup("known").orElse("<none>"));
        System.out.println("lookup(missing) : " + lookup("missing").orElse("<none>"));
    }
}
