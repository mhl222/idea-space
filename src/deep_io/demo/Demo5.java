package deep_io.demo;

import java.io.*;
//  IO   序列化/反序列化
public class Demo5 {
    private static final File file = new File("C:\\Users\\孟哥\\Desktop\\ss\\s.txt");
    public static void main(String[] args){
        saveObject(new Person("张三",12));
        Person person=(Person) loadObject();
        System.out.println(person);

    }
     static void saveObject(Object object){
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))) {
            output.writeObject(object);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    static Object loadObject(){
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));

           Object  object=input.readObject();
            input.close();
            return object;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
class Person implements Serializable{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age=age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "姓名："+name+"年龄："+age;
    }
}
