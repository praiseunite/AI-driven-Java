class Vehicle {
    protected final String name;
    protected int speed = 0;
    Vehicle(String name) { this.name = name; }
    void accelerate(int d) { speed += d; }
    String describe() { return name + " at " + speed + " km/h"; }
}

class SportsCar extends Vehicle {
    SportsCar(String name) { super(name); }
    @Override void accelerate(int d) { speed += d * 2; }   // twice as punchy
}

class Truck extends Vehicle {
    private final int cargo;
    Truck(String name, int cargo) { super(name); this.cargo = cargo; }
    @Override String describe() { return super.describe() + " carrying " + cargo + "kg"; }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle[] fleet = { new Vehicle("Sedan"), new SportsCar("Viper"), new Truck("Hauler", 500) };
        for (Vehicle v : fleet) v.accelerate(20);
        for (Vehicle v : fleet) System.out.println(v.describe());
    }
}
