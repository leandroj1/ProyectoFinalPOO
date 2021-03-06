package logico;

public class Ubicacion {
	public Ubicacion(String pais, String provincia, String ciudad, String direccion) {
		super();
		this.pais = pais;
		this.provincia = provincia;
		this.ciudad = ciudad;
		this.direccion = direccion;
	}

	private String pais;
	private String provincia;
	private String ciudad;
	private String direccion;

	public String getPais() {
		return pais;
	}

	public String getProvincia() {
		return provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getDireccion() {
		return direccion;
	}
	
	@Override
	public String toString() {
		return direccion + ", " + ciudad + ", " + provincia + ", " + pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
