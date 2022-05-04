package Classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.*;

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
            String query = "INSERT INTO delivery VALUES (?, ?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,location);
            st.setString(2,name);
            st.execute();
            conn.close();
          } catch (SQLException e) {
               //log
          }
    }

    public void Delete(){
        //log
    }
}
