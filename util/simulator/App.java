package util.simulator;

public class App {
    public static Window w = new Window();

    public static void main(String args[]) {
        w.spawnWindow();
        SocketListenerThread sl = new SocketListenerThread();
        sl.setName("SocketListener");
        sl.start();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                sl.interrupt();
            }
        }));
    }
}
