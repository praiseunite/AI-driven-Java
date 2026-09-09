import java.time.*;

public class DateTimeBasics {
    public static void main(String[] args) {
        LocalDate d = LocalDate.of(2026, 4, 21);        // year, month, day
        LocalTime t = LocalTime.of(14, 30);             // 2:30 pm
        LocalDateTime dt = LocalDateTime.of(d, t);

        System.out.println("date        : " + d);
        System.out.println("time        : " + t);
        System.out.println("date-time   : " + dt);

        System.out.println("day of week : " + d.getDayOfWeek());     // enum: TUESDAY
        System.out.println("month       : " + d.getMonth());          // enum: APRIL
        System.out.println("+10 days    : " + d.plusDays(10));
        System.out.println("-2 months   : " + d.minusMonths(2));
        System.out.println("leap year?  : " + d.isLeapYear());

        LocalDate deadline = LocalDate.of(2026, 5, 1);
        System.out.println("d before deadline? " + d.isBefore(deadline));
    }
}
