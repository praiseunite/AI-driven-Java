import java.time.*;
import java.time.temporal.ChronoUnit;

public class AgeCalculator {
    public static void main(String[] args) {
        LocalDate birth = LocalDate.of(2001, 7, 15);
        LocalDate on    = LocalDate.of(2026, 4, 21);   // "today" fixed for a stable demo

        Period age = Period.between(birth, on);
        long totalDays = ChronoUnit.DAYS.between(birth, on);

        System.out.printf("Age: %d years, %d months, %d days%n",
                age.getYears(), age.getMonths(), age.getDays());
        System.out.println("Total days alive: " + totalDays);
        System.out.println("Born on a " + birth.getDayOfWeek());

        LocalDate nextBday = birth.withYear(on.getYear());
        if (!nextBday.isAfter(on)) nextBday = nextBday.plusYears(1);
        System.out.println("Next birthday: " + nextBday
                + " (" + ChronoUnit.DAYS.between(on, nextBday) + " days away)");
    }
}
