package deep_io.demo;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

//IO深入：   管道流 （实现俩个线程之间的IO处理操作）
public class Demo2 {
    public static void main(String []args){
        SendTread sendTread = new SendTread();
        ReceiveThread receiveThread =new ReceiveThread();
        try {
            sendTread.getOutput().connect(receiveThread.getInput());

        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(sendTread).start();
        new Thread(receiveThread).start();
    }
}

class SendTread implements Runnable{
    private PipedOutputStream output ;
    public SendTread() {
        this.output = new PipedOutputStream();
    }

    @Override
    public void run() {
            try {
                this.output.write((Thread.currentThread().getName()+"发送信息").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    public PipedOutputStream getOutput() {
        return output;
    }
}
class ReceiveThread implements Runnable{

    private PipedInputStream input;

    public ReceiveThread() {
        this.input = new PipedInputStream( );
    }

    public PipedInputStream getInput() {
        return input;
    }

    @Override
    public void run() {

            byte[] data = new byte[1024];
            try {
                int len=input.read(data);
                System.out.println(Thread.currentThread().getName()+"接受消息："+new String(data,0,len));
            } catch (IOException e) {
                e.printStackTrace();
            }


    }
}