package Interfaces;

import java.sql.SQLException;

public interface Observable {

    void Add(Observer observer);

    void Remove(Observer observer);

    void Notify() throws SQLException;
}
