package internet.demo.Udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPclient {
    public static void main(String[] args)throws Exception {
        DatagramSocket client = new DatagramSocket(9999);
        byte data[] =new byte[24];
        DatagramPacket packet = new DatagramPacket(data,data.length);
        System.out.println("等待接收数据");
        client.receive(packet);

        System.out.println("接收到数据："+new String(data,0,packet.getLength()));
        client.close();
    }
}
