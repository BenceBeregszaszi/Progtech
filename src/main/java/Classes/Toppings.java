package Classes;

import java.util.List;

public class Toppings {
    public Toppings(int toppings_id, String name, int price){
        setToppings_id(toppings_id);
        setName(name);
        setPrice(price);
    }

    int toppings_id;

    String name;

    int price;

    public int getToppings_id() {
        return toppings_id;
    }

    public void setToppings_id(int toppings_id) {
        this.toppings_id = toppings_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Toppings> Read(){
        return null;
    }

    public void Create(){
        //log
    }

    public void Delete(){
        //log
    }
}
