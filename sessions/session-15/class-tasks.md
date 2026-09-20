# Session 15: In-Class Practical Tasks 💻

> **Track:** AI-Driven Java Programming (JAVA-I) | **Session 15 Lab**
> Reference solutions: [solution/solution.html](solution/solution.html)

---

## 🟡 Task 15.1 (Medium): Event Router (sealed + record patterns + guards)

```java
public class EventRouter {
    sealed interface Event permits Click, KeyPress, Scroll {}
    record Click(int x, int y) implements Event {}
    record KeyPress(char key) implements Event {}
    record Scroll(int amount) implements Event {}

    static String handle(Event e) {
        return switch (e) {
            case Click(int x, int y)          -> "click at (" + x + "," + y + ")";
            case KeyPress(char k)             -> "key '" + k + "'";
            case Scroll s when s.amount() > 0 -> "scroll down " + s.amount();
            case Scroll s                     -> "scroll up " + (-s.amount());
        };
    }

    public static void main(String[] args) {
        Event[] events = { new Click(10, 20), new KeyPress('A'), new Scroll(3), new Scroll(-2) };
        for (Event e : events) System.out.println(handle(e));
    }
}
```
**Expected output:**
```
click at (10,20)
key 'A'
scroll down 3
scroll up 2
```

---

## 🟡 Task 15.2 (Medium): Virtual-Thread Task Runner

```java
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class TaskRunner {
    public static void main(String[] args) throws Exception {
        AtomicLong sum = new AtomicLong();
        int tasks = 2000;

        try (var pool = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 1; i <= tasks; i++) {
                final int n = i;
                pool.submit(() -> sum.addAndGet(n));
            }
        }   // close() waits for every task to finish

        long expected = (long) tasks * (tasks + 1) / 2;
        System.out.println("sum of 1.." + tasks + " via virtual threads = " + sum.get());
        System.out.println("matches formula? " + (sum.get() == expected));
    }
}
```
**Expected output:**
```
sum of 1..2000 via virtual threads = 2001000
matches formula? true
```
`AtomicLong` because many threads add at once — a plain `long +=` would lose updates.

---

## 🟢 Task 15.3 (Easy): Queue with Sequenced-Collection API

```java
import java.util.*;

public class Deque {
    public static void main(String[] args) {
        LinkedList<String> line = new LinkedList<>(List.of("Ada", "Bode", "Chi"));

        line.addLast("Dee");
        line.addFirst("VIP");
        System.out.println("queue      : " + line);
        System.out.println("serving    : " + line.getFirst());
        System.out.println("last in    : " + line.getLast());

        line.removeFirst();
        System.out.println("after serve: " + line);
        System.out.println("reversed   : " + line.reversed());
    }
}
```
**Expected output:**
```
queue      : [VIP, Ada, Bode, Chi, Dee]
serving    : VIP
last in    : Dee
after serve: [Ada, Bode, Chi, Dee]
reversed   : [Dee, Chi, Bode, Ada]
```
