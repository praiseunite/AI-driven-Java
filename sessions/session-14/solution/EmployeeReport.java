import java.util.*;
import java.util.stream.*;

public class EmployeeReport {
    record Employee(String name, String dept, int salary) {}

    public static void main(String[] args) {
        List<Employee> staff = List.of(
            new Employee("Ada", "ENG", 95000),
            new Employee("Bode", "ENG", 82000),
            new Employee("Chi", "SALES", 70000),
            new Employee("Dee", "SALES", 91000),
            new Employee("Eze", "ENG", 78000)
        );

        Map<String, Long> countByDept = staff.stream()
            .collect(Collectors.groupingBy(Employee::dept, Collectors.counting()));
        System.out.println("count by dept   : " + new TreeMap<>(countByDept));

        Map<String, Double> avgByDept = staff.stream()
            .collect(Collectors.groupingBy(Employee::dept,
                     Collectors.averagingInt(Employee::salary)));
        System.out.println("avg salary/dept : " + new TreeMap<>(avgByDept));

        String topEarner = staff.stream()
            .max(Comparator.comparingInt(Employee::salary))
            .map(Employee::name)
            .orElse("<none>");
        System.out.println("top earner      : " + topEarner);

        String engNames = staff.stream()
            .filter(e -> e.dept().equals("ENG"))
            .map(Employee::name)
            .sorted()
            .collect(Collectors.joining(", "));
        System.out.println("ENG team        : " + engNames);
    }
}
