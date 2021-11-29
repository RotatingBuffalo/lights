package util.simulator;

import javax.swing.*;

public class Window {
    private static Matrix frame = new Matrix("Matrix LED Simulator");

    public static void spawnWindow() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public static Matrix getMatrix() {
        return frame;
    }
}