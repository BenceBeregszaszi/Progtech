package Abstract;

import Classes.Pizza;

public abstract class Decorator extends Pizza {

   protected Pizza pizza;

   protected abstract String getname();

   //protected abstract String getDescription();

   protected abstract int getdiameter();

   protected abstract int getcost();

}
