package deep_io.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

//IO深入：RandomAccessFile
public class Demo3 {
    public static void main(String []args){
        File file= new File("C:\\Users\\孟哥\\Desktop\\ss\\s.txt");
        RandomAccessFile raf;
        try {
            raf = new RandomAccessFile(file,"rw");
            String str[]=new String[]{"zhangsan","lisi    ","wangwu  "};
            int[] ages = new int[]{10,45,55};
            for(int x=0;x<3;x++)
            {
                raf.write(str[x].getBytes());
                raf.writeInt(ages[x]);
            }
            raf.seek(12);
            byte[]data= new byte[8];
            int len =raf.read(data);
            System.out.println("姓名："+new String(data,0,8)+"年龄："+raf.readInt());
          //  raf.skipBytes(12);
            len =raf.read(data);
            System.out.println("姓名："+new String(data,0,8)+"年龄："+raf.readInt());

            raf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
