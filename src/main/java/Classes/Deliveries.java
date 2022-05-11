package Classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Deliveries {

    int delivery_id;

    String location;

    String name;


    public static void Create(String location, String name){
        try {
            Connection conn = DataNode.getConnection();
            String query = "INSERT INTO delivery(location, name) VALUES (?, ?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,location);
            st.setString(2,name);
            st.execute();
            conn.close();
          } catch (SQLException e) {
               LoggerClass.ExceptionLog(e.getMessage());
          }
        LoggerClass.DeliveriesCreateLog(location, name);
    }

    public static void Delete(String name){
        try {
            Connection conn = DataNode.getConnection();
            String query = "DELETE FROM delivery WHERE name = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,name);
            st.execute();
            conn.close();
        } catch (Exception e) {
            LoggerClass.ExceptionLog(e.getMessage());
        }
        LoggerClass.DeliveriesDeleteLog(name);
    }
    public static Deliveries[] ReadDeliveries() {
      Deliveries[] temp = null;
      try {
       List<Deliveries> helper = new ArrayList<>();
       Connection conn = DataNode.getConnection();
       String query = "SELECT * FROM delivery";
       Statement st = conn.createStatement();
       ResultSet rs = st.executeQuery(query);
       while (rs.next()) {
           Deliveries actual = new Deliveries(rs.getInt("delivery_id"), rs.getString("location"), rs.getString("name"));
           helper.add(actual);
       }
       conn.close();
       temp = new Deliveries[helper.size()];
       helper.toArray(temp);
     } catch (SQLException e) {
       LoggerClass.ExceptionLog(e.getMessage());
   }
   return temp;
}

    @Override
    public String toString() {
        return getLocation() +"-"+ getName();
    }
}
