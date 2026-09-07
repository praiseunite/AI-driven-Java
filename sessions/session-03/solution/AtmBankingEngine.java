/**
 * Session 3 — Assignment 3 reference solution: Automated ATM Banking Machine Simulator
 * Apex National Bank smart ATM kiosk (console prototype).
 *
 * Concepts combined:
 *   - Scanner input (Session 2)
 *   - while loop for PIN retries, with a counter and break
 *   - while loop for the transaction menu, exits when choice == 5
 *   - switch-case menu dispatch with break on every case + default
 *   - if-else business rules: positive amounts, overdraft protection,
 *     single-transaction limit
 *   - printf %.2f for currency
 *
 * Everything lives in one main() method — no user-defined methods are needed
 * (those arrive in Session 5).
 *
 * Run:
 *   javac AtmBankingEngine.java
 *   java AtmBankingEngine
 * Scripted run (PIN 2026, over-limit withdraw, valid withdraw, exit):
 *   printf '2026\n3\n600\n3\n200\n5\n' | java AtmBankingEngine
 */
import java.util.Scanner;

public class AtmBankingEngine {
    public static void main(String[] args) {
        final int CORRECT_PIN = 2026;
        final int MAX_TRIES = 3;
        final double SINGLE_WITHDRAWAL_LIMIT = 500.00;

        Scanner in = new Scanner(System.in);

        double balance = 1500.00;
        int transactionCount = 0;

        System.out.println("==================================================");
        System.out.println("           APEX NATIONAL BANK - SMART ATM          ");
        System.out.println("==================================================");

        // --- PIN authentication loop ---
        int tries = 0;
        boolean authenticated = false;
        while (tries < MAX_TRIES) {
            System.out.print("Enter Security PIN: ");
            int pin = in.nextInt();
            if (pin == CORRECT_PIN) {
                authenticated = true;
                break;
            }
            tries++;
            System.out.println("Incorrect PIN. Attempts remaining: " + (MAX_TRIES - tries));
        }

        if (!authenticated) {
            System.out.println("Card retained after 3 failed attempts. Please contact your bank.");
            in.close();
            return;
        }

        System.out.println("PIN Verified! Welcome, Account Holder #8921.");

        // --- Transaction menu loop ---
        int choice = 0;
        while (choice != 5) {
            System.out.println();
            System.out.println("--- MAIN TRANSACTION MENU ---");
            System.out.println("1. Check Account Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Cash");
            System.out.println("4. Transaction Summary");
            System.out.println("5. Exit / Eject Card");
            System.out.print("Choice: ");
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Current balance: $%.2f%n", balance);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: $");
                    double deposit = in.nextDouble();
                    if (deposit <= 0) {
                        System.out.println("ERROR: Deposit must be greater than $0.00.");
                    } else {
                        balance += deposit;
                        transactionCount++;
                        System.out.printf("SUCCESS: Deposited $%.2f. Updated balance: $%.2f%n",
                                          deposit, balance);
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double amount = in.nextDouble();
                    if (amount <= 0) {
                        System.out.println("ERROR: Amount must be greater than $0.00.");
                    } else if (amount > SINGLE_WITHDRAWAL_LIMIT) {
                        System.out.printf("ERROR: Exceeds single-transaction limit of $%.2f!%n",
                                          SINGLE_WITHDRAWAL_LIMIT);
                    } else if (amount > balance) {
                        System.out.println("ERROR: Insufficient funds.");
                    } else {
                        balance -= amount;
                        transactionCount++;
                        System.out.printf("SUCCESS: Dispensing $%.2f cash.%n", amount);
                        System.out.printf("Updated Balance: $%.2f%n", balance);
                    }
                    break;

                case 4:
                    System.out.println("--- MINI STATEMENT ---");
                    System.out.println("Completed transactions this session: " + transactionCount);
                    System.out.printf("Final balance: $%.2f%n", balance);
                    break;

                case 5:
                    System.out.println("Thank you for banking with Apex National Bank! Card ejected.");
                    break;

                default:
                    System.out.println("Invalid option. Please choose 1-5.");
                    break;
            }
        }

        in.close();
    }
}
