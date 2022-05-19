
   
package Classes.Decorators;

import Abstract.Decorator;
import Classes.Pizza;

public class Salami  extends Decorator {

    Pizza pizza;

    public Salami(Pizza pizza){
        this.pizza=pizza;
        topping = 3;
    }

    @Override
    protected String getname() {
        return pizza.getName() + "Szalámi";
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
