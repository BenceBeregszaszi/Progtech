package Classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Toppings {

    int toppings_id;

    String name;

    int price;


    public static void Create(String name, int price){
        try {
            Connection conn = DataNode.getConnection();
            String query = "INSERT INTO toppings VALUES (?, ?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,name);
            st.setInt(2,price);
            st.execute();
            conn.close();
            //log
        } catch (SQLException e) {
            //log
        }
    }

    public void Delete(){
        //log
    }
}
