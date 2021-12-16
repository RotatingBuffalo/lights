package util.simulator;

import javax.swing.*;

public class Window {
    private Matrix frame = new Matrix("Matrix LED Simulator");

    public void update(Pixel[][] grid) {
        frame.Repaint(grid);
    }

    public void update() {
        Pixel[][] grid = new Pixel[32][32];
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                grid[i][j] = new Pixel();
            }
        }
        frame.Repaint(grid);
    }

    public void spawnWindow() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}