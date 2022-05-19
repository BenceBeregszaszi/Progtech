package Classes;


import java.sql.*;

public class DataNode {

   public static Connection getConnection() throws SQLException {
      String jdbcURL = "jdbc:mysql://localhost:3306/pizza";
      String username = "ROOT";
      String password = "ROOT";
      Connection connection =  DriverManager.getConnection(jdbcURL, username, password);;
      return connection;
   }

}

