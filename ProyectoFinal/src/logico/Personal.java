package logico;

import java.util.Date;
import java.util.ArrayList;

public abstract class Personal {
	private String cedula;
	private String nombre;
	private Date fechaNacimiento;
	private boolean esCasado;
	private String telefonoPrincipal;
	private String telefonoSecundario;
	private String ciudadResidencia;
	private ArrayList<String> idiomas;
	private boolean disponibilidadSalirCiudad;
	private boolean disponibilidadCambioResidencia;
	private boolean forTiempoCompleto;
	private int agnosExperiencia;
	private String idEmpresaContratacion;
	private boolean isDesempleado;
	private ArrayList<SolicitudPersonal> solicitudes;

	public Personal(String cedula, String nombre, Date fechaNacimiento, boolean esCasado, String telefonoPrincipal,
			String telefonoSecundario, String ciudadResidencia, ArrayList<String> idiomas,
			boolean disponibilidadSalirCiudad, boolean disponibilidadCambioResidencia, boolean forTiempoCompleto,
			int agnosExperiencia) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.esCasado = esCasado;
		this.telefonoPrincipal = telefonoPrincipal;
		this.telefonoSecundario = telefonoSecundario;
		this.ciudadResidencia = ciudadResidencia;
		this.idiomas = idiomas;
		this.disponibilidadSalirCiudad = disponibilidadSalirCiudad;
		this.disponibilidadCambioResidencia = disponibilidadCambioResidencia;
		this.forTiempoCompleto = forTiempoCompleto;
		this.agnosExperiencia = agnosExperiencia;

		this.isDesempleado = true;
		this.idEmpresaContratacion = null;
		this.solicitudes = new ArrayList<SolicitudPersonal>();
	}

	public boolean isEsCasado() {
		return esCasado;
	}

	public void setEsCasado(boolean esCasado) {
		this.esCasado = esCasado;
	}

	public String getTelefonoPrincipal() {
		return telefonoPrincipal;
	}

	public void setTelefonoPrincipal(String telefonoPrincipal) {
		this.telefonoPrincipal = telefonoPrincipal;
	}

	public String getTelefonoSecundario() {
		return telefonoSecundario;
	}

	public void setTelefonoSecundario(String telefonoSecundario) {
		this.telefonoSecundario = telefonoSecundario;
	}

	public String getCiudadResidencia() {
		return ciudadResidencia;
	}

	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}

	public boolean isDisponibilidadSalirCiudad() {
		return disponibilidadSalirCiudad;
	}

	public void setDisponibilidadSalirCiudad(boolean disponibilidadSalirCiudad) {
		this.disponibilidadSalirCiudad = disponibilidadSalirCiudad;
	}

	public boolean isDisponibilidadCambioResidencia() {
		return disponibilidadCambioResidencia;
	}

	public void setDisponibilidadCambioResidencia(boolean disponibilidadCambioResidencia) {
		this.disponibilidadCambioResidencia = disponibilidadCambioResidencia;
	}

	public boolean isForTiempoCompleto() {
		return forTiempoCompleto;
	}

	public void setForTiempoCompleto(boolean forTiempoCompleto) {
		this.forTiempoCompleto = forTiempoCompleto;
	}

	public int getAgnosExperiencia() {
		return agnosExperiencia;
	}

	public void setAgnosExperiencia(int agnosExperiencia) {
		this.agnosExperiencia = agnosExperiencia;
	}

	public String getIdEmpresaContratacion() {
		return idEmpresaContratacion;
	}

	public void setIdEmpresaContratacion(String idEmpresaContratacion) {
		this.idEmpresaContratacion = idEmpresaContratacion;
	}

	public boolean isDesempleado() {
		return isDesempleado;
	}

	public void setDesempleado(boolean isDesempleado) {
		this.isDesempleado = isDesempleado;
	}

	public String getCedula() {
		return cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public ArrayList<String> getIdiomas() {
		return idiomas;
	}

	// TODO: hacer una mejor implementacion
	public int getEdad() {
		return (new Date()).getYear() - fechaNacimiento.getYear();
	}

	public void agregarIdioma(String idioma) {
		this.idiomas.add(idioma);
	}

	public ArrayList<SolicitudPersonal> getSolicitudes() {
		return solicitudes;
	}
	
	public void agregarSolicitud(SolicitudPersonal solicitud) {
		this.solicitudes.add(solicitud);
	}
}