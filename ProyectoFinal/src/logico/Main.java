package logico;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import visual.Login;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SQLConnection.connect();
		while (SQLConnection.sqlConnection == null) {
			continue;
		}
		
		Login login = new Login();
		login.setVisible(true);
	}
}
