package Classes;

import Interfaces.Observable;
import Interfaces.Observer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.sql.ResultSet;

public class Pizza implements Observable {

    protected int number;

    protected String name;

    protected int price;

    protected int diameter;

    DataNode datanode;

    private Collection<Observer> observerCollection = new ArrayList<>();

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
    
    public List<Pizza> Read() {
        List<Pizza> temp = new ArrayList<>();
        try{
            Connection conn = DataNode.getConnection();
            Statement st = conn.createStatement();
            ResultsSet rs = st.executeQuery("SELECT * FROM pizza");
            while (rs.next()) {
                int number = rs.getInt("number");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int diameter = rs.getInt("diameter");
            }
        }catch(SQLException e) {
            //log
        }
        return temp;
    }

    public Pizza GetPizza(){
        return this;
    }

}
