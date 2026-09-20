# Session 13: In-Class Practical Tasks 💻

> **Track:** AI-Driven Java Programming (JAVA-I) | **Session 13 Lab**
> Reference solutions: [solution/solution.html](solution/solution.html)
> Dates are fixed so outputs are stable.

---

## 🟢 Task 13.1 (Easy): Age Calculator (Period + ChronoUnit)

```java
import java.time.*;
import java.time.temporal.ChronoUnit;

public class AgeCalculator {
    public static void main(String[] args) {
        LocalDate birth = LocalDate.of(2001, 7, 15);
        LocalDate on    = LocalDate.of(2026, 4, 21);

        Period age = Period.between(birth, on);
        long totalDays = ChronoUnit.DAYS.between(birth, on);

        System.out.printf("Age: %d years, %d months, %d days%n",
                age.getYears(), age.getMonths(), age.getDays());
        System.out.println("Total days alive: " + totalDays);
        System.out.println("Born on a " + birth.getDayOfWeek());

        LocalDate nextBday = birth.withYear(on.getYear());
        if (!nextBday.isAfter(on)) nextBday = nextBday.plusYears(1);
        System.out.println("Next birthday: " + nextBday
                + " (" + ChronoUnit.DAYS.between(on, nextBday) + " days away)");
    }
}
```
**Expected output:**
```
Age: 24 years, 9 months, 6 days
Total days alive: 9046
Born on a SUNDAY
Next birthday: 2026-07-15 (85 days away)
```

---

## 🟡 Task 13.2 (Medium): Meeting Planner (Duration + formatting)

```java
import java.time.*;
import java.time.format.DateTimeFormatter;

public class MeetingPlanner {
    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.of(2026, 4, 21, 14, 0);
        Duration length = Duration.ofMinutes(90);
        LocalDateTime end = start.plus(length);

        DateTimeFormatter f = DateTimeFormatter.ofPattern("EEE d MMM, HH:mm");
        System.out.println("Starts : " + start.format(f));
        System.out.println("Ends   : " + end.format(f));
        System.out.println("Length : " + length.toHours() + "h " + length.toMinutesPart() + "m");

        boolean businessHours = !end.toLocalTime().isAfter(LocalTime.of(17, 0));
        System.out.println("Within business hours? " + businessHours);
    }
}
```
**Expected output:**
```
Starts : Tue 21 Apr, 14:00
Ends   : Tue 21 Apr, 15:30
Length : 1h 30m
Within business hours? true
```

---

## 🔴 Task 13.3 (Challenge): Subscription Status (plusMonths + ChronoUnit + branching)

```java
import java.time.*;
import java.time.temporal.ChronoUnit;

public class SubscriptionCheck {
    static String status(LocalDate signup, LocalDate today) {
        LocalDate renewal = signup.plusMonths(1);
        if (today.isAfter(renewal)) return "EXPIRED";
        long daysLeft = ChronoUnit.DAYS.between(today, renewal);
        return daysLeft <= 3 ? "DUE SOON (" + daysLeft + "d)" : "ACTIVE (" + daysLeft + "d)";
    }

    public static void main(String[] args) {
        LocalDate today = LocalDate.of(2026, 4, 21);
        LocalDate[] signups = {
            LocalDate.of(2026, 4, 1),    // renewal May 1 -> ACTIVE
            LocalDate.of(2026, 3, 20),   // renewal Apr 20 -> EXPIRED
            LocalDate.of(2026, 3, 23)    // renewal Apr 23 -> DUE SOON (2d left)
        };
        for (LocalDate s : signups) {
            System.out.println(s + " -> " + status(s, today));
        }
    }
}
```
**Expected output:**
```
2026-04-01 -> ACTIVE (10d)
2026-03-20 -> EXPIRED
2026-03-23 -> DUE SOON (2d)
```
