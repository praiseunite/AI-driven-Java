import java.util.*;

public class Inventory<T> {                 // a generic container class
    private final List<T> items = new ArrayList<>();

    void add(T item) { items.add(item); }
    T get(int i) { return items.get(i); }
    int size() { return items.size(); }

    // generic static helper with a bound
    static <E extends Comparable<E>> E largest(List<E> list) {
        E best = list.get(0);
        for (E e : list) if (e.compareTo(best) > 0) best = e;
        return best;
    }

    public static void main(String[] args) {
        Inventory<String> books = new Inventory<>();
        books.add("Java");
        books.add("Kotlin");
        books.add("Scala");
        System.out.println("books size : " + books.size() + ", first: " + books.get(0));

        System.out.println("largest int : " + largest(List.of(3, 8, 5, 1)));
        System.out.println("largest str : " + largest(List.of("pear", "apple", "mango")));
    }
}
