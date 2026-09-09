# AI-Driven Java Programming (JAVA-I) ☕🤖

> **Aptech Certified Courseware — Module Ver. 1.0 (Effective April 2026)**  
> *Target Duration:* 32 Online / Contact Hours (16 Sessions × 2 Hours) + 12 Hours Self-Study

Welcome to **AI-Driven Java Programming**, an immersive, beginner-first curriculum engineered to take learners with zero programming background from the fundamentals of software execution to modern Java development (through JDK 25) enhanced with AI-assisted workflows (ChatGPT, GitHub Copilot, Eclipse AI tooling).

---

## 🎯 Course Pedagogical Framework

Each session follows a structured, evidence-based learning sequence:

```
[ Pre-Class Diagnostic Quiz ]
             ↓
[ Core Conceptual & Intuitive Lecture ]
             ↓
[ Guided Live Coding & Line-by-Line Breakdown ]
             ↓
[ Hands-on In-Class Tasks (Tiered: Easy → Medium → Challenge) ]
             ↓
[ Post-Class Formative Quiz & Conceptual Review ]
             ↓
[ Real-World Scenario Take-Home Assignment ]
```

---

## 📂 Repository & Folder Architecture

```text
AI driven Java/
├── index.html                      # Interactive Course Hub & Visual Dashboard
├── start-here.html                 # Course onboarding: how to study, use solutions, get unstuck
├── intellij-guide.html             # Visual Orientation: Laptop & IntelliJ IDEA Cockpit Guide
├── README.md                       # High-level architecture & instructor guide
├── setup/
│   └── environment-setup.html      # Install JDK 25 LTS + IntelliJ (Win/macOS/Linux) & troubleshoot PATH/JAVA_HOME
├── reference/
│   ├── commands.html               # Every action done both ways: IntelliJ IDEA <-> command line
│   ├── reading-errors.html         # Compile vs runtime errors, reading a stack trace, message decoder
│   ├── ai-tutor-guide.html         # Using ChatGPT/Copilot/IntelliJ AI as a tutor, not a crutch
│   └── glossary.html               # Master glossary — every term, plain English, grouped by topic
├── css/
│   └── style.css                   # Glassmorphism dark-theme design system
├── js/
│   └── quiz.js                     # Dynamic client-side quiz & scoring engine
├── assets/
│   └── images/                     # Diagrams, illustrations, architecture charts
└── sessions/
    ├── session-01/                 # Introduction to Java & JDK Architecture
    ├── session-02/                 # Variables, Data Types & Operators
    ├── session-03/                 # Decision-Making Constructs & Loops
    ├── session-04/                 # Try It Yourself: Consolidation & Debugging (1-3)
    ├── session-05/                 # Classes, Objects & Methods
    ├── session-06/                 # Arrays, ArrayList & Strings
    ├── session-07/                 # Modifiers, Packages & JAR Deployment
    ├── session-08/                 # Try It Yourself (4-6) + Self-Study Evaluation S1-S3
    ├── session-09/                 # Inheritance & Polymorphism
    ├── session-10/                 # Interfaces, Nested & Anonymous Classes
    ├── session-11/                 # Exception Handling & Defensive Engineering
    ├── session-12/                 # Try It Yourself: Consolidation (7-9)
    ├── session-13/                 # Modern Date and Time API (java.time)
    ├── session-14/                 # Advanced Features: Lambdas, Streams, Generics
    ├── session-15/                 # JDK 25 Enhancements & AI-Assisted Java Coding
    └── session-16/                 # Final Review, Capstone Lab & Evaluation S4-S6
```

### Standard Artifacts Per Session
Inside each `session-XX` directory, you will find:
- **`lesson.html`**: The canonical lesson — comprehensive, visual, interactive web lecture with line-by-line code breakdowns, real-world analogies, IDE + command-line workflows, "Trace it" tables, an "Ask Your AI Tutor" box, and sticky navigation.
- **`lesson.md`**: A **quick-reference summary** of the lesson (30-second mental model, syntax card, glossary links, self-check questions). It is intentionally short; `lesson.html` is the full lesson.
- **`pre-quiz.html`**: Pre-lecture diagnostic quiz evaluating readiness and intuition.
- **`post-quiz.html`**: Post-lecture knowledge check with instant feedback and answer explanations.
- **`class-tasks.html` / `class-tasks.md`**: Tiered in-class coding exercises with starter templates and expected outputs.
- **`assignment.html` / `assignment.md`**: Scenario-based practical take-home assignments with grading rubrics.
- **`code-examples/`**: Compilable, tested, heavily-annotated `.java` source files ready to run via `javac` & `java`.

---

## 🗓️ 4-Week Session Roadmap

Every session ships: `pre-quiz.html`, canonical `lesson.html` + summary `lesson.md`, tiered
`class-tasks` (each task with a run-verified **Expected Output**), a scenario `assignment`
(review sessions 4/8/12/16 have consolidation labs / a capstone instead), `post-quiz.html`,
compilable `code-examples/`, and a `solution/` folder (reference `.java` + `solution.html`).

| Week | Session | Module Title | Focus Areas |
| :--- | :--- | :--- | :--- |
| **W1** | **01** | Introduction to Java | Structured vs OOP, JVM/JRE/JDK, JDK 25 + IntelliJ setup, first error message, comments, First Program |
| | **02** | Variables, Data Types & Operators | 8 primitives, **`Scanner` input**, `++`/`+=`, **operator precedence**, `final`, **`Math`**, casting, **money & floating-point** |
| | **03** | Decision-Making & Loops | `if/else`, `switch` (+ arrow-form preview), `while`/`for`/`do-while`, `break`/`continue`, **trace tables**, off-by-one, **infinite-loop recovery**, nested loops, `Scanner` menu |
| | **04** | Try It Yourself: Review 1–3 | **String-methods mini-lesson**, the 4 loop patterns, formal tracing, **reading stack traces**, algorithm challenges |
| **W2** | **05** | Classes, Objects & Methods | Class vs object, fields/methods, `new`/references/`null`, constructors & `this`, method & constructor overloading, `toString()`, encapsulation, stack/heap |
| | **06** | Arrays and Strings | 1-D/2-D arrays, `.length`, `for` vs for-each, array algorithms, `ArrayList`, wrapper types & autoboxing, `String` immutability, `StringBuilder`, `split`/`join` |
| | **07** | Modifiers and Packages | `public`/`protected`/package-private/`private`, `static` (shared state & utility classes), `final`, packages (folder = name), `import`, **executable `.jar`** |
| | **08** | Review 4–6 (Week 2) | Concept map, integrative `Gradebook` example, OOP-era debugging playbook, S5–S7 assignment self-review, combined challenges |
| **W3** | **09** | Inheritance & Polymorphism | `extends`/`super`/`@Override`, override vs overload, **dynamic dispatch**, `abstract` classes, overriding `toString`/`equals`/`hashCode`, `instanceof` |
| | **10** | Interfaces & Nested Classes | Contracts, multiple `implements`, `default` methods, `Comparable`, abstract class vs interface, static/inner/local/**anonymous** classes, first **lambda** |
| | **11** | Exception Handling | Hierarchy, checked vs unchecked, `try`/`catch`/`finally`, multi-catch, **try-with-resources**, `throw`/`throws`, **custom exceptions**, best practices |
| | **12** | Try It Yourself: Review 7–9 | Concept map, integrative `PaymentSystem`, **refactoring `instanceof` ladders to polymorphism**, Week 3 debugging playbook |
| **W4** | **13** | Date and Time API | `LocalDate`/`Time`/`DateTime`, immutability, `Period` vs `Duration`, `ChronoUnit`, `DateTimeFormatter`, `DayOfWeek`/`Month` enums, `ZonedDateTime` |
| | **14** | Additional Modern Features | Lambdas & method references, **Streams** (`filter`/`map`/`collect`/`groupingBy`/`reduce`), generics, `var`, **switch expressions**, **records**, text blocks, `Optional` |
| | **15** | JDK 25 & AI-Assisted Coding | Release cadence & LTS, **virtual threads**, `sealed` types, **record patterns** in `switch`, sequenced collections; AI tooling, **prompt engineering**, **review checklist**, ethics/licensing/security |
| | **16** | Final Review & Capstone | Whole-course concept map, **professional code-review checklist**, **Campus Bookstore capstone** (5 milestones integrating every module), 20-question final assessment |

---

## 🚀 Getting Started for Instructors & Students

1. **Launch the Dashboard**: Double-click [index.html](file:///c:/Projects/Aptech/AI%20driven%20Java/index.html) or serve using any static web server (e.g., Live Server, `python -m http.server 8000`, or `npx serve`).
2. **Read `start-here.html`**: How the course is structured, how to self-check with the reference solutions, and how to use an AI tutor responsibly.
3. **Set up your machine**: Follow [setup/environment-setup.html](file:///c:/Projects/Aptech/AI%20driven%20Java/setup/environment-setup.html) to install **JDK 25 LTS** and **IntelliJ IDEA Community**, verify from the terminal, and fix `PATH` / `JAVA_HOME` problems.
4. **First-Time Orientation**: Open [intellij-guide.html](file:///c:/Projects/Aptech/AI%20driven%20Java/intellij-guide.html) for an annotated visual tour of laptop folders, IntelliJ IDEA interface zones, keyboard shortcuts, and debugging workflows.
5. **Compile and Run Code Examples**:
   - **In IntelliJ IDEA**: Open the workspace root, right-click any `.java` file in `src/` or `sessions/`, and click **Run ▶**.
   - **Via Terminal**:
     ```bash
     cd sessions/session-01/code-examples
     javac HelloWorld.java
     java HelloWorld
     ```
6. **Interactive Quizzes**: Open `pre-quiz.html` or `post-quiz.html` in any modern web browser to engage in interactive question-and-answer sessions with real-time scoring.

---
*Developed for Aptech Training Centers — AI-Driven Java Programming Curriculum.*
