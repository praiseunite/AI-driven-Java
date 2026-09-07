class Animal {
    protected String name;
    Animal(String name) { this.name = name; }
    String speak() { return name + " makes a sound"; }
}

class Dog extends Animal {
    Dog(String name) { super(name); }
    @Override String speak() { return name + " says Woof"; }
}

class Cat extends Animal {
    Cat(String name) { super(name); }
    @Override String speak() { return name + " says Meow"; }
}

public class AnimalDemo {
    public static void main(String[] args) {
        Animal[] zoo = { new Dog("Rex"), new Cat("Milo"), new Animal("Thing") };
        for (Animal a : zoo) {
            System.out.println(a.speak());   // dynamic dispatch: the REAL type's method runs
        }
    }
}
