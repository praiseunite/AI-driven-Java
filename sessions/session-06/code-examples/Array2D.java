/**
 * Session 6: Code Example 2
 * Program: Array2D.java
 * Purpose: A two-dimensional array is an "array of arrays" — think rows and columns.
 *          grid.length is the number of rows; grid[r].length is that row's column count.
 *
 *   javac Array2D.java
 *   java Array2D
 */
public class Array2D {
    public static void main(String[] args) {
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Rows: " + grid.length + ", Cols: " + grid[0].length);

        int diagonal = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                System.out.printf("%3d", grid[r][c]);
            }
            diagonal += grid[r][r];      // element where row index == column index
            System.out.println();
        }
        System.out.println("Sum of main diagonal: " + diagonal);
    }
}
