package Classes;

import Abstract.Decorator;
import Interfaces.Observable;
import Interfaces.Observer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.sql.ResultSet;

@Setter
@Getter
@NoArgsConstructor
public class Pizza implements Observable {

    protected int number;

    protected String name;

    protected int price;

    protected int diameter;

    DataNode datanode;

    Decorator decorator;

    private Collection<Observer> observerCollection = new ArrayList<>();

    public Pizza(int number, String name, int price, int diameter) {
        this.setNumber(number);
        this.setName(name);
        this.setPrice(price);
        this.setDiameter(diameter);
        //log
    }

    @Override
    public void Add(Observer observer) {
        this.observerCollection.add(observer);
    }

    @Override
    public void Remove(Observer observer) {
        this.observerCollection.remove(observer);
    }

    @Override
    public void Notify() {
        for (Observer o : this.observerCollection) {
            o.update();
        }
    }

    public static Pizza[] GetPizza(){
        Pizza[] temp = null;
        try {
            List<Pizza> helper = new ArrayList<>();
            Connection conn = DataNode.getConnection();
            String query = "SELECT * FROM pizza";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Pizza actual = new Pizza(rs.getInt("number"),rs.getString("name"), rs.getInt("price"), rs.getInt("diameter"));
                helper.add(actual);
            }
            conn.close();
            temp = new Pizza[helper.size()];
            helper.toArray(temp);
        } catch (SQLException e) {
            //log
        }
        catch (Exception ex){
            //log
        }
        return temp;
    }
    
    public static void AddPizza(String name, int price, int diameter){
        try {
            Connection conn = DataNode.getConnection();
            String query = "INSERT INTO pizza (name, price, diameter) VALUES (?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,name);
            st.setInt(2,price);
            st.setInt(3,diameter);
            st.execute();
            conn.close();
         } catch (SQLException e) {
            //log + window
         }
    }

    @Override
    public String toString() {
        return number + " " + name + " " + name + " " + price + " Ft " + " " + diameter + " cm ";
    }
}
