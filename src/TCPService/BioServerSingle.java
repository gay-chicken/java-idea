package TCPService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServerSingle {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(9000);
            while (true) {
                socket = serverSocket.accept();
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();
                byte[] bit = new byte[1024];
                while (inputStream.read(bit) > 0) {
                    System.out.println(new String(bit));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
