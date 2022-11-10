package mfs.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class SQLConnection {
	public static Connection con;
	
	public static Connection getConnection() throws IOException {
		return con;
	}

	public static void closeConnection(Connection connection) {
		connection = null;
		
	}

    public static void closePreparedStatement(PreparedStatement preStatment) {
    	// close preStatment
    	preStatment = null;
    }

    public static void closeStatement(Statement stmt) {
    	// TODO close statment
    	stmt = null;
    }
}
