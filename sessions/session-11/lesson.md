# Session 11: Exception Handling — Quick Reference ⚠️

> 📄 **This is a summary.** Full lesson (fire-drill analogy, hierarchy, best practices,
> "Ask Your AI Tutor") in **[lesson.html](lesson.html)**.

---

## 30-Second Mental Model

An **exception** unwinds the call stack until something `catch`es it (or it crashes `main`).
**Checked** exceptions must be caught or declared `throws`; **unchecked** (`RuntimeException`)
need not be. `try` runs risky code, `catch` handles a type (specific first), `finally` always
runs, **try-with-resources** auto-closes. `throw` raises one; custom exceptions extend
`Exception` or `RuntimeException`.

---

## Hierarchy

```
Throwable
├── Error                 (JVM problems — don't catch)
└── Exception
    ├── RuntimeException   UNCHECKED (NullPointer, Arithmetic, IllegalArgument, IndexOutOfBounds)
    └── (everything else)  CHECKED   (IOException, SQLException, your custom ones)
```

## Core Syntax

```java
class OutOfStockException extends Exception {
    OutOfStockException(String m) { super(m); }
}

static void buy(int stock, int qty) throws OutOfStockException {
    if (qty <= 0) throw new IllegalArgumentException("qty must be positive");
    if (qty > stock) throw new OutOfStockException("only " + stock + " left");
    System.out.println("sold " + qty);
}

try {
    buy(3, 5);
} catch (OutOfStockException e) {
    System.out.println("sorry: " + e.getMessage());
} catch (IllegalArgumentException e) {
    System.out.println("bad request: " + e.getMessage());
} finally {
    System.out.println("logged");
}
```

---

## Must-Remember Points

- **Checked vs unchecked:** compiler forces handling of checked; unchecked = usually a bug to
  fix in code.
- `catch` a **superclass** must come **after** its subclasses (else unreachable → compile
  error).
- **Multi-catch:** `catch (A | B e)` for shared handling.
- `finally` **always** runs — even after `return` (not after `System.exit`).
- **try-with-resources:** `try (Resource r = ...)` auto-calls `r.close()`. Works for anything
  `AutoCloseable` (files, streams, `Scanner`).
- `throw new X(...)` raises now; `void m() throws X` declares it may escape.
- **Best practices:** catch specific types; never an empty `catch`; don't use exceptions for
  normal flow; handle where you can respond; keep the cause when re-throwing; validate inputs
  early with `IllegalArgumentException`.

---

## Self-Check

1. **`finally` after a `return` in `try`?** — Yes, it runs.
2. **Which kind must the compiler see handled?** — Checked.
3. **Why `catch(NumberFormatException)` before `catch(Exception)`?** — Superclass first makes
   the specific block unreachable.
4. **What does try-with-resources replace?** — A manual `finally { r.close(); }`.

Glossary: [../../reference/glossary.html](../../reference/glossary.html) · Errors:
[../../reference/reading-errors.html](../../reference/reading-errors.html)
