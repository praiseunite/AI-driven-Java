abstract class Shape {
    abstract double area();                       // no body: subclasses MUST provide one
    void describe() {
        System.out.printf("%s with area %.2f%n", getClass().getSimpleName(), area());
    }
}

class Circle extends Shape {
    private final double r;
    Circle(double r) { this.r = r; }
    @Override double area() { return Math.PI * r * r; }
}

class Rectangle extends Shape {
    private final double w, h;
    Rectangle(double w, double h) { this.w = w; this.h = h; }
    @Override double area() { return w * h; }
}

public class ShapeDemo {
    public static void main(String[] args) {
        // Shape s = new Shape();   // won't compile: Shape is abstract
        Shape[] shapes = { new Circle(3), new Rectangle(4, 5) };
        for (Shape s : shapes) s.describe();
    }
}
