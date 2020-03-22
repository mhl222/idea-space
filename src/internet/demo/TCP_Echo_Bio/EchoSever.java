package internet.demo.TCP_Echo_Bio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class EchoSever {
    private static class ClientTread implements Runnable{
        private Socket client = null;
        private Scanner scanner =null;
        private PrintWriter out = null;
        private boolean flag=true;

        public ClientTread(Socket client) throws Exception{
            this.client = client;
            this.scanner = new Scanner(client.getInputStream());
            this.scanner.useDelimiter("\n");
            this.out=new PrintWriter(client.getOutputStream());
        }

        @Override
        public void run() {
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
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String []args) throws Exception{
        ServerSocket server = new ServerSocket(9999);
            System.out.println("等待客户端链接。。。。");

            boolean flag=true;
            while (flag) {
                Socket client = server.accept();
               new Thread(new ClientTread(client)).start();
            }
          server.close();

        }

}
