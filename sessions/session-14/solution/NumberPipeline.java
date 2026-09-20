import java.util.*;
import java.util.stream.*;

public class NumberPipeline {
    public static void main(String[] args) {
        List<Integer> nums = List.of(4, 7, 2, 9, 6, 1, 8, 3, 10, 5);

        List<Integer> evensSquaredDesc = nums.stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n * n)
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        System.out.println("even, squared, desc : " + evensSquaredDesc);

        int sumOdd = nums.stream().filter(n -> n % 2 != 0).mapToInt(Integer::intValue).sum();
        System.out.println("sum of odds          : " + sumOdd);

        OptionalDouble avg = nums.stream().mapToInt(Integer::intValue).average();
        System.out.printf("average              : %.1f%n", avg.getAsDouble());

        boolean anyOver9 = nums.stream().anyMatch(n -> n > 9);
        System.out.println("any > 9?             : " + anyOver9);
    }
}
