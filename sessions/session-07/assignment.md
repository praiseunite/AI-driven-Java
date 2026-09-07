# Assignment 7: Café Order System — Packaged & Shipped as a JAR 📋

> **Module:** JAVA-I-TL7 | **Due:** Before Session 8 | **Max Score:** 100 Pts
> Reference solution: [solution/solution.html](solution/solution.html)

---

## Scenario
The Aptech campus café wants a tiny receipt program it can hand to staff as one runnable file.
Organise it as the package `com.aptech.cafe`.

## Requirements

1. **Package:** both files declare `package com.aptech.cafe;` and live under `com/aptech/cafe/`.
2. **`MenuItem.java`:**
   - `public static final double TAX_RATE = 0.08;`
   - `private static int itemsOnMenu = 0;` bumped in the constructor; exposed by
     `public static int getItemsOnMenu()`.
   - `private final String name; private final double price;` set in the constructor (clamp
     negative price to 0).
   - Getters `getName()`, `getPrice()`; `priceWithTax()` = `price * (1 + TAX_RATE)`; a readable
     `toString()`.
3. **`CafeApp.java`:** holds `main`. Build a `MenuItem[]` of Espresso 2.50, Muffin 3.25,
   Sandwich 5.75; print each; total the subtotal; add tax with `MenuItem.TAX_RATE`; print the
   total and `MenuItem.getItemsOnMenu()`.
4. **Run it two ways** and confirm identical output:

```
javac -d out $(find . -name "*.java")
java -cp out com.aptech.cafe.CafeApp

jar --create --file cafe.jar --main-class com.aptech.cafe.CafeApp -C out .
java -jar cafe.jar
```

## Expected Console Output (both ways)

```
=== APTECH CAFE RECEIPT ===
Espresso         $  2.50  (with tax $  2.70)
Muffin           $  3.25  (with tax $  3.51)
Sandwich         $  5.75  (with tax $  6.21)
---------------------------------------------
Subtotal                             $ 11.50
Tax (8%)                             $  0.92
TOTAL                                $ 12.42
Distinct items defined on menu: 3
```

## Grading Rubric (100 Pts)

| Criterion | Details | Pts |
| :--- | :--- | :--- |
| Package structure | Correct `package` line; matching folder path; runs by fully-qualified name | 25 |
| `static` & `final` | Class-wide `TAX_RATE`; shared counter + static getter | 25 |
| Encapsulation | Instance fields `private final`; access via methods | 20 |
| Executable JAR | Built with main class recorded; `java -jar cafe.jar` gives expected output | 30 |

**Submission:** Zip the `com/` folder and `cafe.jar`; upload via ProConnect under
*Work Assignments → Session 7*.
