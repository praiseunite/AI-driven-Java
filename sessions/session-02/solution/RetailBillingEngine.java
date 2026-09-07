/**
 * Session 2 — Assignment 2 reference solution: Retail Point-of-Sale Billing Engine
 * Aptech Campus Tech Store.
 *
 * Pipeline:
 *   line totals  -> gross subtotal
 *   -> promotional discount (8% if gross > $150, else 0%)   [ternary operator]
 *   -> VAT 7.5% on the discounted subtotal
 *   -> final invoice total
 *   -> explicit narrowing cast to whole cents: (int)(finalTotal * 100)
 *
 * All money is printed with %.2f. Because double cannot store every decimal exactly,
 * we only rely on it for display here; real tills use BigDecimal (see Session 2 lesson).
 */
public class RetailBillingEngine {
    public static void main(String[] args) {
        // --- Catalogue: price and quantity per product ---
        final double VAT_RATE = 0.075;      // 7.5% sales tax
        final double DISCOUNT_RATE = 0.08;  // 8% promo
        final double DISCOUNT_THRESHOLD = 150.00;

        String p1 = "Mechanical Keyboard";
        double p1Price = 85.50;  int p1Qty = 2;

        String p2 = "USB-C Hub";
        double p2Price = 34.99;  int p2Qty = 1;

        String p3 = "128GB Flash Drive";
        double p3Price = 18.75;  int p3Qty = 3;

        // --- Line totals ---
        double p1Total = p1Price * p1Qty;
        double p2Total = p2Price * p2Qty;
        double p3Total = p3Price * p3Qty;

        double grossSubtotal = p1Total + p2Total + p3Total;

        // --- Discount via ternary operator ---
        double discount = (grossSubtotal > DISCOUNT_THRESHOLD)
                        ? grossSubtotal * DISCOUNT_RATE
                        : 0.0;
        double discountedSubtotal = grossSubtotal - discount;

        // --- VAT on the discounted amount ---
        double vat = discountedSubtotal * VAT_RATE;
        double finalTotal = discountedSubtotal + vat;

        // --- Explicit narrowing cast to whole cents ---
        int totalCents = (int) (finalTotal * 100);

        // --- Formatted receipt ---
        System.out.println("+==============================================================+");
        System.out.println("|            APTECH CAMPUS TECH STORE  -  SALES RECEIPT         |");
        System.out.println("+==============================================================+");
        System.out.printf("%-22s %5s %10s %12s%n", "ITEM", "QTY", "UNIT", "LINE TOTAL");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-22s %5d %10.2f %12.2f%n", p1, p1Qty, p1Price, p1Total);
        System.out.printf("%-22s %5d %10.2f %12.2f%n", p2, p2Qty, p2Price, p2Total);
        System.out.printf("%-22s %5d %10.2f %12.2f%n", p3, p3Qty, p3Price, p3Total);
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-38s $%10.2f%n", "Gross Subtotal", grossSubtotal);
        System.out.printf("%-38s $%10.2f%n", "Promotional Discount (8%)", discount);
        System.out.printf("%-38s $%10.2f%n", "Subtotal After Discount", discountedSubtotal);
        System.out.printf("%-38s $%10.2f%n", "VAT (7.5%)", vat);
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-38s $%10.2f%n", "FINAL INVOICE TOTAL", finalTotal);
        System.out.printf("%-38s %11d%n", "Total in whole cents (int cast)", totalCents);
        System.out.println("+==============================================================+");
    }
}
