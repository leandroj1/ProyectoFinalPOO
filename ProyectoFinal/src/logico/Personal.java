package logico;

import java.util.Date;
import java.util.ArrayList;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public abstract class Personal implements Serializable {
	private static final long serialVersionUID = 6682358128703110186L;
	private String cedula;
	private String nombre;
	private Date fechaNacimiento;
	private boolean esCasado;
	private String telefonoPrincipal;
	private String telefonoSecundario;
	private ArrayList<String> idiomas;
	private String nacionalidad;
	private String idEmpresaContratacion;
	private String idSolicitudPersonalContratacion;
	private ArrayList<SolicitudPersonal> solicitudes;
	private Ubicacion ubicacion;
	private String sexo;

	public Personal(String cedula, String nombre, Date fechaNacimiento, boolean esCasado, String telefonoPrincipal,
			String telefonoSecundario, String nacionalidad, ArrayList<String> idiomas, Ubicacion ubicacion,
			String sexo) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.esCasado = esCasado;
		this.telefonoPrincipal = telefonoPrincipal;
		this.telefonoSecundario = telefonoSecundario;
		this.nacionalidad = nacionalidad;
		this.idiomas = idiomas;
		this.ubicacion = ubicacion;
		this.idEmpresaContratacion = null;
		this.setIdSolicitudPersonalContratacion(null);
		this.sexo = sexo;
		this.solicitudes = new ArrayList<SolicitudPersonal>();
		this.sexo = sexo;
	}

	public int esCasado() {
		if (esCasado) {
			return 1;
		} else {
			return 0;
		}
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

	public String getIdEmpresaContratacion() {
		return idEmpresaContratacion;
	}

	public void setIdEmpresaContratacion(String idEmpresaContratacion) {
		this.idEmpresaContratacion = idEmpresaContratacion;
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
		return Utils.yearsBetween(fechaNacimiento);
	}

	public void removerIdioma(String idioma) {
		if (idioma != null) {
			idiomas.removeIf(idiomaActual -> idioma.equalsIgnoreCase(idiomaActual));
		}
	}

	public void agregarIdioma(String idioma) {
		if (idioma != null) {
			if (idioma != "" && !(idiomas.contains(idioma))) {
				idiomas.add(idioma);
			}
		}
	}

	public ArrayList<SolicitudPersonal> getSolicitudes() {
		return solicitudes;
	}

	public void agregarSolicitud(SolicitudPersonal solicitud) {
		if (solicitud != null) {
			this.solicitudes.add(solicitud);
		}
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public String getIdSolicitudPersonalContratacion() {
		return idSolicitudPersonalContratacion;
	}

	public void setIdSolicitudPersonalContratacion(String idSolicitudPersonalContratacion) {
		this.idSolicitudPersonalContratacion = idSolicitudPersonalContratacion;
	}

	public String getGenero() {
		return sexo;
	}

	public void setIdiomas(ArrayList<String> idiomas) {
		this.idiomas = idiomas;
	}
}
