# 📋 Product Requirements Document
## Project: Advanced Java Calculator
### AI-Driven Java Programming (JAVA-I) — Aptech Certified Courseware

> **Type:** Optional Advanced Challenge Project  
> **Recommended After:** Session 11 (Exception Handling)  
> **Estimated Time:** 4–8 hours  
> **Difficulty:** ⭐⭐⭐ (Intermediate–Advanced)

---

## 1. Overview

You are building **AdvancedCalculator** — a console-based Java program that goes well beyond a basic four-function calculator. It reinforces *every major concept* covered in Sessions 2 through 14 of this course, all in one cohesive, menu-driven application.

Think of it as a **mini capstone**: if you can build this calculator without looking at the reference solution, you have genuinely mastered the core of Java-I.

---

## 2. Learning Objectives

By completing this project you will demonstrate the ability to:

| # | Objective | Sessions Covered |
|---|-----------|-----------------|
| 1 | Use `double` arithmetic and handle edge cases (divide-by-zero) | S2 |
| 2 | Apply `if/else`, `switch` expressions, and `do-while` loops | S3 |
| 3 | Design a class with private fields, constructors, and public methods | S5 |
| 4 | Use `ArrayList` / `ArrayDeque` for dynamic data storage | S6 |
| 5 | Model with `enum` constants and `switch` expressions | S10, S14 |
| 6 | Throw and catch custom exceptions | S11 |
| 7 | Use Streams for aggregation (average, max, sum) | S14 |
| 8 | Write clean, well-commented, production-quality Java | S15 |

---

## 3. Feature Specifications

### Feature 1 — Basic Arithmetic ✅ Required
The calculator must support the four standard operations on `double` values:

| Operation | Symbol | Notes |
|-----------|--------|-------|
| Addition | `+` | |
| Subtraction | `-` | |
| Multiplication | `*` | |
| Division | `/` | Must throw `CalculatorException` on divide-by-zero |

**Acceptance Criteria:**
- [ ] Results formatted to 4 decimal places
- [ ] Dividing by zero prints a friendly error message and does NOT crash the program
- [ ] Each completed operation is automatically added to the history log

---

### Feature 2 — Memory Store / Recall 🧠 Required
Implement a **single memory slot** (like a real calculator's M button):

| Operation | Command | Behaviour |
|-----------|---------|-----------|
| Memory Store | `MS` | Save the last result to memory |
| Memory Recall | `MR` | Load the memory value as the current value |
| Memory Add | `M+` | Add the last result to memory |
| Memory Clear | `MC` | Reset memory to 0.0 |

**Acceptance Criteria:**
- [ ] Memory is a `private double` field, never directly accessible from `main`
- [ ] If `MR` is called when memory is 0 (never set), print `"Memory is empty (0.0)"` — do not error

---

### Feature 3 — History Log 📜 Required
Maintain a log of the **last 10 completed operations**.

**Acceptance Criteria:**
- [ ] Each entry shows: `[n]  operand1  operator  operand2  =  result`  
  Example: `[1]  10.0  +  5.0  =  15.0`
- [ ] When 11+ operations exist, the oldest entry drops off (use a sliding window)
- [ ] User can type `HISTORY` to display the full log
- [ ] If history is empty, print `"No operations recorded yet."`

---

### Feature 4 — Unit Conversion 🔄 Required
Provide instant unit conversions via a sub-menu:

| Conversion | Formula |
|-----------|---------|
| km → miles | `mi = km × 0.621371` |
| miles → km | `km = mi ÷ 0.621371` |
| °C → °F | `F = (C × 9/5) + 32` |
| °F → °C | `C = (F − 32) × 5/9` |
| kg → lbs | `lb = kg × 2.20462` |
| lbs → kg | `kg = lb ÷ 2.20462` |

**Acceptance Criteria:**
- [ ] Conversions are modelled as a Java `enum ConversionType`
- [ ] A `switch` expression maps each `ConversionType` to its formula
- [ ] Result is displayed and stored as the current value (usable in next arithmetic operation)

---

### Feature 5 — History Statistics 📊 Advanced
Use the **Java Streams API** to compute statistics over all recorded results:

| Stat | Method |
|------|--------|
| Average result | `stream().mapToDouble().average()` |
| Highest result | `stream().mapToDouble().max()` |
| Sum of all results | `stream().mapToDouble().sum()` |

**Acceptance Criteria:**
- [ ] Command `STATS` prints all three statistics
- [ ] If fewer than 2 entries exist, print `"Not enough history for statistics."`

---

### Feature 6 — Custom Exception ⚠️ Required
Create a class `CalculatorException` that extends `RuntimeException`.

**Acceptance Criteria:**
- [ ] `CalculatorException(String message)` constructor
- [ ] Used for: divide-by-zero, invalid menu choices, malformed input
- [ ] Caught in `main` so the program always continues running — never crashes on bad input

---

## 4. User Interface (Console Menu)

When the program runs, it should display a menu like this:

```
╔══════════════════════════════════════╗
║     ADVANCED JAVA CALCULATOR v1.0    ║
╚══════════════════════════════════════╝
 Current Value : 0.0    Memory : 0.0

 [1] Arithmetic    [2] Unit Convert
 [3] Memory        [4] History
 [5] Stats         [0] Quit

Enter choice:
```

- The **current value** updates after every operation and is the default first operand for the next arithmetic step
- The **menu loops** until the user types `0`
- All input is read via `Scanner`

---

## 5. Milestones (Suggested Build Order)

Build the project one milestone at a time. Each milestone is independently runnable.

### 🟢 Milestone 1 — Basic Arithmetic (est. 1 hour)
- [ ] Create the `AdvancedCalculator` class with `currentValue`, `memory`, `history` fields
- [ ] Implement the `calculate(double a, char op, double b)` method
- [ ] Implement the `CalculatorException` class
- [ ] Build the main `do-while` menu loop (arithmetic option only)
- [ ] Verify: `5 + 3 = 8.0`, `10 / 0` shows error without crashing

### 🟡 Milestone 2 — History + Memory (est. 1 hour)
- [ ] Implement `addToHistory(String entry)` with a 10-entry sliding window
- [ ] Implement `showHistory()` 
- [ ] Implement `memoryStore()`, `memoryRecall()`, `memoryAdd()`, `memoryClear()`
- [ ] Verify: do 5 operations → `HISTORY` shows all 5 correctly formatted

### 🟠 Milestone 3 — Unit Conversion (est. 1.5 hours)
- [ ] Define `enum ConversionType { KM_TO_MI, MI_TO_KM, C_TO_F, F_TO_C, KG_TO_LB, LB_TO_KG }`
- [ ] Implement `convert(double value, ConversionType type)` using a `switch` expression
- [ ] Wire the conversion sub-menu
- [ ] Verify: `100°C → 212.0°F`, `1 km → 0.6214 mi`

### 🔴 Milestone 4 — Stream Statistics (est. 30 min)
- [ ] Extract `double` results from history entries into a `DoubleStream`
- [ ] Implement `showStats()` printing average, max, sum
- [ ] Verify with at least 3 operations in history

### ⭐ Milestone 5 — Polish (est. 30 min)
- [ ] Add the visual banner and formatted menu
- [ ] Ensure current value always shows after every operation
- [ ] Full end-to-end test: run every feature once without errors

---

## 6. Class Structure (Suggested)

```
AdvancedCalculator.java
│
├── class CalculatorException extends RuntimeException
│
├── enum ConversionType
│   └── (6 constants: KM_TO_MI, MI_TO_KM, C_TO_F, F_TO_C, KG_TO_LB, LB_TO_KG)
│
└── class AdvancedCalculator
    ├── Fields:
    │   ├── private double currentValue
    │   ├── private double memory
    │   └── private ArrayDeque<String> history   // max 10
    │
    ├── Methods:
    │   ├── double calculate(double a, char op, double b)
    │   ├── void addToHistory(String entry)
    │   ├── void showHistory()
    │   ├── void memoryStore() / memoryRecall() / memoryAdd() / memoryClear()
    │   ├── double convert(double value, ConversionType type)
    │   ├── void showStats()
    │   ├── void showMenu()
    │   └── void run()   ← main loop
    │
    └── main(String[] args)  ← creates one AdvancedCalculator, calls run()
```

---

## 7. Sample Session (Expected Output)

```
╔══════════════════════════════════════╗
║     ADVANCED JAVA CALCULATOR v1.0    ║
╚══════════════════════════════════════╝
 Current Value : 0.0    Memory : 0.0

 [1] Arithmetic    [2] Unit Convert
 [3] Memory        [4] History
 [5] Stats         [0] Quit

Enter choice: 1
Enter first operand (or press Enter to use 0.0): 10
Enter operator (+, -, *, /): /
Enter second operand: 0
⚠ Error: Cannot divide by zero.

Enter choice: 1
Enter first operand (or press Enter to use 0.0): 10
Enter operator (+, -, *, /): +
Enter second operand: 5
✔ 10.0 + 5.0 = 15.0000

 Current Value : 15.0    Memory : 0.0

Enter choice: 3
Memory Operations: [1] MS  [2] MR  [3] M+  [4] MC
Choice: 1
✔ Stored 15.0 in memory.

Enter choice: 4
── History ────────────────────────────
 [1]  10.0  +  5.0  =  15.0

Enter choice: 0
Goodbye! 👋
```

---

## 8. Grading Rubric (for Instructors)

| Criteria | Points |
|----------|--------|
| Milestone 1 complete & compiles | 20 |
| Milestone 2 complete (history + memory) | 20 |
| Milestone 3 complete (unit conversion + enum) | 20 |
| Milestone 4 complete (stream statistics) | 15 |
| Custom exception used correctly | 10 |
| Code quality: comments, naming, formatting | 10 |
| Milestone 5 polish (menu, UX) | 5 |
| **Total** | **100** |

---

## 9. How to Compile & Run

```bash
# Navigate to the project folder
cd projects/calculator

# Compile
javac AdvancedCalculator.java

# Run
java AdvancedCalculator
```

For the starter file:
```bash
cd projects/calculator/starter
javac CalculatorStarter.java
java CalculatorStarter
```

---

## 10. Submission Checklist

Before submitting, verify:
- [ ] Program compiles with **zero errors** (`javac AdvancedCalculator.java`)
- [ ] All 5 milestones are functional
- [ ] Division by zero is handled gracefully
- [ ] History shows exactly the last 10 entries (older ones drop off)
- [ ] Unit conversions produce correct results (verify with Google)
- [ ] `STATS` command works after 2+ operations
- [ ] Code has meaningful comments on every class, field, and method

---

*AI-Driven Java Programming — Aptech Certified Courseware*  
*Project PRD v1.0 — Advanced Java Calculator*
