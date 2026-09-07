package com.aptech.cafe;

/**
 * Session 7 - Assignment 7 reference solution (1 of 2)
 * An encapsulated menu item plus class-wide constants and a shared counter.
 */
public class MenuItem {
    public static final double TAX_RATE = 0.08;   // class-wide constant
    private static int itemsOnMenu = 0;           // shared counter

    private final String name;
    private final double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = Math.max(price, 0);
        itemsOnMenu++;
    }

    public String getName()  { return name; }
    public double getPrice() { return price; }
    public double priceWithTax() { return price * (1 + TAX_RATE); }

    public static int getItemsOnMenu() { return itemsOnMenu; }

    @Override
    public String toString() {
        return String.format("%-16s $%6.2f  (with tax $%6.2f)", name, price, priceWithTax());
    }
}
