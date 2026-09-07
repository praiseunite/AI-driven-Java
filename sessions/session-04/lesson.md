# Session 4: Week 1 Consolidation & Debugging — Quick Reference 🔄

> 📄 **This is a summary.** The full review guide (String-methods table, stack-trace reading,
> trace-table method, AI-tutor prompts) is in **[lesson.html](lesson.html)**.

---

## The Week 1 Grand Mental Model

**Write** human code in a class with `public static void main`. **Compile** with `javac` to
platform-independent bytecode (`.class`). **Execute** on the host JVM — primitives and method
frames on the stack, objects on the heap — with branching and loops steering the flow.

---

## Essential `String` methods (Strings are immutable — methods return a *new* string)

| Method | Gives back |
| :--- | :--- |
| `s.length()` | character count (`int`) |
| `s.charAt(i)` | the `char` at index `i` (0-based) |
| `s.substring(a)` / `s.substring(a, b)` | from `a` to end / from `a` up to (not incl.) `b` |
| `s.toUpperCase()` / `s.toLowerCase()` | recased copy |
| `s.equals(t)` / `s.equalsIgnoreCase(t)` | `boolean` exact / case-insensitive match |
| `s.contains(t)` / `s.indexOf(t)` | `boolean` / first index or `-1` |
| `s.trim()` | copy without leading/trailing spaces |
| `s.replace(a, b)` | copy with every `a` → `b` |

**Gotchas:** bad index → `StringIndexOutOfBoundsException` (valid: `0..length()-1`); you must
capture the result — `s = s.toUpperCase();`.

---

## Four classic loop patterns

1. **Accumulator:** `total += value;`
2. **Counter / filter:** `if (condition) count++;`
3. **Sentinel / early exit:** `if (match) { found = true; break; }`
4. **Digit extraction:** `digit = num % 10; num /= 10;`

---

## Debugging checklist

- Case sensitivity: `String`, `System` capitalised; `main` lowercase.
- Integer division: use `2.0` not `2` when you need decimals.
- Compare text with `.equals()` / `.equalsIgnoreCase()`, never `==`.
- No `;` straight after an `if` / `for` / `while` header.
- Narrowing needs an explicit `(type)` cast — and it truncates.

## Reading a stack trace

```
Exception in thread "main" java.lang.ArithmeticException: / by zero
    at Averager.main(Averager.java:8)
```

Kind of problem → detail → **file and line to open**. Common Week 1 exceptions:
`ArithmeticException` (÷ or % by zero), `InputMismatchException` (bad `nextInt` input),
`StringIndexOutOfBoundsException`, `NullPointerException`. Full guide:
[../../reference/reading-errors.html](../../reference/reading-errors.html)

---

## Self-Check

1. **Loop that must run once before its test?** — `do-while`.
2. **Why is `a == b` false for two separately built `"test"` strings?** — `==` compares
   addresses; use `a.equals(b)`.
3. **`5 + 10 + "Java" + 5 + 10`?** — `"15Java510"` (left to right: `15`, then concatenation).

Glossary: [../../reference/glossary.html](../../reference/glossary.html)
