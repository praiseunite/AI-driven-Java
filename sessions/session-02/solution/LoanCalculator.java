/**
 * Session 2 — Task 2.2 (Medium) reference solution
 * Simple-interest loan summary with an aligned currency table.
 *
 *   Interest = (Principal * Rate% * Years) / 100
 *   Total    = Principal + Interest
 *   Monthly  = Total / (Years * 12)
 *
 * %10.2f right-aligns the number in a 10-character column so the "$" signs line up.
 */
public class LoanCalculator {
    public static void main(String[] args) {
        double principal = 5000.00;
        double annualRate = 6.5;
        int durationYears = 2;

        double totalInterest = (principal * annualRate * durationYears) / 100.0;
        double totalRepayment = principal + totalInterest;
        double monthlyInstallment = totalRepayment / (durationYears * 12);

        System.out.println("========================================");
        System.out.println("     STUDENT LAPTOP LOAN SUMMARY        ");
        System.out.println("========================================");
        System.out.printf("Principal Borrowed : $%10.2f%n", principal);
        System.out.printf("Interest Rate      : %9.1f%%%n", annualRate);
        System.out.printf("Total Interest Fee : $%10.2f%n", totalInterest);
        System.out.printf("Total Repayment    : $%10.2f%n", totalRepayment);
        System.out.printf("Monthly Payment    : $%10.2f%n", monthlyInstallment);
        System.out.println("========================================");
    }
}
