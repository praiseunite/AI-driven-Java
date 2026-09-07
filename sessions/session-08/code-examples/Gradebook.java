import java.util.ArrayList;

class Student {
    private final String name;
    private int score;
    Student(String name, int score) { this.name = name; this.score = score; }
    String getName() { return name; }
    int getScore() { return score; }
    void adjust(int delta) { score += delta; }
    @Override public String toString() { return name + " (" + score + ")"; }
}

public class Gradebook {
    private final ArrayList<Student> students = new ArrayList<>();

    void add(Student s) { students.add(s); }

    double classAverage() {
        if (students.isEmpty()) return 0;
        int total = 0;
        for (Student s : students) total += s.getScore();
        return (double) total / students.size();
    }

    Student topStudent() {
        Student top = students.get(0);
        for (Student s : students) {
            if (s.getScore() > top.getScore()) top = s;
        }
        return top;
    }

    public static void main(String[] args) {
        Gradebook gb = new Gradebook();
        gb.add(new Student("Ada", 82));
        gb.add(new Student("Bob", 74));
        gb.add(new Student("Cal", 91));
        gb.add(new Student("Dee", 68));

        System.out.printf("Class average : %.2f%n", gb.classAverage());
        System.out.println("Top student   : " + gb.topStudent());

        gb.topStudent().adjust(-50);   // objects are shared references
        System.out.println("After penalty : " + gb.topStudent());
    }
}
