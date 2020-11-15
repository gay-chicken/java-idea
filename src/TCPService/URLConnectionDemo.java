package TCPService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionDemo {
    public static void main(String[] args) throws Exception{
        URL url = new URL("http://www.baidu.com");
        URLConnection conn = url.openConnection();
        BufferedReader buff = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String str;
        while((str = buff.readLine()) != null) {
            System.out.println(str);
        }
        buff.close();
    }
}
