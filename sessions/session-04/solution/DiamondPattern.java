/**
 * Session 4 — Challenge 4.3 reference solution
 * Two stacked triangles. Per row i: print (n - i) leading spaces, then (2*i - 1) stars.
 * The upper loop grows i from 1..n; the lower loop shrinks i from n-1..1 so the middle
 * row is not repeated.
 */
public class DiamondPattern {
    public static void main(String[] args) {
        int n = 5;   // height of each half

        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= (n - i); s++) System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++) System.out.print("*");
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int s = 1; s <= (n - i); s++) System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++) System.out.print("*");
            System.out.println();
        }
    }
}
