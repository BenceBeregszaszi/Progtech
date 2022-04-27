package Interfaces;

public interface Observable {

    void Add(Observer observer);

    void Remove(Observer observer);

    void Notify();
}
