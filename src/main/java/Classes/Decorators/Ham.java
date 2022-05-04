
   
package Classes.Decorators;

import Abstract.Decorator;
import Classes.Pizza;

public class Ham  extends Decorator {

    Pizza pizza;

    public Ham(Pizza pizza){
        this.pizza=pizza;
    }

    @Override
    protected String getname() {
        return pizza.getName() + "Sonkával";
    }

    @Override
    protected int getdiameter() {
        return pizza.getDiameter();
    }

    @Override
    protected int getcost() {
        return pizza.getPrice() + decorator_price;
    }
}
