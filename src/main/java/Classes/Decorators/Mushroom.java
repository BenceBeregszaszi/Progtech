
   
package Classes.Decorators;

import Abstract.Decorator;
import Classes.Pizza;

public class Mushroom  extends Decorator {

    Pizza pizza;

    public Mushroom(Pizza pizza){
        this.pizza=pizza;
    }

    @Override
    protected String getname() {
        return pizza.getName() + "Gomba";
    }

    @Override
    protected int getdiameter() {
        return pizza.getDiameter();
    }

    @Override
    protected int getcost() {
        return pizza.getPrice() + decorator_price;
    }

    @Override
    public String toString() {
        return pizza.getNumber() + " " + this.getname() + " " + this.getcost() + " Ft " + pizza.getDiameter() + " cm";
    }
}
