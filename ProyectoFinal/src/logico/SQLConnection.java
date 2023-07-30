package logico;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import visual.Warning;

public class SQLConnection {
	public static Connection sqlConnection;
	
	public static void connect(String user, String password) {
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			System.out.println(DriverManager.drivers().toArray()[0].toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String IP = "192.168.100.118";
		String PORT = "1433";
		String DB = "BolsaLaboral_G3";
		String URL = "jdbc:sqlserver://" + IP + ":" + PORT + "/" + DB;
//		String URL = "jdbc:sqlserver://;serverName=192.168.100.118;databaseName=BolsaLaboral_G3";
		DriverManager.setLoginTimeout(1);
		
		try {
			System.out.println("Started");
			sqlConnection = DriverManager.getConnection(URL, user, password);
			System.out.println("Finnished");
			Warning warning = new Warning("Engresado", "FINALLY");
		} catch (SQLException e) {
			Warning warning = new Warning("Error de conexion", e.getMessage());
		}
	}
}
