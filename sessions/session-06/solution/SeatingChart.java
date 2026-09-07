public class SeatingChart {
    public static void main(String[] args) {
        char[][] hall = {
            {'X', 'X', '.', 'X'},
            {'.', 'X', '.', '.'},
            {'X', 'X', 'X', 'X'}
        };
        int occupied = 0, free = 0;
        for (int r = 0; r < hall.length; r++) {
            for (int c = 0; c < hall[r].length; c++) {
                System.out.print(hall[r][c] + " ");
                if (hall[r][c] == 'X') occupied++;
                else free++;
            }
            System.out.println();
        }
        System.out.println("Occupied: " + occupied + ", Free: " + free);
    }
}
