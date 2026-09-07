import java.util.Arrays;

class Employee implements Comparable<Employee> {
    final String name;
    final int salary;
    Employee(String name, int salary) { this.name = name; this.salary = salary; }
    @Override public int compareTo(Employee o) { return Integer.compare(o.salary, this.salary); } // descending
    @Override public String toString() { return name + " ($" + salary + ")"; }
}

public class EmployeeSort {
    public static void main(String[] args) {
        Employee[] team = {
            new Employee("Ada", 72000),
            new Employee("Bode", 95000),
            new Employee("Chi", 68000)
        };
        Arrays.sort(team);
        for (Employee e : team) System.out.println(e);
    }
}
