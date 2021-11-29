package util.simulator;

public class App {
    public static Window w = new Window();

    public static void main(String args[]) {
        w.spawnWindow();
        SocketListener sl = new SocketListener();
        sl.startConnection();

    }
}
