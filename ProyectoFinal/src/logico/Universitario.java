package logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Universitario extends Personal implements Serializable{
	private static final long serialVersionUID = 8206864101404679324L;
	private String carrera;
	private String universidad;

	public Universitario(String cedula, String nombre, Date fechaNacimiento, boolean esCasado, String telefonoPrincipal,
			String telefonoSecundario, String nacionalidad, ArrayList<String> idiomas, String carrera,
			String universidad, Ubicacion ubicacion, String sexo) {
		super(cedula, nombre, fechaNacimiento, esCasado, telefonoPrincipal, telefonoSecundario, nacionalidad, idiomas, ubicacion, sexo);
		this.carrera = carrera;
		this.universidad = universidad;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	@Override
	public String toString() {
		return "Universitario";
	}
}
