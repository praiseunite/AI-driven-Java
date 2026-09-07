/**
 * Session 5 — Task 5.1 reference solution
 * Two private fields, a constructor with this., two methods that RETURN a computed value.
 */
public class Rectangle {
    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area()      { return width * height; }
    public double perimeter() { return 2 * (width + height); }

    public static void main(String[] args) {
        Rectangle a = new Rectangle(3, 4);
        Rectangle b = new Rectangle(5.5, 2);
        System.out.printf("A: area=%.2f perimeter=%.2f%n", a.area(), a.perimeter());
        System.out.printf("B: area=%.2f perimeter=%.2f%n", b.area(), b.perimeter());
    }
}
