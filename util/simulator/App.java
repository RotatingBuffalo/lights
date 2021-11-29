package util.simulator;

public class App {
    public static void main(String args[]) {
        SocketListener sl = new SocketListener();
        Window.spawnWindow();
        sl.startConnection();
        // Window.getMatrix().setPixel(31, 31, new Pixel(255, 0, 255));
    }
}
