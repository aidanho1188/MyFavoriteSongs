package mfs.sql;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class SQLConnection {
	public static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	public java.sql.Connection getConnection() throws IOException {
		Properties props = new Properties();
		FileInputStream in = new FileInputStream(".dbconfig.properties");
		props.load(in);
		in.close();
		String url = props.getProperty("db.url");
		String username = props.getProperty("db.username");
		String password = props.getProperty("db.password");
		try {
//		    reader = ResourceBundle.getBundle("dbconfig.properties");
			conn = DriverManager.getConnection(url, username, password);
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void closeEverything() {
		
	}
	
	public void closeConnection(){
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	
	

    public static void closePreparedStatement() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
    }

    public static void closeStatement() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
    }
}
