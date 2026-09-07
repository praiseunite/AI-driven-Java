# Session 5: Classes, Objects & Methods — Quick Reference 🏗️

> 📄 **This is a summary.** The full lesson (analogies, memory diagrams, "Ask Your AI Tutor")
> is in **[lesson.html](lesson.html)**.

---

## 30-Second Mental Model

A **class** is a blueprint: fields (state) + methods (behavior). `new` builds an **object** on
the heap and returns a **reference**. A **constructor** initialises it; `this` means "this
object". Make fields `private` and expose methods (**encapsulation**). Override `toString()` to
print nicely. **Overloading** = same name, different parameter lists.

---

## Core Syntax

```java
public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {   // constructor: class name, no return type
        this.name = name;                         // this.x = field, x = parameter
        this.price = price;
    }

    public double getPrice() { return price; }    // getter

    public void applyDiscount(double pct) {        // behavior + validation
        if (pct > 0 && pct < 100) price -= price * pct / 100;
    }

    @Override
    public String toString() {
        return String.format("%s ($%.2f)", name, price);
    }
}

Product p = new Product("Hub", 34.99);
p.applyDiscount(10);
System.out.println(p);            // Hub ($31.49)
```

---

## Must-Remember Points

- **Class vs object:** blueprint vs instance. One class, many objects, each with its own field values.
- **Fields** get automatic defaults (`0`, `false`, `null`); **local variables** do not.
- `new` = allocate on heap + run constructor + return address. A variable holds the *address*, not the object.
- `Car b = a;` copies the **reference** — both point at the same object.
- **`null`** + method call = `NullPointerException`. Assign an object with `new` first.
- **Constructor:** same name as class, **no return type** (not even `void`). Writing any constructor removes the free no-arg one.
- **`this(...)`** calls another constructor; must be the first statement.
- **Overloading:** methods/constructors share a name if parameter lists differ. Return type alone is not enough.
- **`toString()`** — override it (with `@Override`) for readable printing; called automatically on print/concatenation.
- **Encapsulation:** `private` fields + getters/setters. A `private` field with a validating method can never enter a broken state.
- **`return` is not `print`.** Return a value so the caller can use it.
- **`==` on objects** compares addresses, not contents.

---

## Self-Check

1. **Class vs object?** — Blueprint (code) vs instance (runtime, made with `new`).
2. **`Car b = a; b.speed = 90;` → `a.speed`?** — `90`; same object.
3. **Why is `public void BankAccount(...)` a bug?** — `void` makes it a normal method, not a constructor.
4. **Method call throws `NullPointerException` — cause?** — The variable is `null`; no object was created.

Glossary: [../../reference/glossary.html](../../reference/glossary.html)
