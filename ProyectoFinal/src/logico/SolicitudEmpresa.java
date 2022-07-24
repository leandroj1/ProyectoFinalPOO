package logico;

import java.util.ArrayList;
import java.util.Date;

import enums.EstadoSolicitudEmpresa;

public class SolicitudEmpresa {	
	private String id;
	private Date fecha;
	private int cantidadPlazasNecesarias;
	private EstadoSolicitudEmpresa estado;
	private String tipoPersonalSolicitado;
	private String nacionalidad;
	private String sexo;
	private ArrayList<Personal> candidatosPosibles;

	// Requisitos
	private float salarioMax;
	private float salarioMin;
	private int edad;
	private int agnosExperiencia;
	private boolean disponibilidadSalirCiudad;
	private boolean disponibilidadCambioResidencia;
	private boolean forTiempoCompleto;
	private boolean esCasado;
	private ArrayList<String> idiomas;
	private String carrera;
	private String universidad;
	private String areaTecnica;
	private ArrayList<String> oficios;
	private static int genNumber = 0;

	public SolicitudEmpresa(String id, int cantidadPlazasNecesarias,
			float salarioMax, float salarioMin, int edad, int agnosExperiencia, String tipoPersonalSolicitado, String sexo, String nacionalidad, boolean disponibilidadSalirCiudad,
			boolean disponibilidadCambioResidencia, boolean forTiempoCompleto, boolean esCasado, String carrera, String universidad, String areaTecnica) {
	
		super();
		this.id = id;
		this.cantidadPlazasNecesarias = cantidadPlazasNecesarias;
		this.candidatosPosibles = new ArrayList<Personal>();
		this.salarioMax = salarioMax;
		this.salarioMin = salarioMin;
		this.edad = edad <= 17 ? 18 : edad;
		this.agnosExperiencia = agnosExperiencia;
		this.tipoPersonalSolicitado = tipoPersonalSolicitado;
		this.sexo = sexo;
		this.nacionalidad = nacionalidad;
		this.disponibilidadSalirCiudad = disponibilidadSalirCiudad;
		this.disponibilidadCambioResidencia = disponibilidadCambioResidencia;
		this.forTiempoCompleto = forTiempoCompleto;
		this.esCasado = esCasado;
		this.idiomas = new ArrayList<String>();
		this.carrera = carrera;
		this.universidad = universidad;
		this.areaTecnica = areaTecnica;
		this.oficios = new ArrayList<String>();
		this.fecha = new Date();
		this.estado = EstadoSolicitudEmpresa.ACTIVA;
	}
	
	public static String genID() {
		String num = Integer.toString(++genNumber);
		for (int len = num.length(); len < 10; len++)
			num = "0" + num;

		return "SE" + num;
	}

	public String getId() {
		return id;
	}

	public Date getFecha() {
		return fecha;
	}

	public int getCantidadPlazasNecesarias() {
		return cantidadPlazasNecesarias;
	}

	public EstadoSolicitudEmpresa getEstado() {
		return estado;
	}

	public void setEstado(EstadoSolicitudEmpresa nuevoEstado) {
		this.estado = nuevoEstado;
	}

	public ArrayList<Personal> getCandidatosPosibles() {
		return candidatosPosibles;
	}

	public int getEdad() {
		return edad;
	}

	public int getAgnosExperiencia() {
		return agnosExperiencia;
	}

	public boolean isDisponibilidadSalirCiudad() {
		return disponibilidadSalirCiudad;
	}

	public boolean isDisponibilidadCambioResidencia() {
		return disponibilidadCambioResidencia;
	}

	public boolean isForTiempoCompleto() {
		return forTiempoCompleto;
	}

	public boolean isEsCasado() {
		return esCasado;
	}

	public ArrayList<String> getIdiomas() {
		return idiomas;
	}

	public String getCarrera() {
		return carrera;
	}

	public String getUniversidad() {
		return universidad;
	}

	public String getAreaTecnica() {
		return areaTecnica;
	}

	public ArrayList<String> getOficios() {
		return oficios;
	}

	public void setCantidadPlazasNecesarias(int cantidadPlazasNecesarias) {
		this.cantidadPlazasNecesarias = cantidadPlazasNecesarias;
	}

	public float getSalarioMax() {
		return salarioMax;
	}

	public float getSalarioMin() {
		return salarioMin;
	}

	public String getTipoPersonalSolicitado() {
		return tipoPersonalSolicitado;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setSalarioMax(float salarioMax) {
		this.salarioMax = salarioMax;
	}

	public void setSalarioMin(float salarioMin) {
		this.salarioMin = salarioMin;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setAgnosExperiencia(int agnosExperiencia) {
		this.agnosExperiencia = agnosExperiencia;
	}

	public void setDisponibilidadSalirCiudad(boolean disponibilidadSalirCiudad) {
		this.disponibilidadSalirCiudad = disponibilidadSalirCiudad;
	}

	public void setDisponibilidadCambioResidencia(boolean disponibilidadCambioResidencia) {
		this.disponibilidadCambioResidencia = disponibilidadCambioResidencia;
	}

	public void setForTiempoCompleto(boolean forTiempoCompleto) {
		this.forTiempoCompleto = forTiempoCompleto;
	}

	public void setEsCasado(boolean esCasado) {
		this.esCasado = esCasado;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	public void setAreaTecnica(String areaTecnica) {
		this.areaTecnica = areaTecnica;
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
}