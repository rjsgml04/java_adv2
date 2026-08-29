package network.tcp.v1;

import java.net.InetAddress;
import java.net.UnknownHostException;

// TCP/IP는 통신 대상 서버를 찾을때 IP 주소가 팔요함
public class InetAddressMain {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localhost = InetAddress.getByName("localhost");
        System.out.println(localhost);

        InetAddress google = InetAddress.getByName("google.com");
        System.out.println(google);

    }
}
