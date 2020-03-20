package deep_io.demo;

import java.io.*;

//IO深入：   内存操作流 ByteArrayInputStream
public class demo1 {
    public  static void main(String[] args)
    {
        String str  = "www.mhlsky.com";
        InputStream inputStream = new ByteArrayInputStream(str.getBytes());
        //当使用子类ByteArrayOutputStream时  toByteArray() 方法。
        OutputStream outputStream = new ByteArrayOutputStream();
        int data=0;
        do {
            try {
                data=inputStream.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(data!=-1) {
                try {
                    outputStream.write(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }while (data!=-1);
         System.out.println(outputStream);

    }
}
