package Classes;

import java.sql.*;
import java.util.List;


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

    public static void Create(String username, String password) {
        try {
            Connection conn = DataNode.getConnection();
            String query = "INSERT INTO users VALUES (?, ?, 1)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,username);
            st.setString(2,password);
            st.execute();
            conn.close();
            Login(username,password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
    public static Users Login(String username, String password){
        Users user = null;
        try{
            Connection conn = DataNode.getConnection();
            String query = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,username);
            st.setString(2,password);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                user = new Users(rs.getString("username"), rs.getString("password"), rs.getInt("position_id"));
            }
        }catch(SQLException e) {
            //log
            System.out.println(e.getMessage());
        }
        return user;
    }
}
