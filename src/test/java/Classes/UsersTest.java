package Classes;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.*;


class UsersTest {

    @Test
    void login() {
        Users actual = Users.Login("admin", "admin");
        Users expected = null;
        try {
            Connection conn = DataNode.getConnection();
            String query = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,"admin");
            st.setString(2,"admin");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                expected = new Users(rs.getString("username"), rs.getString("password"), rs.getInt("position_id"));
            }
            conn.close();
        }
        catch (Exception e){
       LoggerClass.ExceptionLog(e.getMessage());
   }
    assertEquals(expected.getUsername(), actual.getUsername());
}

    }

    @Test
    void setUsername() {
        String expected = "admin";
        Users actual = new Users("admin", "admin", 1);
        assertEquals(expected, actual.getUsername());
    }

    @Test
    void setPassword() {
        String expected = "admin";
        Users actual = new Users("admin", "admin", 1);
        assertEquals(expected, actual.getPassword());
    }

    @Test
    void setPosition_id() {
        int expected = 1;
        Users actual = new Users("admin", "admin", 1);
        assertEquals(expected, actual.getPosition_id());
    }
}
