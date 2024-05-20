

public class Grid {

    private final int[][] grid;
    private final int baseNum, centerNum, rows, columns;

    /**
     * @param rows rows of array
     * @param columns columns of array
     * @param baseNum number which all vertexes start out
     * @param centerNum center number
     */
    public Grid(int rows, int columns, int baseNum, int centerNum) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new int[rows][columns];
        this.baseNum = baseNum;
        this.centerNum = centerNum;
        makeGrid();
    }

    /**
     * getter for grid
     * @return grid
     */
    public int[][] getGrid() {
        return grid;
    }

    /**
     * make a 2d array
     */
    private void makeGrid() {
        //make an array with a base amount of chips in each space;
        for (int[] grid1 : grid) {
            for (int j = 0; j < columns; j++) {
                grid1[j] = baseNum;
            }
        }
        grid[rows / 2][columns / 2] = centerNum;
    }

    /**
     * print out the grid
     */
    public void printGrid() {
        for (int[] grid1 : grid) {
            for (int vertex : grid1) {
                System.out.print(colorNumber(vertex) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * @param number number
     * @return the number colored
     */
    private String colorNumber(int number) {
        String colorCode;
        colorCode = switch (number) {
            case 1 ->"\u001B[36m";
            case 2 ->"\u001B[33m";
            case 3 ->"\u001B[31m";
            default ->"\u001B[34m";
        };
        return colorCode + number + "\u001B[0m";
    }

    /**
     * DFS to distribute chips
     * 
     * @param row the current row
     * @param column the current column
     */
    public void ChipDFS(int row, int column) {
        int chips = grid[row][column];
        if (grid[row][column] < 4) return;

        //set current and neighbor chips recursively
        grid[row][column] = chips % 4;  
        if (row+1 != rows){
            grid[row+1][column] += chips / 4;  
            if (grid[row+1][column] > 3) ChipDFS(row+1, column);
        }
        if (row-1 >= 0){
            grid[row-1][column] += chips / 4; 
            if (grid[row-1][column] > 3) ChipDFS(row-1, column);
        } 
        if (column + 1 != columns){
            grid[row][column+1] += chips / 4; 
            if (grid[row][column+1] > 3) ChipDFS(row, column+1);
        } 
        if (column-1 >= 0){
            grid[row][column-1] += chips / 4; 
            if (grid[row][column-1] > 3) ChipDFS(row, column-1);
        } 
    }
}
