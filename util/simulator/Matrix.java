package util.simulator;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.security.InvalidParameterException;

public class Matrix extends JFrame {
    private JPanel gridPanel = new JPanel(new GridLayout(32, 32, 5, 5));

    private Pixel[][] grid = new Pixel[32][32];

    /**
     * instantiates this matrix's grid as all white pixels.
     */
    private void initGrid() {
        grid = new Pixel[32][32];
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                grid[i][j] = new Pixel(255, 255, 255);
            }
        }
    }

    private void Update() {
        gridPanel.removeAll();
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                gridPanel.add(grid[i][j]);
            }
        }
        super.repaint();
    }

    /**
     * Updates the Matrix's frame to the passed in pixel grid.
     * 
     * @param pixelGrid 32x32 array of Pixels.
     * @throws InvalidParameterException if pixel grid is not 32x32
     */
    public void Repaint(Pixel[][] pixelGrid) {
        gridPanel.removeAll();
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                gridPanel.add(pixelGrid[i][j]);
                // System.ou
                // .println("Just added a pixel at ( " + i + ", " + j + "). Should be this
                // color:\n"
                // + pixelGrid[i][j]);
            }
        }
        // System.out.println("Pixel at 0,0:\n" + pixelGrid[0][0]);
        // System.out.println("Pixel at 15,15:\n" + pixelGrid[15][15]);
        gridPanel.revalidate();
        repaint();

    }

    /**
     * this is the default constructor, and will initialize the board to all
     * white. This WILL flashbang you. Be careful.
     */
    public Matrix(String title) {
        super(title);
        initGrid();
        Update();
        super.add(gridPanel);
        gridPanel.setBackground(Color.BLACK);
    }

    /**
     * 
     * @param initColor is the color that every pixel of the matrix will be
     *                  initialized to.
     */
    public Matrix(String title, Pixel initColor) {
        super(title);
        grid = new Pixel[32][32];
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                grid[i][j] = initColor;
            }
        }
        Update();
        super.add(gridPanel);
    }

    public Pixel getPixel(int x, int y) {
        return grid[x][y];
    }

    public void setPixel(int x, int y, Pixel p) {
        grid[x][y] = p;
        Update();
    }
}
