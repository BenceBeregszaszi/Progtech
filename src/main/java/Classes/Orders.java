package Classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
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


    List<Orders> ordersList;

    public List<Orders> Read(){
        return null;
    }


    public void Delete(){
        //log
    }

    public void Add(){
        //log
    }
}