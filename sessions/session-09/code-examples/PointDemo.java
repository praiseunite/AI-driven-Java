import java.util.Objects;

class Point {
    private final int x, y;
    Point(int x, int y) { this.x = x; this.y = y; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point p = (Point) o;
        return x == p.x && y == p.y;
    }
    @Override public int hashCode() { return Objects.hash(x, y); }
    @Override public String toString() { return "(" + x + ", " + y + ")"; }
}

public class PointDemo {
    public static void main(String[] args) {
        Point a = new Point(2, 3);
        Point b = new Point(2, 3);
        Point c = new Point(9, 9);

        System.out.println("a == b        : " + (a == b));          // false: different objects
        System.out.println("a.equals(b)   : " + a.equals(b));       // true: same contents
        System.out.println("a.equals(c)   : " + a.equals(c));       // false
        System.out.println("a.toString()  : " + a);
    }
}
