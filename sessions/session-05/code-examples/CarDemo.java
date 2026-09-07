/**
 * Session 5: Code Example 2
 * Program: CarDemo.java
 * Purpose: One .java file can hold a helper class plus the public driver class.
 *          Shows object independence: two Car objects each keep their own state.
 *
 *   javac CarDemo.java      (compiles BOTH classes -> Car.class and CarDemo.class)
 *   java CarDemo
 */

// A non-public helper class. Only ONE class per file may be public, and it must
// match the file name (CarDemo). Car does not need its own file here.
class Car {
    String model;
    int speed;              // package-private fields, fine for a teaching example

    Car(String model) {     // constructor
        this.model = model;
        this.speed = 0;
    }

    void accelerate(int delta) {
        speed += delta;
        System.out.println(model + " accelerates to " + speed + " km/h");
    }

    void brake() {
        speed = 0;
        System.out.println(model + " stops.");
    }
}

public class CarDemo {
    public static void main(String[] args) {
        Car a = new Car("Corolla");
        Car b = new Car("Mustang");

        a.accelerate(30);
        b.accelerate(80);
        a.accelerate(10);      // a is now 40, b is still 80 — separate objects
        b.brake();

        System.out.println("a.speed = " + a.speed + ", b.speed = " + b.speed);
    }
}
