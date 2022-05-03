package Classes;

import java.util.List;

public class Deliveries {

    public Deliveries(int Delivery_id, String Location, String Name){
        this.setDelivery_id(Delivery_id);
        this.setLocation(Location);
        this.setName(Name);
    }

    int delivery_id;

    String location;

    String name;

    public int getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(int delivery_id) {
        this.delivery_id = delivery_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    List<Deliveries> deliveriesList;

    public List<Deliveries> Read(){
        return null;
    }

    public void Create(){
        //log
    }

    public void Delete(){
        //log
    }
}