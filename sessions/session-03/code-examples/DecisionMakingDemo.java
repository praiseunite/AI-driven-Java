/**
 * Session 3: Code Example 1
 * Program: DecisionMakingDemo.java
 * Purpose: Illustrates all forms of decision making in Java:
 *          if, if-else, if-else-if ladder, nested if, and switch-case with String & int.
 */
public class DecisionMakingDemo {

    public static void main(String[] args) {
        System.out.println("=== 1. IF - ELSE - IF LADDER (ACADEMIC GRADING) ===");
        int examScore = 82;
        char letterGrade;

        if (examScore >= 90) {
            letterGrade = 'A';
        } else if (examScore >= 80) {
            letterGrade = 'B';
        } else if (examScore >= 70) {
            letterGrade = 'C';
        } else if (examScore >= 60) {
            letterGrade = 'D';
        } else {
            letterGrade = 'F';
        }
        System.out.println("Score: " + examScore + " -> Grade Awarded: " + letterGrade);

        System.out.println("\n=== 2. NESTED IF (SECURITY ACCESS CONTROL) ===");
        boolean hasSmartBadge = true;
        boolean hasBiometricVerification = false;
        boolean isSecurityOfficer = true;

        if (hasSmartBadge) {
            if (hasBiometricVerification || isSecurityOfficer) {
                System.out.println("Access Granted: Welcome to the AI Data Center.");
            } else {
                System.out.println("Access Denied: Biometric verification required for non-officers.");
            }
        } else {
            System.out.println("Access Denied: No security badge detected.");
        }

        System.out.println("\n=== 3. SWITCH-CASE STATEMENT (ROLE-BASED PORTAL) ===");
        String userRole = "INSTRUCTOR";

        switch (userRole) {
            case "ADMIN":
                System.out.println("Role: Admin - Full privileges (Create courses, Manage faculty, View billing).");
                break; // Break prevents falling through to next cases!
            case "INSTRUCTOR":
                System.out.println("Role: Instructor - Grade assignments, Launch live sessions, View attendance.");
                break;
            case "STUDENT":
                System.out.println("Role: Student - Access courseware, Submit tasks, Take quizzes.");
                break;
            default:
                System.out.println("Unknown role: Access restricted to guest preview.");
                break;
        }
    }
}
