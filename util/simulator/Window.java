package util.simulator;

import javax.swing.*;

public class Window {
    private Matrix frame = new Matrix("Matrix LED Simulator");

    public void update(Pixel[][] grid) {
        frame.Repaint(grid);
    }

    public void spawnWindow() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}