package mfs.engine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;

public class MFSEngine {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

		MFSEngine.getConnection();
		System.out.print(getConnection().isValid(10));

	}
	
	public static Connection getConnection() throws IOException {
		// Create a variable for the connection string.
//		private ResourceBundle reader = null;
		Connection con = null;
		Properties props = new Properties();
		FileInputStream in = new FileInputStream(".dbconfig.properties");
		props.load(in);
		in.close();

		String url = props.getProperty("db.url");
		String username = props.getProperty("db.username");
		String password = props.getProperty("db.password");
		try {
//		     reader = ResourceBundle.getBundle("dbconfig.properties");
			con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			String SQL = "SELECT * FROM accounts";

			ResultSet rs = stmt.executeQuery(SQL);

			// Iterate through the data in the result set and display it.
//            while (rs.next()) {
//			System.out.println(rs.getString("username") + " " + rs.getString("password"));
//            }
			System.out.println(con);
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
