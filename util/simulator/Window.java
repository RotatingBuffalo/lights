package util.simulator;

import util.simulator.Matrix;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

public class Window {
    public static void spawnWindow() {
        JFrame frame = new JFrame("Matrix LED Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(new DimensionUIResource(600, 400));
        frame.setVisible(true);
    }
}