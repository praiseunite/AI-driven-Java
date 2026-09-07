class InvalidGradeException extends Exception {
    InvalidGradeException(String msg) { super(msg); }
}

public class GradeValidator {
    static char letterFor(int score) throws InvalidGradeException {
        if (score < 0 || score > 100) {
            throw new InvalidGradeException("score out of range: " + score);
        }
        if (score >= 80) return 'A';
        if (score >= 70) return 'B';
        if (score >= 50) return 'C';
        return 'F';
    }

    public static void main(String[] args) {
        int[] scores = {95, 72, 40, 130, -5};
        for (int s : scores) {
            try {
                System.out.println(s + " -> " + letterFor(s));
            } catch (InvalidGradeException e) {
                System.out.println(s + " -> rejected (" + e.getMessage() + ")");
            }
        }
    }
}
