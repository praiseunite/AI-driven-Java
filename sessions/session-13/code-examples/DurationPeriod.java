import java.time.*;
import java.time.temporal.ChronoUnit;

public class DurationPeriod {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2026, 1, 15);
        LocalDate end   = LocalDate.of(2026, 4, 21);

        Period p = Period.between(start, end);
        System.out.printf("Period: %d months, %d days%n", p.getMonths(), p.getDays());
        System.out.println("Total days: " + ChronoUnit.DAYS.between(start, end));

        LocalTime clockIn  = LocalTime.of(9, 5);
        LocalTime clockOut = LocalTime.of(17, 35);
        Duration shift = Duration.between(clockIn, clockOut);
        System.out.printf("Shift: %dh %dm%n", shift.toHours(), shift.toMinutesPart());
    }
}
