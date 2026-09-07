/**
 * Session 7: Code Example 1
 * Program: StaticCounter.java
 * Purpose: A `static` field belongs to the CLASS (one shared copy). An instance field
 *          belongs to each OBJECT (its own copy). Here we count how many Robot objects
 *          have ever been created.
 *
 *   javac StaticCounter.java
 *   java StaticCounter
 */
class Robot {
    static int totalBuilt = 0;     // ONE copy, shared by all Robot objects
    int id;                        // each Robot has its own id

    Robot() {
        totalBuilt++;              // bump the shared counter
        id = totalBuilt;          // this robot's own number
    }

    static int getTotalBuilt() {   // static method: called on the class
        return totalBuilt;
    }
}

public class StaticCounter {
    public static void main(String[] args) {
        Robot a = new Robot();
        Robot b = new Robot();
        Robot c = new Robot();

        System.out.println("a.id = " + a.id);          // 1
        System.out.println("b.id = " + b.id);          // 2
        System.out.println("c.id = " + c.id);          // 3
        System.out.println("Total built = " + Robot.getTotalBuilt());   // 3

        // The counter is shared: reading it through any object sees the same value
        System.out.println("a sees totalBuilt = " + a.totalBuilt);      // 3 (not recommended style)
    }
}
