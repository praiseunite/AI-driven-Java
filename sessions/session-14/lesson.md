# Session 14: Additional Modern Features — Quick Reference ⚡

> 📄 **This is a summary.** Full lesson (functional-interface table, stream ops, records,
> switch expressions, "Ask Your AI Tutor") in **[lesson.html](lesson.html)**.

---

## 30-Second Mental Model

A **lambda** (`x -> ...`) implements a one-method interface; a **method reference** (`Class::m`)
is a shorter lambda. A **stream** pipeline = source → `filter`/`map`/`sorted` → a terminal
(`collect`/`count`/`reduce`). **Generics** make your own containers type-safe. `var` infers a
local type; **switch expressions** yield a value; **records** are one-line immutable data
classes; **`Optional`** models "maybe no value".

---

## Built-in functional interfaces

| Interface | Method | Shape |
| :--- | :--- | :--- |
| `Predicate<T>` | `test` | T → boolean |
| `Function<T,R>` | `apply` | T → R |
| `Consumer<T>` | `accept` | T → void |
| `Supplier<T>` | `get` | () → T |
| `BiFunction<T,U,R>` | `apply` | (T,U) → R |
| `UnaryOperator<T>` | `apply` | T → T |

## Streams

```java
List<String> out = names.stream()
    .filter(s -> s.length() > 3)
    .map(String::toUpperCase)
    .sorted()
    .collect(Collectors.toList());

double sum = items.stream().mapToDouble(Item::price).sum();
Map<String,Long> byCat = items.stream()
    .collect(Collectors.groupingBy(Item::category, Collectors.counting()));
Optional<Item> top = items.stream().max(Comparator.comparingDouble(Item::price));
```

- **Intermediate** (lazy): `filter map sorted distinct limit`.
- **Terminal** (runs it): `collect count forEach reduce anyMatch findFirst mapToInt().sum()`.
- A stream is **one-shot** — build a fresh one each time; it does **not** mutate the source.

## Modern syntax

```java
record Point(int x, int y) { }          // fields + ctor + accessors + equals/hashCode/toString
var list = new ArrayList<String>();      // inferred local type (initialiser required)
String s = switch (n) {                  // switch expression: yields a value
    case 1, 2 -> "low";
    default   -> "high";
};
String t = """
    multi
    line
    """;                                 // text block
Optional<String> o = find(key);
String v = o.orElse("none");
```

---

## Self-Check

1. **What kind of interface can a lambda target?** — Functional (one abstract method).
2. **Which stream call runs the work?** — The terminal op (`collect`, `count`, …).
3. **`record Point(int x, int y)` gives you?** — Fields, ctor, `x()`/`y()`, value
   `equals`/`hashCode`/`toString`.
4. **Why `Optional<User>` over nullable `User`?** — Forces the caller to handle "no result".

Glossary: [../../reference/glossary.html](../../reference/glossary.html)
