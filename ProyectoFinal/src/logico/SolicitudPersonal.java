package logico;

import java.util.ArrayList;
import java.util.Date;

import enums.EstadoSolicitudPersonal;

public class SolicitudPersonal {
	private String id;
	private Date fecha;
	private String cedulaPersonal;
	private String RNCEmpresa;
	private String descripcion;
	private float salarioEsperado;
	private int agnosExperiencia;
	private String tipoPersonal;
	private String areaTecnica;
	private String carrera;
	private String universidad;
	private boolean disponibilidadSalirCiudad;
	private boolean disponibilidadCambioResidencia;
	private String modalidadDeTrabajo;
	private ArrayList<String> oficios;
	// true = activa
	private static int genNumber;

	private EstadoSolicitudPersonal estado;

	public SolicitudPersonal(String id, String cedulaPersonal, String RNCEmpresa, String descripcion,
			float salarioEsperado, int agnosExperiencia,String tipoPersonal, String areaTecnica, String carrera,
			String universidad, boolean disponibilidadSalirCiudad, boolean disponibilidadCambioResidencia,
			String modalidadDeTrabajo) {

		super();
		this.id = id;
		this.cedulaPersonal = cedulaPersonal;
		this.RNCEmpresa = RNCEmpresa;
		this.descripcion = descripcion;
		this.salarioEsperado = salarioEsperado;
		this.agnosExperiencia = agnosExperiencia;
		this.tipoPersonal = tipoPersonal;
		this.areaTecnica = areaTecnica;
		this.carrera = carrera;
		this.universidad = universidad;
		this.oficios = new ArrayList<String>();
		this.estado = EstadoSolicitudPersonal.ACTIVA;
		this.fecha = new Date();
		this.disponibilidadSalirCiudad = disponibilidadSalirCiudad;
		this.disponibilidadCambioResidencia = disponibilidadCambioResidencia;
		this.modalidadDeTrabajo = modalidadDeTrabajo;
	}

	public static String genID() {
		String num = Integer.toString(++genNumber);
		for (int len = num.length(); len < 10; len++)
			num = "0" + num;

		return "SP" + num;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public EstadoSolicitudPersonal getEstado() {
		return estado;
	}

	public void setEstado(EstadoSolicitudPersonal nuevoEstado) {
		this.estado = nuevoEstado;
	}

	public String getId() {
		return id;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getCedulaPersonal() {
		return cedulaPersonal;
	}

	public String getRNCEmpresa() {
		return RNCEmpresa;
	}

	public float getSalarioEsperado() {
		return salarioEsperado;
	}

	public int getAgnosExperiencia() {
		return agnosExperiencia;
	}

	public String getAreaTecnica() {
		return areaTecnica;
	}

	public String getCarrera() {
		return carrera;
	}

	public String getUniversidad() {
		return universidad;
	}

	public ArrayList<String> getOficios() {
		return oficios;
	}

	public String getTipoPersonal() {
		return tipoPersonal;
	}

	public void setRNCEmpresa(String rNCEmpresa) {
		RNCEmpresa = rNCEmpresa;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setSalarioEsperado(float salarioEsperado) {
		this.salarioEsperado = salarioEsperado;
	}

	public void setAgnosExperiencia(int agnosExperiencia) {
		this.agnosExperiencia = agnosExperiencia;
	}

	public void setAreaTecnica(String areaTecnica) {
		this.areaTecnica = areaTecnica;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
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

	public String getModalidadDeTrabajo() {
		return modalidadDeTrabajo;
	}

	public void setModalidadDeTrabajo(String modalidadDeTrabajo) {
		this.modalidadDeTrabajo = modalidadDeTrabajo;
	}
}
