package Classes;

import Interfaces.Observer;

import java.sql.*;

public class DataNode implements Observer {

   public static Connection getConnection() throws SQLException {
      String jdbcURL = "jdbc:mysql://localhost:3306/pizza";
      String username = "ROOT";
      String password = "ROOT";
      Connection connection =  DriverManager.getConnection(jdbcURL, username, password);;
      return connection;
   }

   @Override
   public void update() {
      //main window lista frissítés
   }

   public void Log(){

   }

}

