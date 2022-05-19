package Classes;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrdersTest {

    @Test
    void read() {
        List<Orders> expected = new ArrayList<>();
        List<Orders> actual = new ArrayList<>();
        try {
            Connection conn = DataNode.getConnection();
            String query = "select order_id as orderId,  p.name as pizzaName,t.name as toppingName,d.name as deliveryName, u.username as userName, p.price+t.price as fullPrice from orders\n" +
                    "inner join pizzas p on orders.pizza_id = p.number\n" +
                    "inner join toppings t on orders.topping_id = t.toppings_id\n" +
                    "inner join delivery d on orders.delivery_id = d.delivery_id\n" +
                    "inner join users u on orders.user_id = u.username";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Orders temp = new Orders(rs.getInt("orderId"), rs.getString("pizzaName"), rs.getString("toppingName"), rs.getString("deliveryName"), rs.getString("userName"), rs.getInt("fullPrice"));
                expected.add(temp);
            }
        }catch (Exception e ){
            LoggerClass.ExceptionLog(e.getMessage());
        }
        Orders[] helper = Orders.Read();
        for (int i = 0; i < helper.length; i++) {
            actual.add(helper[i]);
        }
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(actual.get(i).getOrder_id(), expected.get(i).getOrder_id());
        }
    }

    @Test
    void setOrder_id() {
        Orders actual = new Orders();
        actual.setOrder_id(1);
        int expected = 1;
        assertEquals(expected, actual.getOrder_id());
    }

    @Test
    void setPizzaName() {
        Orders actual = new Orders();
        actual.setPizzaName("Erős");
        String expected = "Erős";
        assertEquals(expected, actual.getPizzaName());
    }

    @Test
    void setToppingName() {
        Orders actual = new Orders();
        actual.setToppingName("Paprikás");
        String expected = "Paprikás";
        assertEquals(expected, actual.getToppingName());
    }

    @Test
    void setDelivery_name() {
        Orders actual = new Orders();
        actual.setDelivery_name("Erőd");
        String expected = "Erőd";
        assertEquals(expected, actual.getDelivery_name());
    }

    @Test
    void setUsername() {
        Orders actual = new Orders();
        actual.setUsername("admin");
        String expected = "admin";
        assertEquals(expected, actual.getUsername());
    }

    @Test
    void setFullPrice() {
        Orders actual = new Orders();
        actual.setFullPrice(2000);
        int expected = 2000;
        assertEquals(expected, actual.getFullPrice());
    }
}