package logico;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Empresa {
	private String RNC;
	private String nombre; 
	private String sector;
	private ArrayList<SolicitudEmpresa> solicitudes;
	private String tipo;
	
	public Empresa(String RNC, String nombre, String sector, String tipo) {
		super();
		this.RNC = RNC;
		this.nombre = nombre;
		this.sector = sector;
		this.solicitudes = new ArrayList<SolicitudEmpresa>();
		this.tipo = tipo;
	}

	public String getRNC() {
		return RNC;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
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

	public String getTipo() {
		return tipo;
	}
}
