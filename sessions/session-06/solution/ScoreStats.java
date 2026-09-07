public class ScoreStats {
    public static void main(String[] args) {
        int[] scores = {88, 72, 95, 64, 100, 51, 79};
        int total = 0, min = scores[0], max = scores[0];
        for (int s : scores) {
            total += s;
            if (s < min) min = s;
            if (s > max) max = s;
        }
        double avg = (double) total / scores.length;
        System.out.println("Count   : " + scores.length);
        System.out.println("Total   : " + total);
        System.out.printf("Average : %.2f%n", avg);
        System.out.println("Min     : " + min);
        System.out.println("Max     : " + max);
    }
}
