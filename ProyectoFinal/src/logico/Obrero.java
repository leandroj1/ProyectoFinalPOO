package logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Obrero extends Personal implements Serializable{
	private static final long serialVersionUID = -6616674251564878548L;
	private ArrayList<String> oficios;

	public Obrero(String cedula, String nombre, Date fechaNacimiento, boolean esCasado, String telefonoPrincipal,
			String telefonoSecundario, String nacionalidad, ArrayList<String> idiomas, Ubicacion ubicacion,
			String sexo, ArrayList<String> oficios) {
		super(cedula, nombre, fechaNacimiento, esCasado, telefonoPrincipal, telefonoSecundario, nacionalidad, idiomas, ubicacion, sexo);
		this.oficios = oficios;
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
