import java.util.*;

public class Deque {
    public static void main(String[] args) {
        LinkedList<String> line = new LinkedList<>(List.of("Ada", "Bode", "Chi"));

        line.addLast("Dee");         // joins the back
        line.addFirst("VIP");        // jumps the front
        System.out.println("queue      : " + line);
        System.out.println("serving    : " + line.getFirst());
        System.out.println("last in    : " + line.getLast());

        line.removeFirst();          // served
        System.out.println("after serve: " + line);
        System.out.println("reversed   : " + line.reversed());
    }
}
