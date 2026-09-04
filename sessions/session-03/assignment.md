# Assignment 3: Automated ATM Banking Machine Simulator 📋

> **Module:** JAVA-I-TL3 | **Due Date:** Before Session 4 | **Max Score:** 100 Pts

---

## 🏢 Scenario
Prototype the core state-machine and transaction handler for an ATM kiosk named `AtmBankingEngine.java`.

---

## 📋 Technical Requirements
1. **PIN Security Check**: Use a loop to give the user up to 3 attempts to input PIN `2026`.
2. **Transaction Menu Loop**: Use a `do-while` or `while` loop running until option 5 (Exit) is selected.
3. **Menu Options via `switch-case`**:
   - `1`: View current balance (`$%.2f`).
   - `2`: Deposit funds (reject &le; 0).
   - `3`: Withdraw cash with validations:
     - Must be &gt; $0.
     - Must not exceed account balance (insufficient funds).
     - Must not exceed single transaction limit of $500.00.
   - `4`: Print mini-statement with count of completed transactions.
   - `5`: Eject card and exit loop.
4. **Error Handling**: Catch unknown choices using `default:` inside the switch.

---

## 📊 Grading Rubric (100 Pts)
- **Loop Architecture (30 Pts)**: Clean loop cycle and exit condition.
- **Business Logic & Branching (30 Pts)**: Validations for overdraft, negative deposits, and transaction limits.
- **Menu Switch Implementation (20 Pts)**: Well-structured `switch-case` with breaks.
- **Formatting & Style (20 Pts)**: Clean indentation, currency formatting, and comments.

**Submission**: Upload `AtmBankingEngine.java` via ProConnect under *Work Assignments -> Session 3*.
