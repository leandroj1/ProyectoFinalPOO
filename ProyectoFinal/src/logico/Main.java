package logico;

import visual.Login;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SQLConnection.connect();
		while (SQLConnection.sqlConnection == null) {
			continue;
		}
		BolsaTrabajo.getInstance();
		Login login = new Login();
		login.setVisible(true);
	}
}
