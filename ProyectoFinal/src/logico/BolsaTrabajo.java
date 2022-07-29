package logico;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class BolsaTrabajo {
	private BolsaTrabajo() {
		super();
		this.personal = new ArrayList<Personal>();
		this.empresas = new ArrayList<Empresa>();
		this.solicitudesEmpresa = new ArrayList<SolicitudEmpresa>();
		this.solicitudesPersonal = new ArrayList<SolicitudPersonal>();

	}

	private ArrayList<Personal> personal;
	private ArrayList<Empresa> empresas;
	private ArrayList<SolicitudEmpresa> solicitudesEmpresa;
	private ArrayList<SolicitudPersonal> solicitudesPersonal;

	private static BolsaTrabajo instance;

	public static BolsaTrabajo getInstance() {
		if (instance == null) instance = new BolsaTrabajo();
		return instance;
	}

	public void agregarEmpresa(Empresa empresa) {
		if (empresa != null)
			empresas.add(empresa);
	}

	public void agregarPersonal(Personal candidato) {
		if (candidato != null)
			personal.add(candidato);
	}

	public ArrayList<Personal> getPersonalByID(String cedula) {
		return new ArrayList<Personal>(personal.stream().filter(candidato -> candidato.getCedula().contains(cedula)).collect(Collectors.toList()));
	}

	public ArrayList<Empresa> getEmpresasByID(String RNC) {
		return new ArrayList<Empresa>(empresas.stream().filter(empresa -> empresa.getRNC().contains(RNC)).collect(Collectors.toList()));
	}

	public void agregarSolicitudEmpresa(String RNC, SolicitudEmpresa solicitud) {
		ArrayList<Empresa> empresasAux = getEmpresasByID(RNC);

		if (empresasAux.size() == 1) {
			empresasAux.get(0).agregarSolicitud(solicitud);
			solicitudesEmpresa.add(solicitud);
		}
	}

	public void agregarSolicitudEmpleado(String cedula, SolicitudPersonal solicitud) {
		ArrayList<Personal> personalAux = getPersonalByID(cedula);

		if (personalAux.size() == 1) {
			personalAux.get(0).agregarSolicitud(solicitud);
			solicitudesPersonal.add(solicitud);
		}
	}

	public ArrayList<SolicitudEmpresa> getSolicitudesEmpresaByID(String filterID) {
		return new ArrayList<SolicitudEmpresa>(solicitudesEmpresa.stream().filter(solicitud -> solicitud.getId().contains(filterID)).collect(Collectors.toList()));
	}

	public ArrayList<SolicitudPersonal> getSolicitudesPersonalByID(String filterID) {
		return new ArrayList<SolicitudPersonal>(solicitudesPersonal.stream().filter(solicitud -> solicitud.getId().contains(filterID)).collect(Collectors.toList()));
	}

	public ArrayList<SolicitudEmpresa> getSolicitudesEmpresaByID(String RNC, String solicitudFilter) {
		return getEmpresasByID(RNC).get(0).getSolicitudesByID(solicitudFilter);
	}

	public ArrayList<SolicitudPersonal> getSolicitudesPersonalByID(String cedula, String solicitudFilter) {
		return getPersonalByID(cedula).get(0).getSolicitudes();
	}

	public ArrayList<Personal> getPersonasContratadasBySolicitud(SolicitudEmpresa solicitud) {
		return new ArrayList<Personal>(personal.stream()
				.filter(candidato -> solicitud.getCedulasPersonasContratadas().contains(candidato.getCedula()))
				.collect(Collectors.toList()));
	}
	
	public Empresa buscarEmpresaByRNC(String codEmpresa) {
		Empresa aux = null;
		int ind = 0;
		boolean encontrado = false;
		while(ind < empresas.size() && !encontrado) {
			if(empresas.get(ind).getRNC().equalsIgnoreCase(codEmpresa)) {
				aux = empresas.get(ind);
				encontrado = true;
			}
			ind++;
		}
		return aux;
	}
}
