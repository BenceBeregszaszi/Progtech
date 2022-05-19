package Classes;

import Abstract.Decorator;
import Classes.Decorators.Corn;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {


    @Test
    void setNumber() {
        Pizza actual = new Pizza();
        actual.setNumber(1);
        int expected = 1;
        assertEquals(expected, actual.getNumber());
    }

    @Test
    void setName() {
        Pizza actual = new Pizza();
        actual.setName("Songoku");
        String expected = "Songoku";
        assertEquals(expected, actual.getName());
    }

    @Test
    void setPrice() {
        Pizza actual = new Pizza();
        actual.setPrice(1500);
        int expected = 1500;
        assertEquals(expected, actual.getPrice());
    }

    @Test
    void setDiameter() {
        Pizza actual = new Pizza();
        actual.setDiameter(30);
        int expected = 30;
        assertEquals(expected, actual.getDiameter());
    }

    @Test
    void setTopping() {
        Pizza actual = new Pizza();
        actual.setTopping(1);
        int expected = 1;
        assertEquals(expected, actual.getTopping());
    }


    @Test
    void setDecorator() {
        Pizza actual = new Pizza();
        Decorator d = new Corn(new Pizza(1,"Sonkás", 2000, 30));
        actual.setDecorator(d);
        Decorator expected = new Corn(new Pizza(1,"Sonkás", 2000, 30));
        assertEquals(expected.getName(), actual.getName());
    }


    @Test
    void getPizza() {
        List<Pizza> expected = new ArrayList<>();
        List<Pizza> actual = new ArrayList<>();
        try {
            Connection conn = DataNode.getConnection();
            String query = "SELECT * FROM pizzas";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Pizza temp = new Pizza(rs.getInt("number"),rs.getString("name"), rs.getInt("price"), rs.getInt("diameter"));
                expected.add(temp);
            }
        }catch (Exception e){
            LoggerClass.ExceptionLog(e.getMessage());
        }
        Pizza[] helper = Pizza.GetPizza();
        for (int i = 0; i < helper.length; i++) {
            actual.add(helper[i]);
        }
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(actual.get(i).getName(), expected.get(i).getName());
        }
    }
}