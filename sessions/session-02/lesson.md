# Session 2: Variables, Data Types & Operators — Quick Reference 📦

> 📄 **This is a summary.** The full lesson (analogies, diagrams, Scanner walkthrough, trace
> tables, "Ask Your AI Tutor") is in **[lesson.html](lesson.html)**. Read that first; use this
> page to revise.

---

## 30-Second Mental Model

RAM is a set of named slots. **Primitives** hold their bits directly; **references** (like
`String`) hold an address pointing to an object on the heap. Read what a user types with
`Scanner`. In expressions, `* / %` run before `+ -`, comparisons before `&& ||`, and
assignment last. `final` locks a value. Narrowing casts **truncate** (no rounding). Show money
with `printf("%.2f", amount)`.

---

## Core Syntax

```java
import java.util.Scanner;

final double VAT_RATE = 0.075;                 // constant (UPPER_SNAKE_CASE)

Scanner in = new Scanner(System.in);
System.out.print("Price: ");
double price = in.nextDouble();

double withTax = price * (1 + VAT_RATE);
int    cents   = (int) Math.round(withTax * 100);   // Math + narrowing cast

System.out.printf("Total: $%.2f (%d cents)%n", withTax, cents);
in.close();
```

---

## Must-Remember Points

- **8 primitives:** `byte short int long float double char boolean`. Everyday choices: `int`,
  `double`, `boolean`, `String`.
- **Literal suffixes:** `long x = 5000000000L;`  `float f = 9.99f;`
- **Scanner methods:** `nextLine()` (whole line), `next()` (one word), `nextInt()`,
  `nextDouble()`, `nextBoolean()`.
- **`nextLine()`-after-`nextInt()` trap:** the leftover Enter makes the next `nextLine()`
  return `""`. Fix: add a throwaway `in.nextLine();` after reading a number.
- **Integer division:** `7 / 2` is `3`. Use `7.0 / 2` for `3.5`.
- **Modulus:** `17 % 5` is `2`; `n % 2 == 0` tests even.
- **Compound assignment:** `+= -= *= /= %=`.
- **Increment:** `i++` uses the old value then adds 1; `++i` adds first.
- **Precedence:** `()` → unary `++ -- !` → `* / %` → `+ -` → `< <= > >=` → `== !=` → `&&` →
  `||` → `=`.
- **`final`:** constant; reassigning is a compile error.
- **`Math`:** `abs, pow, sqrt, round, min, max, random, PI` — no import needed, prefix with
  `Math.`.
- **Casting:** widening (`int`→`double`) is automatic; narrowing needs `(type)` and truncates.
- **Money:** never compare `double`s with `==`; round for display; real currency uses
  `BigDecimal` (later).
- **Compare text** with `.equals()`, not `==`.

---

## Self-Check

1. **Why is `int answer = 7 / 2;` equal to 3?** — Integer division truncates the `.5`.
2. **`int i = 5; System.out.println(i++);` prints what, and what is `i` after?** — Prints `5`;
   `i` becomes `6`.
3. **`nextLine()` right after `nextInt()` returns blank — why?** — The leftover newline was
   consumed. Add a throwaway `nextLine()`.
4. **Does `(int) 9.99` round to 10?** — No, it truncates to `9`.

Glossary: [../../reference/glossary.html](../../reference/glossary.html)
