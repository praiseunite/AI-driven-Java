/**
 * Session 7: Code Example 4 (part 2 of 2)
 * Uses a class from another package via `import`.
 *
 *   javac PackageMain.java com/aptech/util/TextTools.java
 *   java PackageMain
 */
import com.aptech.util.TextTools;

public class PackageMain {
    public static void main(String[] args) {
        System.out.println(TextTools.repeat("=", 30));
        System.out.println(TextTools.center("APTECH", 30));
        System.out.println(TextTools.repeat("=", 30));
    }
}
