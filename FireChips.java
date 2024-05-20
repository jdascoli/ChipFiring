
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author Josh Dascoli
 */
public class FireChips {

    public static final int ROWS = 97, COLS = 97;
    public static int baseNum = 0, centerNum = 10000;
    /**
     * Fire the Chips
     *
     * @param args
     */
    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {

            //set up JFrame window
            JFrame frame = new JFrame("Grid Display");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(1200, 800);
            frame.setLocationRelativeTo(null);

            Grid grid = new Grid(ROWS, COLS, baseNum, centerNum);
            grid.ChipDFS(ROWS / 2, COLS / 2);
            grid.printGrid();
            
            frame.setVisible(true);
        });
    }
}
