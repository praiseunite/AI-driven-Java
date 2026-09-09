# Session 16: Final Review & Capstone — Quick Reference 🏆

> 📄 **This is a summary.** Full review guide (course concept map, code-review checklist,
> capstone brief + reference walkthrough, exam prep) in **[lesson.html](lesson.html)**.

---

## The Whole Course, in one breath

Source `.java` → `javac` → bytecode `.class` → JVM. Data in **variables** (primitives on the
stack, objects on the heap), moved by **operators**. **Control flow** (if/switch, loops) decides
what runs. Model the domain as **classes** (state + behavior, `private` fields), organised by
**inheritance** + **interfaces**, held in **collections**, guarded by **exception handling**,
processed with **streams**. Dates via `java.time`; records / switch expressions / `var` /
patterns cut boilerplate. Use **AI** to learn and draft — never to submit what you can't
explain.

---

## Professional code-review checklist

1. Compiles & runs (happy path + one failure path), zero warnings.
2. Correctness: off-by-one, integer division, rounding, `==` on objects, null handling.
3. Encapsulation: `private` fields; state changes only via validating methods.
4. Naming: nouns for classes, verbs for methods, `UPPER_SNAKE` constants.
5. Methods do one thing; return rather than print.
6. Exceptions: specific catches, never empty, not for normal flow; try-with-resources.
7. Duplication → a method; `instanceof` ladders → polymorphism.
8. Comments explain *why*.
9. Consistent formatting.

---

## Capstone — Campus Bookstore Console App

One file `BookstoreApp.java`. Required elements (→ session):

| Element | From |
| :--- | :--- |
| `record Book(isbn, title, genre, price)` | S14 |
| Encapsulated `Order`: `private` fields, `static` id counter, `subtotal()`/`total()` | S5, S7 |
| `interface Discount` + 2+ implementations, applied polymorphically | S10, S9 |
| Collections for catalogue, stock, order history | S6 |
| Custom `OutOfStockException`; checkout validates all lines then commits (all-or-nothing) | S11 |
| `LocalDateTime` timestamps + `DateTimeFormatter` | S13 |
| Stream reports: total revenue, revenue by genre, top-3 best sellers, low-stock count | S14 |
| Clean structure + the review checklist | S8, S16 |

Reference solution + expected output: [solution/solution.html](solution/solution.html). Build it
in the five milestones in [class-tasks.html](class-tasks.html).

---

## Exam prep

- Re-take every session post-quiz (target 80%+).
- Re-run every `solution/` program; predict the output first.
- Trace 3 loops + 1 recursive method by hand.
- Explain aloud: overriding vs overloading, checked vs unchecked, `Period` vs `Duration`,
  array vs `ArrayList`, abstract class vs interface, `==` vs `.equals()`.

**Congratulations on finishing JAVA-I. ☕**

Glossary: [../../reference/glossary.html](../../reference/glossary.html)
