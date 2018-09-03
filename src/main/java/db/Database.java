package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.naming.NamingException;



public class Database {
	
	
	private static Connection connection;
    
	/**
	 * Connessione al database
	 * 
	 * @throws javax.naming.NamingException
	 * @throws java.sql.SQLException
	 * @throws ClassNotFoundException 
	 */
	public static void connect() throws NamingException, SQLException, ClassNotFoundException {
		String driverName = "com.mysql.cj.jdbc.Driver";
	    Class.forName(driverName);

	    String serverName = "localhost";
	    String mydatabase = "digitallibrary?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    
	    String url = "jdbc:mysql://" + serverName + "/" + mydatabase; 

	    String username = "root";
	    String password = "root";
	    connection = DriverManager.getConnection(url, username, password);
	}

	/**
	 * Chiusura connessione al database
	 * 
	 * @throws java.sql.SQLException
	 */
	public static void close() throws SQLException {
		if (Database.connection == null) {
			throw new SQLException();
		}
		Database.connection.close();
	}

	/**
	 * Metodi con query secche
	 * 
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public static List<Map<String, Object>> select(String query) throws SQLException {
		return Database.executeQuery(query);
	}

	public static void insert(String query) throws SQLException {
		Database.updateQuery(query);
	}

	public static void update(String query) throws SQLException {
		Database.updateQuery(query);
	}

	public static void delete(String query) throws SQLException {
		Database.updateQuery(query);
	}

	public static Long count(String query) throws SQLException {
		
		// Esecuzione query
		List<Map<String, Object>> recordList = Database.executeQuery(query);
		if (recordList.isEmpty()) {
			return 0L;
		}
		// Restituzione del risultato
		return (Long) recordList.get(0).get("NUM");
	}

	/**
	 * Metodi con nome tabella e condizione
	 * 
	 * @param table
	 * @param condition
	 * @return
	 * @throws SQLException
	 */
	public static List<Map<String, Object>> select(String table, String condition) throws SQLException {
		return Database.select(table, condition, null);
	}

	public static void delete(String table, String condition) throws SQLException {
		// Generazione query
		String query = "DELETE FROM " + table + " WHERE " + condition + ";";
		// Esecuzione query
		Database.delete(query);
	}

	public static Long count(String table, String condition) throws SQLException {
		// Generazione query
		String query = "SELECT COUNT(*) AS NUM FROM " + table + " WHERE " + condition + ";";
		// Esecuzione query
		return Database.count(query);
	}

	/**
	 * Metodi con tabella e map
	 * 
	 * @param table
	 * @param bean
	 * @return
	 * @throws SQLException
	 */

	public static List<Map<String, Object>> select(String table, Map<String, Object> data) throws SQLException {
		// Esecuzione query
		return Database.select(table, createANDCondition(data));
	}
	
	public static void insert(String table, List<Map<String, Object>> data) throws SQLException {
		// Generazione query
		String listColumn = String.join(", ", data.get(0).keySet());
		int counter = 1;
		StringBuilder valueList = new StringBuilder();
		for (Map<String, Object> current : data) {
			valueList.append("(" + String.join(", ", objectListToString(new ArrayList<Object>(current.values())) ) + ")");
			if (data.size() != counter) {
				valueList.append(",");
				counter++;
			}
		}
		String query = "INSERT INTO " + table + " ( " + listColumn + ") " + " VALUES " + valueList.toString() + ";";
		// Esecuzione query
		Database.insert(query);
	}

	public static void update(String table, Map<String, Object> data, Map<String, Object> condition) throws SQLException {
		// Generazione query
		String query = "UPDATE " + table + " SET " + concatMapWithSeparator(data, ",") + " WHERE " + concatMapWithSeparator(condition, "AND") + ";";
		// Esecuzione query
		Database.update(query);
	}

	public static void delete(String table, Map<String, Object> data) throws SQLException {
		// Esecuzione query
		Database.delete(table, createANDCondition(data));
	}

	public static Long count(String table, Map<String, Object> data) throws SQLException {
		// Esecuzione query
		return Database.count(table, createANDCondition(data));
	}
	
	/**
	 * Metodi con tabella, map e ordinamento
	 * 
	 * @param table
	 * @param bean
	 * @return
	 * @throws SQLException
	 */
	
	public static List<Map<String, Object>> select(String table, String condition, String orderBy) throws SQLException {
		// Generazione query
		String query = "SELECT * FROM " + table;
		if (condition != null) {
			query += " WHERE " + condition;
		}
		
		if (orderBy != null) {
			query += " ORDER BY " + orderBy;
		}
		// Esecuzione query
		return Database.select(query);
	}
	
	public static List<Map<String, Object>> select(String table, Map<String, Object> data, String orderBy) throws SQLException {
		// Esecuzione query
		return Database.select(table, createANDCondition(data), orderBy);
	}

	/**
	 * METODI DI SUPPORTO
	 */

	/**
	 * executeQuery personalizzata
	 * 
	 * @param query
	 *            query da eseguire
	 */
	private static List<Map<String, Object>> executeQuery(String query) throws SQLException {
		
		if (Database.connection == null) {
			throw new SQLException();
		}
	
		Statement s1 = Database.connection.createStatement();
		ResultSet records = s1.executeQuery(query);
		List<Map<String, Object>> recordList = resultSetToArrayList(records);
		s1.close();
		records.close();
		
		return recordList;

	}

	/**
	 * updateQuery personalizzata
	 * 
	 * @param query
	 *            query da eseguire
	 */
	private static void updateQuery(String query) throws SQLException {
		if (Database.connection == null) {
			throw new SQLException();
		}
		Statement s1 = Database.connection.createStatement();
		s1.executeUpdate(query);
		s1.close();
	}

	private static List<Map<String, Object>> resultSetToArrayList(ResultSet rs) throws SQLException {
		
		ResultSetMetaData md = rs.getMetaData();
		int columns = md.getColumnCount();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		while (rs.next()) {
			Map<String, Object> row = new HashMap<String, Object>();
			for (int i = 1; i <= columns; ++i) {
				row.put(md.getColumnName(i), rs.getObject(i));
			}
			list.add(row);
		}

		return list;
	}

	private static String concatMapWithSeparator(Map<String, Object> map, String separator) {
		StringBuilder condition = new StringBuilder();

		int counter = 1;
		for (String column : map.keySet()) {
			Object value = map.get(column);
			if (value instanceof Integer) {
				condition.append(column + " = " + value);
			} else if (value instanceof java.util.Date) {
				// In caso di Date delle libreria java.util, � necessario convertirla in una
				// Date della libreria java.sql
				Date sqlDate = new Date(((java.util.Date) value).getTime());
				condition.append(column + " = \"" + sqlDate + "\"");
			} else {
				condition.append(column + " = \"" + value + "\"");
			}
			// Se non � l'ultimo elemento, aggiungi separatore
			if (map.size() != counter) {
				condition.append(" " + separator + " ");
			}

			counter++;
		}

		return condition.toString();
	}
	
	private static List<String> objectListToString(List<Object> valueList) {
		List<String> stringList = new ArrayList<String>();
	
		for (int i = 0; i < valueList.size(); i++) {
			Object value = valueList.get(i);
			String valueString = null;
			if (value instanceof Integer) {
				valueString = value.toString();
			} else if (value instanceof java.util.Date) {
				// In caso di Date delle libreria java.util, � necessario convertirla in una
				// Date della libreria java.sql
				Date sqlDate = new Date(((java.util.Date) value).getTime());
				valueString = "\"" + sqlDate.toString() + "\"";
			} else {
				valueString = "\"" + value.toString() + "\"";
			}
			stringList.add(valueString);
		}

		return stringList;
	}

	private static String createANDCondition(Map<String, Object> map) {
		if (map.isEmpty()) {
			// If map is empty, return all records
			return null;
		}
		return concatMapWithSeparator(map, "AND");
	}

}
