# Session 6: In-Class Practical Tasks 💻

> **Track:** AI-Driven Java Programming (JAVA-I) | **Session 6 Lab**
> Reference solutions: [solution/solution.html](solution/solution.html)

---

## 🟢 Task 6.1 (Easy): Score Statistics
Accumulator + min + max over one `int[]`.

```java
public class ScoreStats {
    public static void main(String[] args) {
        int[] scores = {88, 72, 95, 64, 100, 51, 79};
        int total = 0, min = scores[0], max = scores[0];
        for (int s : scores) {
            total += s;
            if (s < min) min = s;
            if (s > max) max = s;
        }
        double avg = (double) total / scores.length;
        System.out.println("Count   : " + scores.length);
        System.out.println("Total   : " + total);
        System.out.printf("Average : %.2f%n", avg);
        System.out.println("Min     : " + min);
        System.out.println("Max     : " + max);
    }
}
```
**Expected output:**
```
Count   : 7
Total   : 549
Average : 78.43
Min     : 51
Max     : 100
```

---

## 🟡 Task 6.2 (Medium): Grade Distribution
Counter/filter with an `if-else` ladder.

```java
public class GradeDistribution {
    public static void main(String[] args) {
        int[] scores = {88, 72, 95, 64, 100, 51, 79, 45, 83, 68};
        int a = 0, b = 0, c = 0, f = 0;
        for (int s : scores) {
            if (s >= 80) a++;
            else if (s >= 70) b++;
            else if (s >= 50) c++;
            else f++;
        }
        System.out.println("A (80-100): " + a);
        System.out.println("B (70-79) : " + b);
        System.out.println("C (50-69) : " + c);
        System.out.println("F (0-49)  : " + f);
    }
}
```
**Expected output:**
```
A (80-100): 4
B (70-79) : 2
C (50-69) : 3
F (0-49)  : 1
```

---

## 🔴 Task 6.3 (Challenge): Cinema Seating Chart (2D array)
Nested loops over a `char[][]`; print it and count `'X'` vs `'.'`.

```java
public class SeatingChart {
    public static void main(String[] args) {
        char[][] hall = {
            {'X', 'X', '.', 'X'},
            {'.', 'X', '.', '.'},
            {'X', 'X', 'X', 'X'}
        };
        int occupied = 0, free = 0;
        for (int r = 0; r < hall.length; r++) {
            for (int c = 0; c < hall[r].length; c++) {
                System.out.print(hall[r][c] + " ");
                if (hall[r][c] == 'X') occupied++;
                else free++;
            }
            System.out.println();
        }
        System.out.println("Occupied: " + occupied + ", Free: " + free);
    }
}
```
**Expected output:**
```
X X . X
. X . .
X X X X
Occupied: 8, Free: 4
```

---

## 🟡 Task 6.4 (Medium): To-Do Manager (ArrayList + StringBuilder)
`add`, `remove`, `set`, `size`, `isEmpty`; render numbered list with `StringBuilder`.

```java
import java.util.ArrayList;

public class TodoManager {
    public static void main(String[] args) {
        ArrayList<String> todos = new ArrayList<>();
        todos.add("Write lesson");
        todos.add("Test code");
        todos.add("Review PR");
        todos.add("Ship");

        todos.remove("Review PR");
        todos.set(0, "Write & edit lesson");

        System.out.println("Tasks remaining: " + todos.size());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < todos.size(); i++) {
            sb.append((i + 1)).append(". ").append(todos.get(i)).append("\n");
        }
        System.out.print(sb);
        System.out.println("All done? " + todos.isEmpty());
    }
}
```
**Expected output:**
```
Tasks remaining: 3
1. Write & edit lesson
2. Test code
3. Ship
All done? false
```
