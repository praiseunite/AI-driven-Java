import java.util.*;
import java.util.stream.*;

public class StreamsBasics {
    record Product(String name, String category, double price) {}

    public static void main(String[] args) {
        List<Product> products = List.of(
            new Product("Keyboard", "input", 45.00),
            new Product("Mouse", "input", 19.99),
            new Product("Monitor", "display", 189.00),
            new Product("Hub", "misc", 34.50),
            new Product("Webcam", "input", 59.00)
        );

        long inputCount = products.stream()
            .filter(p -> p.category().equals("input"))
            .count();
        System.out.println("input items: " + inputCount);

        double inputTotal = products.stream()
            .filter(p -> p.category().equals("input"))
            .mapToDouble(Product::price)
            .sum();
        System.out.printf("input total: $%.2f%n", inputTotal);

        List<String> cheapNames = products.stream()
            .filter(p -> p.price() < 50)
            .sorted(Comparator.comparingDouble(Product::price))
            .map(Product::name)
            .collect(Collectors.toList());
        System.out.println("under $50 (cheapest first): " + cheapNames);

        Optional<Product> priciest = products.stream()
            .max(Comparator.comparingDouble(Product::price));
        priciest.ifPresent(p -> System.out.println("priciest: " + p.name()));

        Map<String, Long> byCategory = products.stream()
            .collect(Collectors.groupingBy(Product::category, Collectors.counting()));
        System.out.println("by category: " + byCategory);
    }
}
