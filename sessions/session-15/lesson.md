# Session 15: JDK 25 & AI-Assisted Coding — Quick Reference 🤖

> 📄 **This is a summary.** Full lesson (virtual threads, sealed types + record patterns, AI
> tooling landscape, prompt/review checklists, ethics) in **[lesson.html](lesson.html)**.

---

## 30-Second Mental Model

Java ships every 6 months; **LTS** (21, 25) is what you target. **Virtual threads**: millions of
cheap threads, one per task. **Sealed** types + **record patterns** in `switch` give exhaustive,
deconstructing matches that replace `instanceof` ladders. **Sequenced collections** add
`getFirst/getLast/reversed`. For **AI**: prompt with role + task + constraints + output shape;
then compile, read every line, verify the API, test edges — never ship code you can't explain.

---

## Modern JDK features

```java
// virtual threads
Thread t = Thread.ofVirtual().start(() -> work());
try (var pool = Executors.newVirtualThreadPerTaskExecutor()) {
    for (var task : tasks) pool.submit(task);
}

// sealed + record patterns in switch
sealed interface Shape permits Circle, Rectangle {}
record Circle(double r) implements Shape {}
record Rectangle(double w, double h) implements Shape {}

double area(Shape s) {
    return switch (s) {
        case Circle c                      -> Math.PI * c.r() * c.r();
        case Rectangle(double w, double h) -> w * h;
    };  // no default: sealed => exhaustive
}

// guards + null in switch
switch (o) {
    case Integer i when i < 0 -> "neg";
    case Integer i            -> "int " + i;
    case null                 -> "null";
    default                   -> "other";
}

// sequenced collections
list.getFirst(); list.getLast(); list.addFirst(x); list.reversed();

// misc: Stream.toList(), Math.clamp(v, lo, hi), "=".repeat(10), s.isBlank()
```

## AI workflow

**Prompt** = role & level + concrete task + constraints (Java version, allowed concepts) +
output shape (code + example + explanation).

**Review checklist:**
1. Compile & run it. 2. Read every line — can you explain it? 3. Verify the API is real
   (no hallucinated methods). 4. Test edges (empty, null, 1, huge, negative). 5. Hunt silent
   bugs (off-by-one, swallowed exceptions, `==` on objects, integer division). 6. Match the
   codebase's style; no stray libraries.

**Ethics:** academic honesty (explain your own submissions); licensing (caution with large
verbatim blocks); confidentiality (no secrets/proprietary code into public tools); security
(review auth/crypto/input handling hard).

---

## Self-Check

1. **Why can millions of virtual threads run?** — They don't each own an OS thread; the JVM
   multiplexes them onto a small carrier pool.
2. **Why no `default` in a sealed-type `switch`?** — The compiler knows all permitted subtypes;
   cover them all and it's provably exhaustive.
3. **AI code uses `getFirst()` and won't compile — why?** — Project targets a JDK older than 21.
4. **Rule for submitting AI-assisted code?** — Understand and be able to explain every line.

Glossary: [../../reference/glossary.html](../../reference/glossary.html) · AI guide:
[../../reference/ai-tutor-guide.html](../../reference/ai-tutor-guide.html)
