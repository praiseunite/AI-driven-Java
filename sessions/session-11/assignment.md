# Assignment 11: Robust CSV Line Processor 📋

> **Module:** JAVA-I-TL11 | **Due:** Before Session 12 | **Max Score:** 100 Pts
> Reference solution: [solution/solution.html](solution/solution.html)

---

## Scenario
A registration import feeds you lines of the form `name,age,score`. Real uploads are messy:
missing fields, non-numeric ages, out-of-range scores, blank names. Process every good line and
log every bad one — one bad line must never stop the batch.

## Requirements

1. **Custom checked exception** `RecordFormatException extends Exception` with a message
   constructor.
2. **`Person`** class: `final String name; final int age; final int score;` + readable
   `toString()`.
3. **`static Person parse(String line) throws RecordFormatException`**:
   - Split on `,`. If not exactly 3 fields → throw "expected 3 fields, got N".
   - Trim name. If blank → throw "name is blank".
   - Parse age and score; catch `NumberFormatException` and re-throw a `RecordFormatException`
     ("age/score not a number: ...").
   - If `age < 0` or `score` outside `0..100` → throw "age/score out of range".
   - Otherwise return a `Person`.
4. **`main`**: loop the sample lines; `OK   : <person>` or
   `SKIP : "<line>"  (<reason>)`. Track valid/invalid counts and total score of valid records;
   print a summary with the average score of valid records.

## Expected Console Output

```
=== PROCESSING ===
OK   : Ada      age 30 score 88
OK   : Bode     age 25 score 72
SKIP : "Chi, twenty, 60"  (age/score not a number: For input string: "twenty")
SKIP : "Dee, 40"  (expected 3 fields, got 2)
SKIP : ", 22, 91"  (name is blank)
SKIP : "Eze, 19, 130"  (age/score out of range)

=== SUMMARY ===
Valid records   : 2
Invalid records : 4
Average score    : 80.00
```

## Grading Rubric (100 Pts)

| Criterion | Details | Pts |
| :--- | :--- | :--- |
| Custom exception | Extends `Exception`; helpful message | 20 |
| Validation coverage | All four bad cases detected and reported distinctly | 30 |
| Exception translation | `NumberFormatException` caught in `parse` and re-thrown | 25 |
| Batch resilience & summary | One bad line never stops the loop; counts/average correct | 25 |

**Submission:** Upload `RecordProcessor.java` via ProConnect under *Work Assignments → Session 11*.
