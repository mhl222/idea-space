package io.demo;
//本包字节流与字符流
import java.io.*;
/*
IO流  outstream练习。

 */
public class Demo2 {
    public static void main(String[] args) {
        File f = new File("C:\\Users\\孟哥\\Desktop\\ss\\s.txt");
        System.out.println(!f.getParentFile().exists());
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        System.out.println(f.exists());
        try {
            OutputStream out = new FileOutputStream(f,true);
            String msg ="www.mhlsky.comaa\r\n";
            out.write(msg.getBytes());
         //   out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /*
        InputStream   IO练习
         */
    public static class Demo3 {

    }
}
