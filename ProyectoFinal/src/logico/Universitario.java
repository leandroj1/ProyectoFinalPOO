package logico;

import java.util.ArrayList;
import java.util.Date;

public class Universitario extends Personal {
	private String carrera;
	private String universidad;

	public Universitario(String cedula, String nombre, Date fechaNacimiento, boolean esCasado, String telefonoPrincipal,
			String telefonoSecundario, String ciudadResidencia, ArrayList<String> idiomas,
			boolean disponibilidadSalirCiudad, boolean disponibilidadCambioResidencia, boolean forTiempoCompleto, String carrera, String universidad) {
		super(cedula, nombre, fechaNacimiento, esCasado, telefonoPrincipal, telefonoSecundario, ciudadResidencia, idiomas,
				disponibilidadSalirCiudad, disponibilidadCambioResidencia, forTiempoCompleto);
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