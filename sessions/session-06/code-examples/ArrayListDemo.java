/**
 * Session 6: Code Example 3
 * Program: ArrayListDemo.java
 * Purpose: ArrayList grows and shrinks at runtime, unlike a fixed-size array.
 *          Also shows autoboxing: an ArrayList<Integer> stores int values that Java
 *          automatically wraps as Integer objects.
 *
 *   javac ArrayListDemo.java
 *   java ArrayListDemo
 */
import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();

        tasks.add("Write lesson");     // grows automatically
        tasks.add("Test code");
        tasks.add("Review PR");
        tasks.add("Ship");

        System.out.println("Size: " + tasks.size());
        System.out.println("First: " + tasks.get(0));
        System.out.println("Contains 'Ship'? " + tasks.contains("Ship"));

        tasks.remove("Review PR");     // shrinks automatically
        System.out.println("After remove: " + tasks);

        System.out.print("Iterate: ");
        for (String t : tasks) {
            System.out.print("[" + t + "] ");
        }
        System.out.println();

        // Autoboxing: we add plain ints; Java wraps them as Integer objects
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(20);
        nums.add(30);
        int sum = 0;
        for (int n : nums) {           // auto-unboxing back to int
            sum += n;
        }
        System.out.println("Sum of nums: " + sum);
    }
}
