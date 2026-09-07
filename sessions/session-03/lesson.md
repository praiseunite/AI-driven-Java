# Session 3: Decision-Making & Loops — Quick Reference 🔀

> 📄 **This is a summary.** The full lesson (analogies, trace tables, off-by-one & infinite-loop
> recovery, the `Scanner` menu example) is in **[lesson.html](lesson.html)**. Read that first.

---

## 30-Second Mental Model

**Branching** (`if`/`else`, `switch`) chooses *which* block runs. **Loops** (`for`, `while`,
`do-while`) choose *how many times* a block repeats. `while`/`for` test **before** the body (can
run 0 times); `do-while` tests **after** (runs at least once). Every decision reduces to a
`boolean`.

---

## Core Syntax

```java
// if - else if - else
if (score >= 90)      grade = 'A';
else if (score >= 80) grade = 'B';
else                  grade = 'F';

// switch (classic form — needs break; can fall through)
switch (role) {
    case "ADMIN": grantFullAccess(); break;
    case "USER":  grantUserAccess(); break;
    default:      denyAccess();      break;
}

// for — known repeat count
for (int i = 0; i < 5; i++) { /* runs 5 times: 0..4 */ }

// while — condition-driven
while (balance > 0) { makePayment(); }

// do-while — guaranteed at least once (menus, prompts)
do { showMenu(); choice = in.nextInt(); } while (choice != 3);

// jumps
if (found) break;      // exit the loop now
if (skip)  continue;   // skip to the next iteration
```

---

## Must-Remember Points

- **`switch` allows** `byte short char int String enum` — **not** `float double boolean`.
- **Fall-through:** omit `break;` in the classic form and execution runs on into later cases.
- **Arrow form** `case 1 -> ...` (Java 14+, Session 14) needs no `break` and can't fall through.
- **Off-by-one:** `<` vs `<=`, or start `0` vs `1`, changes the count by one.
  - loop *n* times from 0: `for (int i = 0; i < n; i++)`
  - loop 1..*n* inclusive: `for (int i = 1; i <= n; i++)`
- **Infinite loop:** the condition never turns false (forgot the update, wrong variable). **Stop
  it:** `Ctrl+C` in the terminal, or the red ■ Stop button in IntelliJ.
- **Nested loops:** inner finishes fully for each outer pass; `outer × inner` total body runs.
- **`;` right after `if`/`for`/`while` header** is a bug — the body then runs unconditionally /
  the loop body is empty.
- **Trace tables:** step through by hand, recording each variable after each line — this is how
  you find loop bugs.

---

## Self-Check

1. **Can a `double` be the `switch` selector?** — No; binary rounding makes equality unreliable.
2. **Output of `for (int i = 1; i <= 3; i++); { System.out.print(i); }`?** — Won't compile: the
   `;` ends the loop, and `i` is out of scope in the block.
3. **Outer 3 × inner 4 — how many inner-body runs?** — 12.
4. **Minimum runs of a `do-while`?** — 1 (condition checked at the end).

Glossary: [../../reference/glossary.html](../../reference/glossary.html)
