package deep_io.demo;
// Io    打印流
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Demo4 {
    public static void main(String []args){
        File file= new File("C:\\Users\\孟哥\\Desktop\\ss\\s.txt");
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println("sss");
            writer.println("sss");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
