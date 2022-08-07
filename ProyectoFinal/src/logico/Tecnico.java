package logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Tecnico extends Personal implements Serializable{
	private static final long serialVersionUID = -4753350839296223814L;
	private String areaTecnica;

	public Tecnico(String cedula, String nombre, Date fechaNacimiento, boolean esCasado, String telefonoPrincipal,
			String telefonoSecundario, String nacionalidad, ArrayList<String> idiomas, String areaTecnica,
			Ubicacion ubicacion, String sexo) {
		super(cedula, nombre, fechaNacimiento, esCasado, telefonoPrincipal, telefonoSecundario, nacionalidad, idiomas, ubicacion, sexo);
		this.areaTecnica = areaTecnica;
	}

	public String getAreaTecnica() {
		return areaTecnica;
	}

	public void setAreaTecnica(String areaTecnica) {
		this.areaTecnica = areaTecnica;
	}

	@Override
	public String toString() {
		return "Tecnico";
	}
}
