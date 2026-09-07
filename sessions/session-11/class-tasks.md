# Session 11: In-Class Practical Tasks 💻

> **Track:** AI-Driven Java Programming (JAVA-I) | **Session 11 Lab**
> Reference solutions: [solution/solution.html](solution/solution.html)

---

## 🟢 Task 11.1 (Easy): Safe Parser (try/catch a bad number)

```java
public class SafeParser {
    static int parseOrDefault(String s, int fallback) {
        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            System.out.println("  bad number \"" + s + "\" -> using " + fallback);
            return fallback;
        }
    }

    public static void main(String[] args) {
        String[] inputs = {"42", "  17 ", "seven", "-3", ""};
        int total = 0;
        for (String in : inputs) {
            total += parseOrDefault(in, 0);
        }
        System.out.println("Total: " + total);
    }
}
```
**Expected output:**
```
  bad number "seven" -> using 0
  bad number "" -> using 0
Total: 56
```

---

## 🟡 Task 11.2 (Medium): Custom checked exception (`throw` + `throws`)

```java
class InvalidGradeException extends Exception {
    InvalidGradeException(String msg) { super(msg); }
}

public class GradeValidator {
    static char letterFor(int score) throws InvalidGradeException {
        if (score < 0 || score > 100) {
            throw new InvalidGradeException("score out of range: " + score);
        }
        if (score >= 80) return 'A';
        if (score >= 70) return 'B';
        if (score >= 50) return 'C';
        return 'F';
    }

    public static void main(String[] args) {
        int[] scores = {95, 72, 40, 130, -5};
        for (int s : scores) {
            try {
                System.out.println(s + " -> " + letterFor(s));
            } catch (InvalidGradeException e) {
                System.out.println(s + " -> rejected (" + e.getMessage() + ")");
            }
        }
    }
}
```
**Expected output:**
```
95 -> A
72 -> B
40 -> F
130 -> rejected (score out of range: 130)
-5 -> rejected (score out of range: -5)
```

---

## 🔴 Task 11.3 (Challenge): try-with-resources (`AutoCloseable`)

```java
class Lease implements AutoCloseable {
    private final int id;
    Lease(int id) { this.id = id; System.out.println("acquire lease " + id); }
    void work() { System.out.println("work with lease " + id); }
    @Override public void close() { System.out.println("release lease " + id); }
}

public class ResourcePool {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            try (Lease lease = new Lease(i)) {
                lease.work();
                if (i == 2) throw new IllegalStateException("problem on " + i);
            } catch (IllegalStateException e) {
                System.out.println("handled: " + e.getMessage());
            }
        }
        System.out.println("all leases released");
    }
}
```
**Expected output:**
```
acquire lease 1
work with lease 1
release lease 1
acquire lease 2
work with lease 2
release lease 2
handled: problem on 2
acquire lease 3
work with lease 3
release lease 3
all leases released
```
Notice: on iteration 2, `release lease 2` prints *before* `handled:` — the resource is closed
as the `try` block exits, then the `catch` runs.
