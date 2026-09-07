/**
 * Session 5: Code Example 4
 * Program: StudentRecord.java
 * Purpose: Constructor OVERLOADING, `this(...)` to call one constructor from another,
 *          and overriding toString() so an object prints nicely.
 *
 *   javac StudentRecord.java
 *   java StudentRecord
 */
public class StudentRecord {

    private String name;
    private String track;
    private int score;

    // Full constructor
    public StudentRecord(String name, String track, int score) {
        this.name = name;
        this.track = track;
        this.score = score;
    }

    // Convenience constructor: no score yet -> reuse the full one with a default
    public StudentRecord(String name, String track) {
        this(name, track, 0);          // must be the first line
    }

    public void addMarks(int delta) {
        score += delta;
    }

    public String grade() {
        if (score >= 80) return "A";
        if (score >= 70) return "B";
        if (score >= 50) return "C";
        return "F";
    }

    @Override
    public String toString() {
        return String.format("%s [%s] score=%d grade=%s", name, track, score, grade());
    }

    public static void main(String[] args) {
        StudentRecord s1 = new StudentRecord("Amara", "AI-Driven Java", 74);
        StudentRecord s2 = new StudentRecord("Ken", "AI-Driven Java");   // score defaults to 0

        s2.addMarks(83);

        System.out.println(s1);      // toString() is called automatically
        System.out.println(s2);
    }
}
