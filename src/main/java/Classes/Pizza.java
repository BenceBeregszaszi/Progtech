package Classes;

import Interfaces.Observable;
import Interfaces.Observer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
            ResultSet rs = st.executeQuery("SELECT * FROM pizza");
            while (rs.next()) {
                Pizza temppizza = new Pizza();
                temppizza.setNumber(rs.getInt("number"));
                temppizza.setName(rs.getString("name"));
                temppizza.setPrice(rs.getInt("price"));
                temppizza.setDiameter(rs.getInt("diameter"));
                temp.add(temppizza);
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
