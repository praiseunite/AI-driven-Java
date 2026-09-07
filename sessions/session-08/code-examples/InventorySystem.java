class Product {
    private static int catalogueSize = 0;      // shared count
    static final double LOW_STOCK = 5;

    private final String sku;
    private final double price;
    private int quantity;

    Product(String sku, double price, int quantity) {
        this.sku = sku;
        this.price = price;
        this.quantity = Math.max(quantity, 0);
        catalogueSize++;
    }

    void sell(int n) {
        if (n <= 0 || n > quantity) {
            System.out.println(sku + ": cannot sell " + n);
        } else {
            quantity -= n;
        }
    }

    void restock(int n) { if (n > 0) quantity += n; }

    double lineValue() { return price * quantity; }
    boolean isLow()    { return quantity < LOW_STOCK; }

    static int getCatalogueSize() { return catalogueSize; }

    @Override public String toString() {
        return String.format("%-8s x%-3d @ $%6.2f = $%8.2f%s",
                sku, quantity, price, lineValue(), isLow() ? "  [LOW]" : "");
    }
}

public class InventorySystem {
    public static void main(String[] args) {
        Product[] stock = {
            new Product("KB-01", 45.00, 10),
            new Product("MS-02", 19.99, 3),
            new Product("HB-03", 34.50, 7)
        };

        stock[0].sell(4);
        stock[1].restock(2);
        stock[2].sell(9);      // rejected

        double total = 0;
        System.out.println("=== INVENTORY ===");
        for (Product p : stock) {
            System.out.println(p);
            total += p.lineValue();
        }
        System.out.printf("Total stock value : $%.2f%n", total);
        System.out.println("Distinct products : " + Product.getCatalogueSize());
    }
}
