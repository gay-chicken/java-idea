package TCPService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServiceDemo {
    public static void main(String[] args) {
        try {
            ServerSocket server = null;
            try {
                server = new ServerSocket(42055);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Socket socket = null;
            try {
                socket = server.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String str = "";
            BufferedReader buff = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while("bye".equals(str)) {
                str = buff.readLine();
                System.out.println(str);
            }
            buff.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
