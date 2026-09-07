package com.aptech.cafe;

/**
 * Session 7 - Assignment 7 reference solution (2 of 2)
 * The entry point. Package: com.aptech.cafe -> run as java com.aptech.cafe.CafeApp
 */
public class CafeApp {
    public static void main(String[] args) {
        MenuItem[] order = {
            new MenuItem("Espresso", 2.50),
            new MenuItem("Muffin", 3.25),
            new MenuItem("Sandwich", 5.75)
        };

        double subtotal = 0;
        System.out.println("=== APTECH CAFE RECEIPT ===");
        for (MenuItem item : order) {
            System.out.println(item);
            subtotal += item.getPrice();
        }
        double tax = subtotal * MenuItem.TAX_RATE;
        System.out.println("---------------------------------------------");
        System.out.printf("Subtotal%29s$%6.2f%n", "", subtotal);
        System.out.printf("Tax (8%%)%29s$%6.2f%n", "", tax);
        System.out.printf("TOTAL%32s$%6.2f%n", "", subtotal + tax);
        System.out.println("Distinct items defined on menu: " + MenuItem.getItemsOnMenu());
    }
}
