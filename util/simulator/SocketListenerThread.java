package util.simulator;

public class SocketListenerThread extends Thread {

    public SocketListenerThread() {
        super(new Runnable() {
            SocketListener listener = new SocketListener();

            public void run() {
                listener.startConnection();
                listener.listen();
            }
        });
    }

}
