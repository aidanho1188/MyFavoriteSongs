package mfs.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLEngine {
	private static Connection tempConn = null;
	private static Statement stmt = null;
	
	public static void main(String[] args) throws SQLException, IOException {
		SQLConnection con = new SQLConnection();
		SQLUpdater updater = new SQLUpdater();
		SQLRetriever retrieve = new SQLRetriever();
		ResultSet rs = null;
		String input = "'user_name','user_password'"; // can change input whenevers
		
		setUpStatement(con);
		sendInput(input, updater);
		getResult(rs, retrieve); // get and print result
        // reset table
		stmt.executeUpdate("TRUNCATE TABLE accounts;");
		con.resetTable(con.getConn());
	}
	
	public boolean verifyUser(String username) throws IOException, SQLException {
		SQLConnection con = new SQLConnection();
		SQLRetriever retrieve = new SQLRetriever();
		ResultSet rs = null;
		String SQL = "username";
		boolean isExisted = false;
		
		setUpStatement(con);
		rs = stmt.executeQuery(retrieve.SQLRetrieve(SQL));
		 while (rs.next()) {
			 	if(rs.getString(SQL).equals(username)) {
			 		isExisted = true;
			 	}
	        }
		return isExisted;
	}
	
	public boolean verifyUserPassword(String username, String password) throws SQLException, IOException {
		SQLConnection con = new SQLConnection();
		SQLRetriever retrieve = new SQLRetriever();
		ResultSet rs = null;
		String SQL = "password";
		boolean isExisted = false;
		
		setUpStatement(con);
		rs = stmt.executeQuery(retrieve.SQLRetrieveUserInfo(username,password));
		if(rs.equals(0)) {
			isExisted = true;
		}
		return isExisted;
	}
	
	public void addUser(String username, String password) throws SQLException, IOException {
		SQLConnection con = new SQLConnection();
		SQLUpdater updater = new SQLUpdater();
		String input = "'"+username+"','"+password+"'";
		
		setUpStatement(con);
		sendInput(input, updater);
		
	}
	
	// Initiate statement 
	public static void setUpStatement(SQLConnection con) throws IOException, SQLException {
		// set up connection/statement
		tempConn = con.getConnection();
		con.setConn(tempConn);
		stmt = con.getStatement(tempConn);
	}
	
	public static void sendInput(String input, SQLUpdater updater) throws SQLException {
		// send input
		stmt.executeUpdate(updater.SQLInsert("username,password", input));
	}
	
	public static void getResult(ResultSet rs, SQLRetriever retrieve) throws SQLException {
		 rs = stmt.executeQuery(retrieve.SQLRetrieve("*"));
		 while (rs.next()) {
			 	System.out.println(rs.getString("username") + " " + rs.getString("password"));
	        }
	}
}
