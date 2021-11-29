package util.simulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketListener {
    private Socket clientSocket;
    private BufferedReader in;

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
                    System.out.println("cya");
                    break;
                } else {
                    System.out.println(inputLine);
                }
            }
        } catch (IOException e) {
            System.err.println("try catch try catch java is pain");
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
