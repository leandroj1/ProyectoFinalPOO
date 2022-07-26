package logico;

import java.util.ArrayList;
import java.util.Date;

public class Obrero extends Personal {
	private ArrayList<String> oficios;

	public Obrero(String cedula, String nombre, Date fechaNacimiento, boolean esCasado, String telefonoPrincipal,
			String telefonoSecundario, String ciudadResidencia, ArrayList<String> idiomas,
			boolean disponibilidadSalirCiudad, boolean disponibilidadCambioResidencia, boolean forTiempoCompleto,
			Ubicacion ubicacion) {
		super(cedula, nombre, fechaNacimiento, esCasado, telefonoPrincipal, telefonoSecundario, ciudadResidencia, idiomas, ubicacion);
		this.oficios = new ArrayList<String>();
	}

	public ArrayList<String> getOficios() {
		return oficios;
	}

	public void removerOficio(String oficio) {
		if(oficio != null) {
			oficios.removeIf(oficioActual -> oficio.equalsIgnoreCase(oficioActual));
		}
	}

	public void agregarOficio(String oficio) {
		if(oficio != null) {
			if(oficio != "" && !(oficios.contains(oficio))) {
				oficios.add(oficio);
			}
		}
	}

	@Override
	public String toString() {
		return "Obrero";
	}
}