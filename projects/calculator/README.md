# 🧮 Advanced Java Calculator
### AI-Driven Java Programming (JAVA-I) — Aptech Project

> **Difficulty:** ⭐⭐⭐ Intermediate–Advanced  
> **Recommended After:** Session 11  
> **Est. Time:** 4–8 hours

---

## What Is This?

A console-based **Advanced Java Calculator** that exercises every major concept from Sessions 2–14 in a single cohesive project. Features include:

- ✅ Basic arithmetic with proper error handling
- 🧠 Memory store / recall (M+, M−, MR, MC)
- 📜 History log of last 10 operations
- 🔄 Unit conversions (km↔mi, °C↔°F, kg↔lb)
- 📊 Stream-based statistics on your history
- ⚠️ Custom exception class (`CalculatorException`)
- 🎨 Formatted console menu with live current-value display

---

## Files in This Folder

| File | Description |
|------|-------------|
| [`PRD.md`](PRD.md) | **Start here.** Full Product Requirements Document — what to build, acceptance criteria, milestones, rubric |
| [`AdvancedCalculator.java`](AdvancedCalculator.java) | Complete, annotated **reference solution** — only peek after you've tried! |
| [`starter/CalculatorStarter.java`](starter/CalculatorStarter.java) | **Student scaffold** — skeleton with `TODO` comments guiding you step-by-step |

---

## Quick Start

### Option A — Build it yourself (recommended)
```bash
cd projects/calculator/starter
# Open CalculatorStarter.java in IntelliJ IDEA
# Follow the TODO comments to complete each method
javac CalculatorStarter.java
java CalculatorStarter
```

### Option B — Study the reference solution
```bash
cd projects/calculator
javac AdvancedCalculator.java
java AdvancedCalculator
```

---

## Build Order (Milestones)

Follow the milestones in [`PRD.md`](PRD.md):

```
🟢 Milestone 1 — Basic Arithmetic        (~1 hour)
🟡 Milestone 2 — History + Memory        (~1 hour)
🟠 Milestone 3 — Unit Conversion         (~1.5 hours)
🔴 Milestone 4 — Stream Statistics       (~30 min)
⭐ Milestone 5 — Polish & Full Test       (~30 min)
```

---

## Concepts You'll Practice

| Java Feature | Where You'll Use It |
|---|---|
| `double` arithmetic | `calculate()` method |
| `ArithmeticException` / custom exceptions | Divide-by-zero guard |
| `private` fields + encapsulation | Memory slot |
| `ArrayDeque` | 10-entry sliding history window |
| `enum` + `switch` expression | Unit conversion types |
| `ArrayList` + Streams | Statistics computation |
| `Scanner` + `do-while` | Menu loop |
| Formatted output (`printf`) | All result displays |

---

*AI-Driven Java Programming — Aptech Certified Courseware*
