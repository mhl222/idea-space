package io.demo;
//本包字节流与字符流
import java.io.*;
/*
IO流  inputstream练习。

 */
public class Demo3 {
    public  static  void main(String []args){
        File file =new File("C:\\Users\\孟哥\\Desktop\\ss\\s.txt");
        try {
            InputStream inputStream =new FileInputStream(file);
            byte data[]=new byte[400];
            int len = inputStream.read(data);
            System.out.println("["+new String(data,0,len)+"]");
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
