
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author Josh Dascoli
 */
public class FireChips {

    public static final int ROWS = 1000, COLS = 1000;
    public static int baseNum = 0, centerNum = 1000000;
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
        
            Grid grid = new Grid(ROWS, COLS, baseNum, centerNum);
            grid.ChipDFS(ROWS / 2, COLS / 2);

            GridDisplay display = new GridDisplay(grid);
            frame.add(display, BorderLayout.CENTER); 

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
