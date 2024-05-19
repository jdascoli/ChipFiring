
/**
 *
 * @author Josh Dascoli
 */
public class FireChips {

    private static int[][] grid;
    private static int baseNum = 0, centerNum;

    /**
     * @param size1
     * @param size2
     * @return grid, array with appropriate sizes
     */
    private static int[][] makeGrid(int size1, int size2) {
        grid = new int[size1][size2];

        //make an array with a base amount of chips in each space;
        if (baseNum != 0) {
            for (int[] grid1 : grid) {
                for (int j = 0; j < grid1.length; j++) {
                    grid1[j] = baseNum;
                }
            }
        }
        grid[grid.length / 2][grid[0].length / 2] = centerNum;
        return grid;
    }

    public static int getCenterNum() {
        return centerNum;
    }

    private static void setCenterNum(int centerNum) {
        FireChips.centerNum = centerNum;
    }

    public static int getBaseNum() {
        return baseNum;
    }

    private static void setBaseNum(int baseNum) {
        FireChips.baseNum = baseNum;
    }

    /**
     * Fire the Chips
     *
     * @param args
     */
    public static void main(String args[]) {
        setBaseNum(0);
        setCenterNum(4);
        grid = makeGrid(5, 5);

        //print out the grid
        for (int[] grid1 : grid) {
            for (int j = 0; j < grid1.length; j++) {
                System.out.print(grid1[j]);
            }
            System.out.println();
        }
    }
}
