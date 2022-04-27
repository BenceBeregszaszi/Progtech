package Classes;

import Interfaces.Observable;
import Interfaces.Observer;

import java.util.ArrayList;
import java.util.Collection;

public class Pizza implements Observable {

    protected int number;

    protected String name;

    protected int price;

    protected int diameter;

    //DataNode datanode;

    private Collection<Observer> observerCollection = new ArrayList<>();

    @Override
    public void Add(Observer observer) {
        this.observerCollection.add(observer);
    }

    @Override
    public void Remove(Observer observer) {
        this.observerCollection.remove(observer);
    }

    @Override
    public void Notify() {
        for (Observer o : this.observerCollection) {
            o.update();
        }
    }

    public Pizza GetPizza(){
        return this;
    }

}
