package util.simulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketListener {
    private Socket clientSocket;
    private BufferedReader in;

    public Pixel[][] parseFrameBuffer(String socketMessage) {
        socketMessage = socketMessage.substring(socketMessage.indexOf('{') + 1, socketMessage.indexOf('}'));
        String[] receivedHexCodes = socketMessage.split(";", 0);
        // System.out.println("Number of colors parsed: " + receivedHexCodes.length);
        Pixel[][] rtrn = new Pixel[32][32];
        // System.out.println("Message received:" + receivedHexCodes[0]);
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                rtrn[i][j] = new Pixel(receivedHexCodes[(i * j) + j]);
            }
        }
        // System.out.println("Setting grid to: " + rtrn[15][31]);
        return rtrn;
    }

    public void startConnection() {
        System.out.println("Listening on port 12000");
        try {
            clientSocket = new Socket("127.0.0.1", 12000);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String inputLine = "";
        try {
            while ((inputLine = in.readLine()) != null) {
                if (".".equals((inputLine))) {
                    System.out.println("Killswitch received. Goodbye!");
                    break;
                } else {
                    App.w.update(parseFrameBuffer(inputLine));
                }
            }
        } catch (IOException e) {
            System.err.println("try catch try catch java is pain");
            e.printStackTrace();
        }
    }

    public void stopConnection() {
        try {
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
