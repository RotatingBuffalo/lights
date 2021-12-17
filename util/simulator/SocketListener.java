package util.simulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketListener {
    private ServerSocket ss;
    private Socket clientSocket;
    private BufferedReader in;

    public Pixel[][] parseFrameBuffer(String socketMessage) {
        socketMessage = socketMessage.substring(socketMessage.indexOf('{') + 1, socketMessage.indexOf('}'));
        String[] receivedHexCodes = socketMessage.split(";", 0);
        Pixel[][] rtrn = new Pixel[32][32];
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                rtrn[i][j] = new Pixel(receivedHexCodes[32 * i + j]);
            }
        }
        return rtrn;
    }

    public void startConnection() {

        try {
            ss = new ServerSocket(12000);
            clientSocket = ss.accept();
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();

        }
        System.out.println("Listening on port 12000");
    }

    public void listen() {
        String inputLine = "";
        while (!clientSocket.isClosed()) {
            try {
                inputLine = in.readLine();
            } catch (IOException e) {
                System.out.println("Listening on port 12000");
                e.printStackTrace();
            }
            if (inputLine == null) {
                try {
                    Thread.sleep(33L);
                } catch (InterruptedException e) {
                    stopConnection();
                }
                continue;
            }
            if (",".equals(inputLine)) {
                try {
                    Thread.sleep(25L);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
                System.out.println("Connection Lost... Awaiting new connection.");
                App.w.update();
                stopConnection();
                startConnection();
                listen();
            }
            if (".".equals((inputLine))) {
                System.out.println("Killswitch received. Goodbye!");
                break;
            } else {
                App.w.update(parseFrameBuffer(inputLine));
            }
        }
        if (clientSocket.isClosed()) {
            System.out.println("clientSocket was closed?");
            stopConnection();
            startConnection();
            listen();
        }
    }

    public void stopConnection() {
        try {
            in.close();
            clientSocket.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
