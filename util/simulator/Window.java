package util.simulator;

import java.awt.BorderLayout;

import javax.swing.*;

public class Window {
    public static void spawnWindow() {
        JFrame frame = new JFrame("Matrix LED Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent matrix = new Matrix(new Pixel(0, 0, 0));
        frame.getContentPane().add(matrix, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}