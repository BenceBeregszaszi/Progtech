package Classes;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeliveriesTest {

    @Test
    void read() {
        List<Deliveries> expected = new ArrayList<>();
        List<Deliveries> actual = new ArrayList<>();
        try {
            Connection conn = DataNode.getConnection();
            String query = "SELECT * FROM delivery";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Deliveries temp = new Deliveries(rs.getInt("delivery_id"), rs.getString("location"), rs.getString("name"));
                expected.add(temp);
            }
        }catch (Exception e) {
            LoggerClass.ExceptionLog(e.getMessage());
        }
        Deliveries[] helper = Deliveries.Read();
        for (int i = 0; i < helper.length; i++) {
            actual.add(helper[i]);
        }
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(actual.get(i).getName(), expected.get(i).getName());
        }

    }

    @Test
    void setDelivery_id() {
        Deliveries actual = new Deliveries(1,"Eger", "Teletál");
        int expected = 1;
        assertEquals(expected, actual.delivery_id);
    }

    @Test
    void setLocation() {
        Deliveries actual = new Deliveries(1,"Eger", "Teletál");
        String expected = "Eger";
        assertEquals(expected, actual.location);
    }

    @Test
    void setName() {
        Deliveries actual = new Deliveries(1,"Eger", "Teletál");
        String expected = "Teletál";
        assertEquals(expected, actual.name);
    }
}
