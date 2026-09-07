import java.util.ArrayList;
public class TodoManager {
    public static void main(String[] args) {
        ArrayList<String> todos = new ArrayList<>();
        todos.add("Write lesson");
        todos.add("Test code");
        todos.add("Review PR");
        todos.add("Ship");

        todos.remove("Review PR");
        todos.set(0, "Write & edit lesson");

        System.out.println("Tasks remaining: " + todos.size());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < todos.size(); i++) {
            sb.append((i + 1)).append(". ").append(todos.get(i)).append("\n");
        }
        System.out.print(sb);
        System.out.println("All done? " + todos.isEmpty());
    }
}
