package io.demo;
//本包字节流与字符流
import java.io.*;

/*
 * IO练习  转换流
 */
public class Demo6 {
    public static void main(String []args){
        File f = new File("C:\\Users\\孟哥\\Desktop\\ss\\s.txt");
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        try {
            OutputStream out = new FileOutputStream(f,true);
            Writer outwrite = new OutputStreamWriter(out);
            String msg ="www.mhlsky.comaa\r\n";
            outwrite.write(msg);
           outwrite.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
