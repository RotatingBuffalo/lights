package util.simulator;

public class Pixel {
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
     * @see This is the default constructor for Pixel, and will initialize to
     *      #FFFFFF. Unless you feel like flashbanging yourself, you probably don't
     *      want to use this.
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
     * @param HexCode for color of pixel as a string, including leading hashtag.
     *                (Ex: #00AAE0)
     */
    public Pixel(String hexCode) {
        hexCode.trim();
        this.setRed(Integer.parseInt(hexCode.substring(1, 3), 16));
        this.setGreen(Integer.parseInt(hexCode.substring(3, 5), 16));
        this.setBlue(Integer.parseInt(hexCode.substring(5, 7), 16));
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

    // Debug stuff here on out. All likely to be removed.

    /**
     * 
     * @return this Pixel's color data in a "Pretty Printing" friendly format.
     * 
     */
    public String reprString() {
        String rtrn = "";
        rtrn += "R: " + this.r + "\n";
        rtrn += "G: " + this.g + "\n";
        rtrn += "B: " + this.b + "\n";
        rtrn += "HEX: " + this.getHexString() + "\n";
        return rtrn;
    }
}
