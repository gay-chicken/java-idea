package TCPService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",4700);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            String str;
            str = in.readLine();
            while(!"bye".equals(in.readLine())) {
                os.println(str);
                os.flush();
                str = in.readLine();
            }
            os.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
