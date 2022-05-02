package Classes;

import java.util.List;
import java.util.logging.Logger;

public class Users {

    public Users(String Username, String Password, int Position_id){
        this.setUsername(Username);
        this.setPassword(Password);
        this.setPosition_id(Position_id);
    }

    private String username;

    private String password;

    private int position_id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    private List<Users> usersList;
}
