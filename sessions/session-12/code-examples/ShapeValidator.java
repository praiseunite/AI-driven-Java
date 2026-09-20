/**
 * Session 12 integrative demo #2: abstract base + interface + validation exceptions.
 */
class ShapeException extends RuntimeException {   // unchecked: bad construction is a bug
    ShapeException(String msg) { super(msg); }
}

interface Describable {
    String describe();
}

abstract class Shape2D implements Describable {
    abstract double area();
    @Override public String describe() {
        return String.format("%-9s area=%.2f", getClass().getSimpleName(), area());
    }
}

class Circle extends Shape2D {
    private final double r;
    Circle(double r) {
        if (r <= 0) throw new ShapeException("radius must be > 0, got " + r);
        this.r = r;
    }
    @Override double area() { return Math.PI * r * r; }
}

class Square extends Shape2D {
    private final double side;
    Square(double side) {
        if (side <= 0) throw new ShapeException("side must be > 0, got " + side);
        this.side = side;
    }
    @Override double area() { return side * side; }
}

public class ShapeValidator {
    public static void main(String[] args) {
        double[][] specs = { {1.0}, {3.0}, {-2.0} };   // last one is invalid
        java.util.ArrayList<Shape2D> shapes = new java.util.ArrayList<>();

        for (int i = 0; i < specs.length; i++) {
            try {
                Shape2D s = (i % 2 == 0) ? new Circle(specs[i][0]) : new Square(specs[i][0]);
                shapes.add(s);
            } catch (ShapeException e) {
                System.out.println("rejected spec " + i + ": " + e.getMessage());
            }
        }

        double total = 0;
        for (Describable d : shapes) {
            System.out.println(d.describe());
            total += ((Shape2D) d).area();
        }
        System.out.printf("Total area of %d valid shapes: %.2f%n", shapes.size(), total);
    }
}
