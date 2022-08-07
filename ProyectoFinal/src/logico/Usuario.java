package logico;

public class Usuario {
	public Usuario(String nombreUsuario, String contrasegna, boolean esAdmin) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contrasegna = contrasegna;
		this.esAdmin = esAdmin;
	}

	private String nombreUsuario;
	private String contrasegna;
	private boolean esAdmin;

	public String getContrasegna() {
		return contrasegna;
	}

	public void setContrasegna(String contrasegna) {
		this.contrasegna = contrasegna;
	}

	public boolean esAdmin() {
		return esAdmin;
	}

	public void setAdminState(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public boolean authContrasegna(String contrasegna) {
		return this.contrasegna.equals(contrasegna);
	}
}
