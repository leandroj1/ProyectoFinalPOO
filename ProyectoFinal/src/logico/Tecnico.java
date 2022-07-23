package logico;

import java.util.ArrayList;
import java.util.Date;

public class Tecnico extends Personal {
	private String areaTecnica;

	public Tecnico(String cedula, String nombre, Date fechaNacimiento, boolean esCasado, String telefonoPrincipal,
			String telefonoSecundario, String ciudadResidencia, ArrayList<String> idiomas,
			boolean disponibilidadSalirCiudad, boolean disponibilidadCambioResidencia, boolean forTiempoCompleto, String areaTecnica) {
		super(cedula, nombre, fechaNacimiento, esCasado, telefonoPrincipal, telefonoSecundario, ciudadResidencia, idiomas,
				disponibilidadSalirCiudad, disponibilidadCambioResidencia, forTiempoCompleto);
		this.setAreaTecnica(areaTecnica);
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