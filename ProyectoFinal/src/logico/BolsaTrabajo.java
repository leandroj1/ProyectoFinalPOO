package logico;

import java.util.ArrayList;
import java.util.stream.Collectors;

import enums.EstadoSolicitudEmpresa;
import enums.EstadoSolicitudPersonal;

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
		if (empresa != null && getPersonalByID(empresa.getRNC()).size() == 0)
			empresas.add(empresa);
	}

	public void agregarPersonal(Personal candidato) {
		if (candidato != null && getPersonalByID(candidato.getCedula()).size() == 0)
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

	public void anularSolicitudEmpresa(SolicitudEmpresa solicitud) {
		solicitud.setEstado(EstadoSolicitudEmpresa.ANULADA);

		ArrayList<String> cedulasForAnulacion = solicitud.getCedulasPersonasContratadas();
		this.personal.forEach(persona -> {
			if(cedulasForAnulacion.contains(persona.getCedula())) {
				this.desemplearPersonal(persona);
			}
		});
	}

	public void desemplearPersonal(Personal personal) {
		personal.setIdEmpresaContratacion(null);

		personal.getSolicitudes().forEach(solicitudPersonal -> {
			if(solicitudPersonal.getEstado() == EstadoSolicitudPersonal.PENDIENTE){
				solicitudPersonal.setEstado(EstadoSolicitudPersonal.ACTIVA);
			}
		});
	}

	public void contratarPersonal(String cedula, String RNCEmpresaContratacion, String idSolicitudPersonal) {
		ArrayList<Personal> result = getPersonalByID(cedula);
		if(result.size() > 0) {
			Personal personal = result.get(0);
			personal.setIdEmpresaContratacion(RNCEmpresaContratacion);
			personal.getSolicitudes().forEach(solicitud -> {
				// En caso de que se contrate por una solicitud que hizo
				if(idSolicitudPersonal != null){
					if(idSolicitudPersonal.equalsIgnoreCase(solicitud.getId())){
						solicitud.setEstado(EstadoSolicitudPersonal.SATISFECHA);
						return;
					}
				}

				if(solicitud.getEstado() == EstadoSolicitudPersonal.ACTIVA || solicitud.getEstado() == EstadoSolicitudPersonal.SATISFECHA)
					solicitud.setEstado(EstadoSolicitudPersonal.PENDIENTE);
			});
		}
	}
}
