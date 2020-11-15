package practice;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SocketTest {
    public static void main(String[] args) throws UnknownHostException {
        // 获取本机信息
        InetAddress ip = InetAddress.getLocalHost();

        System.out.println("canonical:"+ip.getCanonicalHostName());
        System.out.println("address:"+ip.getHostAddress());
        System.out.println("name:"+ip.getHostName());
        System.out.println("toString:"+ip.toString());
        System.out.println("+=========================+");

        // 获取指定域名信息
        InetAddress ip2 = InetAddress.getByName("www.neusoft.edu.cn");

        System.out.println("canonical:"+ip2.getCanonicalHostName());
        System.out.println("address:"+ip2.getHostAddress());
        System.out.println("name:"+ip2.getHostAddress());
        System.out.println("toString:"+ip2.toString());
        System.out.println("+=========================+");

        // 比较两个地址信息
        InetAddress ip3 = InetAddress.getByAddress(ip2.getAddress());
        System.out.println("canonical:"+ip3.getCanonicalHostName());
        System.out.println("address:"+ip3.getHostAddress());
        System.out.println("name:"+ip3.getHostName());
        System.out.println("+=========================+");

        System.out.println(ip2.equals(ip));
    }
}
