package logico;

import java.util.ArrayList;
import java.util.Date;

public class Obrero extends Personal {
	private ArrayList<String> oficios;

	public Obrero(String cedula, String nombre, Date fechaNacimiento, boolean esCasado, String telefonoPrincipal,
			String telefonoSecundario, String ciudadResidencia, ArrayList<String> idiomas,
			boolean disponibilidadSalirCiudad, boolean disponibilidadCambioResidencia, boolean forTiempoCompleto,
			int agnosExperiencia, ArrayList<String> oficios) {
		super(cedula, nombre, fechaNacimiento, esCasado, telefonoPrincipal, telefonoSecundario, ciudadResidencia, idiomas,
				disponibilidadSalirCiudad, disponibilidadCambioResidencia, forTiempoCompleto, agnosExperiencia);
		this.oficios = oficios;
	}

	public ArrayList<String> getOficios() {
		return oficios;
	}

	public void agregarOficio(String oficio) {
		this.oficios.add(oficio);
	}
}
