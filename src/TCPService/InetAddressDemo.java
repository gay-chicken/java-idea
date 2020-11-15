package TCPService;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ip1 = InetAddress.getLocalHost();
        InetAddress ip2 = InetAddress.getByName("www.baidu.com");
        InetAddress ip3 = InetAddress.getByAddress(ip2.getAddress());

        System.out.println("canonical:"+ip1.getCanonicalHostName());
        System.out.println("address:"+ip1.getHostAddress());
        System.out.println("name:"+ip1.getHostName());
        System.out.println("toString:"+ip1.toString());
        System.out.println("+=================+");

        System.out.println("canonical:"+ip2.getCanonicalHostName());
        System.out.println("address:"+ip2.getAddress());
        System.out.println("name:"+ip2.getHostName());
        System.out.println("toString:"+ip2.toString());
        System.out.println("+========================+");

        System.out.println("canonical:"+ip3.getCanonicalHostName());
        System.out.println("address:"+ip3.getAddress());
        System.out.println("name:"+ip3.getHostName());
        System.out.println("+========================+");
        System.out.println(ip3.equals(ip2));

    }
}
