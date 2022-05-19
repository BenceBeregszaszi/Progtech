package Classes;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.*;

class DataNodeTest {

    @Test
    void getConnection() {
        Connection expected = null;
        Connection actual = null;
        try {
            String jdbcURL = "jdbc:mysql://localhost:3306/pizza";
            String username = "ROOT";
            String password = "ROOT";
            expected  =  DriverManager.getConnection(jdbcURL, username, password);
            actual = DataNode.getConnection();
            }
        catch (Exception e) {
            LoggerClass.ExceptionLog(e.getMessage());
        }
   assertEquals(expected.getClass(), actual.getClass());
    }
}
