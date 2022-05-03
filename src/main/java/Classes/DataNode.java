package Classes;

import Interfaces.Observer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataNode implements Observer {

   public static Connection getConnection() throws SQLException {
      String jdbcURL = "jdbc:mysql://localhost:3306/pizza";
      String username = "ROOT";
      String password = "ROOT";
      Connection connection;
      return connection = DriverManager.getConnection(jdbcURL, username, password);
   }

   @Override
   public void update() {

   }
}

