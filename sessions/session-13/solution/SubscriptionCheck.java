import java.time.*;
import java.time.temporal.ChronoUnit;

public class SubscriptionCheck {
    static String status(LocalDate signup, LocalDate today) {
        LocalDate renewal = signup.plusMonths(1);
        if (today.isAfter(renewal)) return "EXPIRED";
        long daysLeft = ChronoUnit.DAYS.between(today, renewal);
        return daysLeft <= 3 ? "DUE SOON (" + daysLeft + "d)" : "ACTIVE (" + daysLeft + "d)";
    }

    public static void main(String[] args) {
        LocalDate today = LocalDate.of(2026, 4, 21);
        LocalDate[] signups = {
            LocalDate.of(2026, 4, 1),    // renewal May 1 -> ACTIVE
            LocalDate.of(2026, 3, 20),   // renewal Apr 20 -> EXPIRED (today Apr 21)
            LocalDate.of(2026, 3, 23)    // renewal Apr 23 -> DUE SOON (2d left)
        };
        for (LocalDate s : signups) {
            System.out.println(s + " -> " + status(s, today));
        }
    }
}
