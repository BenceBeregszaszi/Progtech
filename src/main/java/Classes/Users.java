package Classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

    public void Create(String username, String password) {
        try {
            Connection conn = DataNode.getConnection();
            Statement st = conn.createStatement();
            String query = "INSERT INTO users VALUES (%s, %s 0)".formatted(username, password);
            st.execute(query);
            conn.close();
        } catch (SQLException e) {
            //log
        }
    }


    public void Delete(String username) {
        try {
            Connection conn = DataNode.getConnection();
            Statement st = conn.createStatement();
            String query = "DELETE FROM users WHERE username = %s".formatted(username);
            st.execute(query);
            conn.close();
        } catch (SQLException e) {
            //log
        }
    }
    public static Users Login(){
        Users user = new Users("Valami", "Valami", 1);
        return user;
    }
}
