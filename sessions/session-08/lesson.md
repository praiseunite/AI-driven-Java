# Session 8: Week 2 Review & Consolidation — Quick Reference 🔄

> 📄 **This is a summary.** Full review guide (concept map, worked `Gradebook` example,
> OOP-era debugging playbook, assignment self-review) in **[lesson.html](lesson.html)**.

---

## The Week 2 Grand Mental Model

Model the domain as **classes** (state + behavior; fields `private`). Build **objects** with
`new`; variables hold **references**. Keep many objects in an **array** (fixed) or an
**ArrayList** (growable). Share class-wide data with **`static`**, lock it with **`final`**.
Organise files into **packages**; ship them in a **JAR**. Most new bugs are `null`,
static-context, private-access, or two-references-one-object.

---

## Class design checklist

1. **What is one object?** — noun class name.
2. **What does it know?** — `private` fields; `final` for what never changes.
3. **How is it born?** — a constructor leaving it in a valid state.
4. **What can it do?** — `public` methods that **return** results; `private` helpers.
5. **Shared by all objects?** — `static` (and `final` if constant).
6. **How does it print?** — override `toString()`.

## OOP-era bugs

| Symptom | Cause / fix |
| :--- | :--- |
| `NullPointerException` on your object | Reference never `new`'d, or array/list slot still `null`. |
| "non-static ... from a static context" | `static main` calling an instance member — make it static or create an object. |
| "x has private access in Y" | Outside code touching a `private` field — add a getter, or move the logic in. |
| `ConcurrentModificationException` | `remove` inside a `for-each` — loop backwards by index, or collect then remove. |
| Change through `b` shows up in `a` | `b = a` copied the address; same object. |
| `==` gives false for equal-looking objects | Use `.equals()` / `Arrays.equals()`. |

## Syntax refresher

| Pattern | Example |
| :--- | :--- |
| Class + constructor | `public Item(String n) { this.name = n; }` |
| Getter | `public String getName() { return name; }` |
| Array loop | `for (int v : a) { ... }` (read-only) |
| ArrayList | `list.add(x); list.get(i); list.size();` |
| Shared constant | `public static final double VAT = 0.075;` |
| Package | `package com.aptech.app;` (first line, folder matches) |

---

## Self-Check

1. **Mutate a `Student` returned from a list — does the list's object change?** — Yes; it's the
   same reference.
2. **When `static` for a field?** — When it describes the class, not one object.
3. **Which needs no parentheses: `list.size()`, `a.length`, `s.length()`?** — `a.length`.
4. **`static main` calling non-static `process()` won't compile — two fixes?** — Make
   `process()` static, or call it on an object.

Glossary: [../../reference/glossary.html](../../reference/glossary.html)
