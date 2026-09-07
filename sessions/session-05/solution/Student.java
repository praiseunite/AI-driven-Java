/**
 * Session 5 — Task 5.3 reference solution
 * Constructor overloading: the 2-arg constructor delegates to the 3-arg one with
 * this(name, track, 0) as its FIRST statement. grade() returns a letter (not print).
 * toString() is overridden so println(student) is readable.
 */
public class Student {
    private String name, track;
    private int score;

    public Student(String name, String track, int score) {
        this.name = name;
        this.track = track;
        this.score = score;
    }

    public Student(String name, String track) {
        this(name, track, 0);
    }

    public void addScore(int delta) { score += delta; }

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
        Student s1 = new Student("Amara", "AI-Driven Java", 68);
        Student s2 = new Student("Ken", "AI-Driven Java");
        s1.addScore(7);
        s2.addScore(82);
        System.out.println(s1);
        System.out.println(s2);
    }
}
