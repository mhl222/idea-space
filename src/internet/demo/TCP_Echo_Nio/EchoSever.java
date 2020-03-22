package internet.demo.TCP_Echo_Nio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoSever {
    public static void main(String []args){
        try (ServerSocket server = new ServerSocket(9999)) {
            System.out.println("等待客户端链接。。。。");
            Socket client=server.accept();
            Scanner scanner = new Scanner(client.getInputStream());
            scanner.useDelimiter("\n");
            PrintWriter out = new PrintWriter(client.getOutputStream());
            boolean flag=true;
            while (flag){
                if(scanner.hasNext()){
                    System.out.println("收到数据");
                    String str =scanner.next().trim();
                    if(str.equalsIgnoreCase("byebye")){
                        flag=false;
                        out.println("ByeBye.....");
                        out.flush();

                    }
                    else
                    {
                        out.println("{ECHO}"+str);
                        out.flush();
                    }
                }
            }
            scanner.close();
            out.close();
            client.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
