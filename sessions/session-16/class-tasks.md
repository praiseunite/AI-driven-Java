# Session 16 Capstone Lab: Campus Bookstore Console App 🏆

> **Module:** JAVA-I-TL16 | Build `BookstoreApp.java` in 5 milestones.
> Full reference solution + expected output: [solution/solution.html](solution/solution.html)

Get milestone 1 running, then grow it. By milestone 5 the whole app is one file (nested
`record`s / `class`es are fine). Run the code-review checklist from the Review Guide before
submitting.

---

## 🟢 Milestone 1 — Catalogue (record + Map) · S14, S6
`record Book(String isbn, String title, String genre, double price)`; 4 books in a
`LinkedHashMap<String, Book>` keyed by ISBN; print as a table.

```
978-1  Effective Java   tech     $45.00
978-2  Clean Code       tech     $38.00
978-3  Dune             sci-fi   $18.50
978-4  The Hobbit       fantasy  $14.00
```

## 🟡 Milestone 2 — Orders (LineItem + encapsulated Order + static id) · S5, S7, S14
`record LineItem(Book book, int qty)` with `total()`; `final class Order` with
`private static int nextId`, `private final List<LineItem>` (copy it), stream `subtotal()`.
Build two orders, print id + subtotal.

```
Order #1000 subtotal $108.50
Order #1001 subtotal $55.50
```

## 🟡 Milestone 3 — Discounts (interface + polymorphic impls) · S10, S9
`interface Discount { double apply(double subtotal); String label(); }` +
`NoDiscount`, `PercentOff(double pct)`, `BulkDeal` ($5 off per full $50). `Order` gets a
`Discount` field and `total() = discount.apply(subtotal())`.

```
Order #1000 [10% off]  subtotal $108.50 -> total $97.65
Order #1001 [$5 per $50]  subtotal $42.00 -> total $42.00
```

## 🔴 Milestone 4 — Bookstore + checkout (validate then commit) · S6, S11
`final class Bookstore` with catalogue, `Map<String,Integer> stock`, order history.
`Order checkout(Map<String,Integer> cart, Discount d, LocalDateTime when) throws
OutOfStockException` — **validate every line first**, throw all-or-nothing if any exceeds
stock, then subtract stock and record the order.

```
Order #1000 committed
REJECTED order: "Clean Code": wanted 5, only 4 in stock
(stock for Clean Code is still 4)
```

## 🔴 Milestone 5 — Stream reports + timestamps · S13, S14
Timestamp orders with `LocalDateTime` + `DateTimeFormatter`. Add to `Bookstore`:
`totalRevenue()`, `revenueByGenre()` (`flatMap` → `groupingBy(genre, summingDouble)`),
`bestSellers(int topN)`, `lowStockCount(int threshold)`.

```
=== REPORTS ===
Total revenue      : $212.65
Revenue by genre   :
  fantasy   $70.00
  sci-fi    $18.50
  tech      $135.00
Best sellers       : [The Hobbit (5), Effective Java (3), Dune (1)]
Low-stock titles (<5): 2
```

---

## Submit
One file `BookstoreApp.java` producing the full reference output, plus a 1-paragraph note
mapping each required element to its session. Then take the
[Final Assessment](post-quiz.html).
