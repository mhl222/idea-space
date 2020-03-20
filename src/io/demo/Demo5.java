package io.demo;
//本包字节流与字符流
import java.io.*;
/*
 * IO练习  Reader练习
 */
public class Demo5 {
    public  static void main(String[] args)
    {
        File file = new File("C:\\Users\\孟哥\\Desktop\\ss\\s.txt");
        if(!file.getParentFile().exists())
            file.mkdirs();
        try {
            Reader reader = new FileReader(file);
            char[] s = new  char[3];
            while(reader.read(s)>=3)
            {
                System.out.println(new String(s));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
