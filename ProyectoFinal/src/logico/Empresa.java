package logico;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Empresa {
	private String RNC;
	private String nombreComercial;
	private String razonSocial; 
	private String sector;
	private ArrayList<SolicitudEmpresa> solicitudes;
	private String tipo;
	private String rubro;
	private String nombreContacto;
	private String telefonoContacto;
	private String emailContacto;
	private Ubicacion ubicacion;

	public Empresa(String RNC, String nombreComercial, String razonSocial, String rubro, String nombreContacto, String telefonoContacto, String emailContacto, String sector, String tipo, Ubicacion ubicacion) {
		super();
		this.RNC = RNC;
		this.nombreComercial = nombreComercial;
		this.sector = sector;
		this.solicitudes = new ArrayList<SolicitudEmpresa>();
		this.tipo = tipo;
		this.razonSocial = razonSocial;
		this.rubro = rubro;
		this.nombreContacto = nombreContacto;
		this.telefonoContacto = telefonoContacto;
		this.emailContacto = emailContacto;
		this.ubicacion = ubicacion;
	}

	public String getRNC() {
		return RNC;
	}

	public String getNombre() {
		return nombreComercial;
	}

	public String getSector() {
		return sector;
	}

	public void agregarSolicitud(SolicitudEmpresa solicitud) {
		if (solicitud != null)
			solicitudes.add(solicitud);
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public ArrayList<SolicitudEmpresa> getSolicitudes() {
		return solicitudes;
	}

	public String getRubro() {
		return rubro;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public void setEmailContacto(String emailContacto) {
		this.emailContacto = emailContacto;
	}

	public String getEmailContacto() {
		return emailContacto;
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

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
}
