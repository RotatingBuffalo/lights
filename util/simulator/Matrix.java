package util.simulator;

import javax.swing.JComponent;
import javax.swing.JPanel;

import java.awt.GridLayout;

public class Matrix extends JComponent {
    JPanel gridPanel = new JPanel(new GridLayout(32, 32, 4, 4));
    private Pixel[][] grid = new Pixel[32][32];

    /**
     * instantiates this matrix's grid as all white pixels.
     */
    private void initGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Pixel();
                gridPanel.add(grid[i][j]);
            }
        }
    }

    /**
     * this is the default constructor, and will initialize the board to all
     * white. This WILL flashbang you. Be careful.
     */
    public Matrix() {
        initGrid();
    }

    /**
     * 
     * @param initColor is the color that every pixel of the matrix will be
     *                  initialized to.
     */
    public Matrix(Pixel initColor) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = initColor;
                gridPanel.add(grid[i][j]);
            }
        }
    }
}
