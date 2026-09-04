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
├── README.md                       # High-level architecture & instructor guide
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
- **`lesson.html`**: Comprehensive, visual, interactive web lecture with line-by-line code breakdowns, real-world analogies, and sticky navigation.
- **`lesson.md`**: Clean markdown edition for reading on GitHub, offline e-readers, or terminal viewers.
- **`pre-quiz.html`**: Pre-lecture diagnostic quiz evaluating readiness and intuition.
- **`post-quiz.html`**: Post-lecture knowledge check with instant feedback and answer explanations.
- **`class-tasks.html` / `class-tasks.md`**: Tiered in-class coding exercises with starter templates and expected outputs.
- **`assignment.html` / `assignment.md`**: Scenario-based practical take-home assignments with grading rubrics.
- **`code-examples/`**: Compilable, tested, heavily-annotated `.java` source files ready to run via `javac` & `java`.

---

## 🗓️ 4-Week Session Roadmap

| Week | Session | Module Title | Focus Areas |
| :--- | :--- | :--- | :--- |
| **W1** | **01** | Introduction to Java | Structured vs OOP, JVM/JRE/JDK, Environment Setup, First Program |
| | **02** | Variables, Data Types & Operators | Primitive vs Reference, Type Casting, Formatting, Expressions |
| | **03** | Decision-Making & Loops | `if/else`, `switch`, `while`, `for`, `break`/`continue`, Nested Constructs |
| | **04** | Try It Yourself: Review 1–3 | Algorithmic Problem Solving, Tracing, Debugging Workshop |
| **W2** | **05** | Classes, Objects & Methods | Object Blueprinting, Constructors, `this`, Overloading, Memory Layout |
| | **06** | Arrays and Strings | Single/Multi-D Arrays, `ArrayList`, `String`, `StringBuilder`, Autoboxing |
| | **07** | Modifiers and Packages | Access Levels, `static` State, User Packages, Creating Executable `.jar` |
| | **08** | Review 4–6 + Assignments S1–S3 | OOP Architecture Review, ProConnect Assignments Evaluation |
| **W3** | **09** | Inheritance & Polymorphism | Class Hierarchies, `super`, Method Overriding, Dynamic Binding, `abstract` |
| | **10** | Interfaces & Nested Classes | Contracts, Multiple Interfaces, Static & Inner Classes, Anonymous Classes |
| | **11** | Exceptions Handling | Checked vs Unchecked, `try-catch-finally`, Custom Exceptions, Best Practices |
| | **12** | Try It Yourself: Review 7–9 | Refactoring, Polymorphic Design Patterns, Robust Error Trapping |
| **W4** | **13** | Date and Time API | `java.time`, `LocalDate`, `ZonedDateTime`, Formatting, Enums & Clocks |
| | **14** | Additional Modern Features | Functional Interfaces, Lambdas, Streams API, Generics, Switch Expressions |
| | **15** | JDK 25 & AI-Assisted Java | Virtual Threads, Record Patterns, Prompt Engineering, IDE AI Plugins |
| | **16** | Final Review & Evaluation S4–S6 | Comprehensive Capstone, Professional Code Reviews, Final Assessment |

---

## 🚀 Getting Started for Instructors & Students

1. **Launch the Dashboard**: Double-click [index.html](file:///c:/Projects/Aptech/AI%20driven%20Java/index.html) or serve using any static web server (e.g., Live Server, `python -m http.server 8000`, or `npx serve`).
2. **Compile and Run Code Examples**:
   ```bash
   cd sessions/session-01/code-examples
   javac HelloWorld.java
   java HelloWorld
   ```
3. **Interactive Quizzes**: Open `pre-quiz.html` or `post-quiz.html` in any modern web browser to engage in interactive question-and-answer sessions with real-time scoring.

---
*Developed for Aptech Training Centers — AI-Driven Java Programming Curriculum.*
