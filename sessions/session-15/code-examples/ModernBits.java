/**
 * A grab-bag of recent conveniences (JDK 21+).
 */
import java.util.*;

public class ModernBits {
    public static void main(String[] args) {
        // Sequenced collections: first/last/reversed on a List
        List<String> queue = new ArrayList<>(List.of("a", "b", "c", "d"));
        System.out.println("first : " + queue.getFirst());
        System.out.println("last  : " + queue.getLast());
        System.out.println("rev   : " + queue.reversed());
        queue.addFirst("Z");
        System.out.println("after addFirst: " + queue);

        // Stream.toList() : concise unmodifiable list
        List<Integer> squares = List.of(1, 2, 3, 4).stream().map(n -> n * n).toList();
        System.out.println("squares: " + squares);

        // Math.clamp (JDK 21)
        System.out.println("clamp(15, 0, 10) = " + Math.clamp(15, 0, 10));
        System.out.println("clamp(-3, 0, 10) = " + Math.clamp(-3, 0, 10));

        // String.repeat / isBlank / strip
        System.out.println("bar: [" + "=".repeat(10) + "]");
        System.out.println("'   '.isBlank() = " + "   ".isBlank());
    }
}
