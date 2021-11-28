package src;

import util.simulator.Pixel;
import util.simulator.Window;

public class App {
    public static void main(String args[]) {
        System.out.println();
        Pixel p = new Pixel("#FFF0FF");
        System.out.print(p);
        Pixel p2 = new Pixel("000F00");
        p2.add(p);
        System.out.print(p2);

        Window.spawnWindow();
    }
}
