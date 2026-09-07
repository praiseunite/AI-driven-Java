interface Drawable {
    double area();
    default String summary() { return getClass().getSimpleName() + " area=" + String.format("%.2f", area()); }
}

class Circle implements Drawable {
    private final double r;
    Circle(double r) { this.r = r; }
    @Override public double area() { return Math.PI * r * r; }
}

class Triangle implements Drawable {
    private final double base, height;
    Triangle(double base, double height) { this.base = base; this.height = height; }
    @Override public double area() { return 0.5 * base * height; }
}

public class ShapeApp {
    public static void main(String[] args) {
        Drawable[] shapes = { new Circle(2), new Triangle(6, 4), new Circle(1) };
        double total = 0;
        for (Drawable d : shapes) {
            System.out.println(d.summary());
            total += d.area();
        }
        System.out.printf("Total area: %.2f%n", total);
    }
}
