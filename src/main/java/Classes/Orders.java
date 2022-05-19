package Classes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class Orders {
    
    public Orders(int order_id, String pizzaName, String toppingName, String delivery_name, String username, int fullPrice) {
        this.setOrder_id(order_id);
        this.setPizzaName(pizzaName);
        this.setToppingName(toppingName);
        this.setDelivery_name(delivery_name);
        this.setUsername(username);
        this.setFullPrice(fullPrice);
    }

    int order_id;

    String pizzaName;

    String toppingName;

    String delivery_name;

    String username;

    int fullPrice;

    public static Orders[] Read(){
        Orders[] temp = null;
        try {
            List<Orders> helper = new ArrayList<>();
            Connection conn = DataNode.getConnection();
            String query = "select order_id as orderId,  p.name as pizzaName,t.name as toppingName,d.name as deliveryName, u.username as userName, p.price+t.price as fullPrice from orders\n" +
               "inner join pizzas p on orders.pizza_id = p.number\n" +
               "inner join toppings t on orders.topping_id = t.toppings_id\n" +
               "inner join delivery d on orders.delivery_id = d.delivery_id\n" +
               "inner join users u on orders.user_id = u.username";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Orders actual = new Orders(rs.getInt("orderId"), rs.getString("pizzaName"), rs.getString("toppingName"), rs.getString("deliveryName"), rs.getString("userName"), rs.getInt("fullPrice"));
                helper.add(actual);
            }
            conn.close();
            temp = new Orders[helper.size()];
            helper.toArray(temp);
        } catch (SQLException e) {
            LoggerClass.ExceptionLog(e.getMessage());
        }
        return temp;
    }




    public static void Delete(int order_id){
        try {
            Connection conn = DataNode.getConnection();
            String query = "DELETE FROM orders WHERE order_id = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1,order_id);
            st.execute();
            conn.close();
        } catch (Exception e) {
            LoggerClass.ExceptionLog(e.getMessage());
        }
        LoggerClass.OrdersDeleteLog(order_id);
    }

    public void Add(){
        //log
    }
    
    @Override
    public String toString() {
        return getOrder_id() + " " + getPizzaName() + " " + getToppingName() + " " + getDelivery_name() + " " + getUsername() + " " + getFullPrice() + " Ft";
    }

}
