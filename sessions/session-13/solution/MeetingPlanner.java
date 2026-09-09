import java.time.*;
import java.time.format.DateTimeFormatter;

public class MeetingPlanner {
    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.of(2026, 4, 21, 14, 0);
        Duration length = Duration.ofMinutes(90);
        LocalDateTime end = start.plus(length);

        DateTimeFormatter f = DateTimeFormatter.ofPattern("EEE d MMM, HH:mm");
        System.out.println("Starts : " + start.format(f));
        System.out.println("Ends   : " + end.format(f));
        System.out.println("Length : " + length.toHours() + "h " + length.toMinutesPart() + "m");

        boolean businessHours = !end.toLocalTime().isAfter(LocalTime.of(17, 0));
        System.out.println("Within business hours? " + businessHours);
    }
}
