package mfs.sql;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;

class SQLConnectionTest {

	Connection connection;

    @Test
    public void connectTest() throws SQLException, IOException {
    	connection = SQLConnection.getConnection();
        assertTrue(connection.isValid(10));
    }
    
    @Test
    public void closeTest() throws SQLException, IOException {
    	connection = SQLConnection.getConnection();
        SQLConnection.closeConnection(connection);
        assertTrue(connection.isClosed());
    }

}
