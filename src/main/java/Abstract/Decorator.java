package Abstract;

import Classes.Pizza;

public abstract class Decorator extends Pizza {

   protected Pizza pizza;

   protected int decorator_price;

   protected abstract String getname();

   //protected abstract String getDescription();

   protected abstract int getdiameter();

   @Override
   public String toString() {
      return number + " " + name + " " + price + " Ft " + diameter + " cm";
   }

   protected abstract int getcost();

}
