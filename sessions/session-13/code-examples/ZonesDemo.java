import java.time.*;

public class ZonesDemo {
    public static void main(String[] args) {
        ZoneId lagos = ZoneId.of("Africa/Lagos");
        ZoneId tokyo = ZoneId.of("Asia/Tokyo");

        // a fixed instant so the output is stable
        ZonedDateTime lagosTime =
            ZonedDateTime.of(2026, 4, 21, 9, 0, 0, 0, lagos);

        ZonedDateTime tokyoTime = lagosTime.withZoneSameInstant(tokyo);

        System.out.println("Lagos : " + lagosTime);
        System.out.println("Tokyo : " + tokyoTime);
        System.out.println("Same instant, different wall clocks. Tokyo is "
            + java.time.Duration.between(
                lagosTime.toLocalDateTime(), tokyoTime.toLocalDateTime()).toHours()
            + "h ahead.");
    }
}
