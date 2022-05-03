package Classes;

import Interfaces.Observer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataNode implements Observer, Display {

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
   
   @Override
   public void display() {
 
   }

}

