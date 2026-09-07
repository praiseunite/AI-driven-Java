# Session 8: "Try It Yourself" Consolidation Challenges 🛠️

> **Module:** JAVA-I-TL8 | **Coverage:** Sessions 5–7 Review
> Reference solutions: [solution/solution.html](solution/solution.html)

Each challenge combines a custom class with a collection and one Week 2 structural idea.

---

## 🟡 Challenge 8.1: Playlist (class + ArrayList + accumulator + running-best)

```java
import java.util.ArrayList;

class Song {
    private final String title;
    private final int seconds;
    Song(String title, int seconds) { this.title = title; this.seconds = seconds; }
    String getTitle() { return title; }
    int getSeconds() { return seconds; }
    @Override public String toString() {
        return String.format("%-18s %d:%02d", title, seconds / 60, seconds % 60);
    }
}

public class Playlist {
    private final ArrayList<Song> songs = new ArrayList<>();

    void add(Song s) { songs.add(s); }

    int totalSeconds() {
        int t = 0;
        for (Song s : songs) t += s.getSeconds();
        return t;
    }

    Song longest() {
        Song best = songs.get(0);
        for (Song s : songs) if (s.getSeconds() > best.getSeconds()) best = s;
        return best;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist();
        p.add(new Song("Intro", 95));
        p.add(new Song("Deep Focus", 372));
        p.add(new Song("Sprint", 188));

        for (Song s : p.songs) System.out.println(s);
        int total = p.totalSeconds();
        System.out.printf("Total  : %d:%02d%n", total / 60, total % 60);
        System.out.println("Longest: " + p.longest());
    }
}
```
**Expected output:**
```
Intro              1:35
Deep Focus         6:12
Sprint             3:08
Total  : 10:55
Longest: Deep Focus         6:12
```

---

## 🟡 Challenge 8.2: Parking Lot (object array with `null` slots)

```java
class Car {
    final String plate;
    Car(String plate) { this.plate = plate; }
}

public class ParkingLot {
    private final Car[] slots;

    ParkingLot(int size) { slots = new Car[size]; }

    boolean park(Car c) {
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == null) {
                slots[i] = c;
                System.out.println(c.plate + " parked in slot " + i);
                return true;
            }
        }
        System.out.println(c.plate + " -> lot full");
        return false;
    }

    void leave(int slot) {
        if (slot >= 0 && slot < slots.length && slots[slot] != null) {
            System.out.println(slots[slot].plate + " leaves slot " + slot);
            slots[slot] = null;
        }
    }

    int freeCount() {
        int free = 0;
        for (Car c : slots) if (c == null) free++;
        return free;
    }

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(3);
        lot.park(new Car("ABC-1"));
        lot.park(new Car("XYZ-9"));
        lot.leave(0);
        lot.park(new Car("JJJ-7"));
        lot.park(new Car("KKK-2"));
        lot.park(new Car("LLL-5"));
        System.out.println("Free slots: " + lot.freeCount());
    }
}
```
**Expected output:**
```
ABC-1 parked in slot 0
XYZ-9 parked in slot 1
ABC-1 leaves slot 0
JJJ-7 parked in slot 0
KKK-2 parked in slot 2
LLL-5 -> lot full
Free slots: 0
```

---

## 🔴 Challenge 8.3: Voting Machine (package + class + tally)

`com/aptech/vote/Candidate.java`:
```java
package com.aptech.vote;

public class Candidate {
    private final String name;
    private int votes = 0;
    public Candidate(String name) { this.name = name; }
    public void addVote() { votes++; }
    public int getVotes() { return votes; }
    public String getName() { return name; }
    @Override public String toString() { return name + ": " + votes; }
}
```

`VotingMachine.java`:
```java
import com.aptech.vote.Candidate;

public class VotingMachine {
    public static void main(String[] args) {
        Candidate[] ballot = {
            new Candidate("Ada"), new Candidate("Bode"), new Candidate("Chi")
        };
        String[] votes = {"Ada", "Chi", "Ada", "Bode", "Ada", "Chi", "Chi", "Chi", "Ada"};

        for (String v : votes) {
            for (Candidate c : ballot) {
                if (c.getName().equals(v)) { c.addVote(); break; }
            }
        }

        Candidate winner = ballot[0];
        System.out.println("=== RESULTS ===");
        for (Candidate c : ballot) {
            System.out.println(c);
            if (c.getVotes() > winner.getVotes()) winner = c;
        }
        System.out.println("Winner: " + winner.getName());
    }
}
```

Compile & run: `javac VotingMachine.java com/aptech/vote/Candidate.java` then `java VotingMachine`
```
=== RESULTS ===
Ada: 4
Bode: 1
Chi: 4
Winner: Ada
```
(Ada and Chi tie at 4; using `>` keeps the first-seen candidate as winner.)
