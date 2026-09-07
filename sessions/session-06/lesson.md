# Session 6: Arrays and Strings — Quick Reference 📚

> 📄 **This is a summary.** Full lesson (locker analogy, 2D pictures, "Ask Your AI Tutor") in
> **[lesson.html](lesson.html)**.

---

## 30-Second Mental Model

An **array** is a fixed row of same-type slots, indexed `0..length-1`. Walk it with `for` (need
the index) or `for-each` (need only values). **ArrayList** grows/shrinks and holds *objects*, so
primitives are auto-boxed into **wrappers** (`Integer`). **String** is immutable — build text in
loops with **StringBuilder**.

---

## Core Syntax

```java
import java.util.ArrayList;
import java.util.Arrays;

int[] a = {5, 2, 8, 1};
for (int v : a) System.out.print(v + " ");
Arrays.sort(a);                       // [1, 2, 5, 8]
System.out.println(Arrays.toString(a));

int[][] grid = new int[3][4];         // 3 rows x 4 cols, all 0
grid[2][3] = 9;

ArrayList<String> list = new ArrayList<>();
list.add("x"); list.add("y");
list.remove("x");
System.out.println(list.size());      // 1

StringBuilder sb = new StringBuilder();
for (String s : list) sb.append(s).append(",");
System.out.println(sb);               // y,
```

---

## Must-Remember Points

- **Index range:** `0` to `length - 1`. Past that → `ArrayIndexOutOfBoundsException`.
- **`a.length`** is a field (no parens). **`s.length()`** / **`list.size()`** are methods.
- Fresh arrays are pre-filled: `0`, `0.0`, `false`, `null`.
- `int[] b = a;` — both point at the **same** array. `==` compares addresses;
  `Arrays.equals(a, c)` compares contents.
- **for-each cannot modify** the array (loop variable is a copy) — use the index form.
- **ArrayList** needs wrapper types: `ArrayList<Integer>`, not `ArrayList<int>`. Autoboxing
  converts in/out.
- Compare wrappers/Strings with `.equals()`.
- **Removing from a list while for-each-ing** → `ConcurrentModificationException`. Loop
  backwards by index, or build a new list.
- **String is immutable.** In a loop, `+=` makes N throwaway objects — use `StringBuilder`.
- `csv.split(",")` → array of pieces; `String.join(" | ", parts)` → glue them back.

---

## Self-Check

1. **Valid indexes for `length` 5?** — `0`–`4`.
2. **`int[] b = a; b[0] = 99;` → `a[0]`?** — `99` (same object).
3. **Why not `ArrayList<int>`?** — Generics hold objects; use `ArrayList<Integer>`.
4. **Building a 10,000-char string in a loop — best tool?** — `StringBuilder`.

Glossary: [../../reference/glossary.html](../../reference/glossary.html)
