# Session 14: In-Class Practical Tasks 💻

> **Track:** AI-Driven Java Programming (JAVA-I) | **Session 14 Lab**
> Reference solutions: [solution/solution.html](solution/solution.html)

---

## 🟢 Task 14.1 (Easy): Number Pipeline (filter → map → sorted → collect)

```java
import java.util.*;
import java.util.stream.*;

public class NumberPipeline {
    public static void main(String[] args) {
        List<Integer> nums = List.of(4, 7, 2, 9, 6, 1, 8, 3, 10, 5);

        List<Integer> evensSquaredDesc = nums.stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n * n)
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        System.out.println("even, squared, desc : " + evensSquaredDesc);

        int sumOdd = nums.stream().filter(n -> n % 2 != 0).mapToInt(Integer::intValue).sum();
        System.out.println("sum of odds          : " + sumOdd);

        OptionalDouble avg = nums.stream().mapToInt(Integer::intValue).average();
        System.out.printf("average              : %.1f%n", avg.getAsDouble());

        boolean anyOver9 = nums.stream().anyMatch(n -> n > 9);
        System.out.println("any > 9?             : " + anyOver9);
    }
}
```
**Expected output:**
```
even, squared, desc : [100, 64, 36, 16, 4]
sum of odds          : 25
average              : 5.5
any > 9?             : true
```

---

## 🟡 Task 14.2 (Medium): Employee Report (records + groupingBy)

```java
import java.util.*;
import java.util.stream.*;

public class EmployeeReport {
    record Employee(String name, String dept, int salary) {}

    public static void main(String[] args) {
        List<Employee> staff = List.of(
            new Employee("Ada", "ENG", 95000),
            new Employee("Bode", "ENG", 82000),
            new Employee("Chi", "SALES", 70000),
            new Employee("Dee", "SALES", 91000),
            new Employee("Eze", "ENG", 78000)
        );

        Map<String, Long> countByDept = staff.stream()
            .collect(Collectors.groupingBy(Employee::dept, Collectors.counting()));
        System.out.println("count by dept   : " + new TreeMap<>(countByDept));

        Map<String, Double> avgByDept = staff.stream()
            .collect(Collectors.groupingBy(Employee::dept,
                     Collectors.averagingInt(Employee::salary)));
        System.out.println("avg salary/dept : " + new TreeMap<>(avgByDept));

        String topEarner = staff.stream()
            .max(Comparator.comparingInt(Employee::salary))
            .map(Employee::name)
            .orElse("<none>");
        System.out.println("top earner      : " + topEarner);

        String engNames = staff.stream()
            .filter(e -> e.dept().equals("ENG"))
            .map(Employee::name)
            .sorted()
            .collect(Collectors.joining(", "));
        System.out.println("ENG team        : " + engNames);
    }
}
```
**Expected output:**
```
count by dept   : {ENG=3, SALES=2}
avg salary/dept : {ENG=85000.0, SALES=80500.0}
top earner      : Ada
ENG team        : Ada, Bode, Eze
```

---

## 🔴 Task 14.3 (Challenge): Generic Container + Generic Method

```java
import java.util.*;

public class Inventory<T> {
    private final List<T> items = new ArrayList<>();

    void add(T item) { items.add(item); }
    T get(int i) { return items.get(i); }
    int size() { return items.size(); }

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
```
**Expected output:**
```
books size : 3, first: Java
largest int : 8
largest str : pear
```
