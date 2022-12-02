package mfs.sql;

/* 
 * Update SQL database from given inputs
 */

public class SQLUpdater {

	public String SQLInsert(String whatToInsert, String input) {
		return "INSERT INTO accounts (" + whatToInsert + ") VALUES ("+ input + ");";
	}

}
