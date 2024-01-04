package mfs.sql;

/*
 * Retrieve data from SQL database from given strings(of what to retrieve)
 */

public class SQLRetriever {

	public String SQLRetrieve(String whatToSelect) {
		return "SELECT " + whatToSelect + " FROM accounts";
	}
	
	public String SQLRetrieveUserInfo(String username, String password) {
		return "SELECT * FROM accounts WHERE username =" + username + " AND password=" + password;
	}
}
