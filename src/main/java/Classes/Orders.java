package Classes;

import java.util.List;

public class Orders {

    public Orders(int order_id, int pizza_id, int topping_id, int delivery_id) {
        this.setOrder_id(order_id);
        this.setPizza_id(pizza_id);
        this.setTopping_id(topping_id);
        this.setDelivery_id(delivery_id);
    }


    int order_id;

    int pizza_id;

    int topping_id;

    int delivery_id;

    public int getTopping_id() {
        return topping_id;
    }

    public void setTopping_id(int topping_id) {
        this.topping_id = topping_id;
    }

    public int getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(int delivery_id) {
        this.delivery_id = delivery_id;
    }

    public int getPizza_id() {
        return pizza_id;
    }

    public void setPizza_id(int pizza_id) {
        this.pizza_id = pizza_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    List<Orders> ordersList;

    public List<Orders> Read(){
        return null;
    }

    public void Create(){
        //log
    }

    public void Delete(){
        //log
    }
}