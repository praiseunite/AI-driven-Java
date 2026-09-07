# Assignment 5: Campus Library Book Tracker 📋

> **Module:** JAVA-I-TL5 | **Due:** Before Session 6 | **Max Score:** 100 Pts
> Reference solution + walkthrough: [solution/solution.html](solution/solution.html)

---

## Scenario
The Aptech campus library wants a small class, `LibraryBook.java`, that tracks how many copies
of a title are on the shelf versus out on loan. The counts must never go negative and must
always add up — so no outside code may touch them directly.

---

## Requirements

1. **Class & file:** `LibraryBook.java` with `public class LibraryBook`.
2. **Fields (all `private`):** `String title`, `String author`, `int copiesAvailable`, `int copiesLent`.
3. **Constructor** `LibraryBook(String title, String author, int totalCopies)` — set
   `copiesAvailable` to `totalCopies` (clamp negatives to 0), `copiesLent` to 0, using `this.`.
4. **`borrow()`** — if `copiesAvailable == 0`, print a "no copies available" message; else move
   one copy available → lent and print the new counts.
5. **`returnCopy()`** — if `copiesLent == 0`, print a "no copies lent" message; else move one
   copy back and print.
6. **`getCopiesAvailable()`** — getter returning the count.
7. **`status()`** — return `"ALL OUT"` (none available), `"FULLY STOCKED"` (none lent), else
   `"PARTIALLY LENT"`.
8. **`toString()`** — one line with title, author, status, and both counts.
9. **`main`** — create a title with 2 total copies; run borrow, borrow, borrow (rejected),
   return, return, return (rejected); then print the object.

---

## Expected Console Output

```
Borrowed "Effective Java". Available: 1, Lent: 1
Borrowed "Effective Java". Available: 0, Lent: 2
"Effective Java": no copies available to borrow.
Returned "Effective Java". Available: 1, Lent: 1
Returned "Effective Java". Available: 2, Lent: 0
"Effective Java": no copies are currently lent.
Effective Java by Bloch [FULLY STOCKED] (avail 2 / lent 0)
```

Exact wording/spacing may differ; what is graded is behaviour (see rubric).

---

## Grading Rubric (100 Pts)

| Criterion | Details | Pts |
| :--- | :--- | :--- |
| Encapsulation | All four fields `private`; no external mutation; constructor uses `this.` | 25 |
| Behaviour & validation | `borrow()` / `returnCopy()` guard the zero cases; counts stay consistent | 35 |
| Return vs print | `status()` and `toString()` **return** strings; getter returns the count | 20 |
| Code quality | camelCase, clear names, class-purpose comment, clean formatting | 20 |

**Submission:** Upload `LibraryBook.java` via ProConnect under *Work Assignments → Session 5*.
