package internet.demo.TCP_Echo_Bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    private static final BufferedReader KEYBOARD_INPUT= new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{

            Socket client = new Socket("localhost", 9999);
            System.out.println(client.isConnected());
            System.out.println(client.isBound());
            Scanner scanner = new Scanner(client.getInputStream());
            scanner.useDelimiter("\n");
            PrintWriter out= new PrintWriter(client.getOutputStream());
            boolean flag=true;
            while (flag){
                String str = getString("请输入发送数据:").trim();
                out.println(str);
               out.flush();//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!缓冲杀我！！！！！！！！
                if(scanner.hasNext())
                {
                    System.out.println(scanner.next());
                }
                if(str.equalsIgnoreCase("byebye"))
                    flag=false;

            }
            scanner.close();
            out.close();
            client.close();

    }
 public static String getString(String promet) throws IOException{
        System.out.print(promet);
        String str = KEYBOARD_INPUT.readLine();
         return str;


    }

}