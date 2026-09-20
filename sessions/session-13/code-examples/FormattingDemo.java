import java.time.*;
import java.time.format.DateTimeFormatter;

public class FormattingDemo {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2026, 4, 21, 14, 30, 0);

        DateTimeFormatter iso = DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter pretty = DateTimeFormatter.ofPattern("EEE, d MMM yyyy 'at' HH:mm");

        System.out.println("iso date : " + dt.toLocalDate().format(iso));
        System.out.println("pretty   : " + dt.format(pretty));

        // parse a string back into a date
        LocalDate parsed = LocalDate.parse("2026-12-25");
        System.out.println("parsed   : " + parsed + " (" + parsed.getDayOfWeek() + ")");
    }
}
