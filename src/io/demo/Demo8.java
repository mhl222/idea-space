package io.demo;
//本包字节流与字符流
import java.io.*;
import java.util.Scanner;

/*
 * IO练习  目录及目录下文件的复制
 * IO操作核心例子
 */

public class Demo8 {
    public static void main(String []args)
    {
        System.out.println("输入拷贝源文件");
        Scanner in = new Scanner(System.in);
        String srcPath = in.next();
        System.out.println("输入拷贝目标文件");
        String desPath = in.next();
        long start = System.currentTimeMillis();
        FileUtil1 fileUtil = new FileUtil1(srcPath,desPath);
        if(new File(srcPath).isFile())
            System.out.println(fileUtil.copy()?"文件拷贝成功":"文件拷贝失败");
        else{
            System.out.println(fileUtil.copyDir()?"文件拷贝成功":"文件拷贝失败");
        }

        long end = System.currentTimeMillis();
        System.out.println("花费时间:"+(end-start)/1000);
    }
}
class FileUtil1{
    private File srcFile;
    private File desFile;
    public FileUtil1(String srcFile,String desFile){
        this.desFile=new File(desFile);
        this.srcFile=new File(srcFile);
    }
    public boolean copy(){
        if(!this.srcFile.exists()) {
            System.out.println("源文件不存在");
            return false;
        }


        return copyFileImpl(this.srcFile,this.desFile);

    }
    public boolean copyFileImpl(File srcFile,File desFile){
        if(!this.desFile.getParentFile().exists())
            this.desFile.getParentFile().mkdirs();
        byte[] data =new byte[1024];
        InputStream input=null;
        OutputStream output =null;
        try {
            input=new FileInputStream(srcFile);
            output=new FileOutputStream(desFile);
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
    public void copyImpl(File file){
        if(file.isDirectory()){
            File[] result = file.listFiles();
            if(result!=null){
                for(int n=0;n<result.length;n++)
                {
                    copyImpl(result[n]);
                }
            }
        }else {
          String newfilePath = file.getPath().replace(this.srcFile.getPath()+File.separator,"");
          File newFile = new File(this.desFile,newfilePath);

          copyFileImpl(file,newFile);
        }

    }
    public  boolean copyDir(){
        this.copyImpl(this.srcFile);
        return true;
    }

}