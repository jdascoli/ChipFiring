import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GridDisplay extends JPanel{
    private final Grid grid;

    public GridDisplay(Grid grid) {
        this.grid = grid;
    }   
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int[][] paintedGrid = grid.getGrid();
        int panelSize = 10;

        //go through the grid
        for(int row = 0; row < paintedGrid.length; row++){
            for(int col = 0; col < paintedGrid[row].length; col++){
                int chips = paintedGrid[row][col];

                //paint the panels
                Color color = switch (chips) {
                    case 1 -> Color.CYAN;
                    case 2 -> Color.YELLOW;
                    case 3 -> Color.RED;
                    default -> Color.BLUE;
                };
                
                //put the panels in display
                g.setColor(color);
                g.fillRect(col * panelSize, row * panelSize, panelSize, panelSize);
                
            }
        }

    }
}