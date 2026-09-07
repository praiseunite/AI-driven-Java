public class GradeDistribution {
    public static void main(String[] args) {
        int[] scores = {88, 72, 95, 64, 100, 51, 79, 45, 83, 68};
        int a = 0, b = 0, c = 0, f = 0;
        for (int s : scores) {
            if (s >= 80) a++;
            else if (s >= 70) b++;
            else if (s >= 50) c++;
            else f++;
        }
        System.out.println("A (80-100): " + a);
        System.out.println("B (70-79) : " + b);
        System.out.println("C (50-69) : " + c);
        System.out.println("F (0-49)  : " + f);
    }
}
