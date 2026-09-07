# Assignment 6: Weekly Weather Station Report 📋

> **Module:** JAVA-I-TL6 | **Due:** Before Session 7 | **Max Score:** 100 Pts
> Reference solution: [solution/solution.html](solution/solution.html)

---

## Scenario
A campus weather station logs one temperature per day for a week. Write `WeatherReport.java`
that summarises the week and prints a simple chart.

## Requirements

1. **Data:** `String[] days` (7 day names) and `double[] temps` = `{19.5, 22.0, 25.5, 21.0,
   18.0, 27.5, 24.0}`.
2. **Average:** sum ÷ `temps.length` (cast to keep decimals), printed with `%.2f`.
3. **Hottest & coldest day:** track the *index* of max and min while looping; print the day name
   and temperature.
4. **Days above average:** a second pass counting readings `> average`.
5. **Bar chart:** for each day build a line — day name, divider, one `#` per whole degree
   (`(int) temps[i]`), the numeric value — in one `StringBuilder`, printed once.

## Expected Console Output

```
=== WEEKLY WEATHER REPORT ===
Average temperature : 22.50 C
Hottest day         : Sat (27.5 C)
Coldest day         : Fri (18.0 C)
Days above average  : 3

Mon | ################### 19.5
Tue | ###################### 22.0
Wed | ######################### 25.5
Thu | ##################### 21.0
Fri | ################## 18.0
Sat | ########################### 27.5
Sun | ######################## 24.0
```

## Grading Rubric (100 Pts)

| Criterion | Details | Pts |
| :--- | :--- | :--- |
| Array traversal | Correct sum/average; index-based min & max | 30 |
| Second-pass counting | "Days above average" uses the computed average | 20 |
| StringBuilder chart | One buffer, correct `#` count, printed once | 30 |
| Code quality | Names, comments, formatting | 20 |

**Submission:** Upload `WeatherReport.java` via ProConnect under *Work Assignments → Session 6*.
