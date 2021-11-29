package util.simulator;

public class App {
    public static void main(String args[]) {
        SocketListener sl = new SocketListener();
        Window.spawnWindow();
        sl.startConnection();
    }
}
