# Session 9: Inheritance & Polymorphism — Quick Reference 🧬

> 📄 **This is a summary.** Full lesson (family-recipe analogy, dynamic-dispatch walkthrough,
> `Object` methods, "Ask Your AI Tutor") in **[lesson.html](lesson.html)**.

---

## 30-Second Mental Model

`class Sub extends Super` — Sub inherits Super's `public`/`protected` members (not `private`, not
constructors). `super(...)` (first line) runs the parent constructor; `super.m()` calls the
parent's method. **Overriding** = same signature in a subclass, chosen at **run time** by the
object's real type (**dynamic dispatch**). `abstract` classes can't be instantiated and can
demand methods. Override `toString` / `equals` / `hashCode` (the last two together) for
value-like types.

---

## Core Syntax

```java
abstract class Payment {
    protected final double amount;
    Payment(double amount) { this.amount = amount; }
    abstract double fee();                             // subclasses must define
    final double total() { return amount + fee(); }    // cannot be overridden
}

class CardPayment extends Payment {
    CardPayment(double amount) { super(amount); }
    @Override double fee() { return amount * 0.029 + 0.30; }
}

Payment[] batch = { new CardPayment(100), new CashPayment(100) };
for (Payment p : batch) System.out.printf("%.2f%n", p.total());   // 103.20, 100.00
```

---

## Must-Remember Points

- Use inheritance only for a true **is-a** relationship; otherwise use a field (**has-a**).
- Every class extends `Object` implicitly → you already have `toString/equals/hashCode`.
- **Single inheritance:** one direct superclass. (Multiple *interfaces* — Session 10.)
- `super(...)` must be the **first statement**; Java auto-inserts `super()` if you omit it
  (fails when the parent has no no-arg constructor).
- `super.method()` lets you **extend** rather than fully replace an overridden method.
- Always write **`@Override`** — the compiler then verifies you really override something.
- **Override vs overload:** same signature in a subclass (run-time) vs different parameters in
  one class (compile-time).
- **Polymorphism:** a `Super` variable can hold any subclass object; the overridden method for
  the *real* type runs.
- `abstract class` — no instances; `abstract` methods have no body and must be implemented.
- `final` method = can't override; `final` class = can't extend (`String`).
- Guard casts with `instanceof` (or use `if (a instanceof Dog d)` pattern form).
- Override `equals` **and** `hashCode` together, or hash collections break.

---

## Self-Check

1. **`Animal a = new Dog(); a.speak();` — whose method?** — `Dog`'s (dynamic dispatch).
2. **Where does `super(name)` go?** — First statement of the subclass constructor.
3. **`new Shape()` when `Shape` is abstract?** — Won't compile; instantiate a concrete subclass.
4. **Override `equals` but not `hashCode` — what breaks?** — `HashSet`/`HashMap` lookups.

Glossary: [../../reference/glossary.html](../../reference/glossary.html)
