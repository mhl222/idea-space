package io.demo;
//本包字节流与字符流
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
/*
* IO练习  Writer练习
 */
public class Demo4 {
    public static  void main(String[] args)
    {
        File file = new File("C:\\Users\\孟哥\\Desktop\\ss\\s.txt");
        if(!file.getParentFile().exists())
            file.mkdirs();
        try {
            Writer writer = new FileWriter(file,true);
            writer.write("www.mhlsky.com  aa");
            //writer.flush();
           // writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
