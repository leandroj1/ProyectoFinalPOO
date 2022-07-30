package logico;

import java.util.ArrayList;
import java.util.Date;

public class Tecnico extends Personal {
	private String areaTecnica;

	public Tecnico(String cedula, String nombre, Date fechaNacimiento, String sexo, boolean esCasado, String telefonoPrincipal,
			String telefonoSecundario, String nacionalidad, ArrayList<String> idiomas, String areaTecnica, Ubicacion ubicacion) {
		super(cedula, nombre, fechaNacimiento, sexo, esCasado, telefonoPrincipal, telefonoSecundario, nacionalidad, idiomas, ubicacion);
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
