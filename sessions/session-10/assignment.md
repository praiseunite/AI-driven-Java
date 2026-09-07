# Assignment 10: Notification Dispatcher 📋

> **Module:** JAVA-I-TL10 | **Due:** Before Session 11 | **Max Score:** 100 Pts
> Reference solution: [solution/solution.html](solution/solution.html)

---

## Scenario
A campus system sends alerts by email, SMS, and push. Only some channels suit *urgent* alerts.
New channels get added often, so the dispatcher must not depend on any specific one.

## Requirements

1. **`interface Channel`** (file `NotificationCenter.java`):
   - `String send(String message);` — returns a one-line log string (does not print).
   - `default boolean isUrgentCapable() { return false; }`
2. **Implementers:**
   - `EmailChannel(String address)` → `"EMAIL -> <address> : <message>"`; not urgent-capable.
   - `SmsChannel(String number)` → `"SMS   -> <number> : <message>"`; overrides
     `isUrgentCapable()` to `true`.
   - `PushChannel(String deviceId)` → `"PUSH  -> <deviceId> : <message>"`; urgent-capable.
3. **`Dispatcher`**: an `ArrayList<Channel>`; `register(Channel)`; `broadcast(String)` sends
   through every channel; `broadcastUrgent(String)` sends only through urgent-capable channels,
   prefixed `"[URGENT] "`.
4. **`main`**: register one of each channel *plus* a one-off **lambda** channel returning
   `"LOG   -> console : <message>"`. Then `broadcast` a maintenance notice and
   `broadcastUrgent` a "Database down!" alert.

## Expected Console Output

```
--- broadcast ---
EMAIL -> ada@example.com : Server maintenance at 22:00
SMS   -> +234-800-0000 : Server maintenance at 22:00
PUSH  -> device-42 : Server maintenance at 22:00
LOG   -> console : Server maintenance at 22:00
--- urgent only ---
[URGENT] SMS   -> +234-800-0000 : Database down!
[URGENT] PUSH  -> device-42 : Database down!
```

## Grading Rubric (100 Pts)

| Criterion | Details | Pts |
| :--- | :--- | :--- |
| Interface design | Abstract method + `default` method; `send` returns, doesn't print | 25 |
| Implementers | Three concrete classes; only SMS/Push override `isUrgentCapable()`; methods `public` | 25 |
| Program to the interface | `Dispatcher` stores & loops `Channel`; no concrete type in its code | 25 |
| Lambda channel | A functional-interface lambda registered and treated identically | 25 |

**Submission:** Upload `NotificationCenter.java` via ProConnect under *Work Assignments → Session 10*.
