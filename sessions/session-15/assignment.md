# Assignment 15: Expression Evaluator + AI Workflow Log 📋

> **Module:** JAVA-I-TL15 | **Due:** Before Session 16 | **Max Score:** 100 Pts
> Reference solution (Part A): [solution/solution.html](solution/solution.html)

Two parts: **A** is code, **B** is a documented AI workflow.

---

## Part A — Expression Evaluator (60 pts)

Model an arithmetic expression as a tree, evaluated recursively. Every node is a `record`; the
tree type is `sealed`, so your `switch` needs no `default`.

1. **Types** (`ExpressionEvaluator.java`):
   - `sealed interface Expr permits Num, Add, Sub, Mul, Neg {}`
   - `record Num(double value) implements Expr {}`
   - `record Add(Expr left, Expr right) implements Expr {}` — same for `Sub`, `Mul`
   - `record Neg(Expr operand) implements Expr {}`
2. **`static double eval(Expr e)`** — a `switch` with a record pattern per case; recurse into
   children; no `default`.
3. **`static String render(Expr e)`** — parenthesised pretty-print, e.g. `((3 + 4) * -(2 - 5))`;
   whole numbers without a trailing `.0`.
4. **`main`** — build and print `(3 + 4) * -(2 - 5)` and `10 + (2 * 6)`.

### Expected Console Output
```
((3 + 4) * -(2 - 5)) = 21.0
(10 + (2 * 6)) = 22.0
```

---

## Part B — AI Workflow Log (40 pts)

Use an AI assistant for **one** concrete sub-problem in Part A. Submit `ai-log.md` with:

1. **The prompt you sent** — verbatim. Show role/level, concrete task, constraints (Java 25,
   concepts through Session 14), and the output shape you asked for.
2. **The AI's answer** — pasted (trimmed to the relevant part).
3. **Your review** — did it compile? did you understand every line? any hallucinated/above-level
   API? what did you change and why? which edge cases did you test?
4. **Reflection** — 3–4 sentences: what the AI sped up, and what you'd have missed without
   review.

> ⚠️ **Academic honesty:** the submitted `ExpressionEvaluator.java` must be code *you* wrote and
> can explain line-by-line. Part B rewards honest, critical use of AI.

---

## Grading Rubric (100 Pts)

| Criterion | Details | Pts |
| :--- | :--- | :--- |
| Sealed + records | Correct sealed hierarchy; every node a record | 20 |
| Record-pattern `eval` | Deconstructing `switch`, no `default`, correct recursion | 25 |
| `render` | Parenthesised output; whole numbers without `.0` | 15 |
| AI log — prompt & answer | Well-structured prompt; answer pasted honestly | 15 |
| AI log — review & reflection | Genuine critique: compiled?, understood?, changes, edges, reflection | 25 |

**Submission:** Upload `ExpressionEvaluator.java` and `ai-log.md` via ProConnect under
*Work Assignments → Session 15*.
