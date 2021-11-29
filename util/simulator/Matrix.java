package util.simulator;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;

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
        gridPanel.setBackground(Color.BLACK);
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                gridPanel.add(grid[i][j]);
            }
        }
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
        return (Pixel) gridPanel.findComponentAt(x, y);
    }

    public void setPixel(int x, int y, Pixel p) {
        grid[x][y] = p;
        Update();
    }
}
