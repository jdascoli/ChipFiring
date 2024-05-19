
public class Grid {

    private final int[][] grid;
    private final int baseNum, centerNum;

    /**
     * @param rows rows of array
     * @param columns columns of array
     * @param baseNum number which all vertexes start out
     * @param centerNum center number
     */
    public Grid(int rows, int columns, int baseNum, int centerNum) {
        this.grid = new int[rows][columns];
        this.baseNum = baseNum;
        this.centerNum = centerNum;
        makeGrid();
    }

    /**
     * make a 2d array
     */
    private void makeGrid() {

        //make an array with a base amount of chips in each space;
        for (int[] grid1 : grid) {
            for (int j = 0; j < grid1.length; j++) {
                grid1[j] = baseNum;
            }
        }
        grid[grid.length / 2][grid[0].length / 2] = centerNum;
    }

    /**
     * print out the grid
     */
    public void printArray() {
        for (int[] grid1 : grid) {
            for (int j = 0; j < grid1.length; j++) {
                System.out.print(grid1[j] + " ");
            }
            System.out.println();
        }
    }
}
