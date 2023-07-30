package logico;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
	public static Connection sqlConnection;
	
	public static void connect() {
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String IP = "192.168.100.118";
		String DB = "BolsaLaboral_G3";
		String URL = "jdbc:sqlserver://;serverName=" + IP + ";databaseName=" + DB + ";trustServerCertificate=true"; 

		DriverManager.setLoginTimeout(5);
		
		try {
			sqlConnection = DriverManager.getConnection(URL, "bolsag3_admin", "Admin!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
