package mySocket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IdentifyHostNameIP {
    public static void main(String[] args) {
        String[] strings = {"localhost", "www.baidu.com", "127.0.0.1"};
        for (int i = 0; i < strings.length; i++) {
            try {
                InetAddress address = InetAddress.getByName(strings[i]);
                System.out.println("Host name: " + address.getHostName());
                System.out.println("IP address: " + address.getHostAddress());
            } catch (UnknownHostException e) {
                System.err.println("Unknown host or IP address " + strings[i]);
            }
        }
    }
}
