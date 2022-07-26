package logico;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Empresa {
	private String RNC;
	private String nombre; 
	private String sector;
	private Ubicacion ubicacion;
	private ArrayList<SolicitudEmpresa> solicitudes;
	private String tipo;

	public Empresa(String rNC, String nombre, String sector, String tipo, Ubicacion ubicacion) {
		super();
		this.RNC = RNC;
		this.nombre = nombre;
		this.sector = sector;
		this.solicitudes = new ArrayList<SolicitudEmpresa>();
		this.tipo = tipo;
		this.ubicacion = ubicacion;
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

<<<<<<< Updated upstream
	public String getTipo() {
		return tipo;
=======
	public Ubicacion getUbicacion() {
		return ubicacion;
>>>>>>> Stashed changes
	}
}
