# Session 12: Week 3 Review & Consolidation — Quick Reference 🔄

> 📄 **This is a summary.** Full review guide (concept map, worked `PaymentSystem`,
> `instanceof`→polymorphism refactor, debugging playbook) in **[lesson.html](lesson.html)**.

---

## The Week 3 Grand Mental Model

Model "is-a" families with **inheritance** (an `abstract` base for shared state + demanded
methods). Model capabilities with **interfaces** a class can `implement` many of. Let
**polymorphism** replace type-checking ladders. Handle failure with **exceptions**: checked for
expected external problems, unchecked for bugs, try-with-resources for cleanup, custom types for
your domain's failures.

---

## Which tool when?

| You want… | Reach for… |
| :--- | :--- |
| Reuse + "is-a" family with shared state | inheritance (`abstract` base) |
| Force subclasses to supply a method | `abstract` method |
| A capability unrelated classes can offer | interface |
| One class, several capabilities | multiple `implements` |
| One call, many behaviours, no `if` ladder | polymorphism (override + program to base type) |
| Sort your objects | `Comparable` / `Comparator` |
| Tiny one-off implementation | lambda / anonymous class |
| Handle expected external failure | checked exception + `try/catch` |
| Reject bad args early | unchecked (`IllegalArgumentException`), `throw` at top |
| Guaranteed resource cleanup | try-with-resources |

## `instanceof` ladder → polymorphism

When you ask "what type is this object?", the answer usually belongs **inside** the object as an
overridden method. Give the types a common interface method; call it; delete the ladder.

## Week 3 bugs

| Message | Fix |
| :--- | :--- |
| `@Override` compile error | Signature doesn't match — fix name/params |
| "does not override abstract method X" | Implement the abstract/interface method (`public` for interfaces) |
| `ClassCastException` | Guard: `if (o instanceof T t)` |
| "unreported exception X" | `try/catch` it or add `throws X` |
| "exception X has already been caught" | Reorder catches — specific first |
| empty `catch` | Always log/handle |

---

## Self-Check

1. **Shared state + several capabilities?** — `abstract` class + multiple `implements`.
2. **`instanceof` ladder in a loop — smell + fix?** — Type-checking that belongs in the objects;
   use a common interface method.
3. **Checked vs unchecked?** — Expected recoverable external problem vs programming bug.
4. **`@Override` compile error means?** — You're not actually overriding anything.

Glossary: [../../reference/glossary.html](../../reference/glossary.html)
