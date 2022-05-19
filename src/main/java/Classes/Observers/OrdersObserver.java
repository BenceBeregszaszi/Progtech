package Classes.Observers;

import Abstract.Decorator;
import Classes.DataNode;
import Classes.LoggerClass;
import Classes.Toppings;
import Interfaces.Observer;
import com.mysql.cj.log.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdersObserver implements Observer {

   Decorator decorator;
   String user_id;
   String delivery_id;

   public OrdersObserver(Decorator decorator, String user_id, String delivery_id){
      this.decorator = decorator;
      this.user_id = user_id;
      this.delivery_id = delivery_id;
   }

   @Override
   public void update() {
      try {
         Connection conn = DataNode.getConnection();
         String query = "INSERT INTO orders (pizza_id, topping_id, delivery_id, user_id) VALUE (?, ?, ?, ?)";
         PreparedStatement st = conn.prepareStatement(query);
         st.setInt(1, this.decorator.pizza_number);
         st.setInt(2, decorator.topping);
         st.setInt(3, Integer.parseInt(delivery_id));
         st.setString(4, user_id);
         st.execute();
         conn.close();
      } catch (Exception e){
         LoggerClass.ExceptionLog(e.getMessage());
      }
   }

   private int readDelivery(String name){
      int temp = 0;
      try {
         Connection c = DataNode.getConnection();
         PreparedStatement st = c.prepareStatement("SELECT delivery_id FROM delivery WHERE name = ?");
         st.setString(1,name);
         ResultSet rs = st.getResultSet();
         temp = rs.getInt("delivery_id");
      } catch (Exception e) {
         LoggerClass.ExceptionLog(e.getMessage());
      }
      return temp;
   }

   private int readTopping(String name){
      int temp = 0;
      try {
         Connection c = DataNode.getConnection();
         PreparedStatement st = c.prepareStatement("SELECT toppings_id FROM toppings WHERE name = ?");
         st.setString(1,name);
         ResultSet rs = st.getResultSet();
         temp = rs.getInt("toppings_id");
      } catch (Exception e) {
         LoggerClass.ExceptionLog(e.getMessage());
      }
      return temp;
   }
}
