/**
 * Session 6 - Assignment 6 reference solution: Weekly Weather Station Report
 */
public class WeatherReport {
    public static void main(String[] args) {
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        double[] temps = {19.5, 22.0, 25.5, 21.0, 18.0, 27.5, 24.0};

        double total = 0;
        int hot = 0, cold = 0;      // indexes of hottest / coldest day
        for (int i = 0; i < temps.length; i++) {
            total += temps[i];
            if (temps[i] > temps[hot])  hot = i;
            if (temps[i] < temps[cold]) cold = i;
        }
        double avg = total / temps.length;

        int aboveAvg = 0;
        for (double t : temps) {
            if (t > avg) aboveAvg++;
        }

        System.out.println("=== WEEKLY WEATHER REPORT ===");
        System.out.printf("Average temperature : %.2f C%n", avg);
        System.out.printf("Hottest day         : %s (%.1f C)%n", days[hot], temps[hot]);
        System.out.printf("Coldest day         : %s (%.1f C)%n", days[cold], temps[cold]);
        System.out.println("Days above average  : " + aboveAvg);
        System.out.println();

        // Text bar chart: one '#' per whole degree
        StringBuilder chart = new StringBuilder();
        for (int i = 0; i < days.length; i++) {
            chart.append(days[i]).append(" | ");
            for (int b = 0; b < (int) temps[i]; b++) {
                chart.append('#');
            }
            chart.append(' ').append(temps[i]).append('\n');
        }
        System.out.print(chart);
    }
}
