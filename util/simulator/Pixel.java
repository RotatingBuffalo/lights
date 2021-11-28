package util.simulator;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class Pixel extends JComponent {
    private int r, g, b = 0;

    // Getters and Setters
    /**
     * 
     * @return Red component of this Pixel (0-255)
     */
    public int getRed() {
        return this.r;
    }

    /**
     * 
     * @return Green component of this Pixel (0-255)
     */
    public int getGreen() {
        return this.g;
    }

    /**
     * 
     * @return Blue component of this Pixel (0-255)
     */
    public int getBlue() {
        return this.b;
    }

    /**
     * @param r Red value for Pixel (0-255)
     */
    public void setRed(int r) {
        this.r = r;
        if (this.r > 255) {
            this.r = 255;
        }
        if (this.r < 0) {
            this.r = 0;
        }
    }

    /**
     * @param g Green value for Pixel (0-255)
     */
    public void setGreen(int g) {
        this.g = g;
        if (this.g > 255) {
            this.g = 255;
        }
        if (this.g < 0) {
            this.g = 0;
        }
    }

    /**
     * @param b Blue value for Pixel (0-255)
     */
    public void setBlue(int b) {
        this.b = b;
        if (this.b > 255) {
            this.b = 255;
        }
        if (this.b < 0) {
            this.b = 0;
        }
    }

    // Constructors
    /**
     * This is the default constructor for Pixel, and will initialize to
     * #FFFFFF. Unless you feel like flashbanging yourself, you probably don't
     * want to use this.
     */
    public Pixel() {
        r = 255;
        g = 255;
        b = 255;
    }

    /**
     * @param red   (0-255)
     * @param green (0-255)
     * @param blue  (0-255)
     */
    public Pixel(int r, int g, int b) {
        this.setRed(r);
        this.setGreen(g);
        this.setBlue(b);
    }

    /**
     * 
     * @param HexCode represents color of pixel as a string, *including* leading
     *                hashtag.
     *                (Ex: #00AAE0)
     * 
     * 
     */
    public Pixel(String hexCode) {
        hexCode.trim();
        try {
            this.setRed(Integer.parseInt(hexCode.substring(1, 3), 16));
            this.setGreen(Integer.parseInt(hexCode.substring(3, 5), 16));
            this.setBlue(Integer.parseInt(hexCode.substring(5, 7), 16));
        } catch (StringIndexOutOfBoundsException e) {
            this.setRed(Integer.parseInt(hexCode.substring(0, 2), 16));
            this.setGreen(Integer.parseInt(hexCode.substring(2, 4), 16));
            this.setBlue(Integer.parseInt(hexCode.substring(4, 6), 16));
        }
    }

    /**
     * 
     * @return
     */
    public String getHexString() {
        String rtrn = "#";
        String rString = Integer.toHexString(r);
        if (rString.length() < 2) {
            rString = "0" + rString;
        }
        String gString = Integer.toHexString(g);
        if (gString.length() < 2) {
            gString = "0" + gString;
        }
        String bString = Integer.toHexString(b);
        if (bString.length() < 2) {
            bString = "0" + bString;
        }
        rtrn += rString + gString + bString;
        return rtrn;
    }

    // Actually useful functions from here on out, offering new ways to change
    // colors.
    public void add(Pixel other) {
        setRed(other.getRed() + this.r);
        setGreen(other.getGreen() + this.g);
        setBlue(other.getBlue() + this.b);
    }

    public void subtract(Pixel other) {
        setRed(other.getRed() - this.r);
        setGreen(other.getGreen() - this.g);
        setBlue(other.getBlue() - this.b);
    }

    // Debug stuff here on out. All likely to be removed.

    /**
     * 
     * @return this Pixel's color data in a "Pretty Printing" friendly format.
     * 
     */
    public String toString() {
        String rtrn = "";
        rtrn += "R: " + this.r + " ";
        rtrn += "G: " + this.g + " ";
        rtrn += "B: " + this.b + "\n";
        rtrn += "HEX: " + this.getHexString() + "\n";
        return rtrn;
    }

    // JAVA SWING STUFF
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(this.r, this.g, this.b));
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(10, 10);
    }

    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

}
