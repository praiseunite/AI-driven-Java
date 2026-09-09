import java.util.function.*;
import java.util.*;

public class LambdasAndRefs {
    public static void main(String[] args) {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Function<String, Integer> length = s -> s.length();
        Consumer<String> printer = s -> System.out.println("  " + s);
        Supplier<String> greet = () -> "hello from a supplier";

        System.out.println("isEven(4)      : " + isEven.test(4));
        System.out.println("length(\"java\") : " + length.apply("java"));
        System.out.println("supplier       : " + greet.get());
        System.out.print("consumer       :\n");
        printer.accept("consumed");

        // method references
        List<String> names = new ArrayList<>(List.of("cara", "ada", "bode"));
        names.sort(String::compareTo);                 // ref to an instance method
        names.forEach(System.out::println);            // ref to System.out.println
        Function<String, Integer> len2 = String::length;   // unbound instance method ref
        System.out.println("len2(\"bode\")   : " + len2.apply("bode"));
    }
}
