/**
 * JDK 21+ : sealed types + records + pattern matching for switch, with deconstruction.
 */
public class RecordPatterns {

    sealed interface Shape permits Circle, Rectangle, Triangle {}
    record Circle(double radius) implements Shape {}
    record Rectangle(double w, double h) implements Shape {}
    record Triangle(double base, double height) implements Shape {}

    static double area(Shape s) {
        return switch (s) {
            case Circle c          -> Math.PI * c.radius() * c.radius();
            case Rectangle(double w, double h) -> w * h;              // record deconstruction
            case Triangle(double b, double h)  -> 0.5 * b * h;
        };  // no default needed: the compiler knows all permitted subtypes
    }

    static String describe(Object o) {
        return switch (o) {
            case Integer i when i < 0 -> "negative int";
            case Integer i            -> "int " + i;
            case String str           -> "string of length " + str.length();
            case null                 -> "null";
            default                   -> "something else";
        };
    }

    public static void main(String[] args) {
        Shape[] shapes = { new Circle(2), new Rectangle(3, 4), new Triangle(6, 8) };
        for (Shape s : shapes) {
            System.out.printf("%-22s area=%.2f%n", s, area(s));
        }
        System.out.println(describe(42));
        System.out.println(describe(-1));
        System.out.println(describe("hello"));
        System.out.println(describe(null));
    }
}
