package Classes;

import Interfaces.Display;
import Interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class DataNode<T> implements Observer, Display {

   @Override
   public void update() {

   }

   @Override
   public void display() {

   }

   public List<T> Read() {
       List<T> temp = new ArrayList<>();
       return temp;
   }

   public void Create() {

   }

   public void Update() {

   }

   public void Delete() {

   }
}

