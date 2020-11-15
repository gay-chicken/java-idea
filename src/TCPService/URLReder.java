package TCPService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class URLReder {
    public static void main(String[] args) throws Exception{
        URL url = new URL("http://www.baidu.com");
        BufferedReader buff = new BufferedReader(new InputStreamReader(url.openStream()));
        String str;
        while((str = buff.readLine()) != null) {
            System.out.println(str);
        }
        buff.close();
    }
}
