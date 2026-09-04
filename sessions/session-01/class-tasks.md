# Session 1: In-Class Practical Tasks 💻

> **Track:** AI-Driven Java Programming (JAVA-I) | **Session 1 Guided Lab**

---

## 🟢 Task 1.1 (Easy): The Developer Profile Banner
**Objective:** Create your very first custom Java file from scratch, compile it using `javac`, and run it using `java` to output a stylish developer profile badge.

### Instructions:
1. Create a new file named `ProfileBadge.java`.
2. Write a public class `ProfileBadge` with the standard `main` method.
3. Print your full name, student ID, track, and personal goal inside a framed border.

```java
public class ProfileBadge {
    public static void main(String[] args) {
        System.out.println("**************************************************");
        System.out.println("*           APTECH DEVELOPER PROFILE             *");
        System.out.println("**************************************************");
        System.out.println("* Name        : Sarah Connor                     *");
        System.out.println("* Student ID  : APT-2026-8942                    *");
        System.out.println("* Track       : AI-Driven Enterprise Java        *");
        System.out.println("* Motivation  : Building Intelligent Cloud Apps   *");
        System.out.println("**************************************************");
    }
}
```

---

## 🟡 Task 1.2 (Medium): Formatting with Escape Sequences
**Objective:** Contrast `System.out.print()` vs `System.out.println()` and format a structured schedule table using `\t` (tab) and `\n` (newline).

### Instructions:
1. Create a file named `CourseSchedule.java`.
2. Format a 3-column table showing Week 1 schedule.

```java
public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println("DAY\t\tSESSION\t\tTOPIC");
        System.out.println("----------------------------------------------------------");
        System.out.println("Day 1\t\tSession 1\tIntro to Java & JDK Setup");
        System.out.println("Day 2\t\tSession 2\tVariables, Types & Operators");
        System.out.println("Day 3\t\tSession 3\tDecisions & Loops");
        System.out.println("Day 4\t\tSession 4\tTry It Yourself Review Lab");
    }
}
```

---

## 🔴 Task 1.3 (Challenge): Command-Line Arguments Explorer
**Objective:** Understand how parameters are passed into a Java program at launch time through `String[] args`.

### Instructions:
1. Create `TerminalGreeter.java`.
2. Access `args[0]` (name) and `args[1]` (city).
3. Test running with: `java TerminalGreeter Ada Abuja`

```java
public class TerminalGreeter {
    public static void main(String[] args) {
        System.out.println("Hello, " + args[0] + " from " + args[1] + "!");
        System.out.println("Welcome to Aptech AI-Driven Java Programming.");
    }
}
```
