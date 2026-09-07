# Session 10: In-Class Practical Tasks 💻

> **Track:** AI-Driven Java Programming (JAVA-I) | **Session 10 Lab**
> Reference solutions: [solution/solution.html](solution/solution.html)

---

## 🟢 Task 10.1 (Easy): `Drawable` interface + default method

```java
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
```
**Expected output:**
```
Circle area=12.57
Triangle area=12.00
Circle area=3.14
Total area: 27.71
```

---

## 🟡 Task 10.2 (Medium): Sort employees with `Comparable`

```java
import java.util.Arrays;

class Employee implements Comparable<Employee> {
    final String name;
    final int salary;
    Employee(String name, int salary) { this.name = name; this.salary = salary; }
    @Override public int compareTo(Employee o) { return Integer.compare(o.salary, this.salary); } // descending
    @Override public String toString() { return name + " ($" + salary + ")"; }
}

public class EmployeeSort {
    public static void main(String[] args) {
        Employee[] team = {
            new Employee("Ada", 72000),
            new Employee("Bode", 95000),
            new Employee("Chi", 68000)
        };
        Arrays.sort(team);
        for (Employee e : team) System.out.println(e);
    }
}
```
**Expected output:**
```
Bode ($95000)
Ada ($72000)
Chi ($68000)
```

---

## 🔴 Task 10.3 (Challenge): Button callbacks (anonymous class + lambda)

```java
interface ClickHandler {
    void onClick(String button);
}

class Button {
    private final String name;
    private ClickHandler handler;
    Button(String name) { this.name = name; }
    void setHandler(ClickHandler h) { this.handler = h; }
    void press() { if (handler != null) handler.onClick(name); }
}

public class ButtonDemo {
    public static void main(String[] args) {
        Button save = new Button("Save");
        Button quit = new Button("Quit");

        save.setHandler(new ClickHandler() {              // anonymous class
            @Override public void onClick(String button) {
                System.out.println("Saving... (" + button + " pressed)");
            }
        });

        quit.setHandler(b -> System.out.println("Bye! (" + b + " pressed)"));  // lambda

        save.press();
        quit.press();
    }
}
```
**Expected output:**
```
Saving... (Save pressed)
Bye! (Quit pressed)
```
