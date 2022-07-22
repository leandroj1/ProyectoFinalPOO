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
	private String areaTecnica;
	private String carrera;
	private String universidad;
	private ArrayList<String> oficios;
	// true = activa
	private boolean estado;
	
	public SolicitudPersonal(String id, String cedulaPersonal, String rNCEmpresa, String descripcion,
			float salarioEsperado, int agnosExperiencia, String areaTecnica, String carrera, String universidad,
			ArrayList<String> oficios) {
		super();
		this.id = id;
		this.cedulaPersonal = cedulaPersonal;
		RNCEmpresa = rNCEmpresa;
		this.descripcion = descripcion;
		this.salarioEsperado = salarioEsperado;
		this.agnosExperiencia = agnosExperiencia;
		this.areaTecnica = areaTecnica;
		this.carrera = carrera;
		this.universidad = universidad;
		this.oficios = oficios;
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
}
