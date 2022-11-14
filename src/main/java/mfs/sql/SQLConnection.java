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
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	// load info from hidden file
	private Properties loadProps() throws IOException {
		Properties props = new Properties();
		FileInputStream in = new FileInputStream(".dbconfig.properties");
		props.load(in);
		in.close();
		return props;
	}
	
	// get URL from hidden file then establish connection to db
	public java.sql.Connection getConnection() throws IOException {
		String url = getURL();
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public String getURL() throws IOException {
		Properties props = loadProps();
		String url = props.getProperty("db.url");
		String username = props.getProperty("db.username");
		String password = props.getProperty("db.password");
		String fullURL = url + "user=" + username + ";password=" + password + ";";

		return fullURL;
	}

	// *****methods for execute SQL commands*****
	public Statement getStatement() throws SQLException {
		stmt = conn.createStatement();
		return ps;
	}

	public ResultSet getResultSet(String query) throws SQLException {
		rs = stmt.executeQuery(query);
		return rs;
	}

	// ******Closes*****
	public void closeEverything() {
		if (rs != null) {
			try {
				closeResult();
			} catch (Exception e) {
				// Ignore
			}
		}
		if (stmt != null) {
			try {
				closeStatment();
			} catch (Exception e) {
				// Ignore
			}
		}
		if (conn != null) {
			try {
				closeConnection();
			} catch (Exception e) {
				// Ignore
			}
		}
	}

	public static void closeResult() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
	}

	public static void closePreparedStatement() {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
			}
		}
	}

	public void closeStatment() {
		if (stmt != null) {
			try {
				ps.close();
			} catch (SQLException e) {
			}
		}
	}

	public void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

}
