package Classes;

import java.util.List;

public class Positions {

    public Positions(int position_id, String name) {
        this.setPosition_id(position_id);
        this.setName(name);
    }

    int position_id;

    String name;

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    List<Positions> positionsList;
}
