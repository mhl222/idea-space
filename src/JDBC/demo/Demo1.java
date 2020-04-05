package JDBC.demo;

import java.sql.*;

public class Demo1 {
    public static void  main(String[] args) throws ClassNotFoundException, SQLException {
         final String DB_url="jdbc:mysql://localhost:3306/mydemo?useSSL=false&serverTimezone=UTC";

           Class.forName("com.mysql.cj.jdbc.Driver");
           System.out.println("链接数据库");
        Connection connection = DriverManager.getConnection(DB_url,"root","123456");
        System.out.println("实列化身体Statement");
        Statement st = connection.createStatement();
      ResultSet rs=  st.executeQuery("SELECT * FROM demo");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + rs.getString(2));
        }
        rs.close();
        st.close();
        connection.close();

    }
}
