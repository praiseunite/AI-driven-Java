# Assignment 14: Sales Analytics with Streams & Records 📋

> **Module:** JAVA-I-TL14 | **Due:** Before Session 15 | **Max Score:** 100 Pts
> Reference solution: [solution/solution.html](solution/solution.html)

---

## Scenario
The campus store wants a one-shot revenue summary from a batch of orders. Build
`SalesAnalytics.java` using a `record` for the order type and the Streams API for every
calculation — no manual loops for aggregates.

## Requirements

1. **Record:** `record Order(String customer, String region, String product, int qty, double
   unitPrice)` with `double total()` (= `qty * unitPrice`).
2. **Data:** a `List<Order>` of the 7 orders in the expected output.
3. **Grand total revenue** — `mapToDouble(Order::total).sum()`.
4. **Revenue by region** — `groupingBy(Order::region, summingDouble(Order::total))`; print
   sorted by region name.
5. **Units sold per product** — `groupingBy(Order::product, summingInt(Order::qty))`; print
   sorted.
6. **Top customer by spend** — group spend by customer, then
   `max(Map.Entry.comparingByValue())`.
7. **Orders over $100** — `filter(o -> o.total() > 100)`, map to `customer:product`, join with
   `", "`.

## Expected Console Output

```
Grand total revenue : $985.41
Revenue by region   :
  EAST   $313.96
  NORTH  $378.00
  WEST   $293.45
Units per product   :
  Hub       3
  Keyboard  3
  Monitor   3
  Mouse     9
Top customer        : Eze ($378.00)
Orders over $100    : Bode:Monitor, Ada:Hub, Eze:Monitor
```

## Grading Rubric (100 Pts)

| Criterion | Details | Pts |
| :--- | :--- | :--- |
| Record | `Order` is a record with a computed `total()` | 15 |
| Stream aggregates | Grand total, region revenue, product units — streams only | 35 |
| Grouping & max | Correct downstream collectors; top customer via `Map.Entry` | 30 |
| Filter & join | "Orders over $100" via `filter` + `map` + `joining` | 20 |

**Submission:** Upload `SalesAnalytics.java` via ProConnect under *Work Assignments → Session 14*.
