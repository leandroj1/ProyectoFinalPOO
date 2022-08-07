package logico;

import visual.Login;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BolsaTrabajo.getInstance();
		Login login = new Login();
		login.setVisible(true);
	}
}
