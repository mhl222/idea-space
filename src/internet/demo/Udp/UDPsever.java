package internet.demo.Udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPsever {
    public static void main(String []args) throws Exception{
        DatagramSocket sever = new DatagramSocket(9990);
        String str = "www.mhlsky.com";
        DatagramPacket data = new DatagramPacket(str.getBytes(),0,str.length(), InetAddress.getLocalHost(),9999);
        sever.send(data);
        System.out.println("发送完毕");
        sever.close();
    }
}
