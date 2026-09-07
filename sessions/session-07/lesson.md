# Session 7: Modifiers and Packages — Quick Reference 📦

> 📄 **This is a summary.** Full lesson (access table, static counter, JAR steps, "Ask Your AI
> Tutor") in **[lesson.html](lesson.html)**.

---

## 30-Second Mental Model

**Access:** `public` > `protected` > package-private (no modifier) > `private`. Fields
`private`, expose methods. **`static`** = belongs to the class, one shared copy, no object
needed (counters, `Math`-style helpers). **`final`** = assign once. A **package** is a named
folder — the path must match the name; `import` or fully-qualify to use one. A **JAR** bundles
`.class` files; an executable one names its main class and runs with `java -jar`.

---

## Access levels

| Modifier | Same class | Same package | Subclass (other pkg) | Anywhere |
| :--- | :--: | :--: | :--: | :--: |
| `public` | ✅ | ✅ | ✅ | ✅ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| *(none)* package-private | ✅ | ✅ | ❌ | ❌ |
| `private` | ✅ | ❌ | ❌ | ❌ |

Top-level classes: only `public` or *(none)*.

## static vs instance

| | Instance member | `static` member |
| :--- | :--- | :--- |
| Belongs to | each object | the class |
| Copies | one per object | exactly one |
| Access | `obj.field` | `ClassName.field` |
| Use for | per-object state | shared state / stateless helpers |

`main` is `static` because the JVM calls it before any object exists. A `static` method has no
`this` and cannot touch instance fields.

## Packages

```java
package com.aptech.util;        // FIRST line; file lives at com/aptech/util/
import com.aptech.util.TextTools;
```

- Naming: reverse domain, lowercase — `com.aptech.util`.
- `java.lang` (`String`, `System`, `Math`, `Integer`) is imported automatically.
- Terminal: `javac com/aptech/util/TextTools.java Main.java` then `java Main` (or
  `java com.aptech.app.Main` if `Main` is packaged).

## Executable JAR

```bash
javac -d out $(find . -name "*.java")
jar --create --file app.jar --main-class Main -C out .
java -jar app.jar
```
IntelliJ: **Project Structure → Artifacts → + → JAR → From modules with dependencies → pick
main class**, then **Build → Build Artifacts**.

---

## Self-Check

1. **"Visible only in the same package"?** — package-private (no modifier).
2. **`static int count++` in a constructor, 3 objects — `count`?** — `3` (one shared copy).
3. **`package com.aptech.util;` — file location?** — `com/aptech/util/`.
4. **`java -jar` → "no main manifest attribute"?** — Manifest lacks `Main-Class:`; rebuild
   naming the main class.

Glossary: [../../reference/glossary.html](../../reference/glossary.html)
