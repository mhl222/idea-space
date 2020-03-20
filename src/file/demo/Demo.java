package file.demo;
//本包字节流与字符流
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;



/*
* 修改文件名    File学习
 */
public class Demo {

    public static void main(String []args)
    {
File f=new File("C:\\Users\\孟哥\\Desktop\\aaa"+File.separator);
rename(f);
    }
   static void rename(File F)
    {
        if(F.isDirectory())
        {
        File[] Fs=F.listFiles();
        if(Fs!=null)
        for(int x=0;x<Fs.length;x++)
        {
            rename(Fs[x]);
        }
        }
        else {
            if(F.isFile()) {
                String newf = "";
                if (F.getName().contains("."))
                    newf = F.getName().substring(0, F.getName().lastIndexOf(".")) + ".txt";
                else
                    newf = F.getName() + ".txt";
                File FF=new File(F.getParentFile(),newf );
                F.renameTo(FF);
            }
        }
        System.out.println(F);
    }

}