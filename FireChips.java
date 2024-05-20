
/**
 * @author Josh Dascoli
 */
public class FireChips {
    public static final int ROWS = 69, COLS = 69;

    /**
     * Fire the Chips
     * @param args
     */
    public static void main(String args[]) {
        Grid grid = new Grid(ROWS, COLS, 0, 10000);
        grid.printArray();
        grid.ChipDFS(ROWS/2, COLS/2);
        grid.printArray();
    }
}
