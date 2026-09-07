# Session 10: Interfaces & Nested Classes — Quick Reference 🔌

> 📄 **This is a summary.** Full lesson (wall-socket analogy, `Comparable`, nested-class table,
> lambdas, "Ask Your AI Tutor") in **[lesson.html](lesson.html)**.

---

## 30-Second Mental Model

An **interface** is a contract of method signatures; a class `implements` as many as it likes
and must supply every method (`public`). Program to the interface type for flexibility.
`default` methods add shared bodies. `Comparable` makes objects sortable. **Nested classes:**
static nested (no outer link), inner (has one), anonymous (one-off implementation) — and a
**lambda** replaces an anonymous class for single-method interfaces.

---

## Core Syntax

```java
interface Shape {
    double area();
    default String label() { return getClass().getSimpleName() + " " + area(); }
}

class Circle implements Shape {
    private final double r;
    Circle(double r) { this.r = r; }
    @Override public double area() { return Math.PI * r * r; }
}

class Square implements Shape, Comparable<Square> {
    private final double side;
    Square(double side) { this.side = side; }
    @Override public double area() { return side * side; }
    @Override public int compareTo(Square o) { return Double.compare(side, o.side); }
}

Runnable r = () -> System.out.println("ran");   // lambda for a 1-method interface
```

---

## Must-Remember Points

- A class `extends` **one** class but `implements` **many** interfaces.
- Interface methods are implicitly `public abstract`; your implementations must be `public`.
- You **cannot** `new` an interface — instantiate an implementing class, an anonymous class, or
  a lambda.
- Interfaces hold no instance state — only `public static final` constants.
- `default` methods (Java 8+) give implementers a shared body they may override.
- `Comparable<T>.compareTo`: negative = `this` sorts first, `0` = equal, positive = after. Use
  `Integer.compare` / `Double.compare`, never `a - b`.
- **Abstract class** = partly-built base with state; **interface** = a capability unrelated
  classes can offer.
- Nested: **static nested** (helper type), **inner** (`outer.new Inner()`, sees outer fields),
  **anonymous** (`new Iface(){...}`), **lambda** (`args -> body`, for functional interfaces).

---

## Self-Check

1. **How many interfaces / classes can one class have?** — Many / exactly one.
2. **Instance fields in an interface?** — No; constants only.
3. **`compareTo` returns negative — meaning?** — `this` sorts before the argument.
4. **When can a lambda replace an anonymous class?** — When the interface has one abstract
   method (functional interface).

Glossary: [../../reference/glossary.html](../../reference/glossary.html)
