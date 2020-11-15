package TCPService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        int count = 0;
        boolean listen = true;
        try {
            try {
                server = new ServerSocket(4700);
                System.out.println("server listening...");
            }catch (IOException e) {
                e.printStackTrace();
            }

            while (listen) {
                Socket socket = server.accept();
                count ++;
                System.out.println("accept "+count);
                Thread read = new ReadThread(socket, "client:"+count);
                read.start();
            }
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ReadThread extends Thread {
    Socket socket = null;
    String client;
    public ReadThread (Socket socket, String client) {
        this.socket = socket;
        this.client = client;
    }

    public ReadThread (Socket socket, String side, int clientnum) {
        this(socket, side);
    }

    @Override
    public void run () {
        try {
            String line = "";
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (line != null && !"bye".equals(line)) {
                line = is.readLine();
                System.out.println("client:"+line);
            }
            is.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
