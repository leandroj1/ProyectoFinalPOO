package logico;

import java.util.ArrayList;
import java.util.Date;

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
	private ArrayList<String> oficios;
	// true = activa
	private boolean estado;

	public SolicitudPersonal(String id, String cedulaPersonal, String rNCEmpresa, String descripcion,
			float salarioEsperado, int agnosExperiencia,String tipoPersonal, String areaTecnica, String carrera, String universidad) {
		super();
		this.id = id;
		this.cedulaPersonal = cedulaPersonal;
		RNCEmpresa = rNCEmpresa;
		this.descripcion = descripcion;
		this.salarioEsperado = salarioEsperado;
		this.agnosExperiencia = agnosExperiencia;
		this.tipoPersonal = tipoPersonal;
		this.areaTecnica = areaTecnica;
		this.carrera = carrera;
		this.universidad = universidad;
		this.oficios = new ArrayList<String>();
		this.estado = true;
		this.fecha = new Date();
	}

	public String getDescripcion() {
		return descripcion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
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

	public void removerOficio(String oficio) {
		if(oficio != "") {
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
}
