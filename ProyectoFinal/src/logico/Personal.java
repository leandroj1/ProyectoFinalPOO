package logico;

import java.util.Date;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

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
	private String idEmpresaContratacion;
	private boolean isDesempleado;
	private ArrayList<SolicitudPersonal> solicitudes;
	private Ubicacion ubicacion;

	public Personal(String cedula, String nombre, Date fechaNacimiento, boolean esCasado, String telefonoPrincipal,
			String telefonoSecundario, String ciudadResidencia, ArrayList<String> idiomas,
			boolean disponibilidadSalirCiudad, boolean disponibilidadCambioResidencia, boolean forTiempoCompleto,
			Ubicacion ubicacion) {
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
		this.ubicacion = ubicacion;

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

	public int getEdad() {
		LocalDate nacimiento = fechaNacimiento.toInstant()
		.atZone(ZoneId.systemDefault())
		.toLocalDate();

		return Period.between(nacimiento, LocalDate.now()).getYears();
	}

	public void removerIdioma(String idioma) {
		if(idioma != null) {
			idiomas.removeIf(idiomaActual -> idioma.equalsIgnoreCase(idiomaActual));	
		}
	}

	public void agregarIdioma(String idioma) {
		if(idioma != null) {
			if(idioma != "" && !(idiomas.contains(idioma))) {
				idiomas.add(idioma);	
			}
		}
	}

	public ArrayList<SolicitudPersonal> getSolicitudes() {
		return solicitudes;
	}

	public void agregarSolicitud(SolicitudPersonal solicitud) {
		if(solicitud != null){
			this.solicitudes.add(solicitud);
		}
	}
}