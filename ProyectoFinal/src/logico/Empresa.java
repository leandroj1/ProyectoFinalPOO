package logico;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Empresa {
	public Empresa(String RNC, String nombre) {
		super();
		this.RNC = RNC;
		this.nombre = nombre;
		this.solicitudes = new ArrayList<SolicitudEmpresa>();
	}

	private String RNC;
	private String nombre;
	private ArrayList<SolicitudEmpresa> solicitudes;

	public String getRNC() {
		return RNC;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void agregarSolicitud(SolicitudEmpresa solicitud) {
		if (solicitud != null)
			solicitudes.add(solicitud);
	}
	
	/*
	 * Esto funciona tanto para traer una solicitud como para varias.
	 * */
	public ArrayList<SolicitudEmpresa> getSolicitudesByID(String id) {
		return new ArrayList<SolicitudEmpresa>(solicitudes.stream().filter(solicitud -> solicitud.getId().contains(id)).collect(Collectors.toList()));
	}
}
