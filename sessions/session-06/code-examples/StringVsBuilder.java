/**
 * Session 6: Code Example 4
 * Program: StringVsBuilder.java
 * Purpose: String is immutable — every change makes a NEW String. Building text in a
 *          loop with + quietly creates a pile of throwaway objects. StringBuilder
 *          edits one buffer in place. Also shows split() and String.join().
 *
 *   javac StringVsBuilder.java
 *   java StringVsBuilder
 */
public class StringVsBuilder {
    public static void main(String[] args) {
        // Immutability: toUpperCase() returns a NEW string; the original is unchanged
        String name = "ada";
        String shout = name.toUpperCase();
        System.out.println(name + " / " + shout);      // ada / ADA

        // Wasteful: each += builds a brand-new String
        String slow = "";
        for (int i = 1; i <= 5; i++) {
            slow += i + ",";
        }
        System.out.println("slow    = " + slow);

        // Efficient: one buffer, edited in place
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            sb.append(i).append(",");
        }
        System.out.println("builder = " + sb.toString());

        // split() -> array of pieces ; String.join() -> glue pieces back
        String csv = "red,green,blue";
        String[] parts = csv.split(",");
        System.out.println("pieces: " + parts.length + " -> " + parts[1]);
        System.out.println("joined: " + String.join(" | ", parts));
    }
}
