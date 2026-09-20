# Session 13: The Modern Date and Time API — Quick Reference 🕐

> 📄 **This is a summary.** Full lesson (type table, formatter letters, time-zone walkthrough,
> "Ask Your AI Tutor") in **[lesson.html](lesson.html)**.

---

## 30-Second Mental Model

`LocalDate` / `LocalTime` / `LocalDateTime` for zone-free values; `ZonedDateTime` when zones
matter. All **immutable** — `plusX` / `minusX` / `withX` return new objects you must capture.
Build with static `.of()` / `.now()` / `.parse()`. **Period** = date amount, **Duration** =
time amount, **`ChronoUnit.X.between`** = a single total. Format/parse with
**`DateTimeFormatter.ofPattern`**.

---

## Core types

| Type | Represents | Example |
| :--- | :--- | :--- |
| `LocalDate` | date only | `2026-04-21` |
| `LocalTime` | time only | `14:30` |
| `LocalDateTime` | date + time | `2026-04-21T14:30` |
| `ZonedDateTime` | date + time + zone | `...+01:00[Africa/Lagos]` |
| `Period` | years/months/days amount | `P3M6D` |
| `Duration` | hours/minutes/seconds amount | `PT8H30M` |

## Core syntax

```java
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

LocalDate d   = LocalDate.of(2026, 4, 21);      // month is 1-based (April)
LocalDate due = d.plusWeeks(3);
long daysLeft = ChronoUnit.DAYS.between(LocalDate.now(), due);

Duration meeting = Duration.between(LocalTime.of(10, 0), LocalTime.of(11, 30));
meeting.toMinutes();                             // 90

String label = d.format(DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy"));
LocalDate x = LocalDate.parse("25/12/2026", DateTimeFormatter.ofPattern("dd/MM/yyyy"));

ZonedDateTime local = ZonedDateTime.of(d.atTime(9,0), ZoneId.of("UTC"))
        .withZoneSameInstant(ZoneId.of("Africa/Lagos"));
```

## Must-Remember Points

- **Immutable:** `date.plusDays(7);` alone does nothing — assign the result.
- Build with **static factories**, never `new`.
- `getDayOfWeek()` / `getMonth()` return **enums** (`TUESDAY`, `APRIL`) — usable in `switch`.
- Compare with `isBefore` / `isAfter` / `isEqual`.
- **Period** for date spans, **Duration** for time spans, `ChronoUnit.UNIT.between(a,b)` for a
  single total.
- Formatter letters: `yyyy MM MMM MMMM dd EEE EEEE HH mm ss`, `'literal'`.
- `withZoneSameInstant` keeps the moment; `withZoneSameLocal` keeps the clock reading.
- Avoid legacy `java.util.Date` / `Calendar`.

---

## Self-Check

1. **Type for a shift length?** — `Duration`.
2. **`d.plusMonths(1); println(d);` prints?** — The original date (immutable).
3. **`getDayOfWeek()` returns what?** — A `DayOfWeek` enum.
4. **UTC 9:00 → Lagos wall clock, same instant?** — `.withZoneSameInstant(ZoneId.of("Africa/Lagos"))`.

Glossary: [../../reference/glossary.html](../../reference/glossary.html)
