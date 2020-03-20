package io.demo;
//本包字节流与字符流
import java.io.*;
import java.util.Scanner;

/*
练习    单个文件拷贝(JDK1.9后有tansferTo()可快速转存)
*/
public class Demo7 {
    public static void main(String [] args){

        System.out.println("输入拷贝源文件");
        Scanner in = new Scanner(System.in);
        String srcPath = in.next();
        System.out.println("输入拷贝目标文件");
        String desPath = in.next();
        long start = System.currentTimeMillis();
        FileUtil fileUtil = new FileUtil(srcPath,desPath);
        System.out.println(fileUtil.copy()?"文件拷贝成功":"文件拷贝失败");
        long end = System.currentTimeMillis();
        System.out.println("花费时间:"+(end-start)/1000);

    }
}

class FileUtil{
    private File srcFile;
    private File desFile;
    public FileUtil(String srcFile,String desFile){
        this.desFile=new File(desFile);
        this.srcFile=new File(srcFile);
    }
    public boolean copy(){
        if(!this.srcFile.exists()) {
            System.out.println("源文件不存在");
            return false;
        }
        if(!this.desFile.getParentFile().exists())
            this.desFile.getParentFile().mkdirs();
        byte data[]=new byte[1024];
        InputStream input=null;
        OutputStream output =null;
        try {
            input=new FileInputStream(this.srcFile);
            output=new FileOutputStream(this.desFile);
            int len=0;
            while ((len=input.read(data))!=-1){
                output.write(data,0,len);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(input!=null)
                    input.close();
                if (output!=null)
                    output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return true;

    }

}