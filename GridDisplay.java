import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JPanel;

public class GridDisplay extends JPanel implements MouseWheelListener{
    private final Grid grid;
    private int panelSize = 10;

    @SuppressWarnings("LeakingThisInConstructor")
    public GridDisplay(Grid grid) {
        this.grid = grid;
        addMouseWheelListener(this);
        setPreferredSize(new Dimension(grid.getGrid()[0].length * panelSize, grid.getGrid().length * panelSize));
    }  

    @Override // implementation
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int[][] paintedGrid = grid.getGrid();
        
        int gridWidth = paintedGrid[0].length * panelSize;
        int gridHeight = paintedGrid.length * panelSize;

        int x = (getWidth() - gridWidth) / 2;
        int y = (getHeight() - gridHeight) / 2;

        //go through the grid
        for(int row = 0; row < paintedGrid.length; row++){
            for(int col = 0; col < paintedGrid[row].length; col++){
                int chips = paintedGrid[row][col];

                //paint the panels
                Color color = switch (chips) {
                    case 1 -> new Color(186,85,211);
                    case 2 -> Color.YELLOW;
                    case 3 -> Color.BLACK;
                    default -> Color.LIGHT_GRAY;
                };
                
                //put the panels in display
                g.setColor(color);
                g.fillRect(x + col * panelSize, y + row * panelSize, panelSize, panelSize);

                //setting border color
                // g.setColor(Color.BLACK);
                // g.drawRect(col * panelSize, row * panelSize, panelSize, panelSize);
            }
        }

    }

    @Override //required
    public void mouseWheelMoved(MouseWheelEvent e) {
        
        //get mouse scroll input
        int direction = e.getWheelRotation();

        //zoom in and out
        if(direction == -1) panelSize+=1; 
        else panelSize-=1;

        //display zoomed in/out grid
        repaint();
    }
}