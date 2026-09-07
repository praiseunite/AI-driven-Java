# Assignment 9: Campus Media Library 📋

> **Module:** JAVA-I-TL9 | **Due:** Before Session 10 | **Max Score:** 100 Pts
> Reference solution: [solution/solution.html](solution/solution.html)

---

## Scenario
The library lends books, DVDs, and magazines. They share almost all behaviour (check-out,
check-in, "is it out?") but charge **different late fees per day**.

## Requirements

1. **`abstract class MediaItem`** (file `MediaLibrary.java`):
   - `private final String title;` and `private boolean checkedOut = false;`
   - Constructor takes the title. Getters `getTitle()`, `isCheckedOut()`.
   - `checkOut()` — reject if already out; else mark out and print.
   - `checkIn(int daysLate)` — reject if not out; else mark in, fee =
     `max(daysLate,0) * lateFeePerDay()`, print it.
   - **`abstract double lateFeePerDay();`**
   - `toString()` — title, `[IN]`/`[OUT]`, daily fee.
2. **Subclasses** `Book` ($0.25/day), `DVD` ($1.00/day), `Magazine` ($0.10/day) — each just
   implements `lateFeePerDay()` with `@Override`.
3. **`main`**: one of each in a `MediaItem[]`; print the catalogue; check out the book and DVD
   (DVD twice); check the book in 3 days late, DVD 5 days late, the magazine (never out); print
   total late fees.

## Expected Console Output

```
=== CATALOGUE ===
Effective Java         [IN]  ($0.25/day late)
The Matrix             [IN]  ($1.00/day late)
Nature - Jan           [IN]  ($0.10/day late)

=== ACTIVITY ===
Checked out: Effective Java
Checked out: The Matrix
"The Matrix" is already out.
Returned: Effective Java         3 days late  fee $0.75
Returned: The Matrix             5 days late  fee $5.00
"Nature - Jan" was not out.

Total late fees this session: $5.75
```

## Grading Rubric (100 Pts)

| Criterion | Details | Pts |
| :--- | :--- | :--- |
| Abstract base | `MediaItem` abstract; shared state/behaviour; `abstract lateFeePerDay()` | 25 |
| Subclasses | Three concrete subclasses; each supplies only its fee; `@Override` | 25 |
| Polymorphism | Catalogue + totals via a `MediaItem[]` loop calling overridden methods | 25 |
| State & validation | `checkOut`/`checkIn` guard already-out / not-out; fields `private` | 25 |

**Submission:** Upload `MediaLibrary.java` via ProConnect under *Work Assignments → Session 9*.
