package logico;

import java.util.Date;

public class SolicitudPersonal {
	private String id;
	private Date fecha;
	private String cedulaPersonal;
	private String RNCEmpresa;
	private String descripcion;
	// true = activa
	private boolean estado;
	
	public SolicitudPersonal(String id, String cedulaPersonal, String rNCEmpresa, String descripcion) {
		super();
		this.id = id;
		this.cedulaPersonal = cedulaPersonal;
		RNCEmpresa = rNCEmpresa;
		this.descripcion = descripcion;

		this.estado = true;
		this.fecha = new Date();
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
}
