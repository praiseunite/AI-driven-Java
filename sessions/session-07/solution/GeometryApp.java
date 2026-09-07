import com.aptech.geometry.Shapes;
public class GeometryApp {
    public static void main(String[] args) {
        System.out.printf("Circle r=3        : %.2f%n", Shapes.circleArea(3));
        System.out.printf("Rectangle 4x5     : %.2f%n", Shapes.rectangleArea(4, 5));
        System.out.printf("Triangle b=6 h=8  : %.2f%n", Shapes.triangleArea(6, 8));
    }
}
