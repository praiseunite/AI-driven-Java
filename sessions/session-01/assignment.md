# Assignment 1: Aptech Smart Campus Registration Receipt 📋

> **Module:** JAVA-I-TL1 | **Due Date:** Before Session 2 | **Max Score:** 100 Pts

---

## 🏢 Business Scenario
The Aptech Student Administration Office is deploying a lightweight console terminal kiosk for students registering for the new **AI-Driven Java Programming** diploma track.

Your task is to write a standalone Java program named `CampusReceipt.java` that prints an official registration and fee confirmation slip with pristine formatting.

---

## 📋 Requirements
1. **Class & Filename**: Must be named `CampusReceipt.java` with a `public class CampusReceipt`.
2. **Framed Header**: Display *APTECH COMPUTER EDUCATION - SMART KIOSK* inside decorative borders.
3. **Registration Metadata**: Include Student Name, Registration ID, Course Title (`AI-Driven Java Programming`), Schedule, and Date.
4. **Itemized Financial Table**:
   - Tuition Fee
   - Lab & Cloud AI Token Fee
   - Courseware & Digital License
   - Total Amount Paid & Balance Due ($0.00)
5. **Escape Sequences**: Use `\t` (tabs) to maintain vertical column alignment.
6. **Code Documentation**: Include comments explaining class purpose and author information.

---

## 🎯 Target Console Output
```text
+==================================================================+
|             APTECH COMPUTER EDUCATION - SMART KIOSK              |
|                   OFFICIAL REGISTRATION RECEIPT                  |
+==================================================================+
  Receipt No   : REC-2026-98102
  Date Issued  : April 2026
  Student Name : [Your Name]
  Student ID   : APT-2026-0012
  Course Track : AI-Driven Java Programming (JAVA-I)
  Schedule     : Mon - Thu (2 Hours/Session)
--------------------------------------------------------------------
  FEE ITEMIZATION                             AMOUNT (USD)
--------------------------------------------------------------------
  Core Java Tuition Fee                       $ 450.00
  Lab & Cloud AI Sandbox Access               $ 120.00
  Courseware & ProConnect Digital License     $  80.00
--------------------------------------------------------------------
  TOTAL PAID                                  $ 650.00
  BALANCE OUTSTANDING                         $   0.00
+==================================================================+
|    *** COMPUTER GENERATED RECEIPT - VERIFIED BY APTECH ***       |
+==================================================================+
```

---

## 📊 Grading Rubric (100 Pts Total)
- **Compilation & Execution (35 Pts)**: Clean compilation via `javac` and run via `java`.
- **Layout Alignment & Aesthetics (25 Pts)**: Professional, aligned output using escape sequences.
- **Completeness (25 Pts)**: All required fields and financial lines present.
- **Code Quality & Comments (15 Pts)**: Clean formatting and comments.

**Submission**: Upload `CampusReceipt.java` to ProConnect under *Work Assignments -> Session 1*.
