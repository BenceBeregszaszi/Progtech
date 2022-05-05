package Classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Toppings {

    int toppings_id;

    String name;

    int price;

    public static Toppings[] getToppings(){
        Toppings[] temp = null;
        try {
            List<Toppings> helper = new ArrayList<>();
            Connection conn = DataNode.getConnection();
            String query = "SELECT * FROM toppings";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Toppings actual = new Toppings(rs.getInt("toppings_id"), rs.getString("name"), rs.getInt("price"));
                helper.add(actual);
            }
            conn.close();
            temp = new Toppings[helper.size()];
            helper.toArray(temp);
        } catch (SQLException e) {
            //log
        }
        catch (Exception ex){
            //log
        }
        return temp;
    }


    public static void Create(String name, int price){
        try {
            Connection conn = DataNode.getConnection();
            String query = "INSERT INTO toppings(name, price) VALUES (?, ?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,name);
            st.setInt(2,price);
            st.execute();
            conn.close();
            //log
        } catch (SQLException e) {
            //log
        }
        //log
    }

    @Override
    public String toString() {
        return name;
    }
}
