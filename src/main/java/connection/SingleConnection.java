package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	private static final String db = "jdbc:postgresql://localhost:5432/curso-jsp-2?autoReconnect=true";
	private static final String user = "postgres";
	private static final String password = "asbiredebob123";
	private static Connection connection = null;
	
	static {
		connect();
	}
	
	public SingleConnection() {
		connect();
	}
	
	private static void connect() {
		try {
			
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(db, user, password);
			connection.setAutoCommit(false);
			
			System.out.println("Database connected successfully.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}

}
