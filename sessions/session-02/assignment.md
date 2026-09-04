# Assignment 2: Retail Point-of-Sale (POS) Billing Engine 📋

> **Module:** JAVA-I-TL2 | **Due Date:** Before Session 3 | **Max Score:** 100 Pts

---

## 🏢 Scenario
Build a console-based retail checkout engine named `RetailBillingEngine.java` for the Aptech Campus Tech Store.

---

## 📋 Requirements
1. **Three Products**:
   - Product 1: Mechanical Keyboard ($85.50 each, qty: 2)
   - Product 2: USB-C Hub ($34.99 each, qty: 1)
   - Product 3: 128GB Flash Drive ($18.75 each, qty: 3)
2. **Calculations**:
   - Individual line item totals
   - Gross subtotal
   - Promotional discount: 8% if gross subtotal > $150.00, otherwise 0% (use ternary operator)
   - VAT/Sales tax: 7.5% on discounted subtotal
   - Final invoice total
   - Explicit narrowing cast converting final dollars into integer cents: `(int)(finalTotal * 100)`
3. **Formatted Table**: Use `System.out.printf()` to produce neat columns with `%.2f` for currency.

---

## 📊 Grading Criteria
- **Math Accuracy (35 Pts)**: Subtotals, discount logic, tax, and grand totals are mathematically correct.
- **Formatting (25 Pts)**: Neat alignment using `System.out.printf()` and escape characters.
- **Data Types & Casting (20 Pts)**: Correct primitives and explicit type casting.
- **Code Quality (20 Pts)**: Meaningful variable names in camelCase and explanatory comments.

**Submission**: Submit `RetailBillingEngine.java` via ProConnect under *Work Assignments -> Session 2*.
