# Assignment 13: Conference Schedule Builder 📋

> **Module:** JAVA-I-TL13 | **Due:** Before Session 14 | **Max Score:** 100 Pts
> Reference solution: [solution/solution.html](solution/solution.html)

---

## Scenario
A one-day developer conference starts at **09:00 on Monday 8 June 2026**. You have the ordered
list of talks and lengths (minutes). Build `ConferenceSchedule.java` to print the schedule.

## Requirements

1. **Data:** a `LocalDateTime` cursor at `2026-06-08T09:00`; a `String[]` of 6 titles and a
   matching `int[]` of durations (minutes).
2. **Per session:** start = cursor; end = `start.plusMinutes(duration)`. Print
   `<start> - <end>  <title> (<dur>m)` formatted `"EEE HH:mm"`.
3. **Late flag:** if end time is after **17:00**, append `"  [RUNS LATE]"`.
4. **Breaks:** after each session, advance the cursor by the length *plus* a 15-minute break.
5. **Summary:** first start, last end (cursor minus trailing break), and total span in `Xh Ym`
   via `ChronoUnit.MINUTES.between`.

## Expected Console Output

```
=== CONFERENCE SCHEDULE ===
Mon 09:00 - Mon 10:00  Keynote: Modern Java     (60m)
Mon 10:15 - Mon 11:45  Streams Deep Dive        (90m)
Mon 12:00 - Mon 12:45  Records & Patterns       (45m)
Mon 13:00 - Mon 14:15  Virtual Threads          (75m)
Mon 14:30 - Mon 16:00  AI-Assisted Coding       (90m)
Mon 16:15 - Mon 17:15  Closing Panel            (60m)  [RUNS LATE]

First session : Mon 09:00
Last ends     : Mon 17:15
Total span    : 8h 15m (including breaks)
```

Durations: `{60, 90, 45, 75, 90, 60}`.

## Grading Rubric (100 Pts)

| Criterion | Details | Pts |
| :--- | :--- | :--- |
| Time arithmetic | End times via `plusMinutes`; breaks advance the cursor correctly | 30 |
| Formatting | `DateTimeFormatter.ofPattern("EEE HH:mm")`; aligned columns | 25 |
| Late flag | Compares end *time* to 17:00 and flags correctly | 20 |
| Summary | Correct last-end (trailing break removed) and total span via `ChronoUnit` | 25 |

**Submission:** Upload `ConferenceSchedule.java` via ProConnect under *Work Assignments → Session 13*.
