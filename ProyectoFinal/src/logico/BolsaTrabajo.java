package logico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
	
//Propiedades del reporte
	public static int cantPersonalUni = 0;
	public static int cantPersonalTecnico = 0;
	public static int cantPersonalObrero = 0;
	public static int cantPersonalFem = 0;
	public static int cantPersonalMasc = 0;

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
		if(cedula == null) {
			return this.personal;
		}

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

		if (personalAux.size() == 1 && personalAux.get(0).getIdEmpresaContratacion() == null) {
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
		return new ArrayList<Personal>(this.personal.stream()
				.filter(candidato -> solicitud.getCedulasPersonasContratadas().contains(candidato.getCedula()))
				.collect(Collectors.toList()));
	}

	public void anularSolicitudEmpresa(SolicitudEmpresa solicitud) {
		solicitud.setEstado(EstadoSolicitudEmpresa.ANULADA);

		ArrayList<String> cedulasForAnulacion = solicitud.getCedulasPersonasContratadas();
		this.personal.forEach(persona -> {
			if(cedulasForAnulacion.contains(persona.getCedula())) {
				this.desemplearPersonal(persona, solicitud);
			}
		});
	}

	public void desemplearPersonal(Personal personal, SolicitudEmpresa solicitudEmpresa) {
		personal.setIdEmpresaContratacion(null);
		personal.setIdSolicitudPersonalContratacion(null);

		personal.getSolicitudes().forEach(solicitudPersonal -> {
			if(solicitudPersonal.getEstado() == EstadoSolicitudPersonal.PENDIENTE){
				solicitudPersonal.setEstado(EstadoSolicitudPersonal.ACTIVA);
			}
		});

		solicitudEmpresa.getCedulasPersonasContratadas().removeIf(cedula -> cedula.equalsIgnoreCase(personal.getCedula()));
	}
	
	public ArrayList<SolicitudPersonal> getActiveSolPersonalByCedula(String cedula) {
		ArrayList<SolicitudPersonal> solPersonalList = getSolicitudesPersonalByID(cedula, "");
		ArrayList<SolicitudPersonal> solPersonalActive = new ArrayList<SolicitudPersonal>();
		for (SolicitudPersonal solPersonal : solPersonalList)
			if (solPersonal.getEstado() == EstadoSolicitudPersonal.ACTIVA)
				solPersonalActive.add(solPersonal);
		return solPersonalActive;
	}


	public void contratarPersonal(Personal persona, SolicitudEmpresa solicitudEmpresa, String idSolicitudPersonal) {
		if(persona != null) {
			persona.setIdEmpresaContratacion(solicitudEmpresa.getRNCEmpresa());
			persona.getSolicitudes().forEach(solicitud -> {
				// En caso de que se contrate por una solicitud que hizo
				if(idSolicitudPersonal != null){
					if(idSolicitudPersonal.equalsIgnoreCase(solicitud.getId())){
						solicitud.setEstado(EstadoSolicitudPersonal.SATISFECHA);
						persona.setIdSolicitudPersonalContratacion(idSolicitudPersonal);	
						if(solicitud.getTipoPersonal().equalsIgnoreCase("Universitario")) {
							cantPersonalUni++;
						}
						else if(solicitud.getTipoPersonal().equalsIgnoreCase("Obrero")) {
							cantPersonalObrero++;
						}
						else if(solicitud.getTipoPersonal().equalsIgnoreCase("Tecnico")) {
							cantPersonalTecnico++;
						}	
						return;
					}
				}

				if(solicitud.getEstado() == EstadoSolicitudPersonal.ACTIVA || solicitud.getEstado() == EstadoSolicitudPersonal.SATISFECHA)
					solicitud.setEstado(EstadoSolicitudPersonal.PENDIENTE);
			});
			if(persona.getGenero().equalsIgnoreCase("Femenino")) {
				cantPersonalFem++;
			}
			else if(persona.getGenero().equalsIgnoreCase("Masculino")) {
				cantPersonalMasc++;
			}
			// Agregar la cedula del personal a las personas contratadas
			solicitudEmpresa.agregarCedulaPersonaContratada(persona.getCedula());
		}
	}

	// Porcentaje de match asociado a las propiedades como salarioMax y salarioMin
	private float getMatchPropiedadesGenerales(Personal personalObj, SolicitudPersonal solicitudPersonal,
			SolicitudEmpresa solicitudEmpresa, int cantidadRequisitos) {
		float match = 0.0f, cantToSum = 1.0f / cantidadRequisitos;

		String sexoRequerido = solicitudEmpresa.getSexo();
		// Si no aplica, el sexo del candidato no tiene relevancia
		if (sexoRequerido.equalsIgnoreCase("N/A")) {
			match += cantToSum;
		} else {
			if (personalObj.getGenero().equalsIgnoreCase(solicitudEmpresa.getSexo()))
				match += cantToSum;
		}

		// El salario cuenta por 2 propiedades
		if (solicitudPersonal.getSalarioEsperado() >= solicitudEmpresa.getSalarioMin()
				&& solicitudPersonal.getSalarioEsperado() <= solicitudEmpresa.getSalarioMax())
			match += 2 * cantToSum;
		// Si es menor que el salario minimo ofrecido, se suma a favor de la empresa 
		else if(solicitudPersonal.getSalarioEsperado() <= solicitudEmpresa.getSalarioMin())
			match += 2 * cantToSum;
			
		if (personalObj.getEdad() >= solicitudEmpresa.getEdad())
			match += cantToSum;
		if (solicitudPersonal.getAgnosExperiencia() >= solicitudEmpresa.getAgnosExperiencia())
			match += cantToSum;

		// Si es falso, no se requiere la disponibilidad, lo mismo para [isDisponibilidadSalirCiudad]
		if(!solicitudEmpresa.isDisponibilidadCambioResidencia()) {
			match += cantToSum;
		}
		else {
			if (solicitudEmpresa.isDisponibilidadCambioResidencia() == solicitudPersonal.isDisponibilidadCambioResidencia())
				match += cantToSum;
		}
		if(!solicitudEmpresa.isDisponibilidadSalirCiudad()) {
			match += cantToSum;
		}
		else {
			if (solicitudEmpresa.isDisponibilidadSalirCiudad() == solicitudPersonal.isDisponibilidadSalirCiudad())
				match += cantToSum;
		}

		// Si no prefiere una nacionalidad
		if(solicitudEmpresa.getNacionalidad().equalsIgnoreCase("Sin preferencia")) {
			match += cantToSum;
		}
		else {
			if(solicitudEmpresa.getNacionalidad().equalsIgnoreCase(personalObj.getNacionalidad())) {
				match += cantToSum;
			}
		}

		if (solicitudPersonal.getModalidadDeTrabajo().equalsIgnoreCase(solicitudEmpresa.getTipoDeTrabajo()))
			match += cantToSum;

		// Si tiene la propiedad como true significa que no importa si es casado o no
		if (solicitudEmpresa.isEsCasado()) {
			match += cantToSum;
		}
		// Si es falso, significa que quiere que sea soltero
		else if (solicitudEmpresa.isEsCasado() == personalObj.isEsCasado()) {
			match += cantToSum;
		}

		float acumuladoIdiomas = 0.0f;
		ArrayList<String> idiomasRequeridos = solicitudEmpresa.getIdiomas();
		// Si la empresa no requiere ningun idioma, se suma a favor del personal
		if(idiomasRequeridos.size() == 0) {
			acumuladoIdiomas = cantToSum;
		}
		else {
			for (String idiomaPersonal : personalObj.getIdiomas()) {
				if (idiomasRequeridos.contains(idiomaPersonal))
					acumuladoIdiomas += (cantToSum / idiomasRequeridos.size());
			}			
		}
		match += acumuladoIdiomas;

		// Esta entre 0 y 1
		return match;
	}

	// Obtener el porcentaje de match de una solicitud
	private float getPorcentajeMatchFrom(Personal personalObj, SolicitudPersonal solicitudPersonal,
			SolicitudEmpresa solicitudEmpresa, int cantidadRequisitos) {
		float acumulado = 0.0f, cantToSum = 1.0f / cantidadRequisitos;
		if (personalObj.toString().equalsIgnoreCase(solicitudEmpresa.getTipoPersonalSolicitado())) {
			// Por ser del mismo tipo
			acumulado += cantToSum;

			// Propiedades especificas
			if (solicitudEmpresa.getTipoPersonalSolicitado().equalsIgnoreCase("Universitario")) {
				if (solicitudPersonal.getCarrera().equalsIgnoreCase(solicitudEmpresa.getCarrera())) {
					acumulado += cantToSum;
					if (solicitudPersonal.getUniversidad().equalsIgnoreCase(solicitudEmpresa.getUniversidad())) {
						acumulado += cantToSum;
					}
				} else {
					// No es de la carrera que se requiere
					return 0.0f;
				}
			} else if (solicitudEmpresa.getTipoPersonalSolicitado().equalsIgnoreCase("Obrero")) {
				float acumuladoOficios = 0.0f;
				ArrayList<String> oficiosSolicitudPersonal = solicitudPersonal.getOficios();
				for (String oficio : solicitudEmpresa.getOficios()) {
					if (oficiosSolicitudPersonal.contains(oficio))
						acumuladoOficios += cantToSum / oficiosSolicitudPersonal.size();
				}

				if (acumuladoOficios > 0.0f) {
					acumulado += acumuladoOficios;
				} else {
					// No tiene ninguno de los oficios que se requiere
					return 0.0f;
				}
			} else {
				if (solicitudPersonal.getAreaTecnica().equalsIgnoreCase(solicitudEmpresa.getAreaTecnica())) {
					acumulado += cantToSum;
				} else {
					// No es del area tecnica que se requiere
					return 0.0f;
				}
			}

			acumulado += getMatchPropiedadesGenerales(personalObj, solicitudPersonal, solicitudEmpresa,
					cantidadRequisitos);
		}

		return acumulado * 100.0f;
	}

	public Map<Personal, SolicitudPersonal> getCandidatosByPorcentajeMatch(SolicitudEmpresa solicitudEmpresa, ArrayList<Personal> personalBusqueda, boolean getContratadasToo) {
		Map<Personal, SolicitudPersonal> candidatos = new HashMap<Personal, SolicitudPersonal>();
		if(solicitudEmpresa != null) {
			float porcentajeMatchRequerido = solicitudEmpresa.getPorcentajeMatchRequerido();
			if (porcentajeMatchRequerido >= 0.0f && porcentajeMatchRequerido <= 100.0f) {
				int cantidadRequisitos = solicitudEmpresa.getCantidadRequisitos();

				personalBusqueda.forEach(person -> {
					if((person.getIdEmpresaContratacion() == null && person.getIdSolicitudPersonalContratacion() == null) || getContratadasToo) {
						person.getSolicitudes().forEach(solicitud -> {
							// Se pasa la cantidad de requisitos para no evaluar propiedades otra vez
							float resultPorcentaje = getPorcentajeMatchFrom(person, solicitud, solicitudEmpresa,
									cantidadRequisitos);
							
							if (resultPorcentaje >= porcentajeMatchRequerido) {
								// Asignar porcentaje de match para no calcularlo de nuevo
								solicitud.setPorcentajeMatchAsignado(resultPorcentaje);
								
								candidatos.put(person, solicitud);
							}
						});						
					}
				});
			}			
		}

		return candidatos;
	}

	public void anularSolicitudPersonal(SolicitudPersonal solicitud) {
		solicitud.setEstado(EstadoSolicitudPersonal.ANULADA);
	}
	
	public Map<String, Integer> getDataReporte3() {
		// Cargarlas llamando el metodo
		ArrayList<Empresa> empresas = this.empresas;
		
		String[] keys = {"Industrial", "Agricultura", "Alimentaci\u00F3n", "Comercio", "Construcci\u00F3n", "Educaci\u00F3n", "Hoteler\u00EDa", "Medios de comunicaci\u00F3n", "Miner\u00EDa", "Petrolero", "Telecomunicaciones", "Salud", "Financieros", "P\u00FAblico", "Silvicultura", "Textil", "Tecnol\u00F3gico", "Transporte"};
		Map<String, Integer> data = new HashMap<String, Integer>();
		for (String key : keys) {
			data.put(key, Integer.valueOf(0));
		}
		
		for (Empresa empresa : empresas) {
			try {
				data.replace(empresa.getSector(), Integer.valueOf(1 + data.get(empresa.getSector()).intValue()));
			} catch (Exception e) {}
		}
		
		return data;
	}
}
