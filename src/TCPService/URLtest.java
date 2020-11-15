package TCPService;

import java.net.URL;

public class URLtest {
    public static void main(String[] args) throws Exception{
        URL arl = new URL("https://www.baidu.com/");
        URL pth = new URL(arl, "index.html");

        System.out.println(pth.getProtocol());
        System.out.println(pth.getHost());
        System.out.println(pth.getFile());
        System.out.println(pth.getPort());
        System.out.println(pth.getRef());
        System.out.println(pth.getQuery());
        System.out.println(pth.getPath());

    }
}
