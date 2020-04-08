package JDBC.demo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Demo1 {
    static final String DB_url="jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&useSeverPrepStmts=true";
    static final String Drive ="com.mysql.cj.jdbc.Driver";
    public static void  main(String[] args) throws SQLException, IOException, ClassNotFoundException {
       /*  Connection con=null;
         Statement stmt = null;
         ResultSet rs =null;

         try{
             Class.forName(Drive);
             System.out.println("链接数据库");
             Connection connection = DriverManager.getConnection(DB_url,"root","123456");
             System.out.println("实列化身体Statement");
             stmt = connection.createStatement();
             rs=  stmt.executeQuery("SELECT * FROM aa");
             int column = rs.getMetaData().getColumnCount();
             while (rs.next()) {
                for(int i=0;i<column;i++){
                    System.out.print(rs.getString(i+1));
                    System.out.print(", ");
                }
                System.out.println();

         }} catch (ClassNotFoundException e) {
             e.printStackTrace();
         } catch (SQLException e) {
             e.printStackTrace();
         } finally {
            {
                 try {
                     if(rs!=null)rs.close();
                     if(stmt!=null)stmt.close();
                     if(con!=null)con.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
             }

         }

*/
       System.out.println(jdbcUtil.getConnection().getClass().getName());
    }
    public static boolean login(String name ,int age){
        Connection con=null;
        PreparedStatement stmt = null;
        ResultSet rs =null;

        try{
            Class.forName(Drive);
            System.out.println("链接数据库");
            Connection connection = DriverManager.getConnection(DB_url,"root","123456");
            System.out.println("实列化身体Statement");
            String sql = "SELECT * FROM aa where name = ? and age = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1,name);
            stmt.setInt(2,age);
            return stmt.executeQuery().next();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            {
                try {
                    if(rs!=null)rs.close();
                    if(stmt!=null)stmt.close();
                    if(con!=null)con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return false;
    }

}
/*
*@date:2020.4.8
* @version:demo1
 */
class jdbcUtil {
    static Properties props = null;
    static {
        Properties props = new Properties();
        InputStream  in = Demo1.class.getClassLoader().getResourceAsStream("JDBC/demo/dbconfig.properties");
        try {
            props.load( in);
            Class.forName(props.getProperty("driverClassName"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {

        /**
         * 加载项目中properties配置文件的三种方式
         *
         */
        /*
        //方式一
        Properties p = new Properties();
        p.load(new FileInputStream("conf/jdbc.properties"));
        String name = p.getProperty("className");

        //方式二 通过类加载器 加载配置文件
        Properties p = new Properties();
        InputStream in = LoadProperties.class.getClassLoader().getResourceAsStream("jdbc.properties");
        p.load(in);
        String name = p.getProperty("className");
        //方式三        基名   文件必须是key=value的properties文件
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String name = bundle.getString("className");

         */

        return DriverManager.getConnection(props.getProperty("url"),props.getProperty("username"),props.getProperty("password"));
    }
}