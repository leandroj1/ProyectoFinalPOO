package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import customs.CheckBoxsEditableTable;
import enums.EstadoSolicitudEmpresa;
import ficheros.UtilsFicheros;
import logico.BolsaTrabajo;
import logico.Empresa;
import logico.Personal;
import logico.SolicitudEmpresa;
import logico.SolicitudPersonal;
import logico.Utils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

public class ManejoDeCandidatos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tablaPersonal;
	private DefaultTableModel model;
	private SolicitudEmpresa solicitudLoaded = null;
	private JButton btnAccion;

	private int kColumnaCheckboxes = 0;
	private JFormattedTextField txtIdSolicitud;
	private JTextField txtRNCEmpresa;
	private JSpinner spnPorcentajeMatch;
	private JButton btnBuscarSolicitud;
	private JLabel lblPlazasNecesarias;
	private JTextField txtPlazasNecesarias;
	private JButton btnActualizarPorcentaje;
	private JLabel lblNewLabel_1;
	private JTextField txtTipoPersonalSolicitado;
	private JPanel panelEmpresa;
	private JButton btnVerDetallesSolicitud;
	private JLabel lblNombreComercial;
	private JTextField txtNombreComercial;
	private JLabel lblTipo;
	private JTextField txtTipodeEmpresa;
	private JLabel lblNewLabel_2;
	private JRadioButton rdbtnDesemplear;
	private JRadioButton rdbtnContratacion;
	private ButtonGroup accionGroup;
	private JPanel panelCandidatos;
	private JScrollPane scrollPane;
	private TitledBorder titledBorder;
	private JButton btnVerDetallesPersonaSeleccionada;
	private Personal personalSeleccionado = null;
	private boolean tieneDatosIniciales = false;
	private JLabel label;

	private Map<Personal, SolicitudPersonal> dataCandidatos = null;

	/**
	 * Create the dialog.
	 */
	public ManejoDeCandidatos(SolicitudEmpresa solicitud) {
		this.solicitudLoaded = solicitud;
		final Object[] headers = {"Selección", "Cédula del candidato", "Nombre del candidato", "Porcentaje de Match"};
		this.model = new DefaultTableModel();
		model.setColumnIdentifiers(headers);
		accionGroup = new ButtonGroup();

		if(solicitud == null) {
			tieneDatosIniciales = false;
			setTitle("Manejo de candidatos");
		}
		else {
			tieneDatosIniciales = true;
			setTitle("Manejo de candidatos de " + solicitudLoaded.getId());			
		}
		titledBorder = new TitledBorder(null, "Candidatos al empleo", TitledBorder.LEADING, TitledBorder.TOP, null, null);
		this.addWindowListener(UtilsFicheros.getWindowAdapterToSave());
		setBounds(100, 100, 953, 675);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{

			JPanel panelData = new JPanel();
			panelData.setBorder(new TitledBorder(null, "Datos de la solicitud", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelData.setBounds(10, 11, 917, 155);
			contentPanel.add(panelData);
			panelData.setLayout(null);

			JLabel lblNewLabel = new JLabel("ID de la solicitud:");
			lblNewLabel.setBounds(10, 23, 115, 14);
			panelData.add(lblNewLabel);

			MaskFormatter maskIdFormatter = null;
			try {
				maskIdFormatter = new MaskFormatter("SE##########");
				maskIdFormatter.setPlaceholderCharacter('_');
			} catch (ParseException e1) {
				e1.printStackTrace();
			}

			txtIdSolicitud = new JFormattedTextField(maskIdFormatter);
			txtIdSolicitud.setBounds(117, 20, 166, 20);
			panelData.add(txtIdSolicitud);
			txtIdSolicitud.setColumns(10);

			btnBuscarSolicitud = new JButton("Buscar");
			btnBuscarSolicitud.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Que no se ha llenado
					if(txtIdSolicitud.getText().lastIndexOf('_') == 11) {
						JOptionPane.showMessageDialog(null,
								"Ingrese un ID de alguna solicitud de empresa.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
					}
					else {
						ArrayList<SolicitudEmpresa> result = BolsaTrabajo.getInstance().getSolicitudesEmpresaByID(txtIdSolicitud.getText());
						if(result.size() == 0) {
							JOptionPane.showMessageDialog(null,
									"No existen datos asociados al ID '" + txtIdSolicitud.getText() + "'.",
									"Error",
									JOptionPane.ERROR_MESSAGE);
							txtIdSolicitud.requestFocus();
						}
						else {
							solicitudLoaded = result.get(0);
							if(solicitudLoaded.getEstado() == EstadoSolicitudEmpresa.ANULADA) {
								JOptionPane.showMessageDialog(null,
										"Esta solicitud est\u00e1 anulada, no se puede administrar.",
										"Error",
										JOptionPane.ERROR_MESSAGE);
								model.setRowCount(0);
							}
							else {
								cargarDatosSolicitud(solicitudLoaded);

								if(solicitudLoaded.getEstado() == EstadoSolicitudEmpresa.SATISFECHA) {
//									rdbtnContratacion.setSelected(true);
									cambiarAccionVentana(false);
								}

								// Cargar datos del personal
								cargarDatosTablaPersonal(false);								
							}
						}
					}
				}
			});
			btnBuscarSolicitud.setBounds(293, 19, 89, 23);
			panelData.add(btnBuscarSolicitud);

			JLabel lblPorcentajeDeMatch = new JLabel("Porcentaje de match requerido:");
			lblPorcentajeDeMatch.setBounds(399, 23, 194, 14);
			panelData.add(lblPorcentajeDeMatch);

			spnPorcentajeMatch = new JSpinner();
			spnPorcentajeMatch.setEnabled(false);
			spnPorcentajeMatch.setModel(new SpinnerNumberModel(new Float(0), new Float(0), new Float(100), new Float(1)));
			spnPorcentajeMatch.setBounds(592, 20, 81, 20);
			panelData.add(spnPorcentajeMatch);

			lblPlazasNecesarias = new JLabel("Plazas necesarias: ");
			lblPlazasNecesarias.setBounds(10, 61, 194, 14);
			panelData.add(lblPlazasNecesarias);

			txtPlazasNecesarias = new JTextField();
			txtPlazasNecesarias.setEditable(false);
			txtPlazasNecesarias.setBounds(127, 58, 107, 20);
			panelData.add(txtPlazasNecesarias);
			txtPlazasNecesarias.setColumns(10);

			btnActualizarPorcentaje = new JButton("Actualizar porcentaje");
			btnActualizarPorcentaje.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					float nuevoPorcentaje = Utils.getSpinnerFloatValue(spnPorcentajeMatch);
					if(nuevoPorcentaje == 0.0f) {
						JOptionPane.showMessageDialog(null,
								"Ingrese un porcentaje mayor a 0.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
					}
					else {
						solicitudLoaded.setPorcentajeMatchRequerido(nuevoPorcentaje);
						JOptionPane.showMessageDialog(null,
								"Porcentaje actualizado correctamente. El nuevo valor es " + nuevoPorcentaje + "%.",
								"Informaci\u00f3n",
								JOptionPane.INFORMATION_MESSAGE);
						// Cargar los datos de nuevo
						cargarDatosTablaPersonal(false);						
					}
				}
			});
			btnActualizarPorcentaje.setEnabled(false);
			btnActualizarPorcentaje.setBounds(711, 19, 196, 23);
			panelData.add(btnActualizarPorcentaje);

			lblNewLabel_1 = new JLabel("Tipo de personal solicitado:");
			lblNewLabel_1.setBounds(256, 61, 159, 14);
			panelData.add(lblNewLabel_1);

			txtTipoPersonalSolicitado = new JTextField();
			txtTipoPersonalSolicitado.setEditable(false);
			txtTipoPersonalSolicitado.setColumns(10);
			txtTipoPersonalSolicitado.setBounds(420, 58, 142, 20);
			panelData.add(txtTipoPersonalSolicitado);

			panelEmpresa = new JPanel();
			panelEmpresa.setBorder(new TitledBorder(null, "Datos de la empresa solicitante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelEmpresa.setBounds(10, 86, 897, 59);
			panelData.add(panelEmpresa);
			panelEmpresa.setLayout(null);

			JLabel lblRncDeLa = new JLabel("RNC:");
			lblRncDeLa.setBounds(10, 24, 142, 14);
			panelEmpresa.add(lblRncDeLa);

			txtRNCEmpresa = new JTextField();
			txtRNCEmpresa.setEditable(false);
			txtRNCEmpresa.setBounds(50, 21, 166, 20);
			panelEmpresa.add(txtRNCEmpresa);
			txtRNCEmpresa.setColumns(10);

			lblNombreComercial = new JLabel("Nombre comercial:");
			lblNombreComercial.setBounds(238, 24, 142, 14);
			panelEmpresa.add(lblNombreComercial);

			txtNombreComercial = new JTextField();
			txtNombreComercial.setEditable(false);
			txtNombreComercial.setColumns(10);
			txtNombreComercial.setBounds(361, 21, 269, 20);
			panelEmpresa.add(txtNombreComercial);

			lblTipo = new JLabel("Tipo:");
			lblTipo.setBounds(668, 24, 82, 14);
			panelEmpresa.add(lblTipo);

			txtTipodeEmpresa = new JTextField();
			txtTipodeEmpresa.setEditable(false);
			txtTipodeEmpresa.setColumns(10);
			txtTipodeEmpresa.setBounds(707, 21, 180, 20);
			panelEmpresa.add(txtTipodeEmpresa);

			lblNewLabel_2 = new JLabel("Tipo de acci\u00F3n:");
			lblNewLabel_2.setBounds(589, 61, 107, 14);
			panelData.add(lblNewLabel_2);

			rdbtnContratacion = new JRadioButton("Contrataci\u00F3n");
			rdbtnContratacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(solicitudLoaded != null) {
						if(solicitudLoaded.getEstado() == EstadoSolicitudEmpresa.SATISFECHA) {
							accionGroup.setSelected(rdbtnDesemplear.getModel(), true);
							cambiarAccionVentana(false);
							return;
						}
					}
					cambiarAccionVentana(true);
				}
			});
			rdbtnContratacion.setSelected(true);
			rdbtnContratacion.setBounds(675, 59, 115, 18);
			panelData.add(rdbtnContratacion);

			rdbtnDesemplear = new JRadioButton("Desemplear");
			rdbtnDesemplear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiarAccionVentana(false);
				}
			});
			rdbtnDesemplear.setBounds(792, 59, 115, 18);

			// Agregar acciones al grupo
			accionGroup.add(rdbtnContratacion);
			accionGroup.add(rdbtnDesemplear);

			panelData.add(rdbtnDesemplear);

			label = new JLabel("%");
			label.setBounds(676, 23, 25, 14);
			panelData.add(label);

			panelCandidatos = new JPanel();
			panelCandidatos.setBorder(titledBorder);
			panelCandidatos.setBounds(10, 165, 917, 427);
			contentPanel.add(panelCandidatos);
			panelCandidatos.setLayout(new BorderLayout(0, 0));

			scrollPane = new JScrollPane();
			panelCandidatos.add(scrollPane);
			{
				tablaPersonal = new CheckBoxsEditableTable(this.model, kColumnaCheckboxes);
				
				// Add sorter
				TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tablaPersonal.getModel());
				List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>(1);
				sortKeys.add(new RowSorter.SortKey(3, SortOrder.DESCENDING));
				sorter.setSortKeys(sortKeys);		
				tablaPersonal.setRowSorter(sorter);
				
				tablaPersonal.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int index = tablaPersonal.getSelectedRow();
						if(index >= 0) {
							String codigoString = tablaPersonal.getValueAt(index, 1).toString();
							ArrayList<Personal> result = BolsaTrabajo.getInstance().getPersonalByID(codigoString);
							if(result.size() != 0) {
								personalSeleccionado = result.get(0);
								btnVerDetallesPersonaSeleccionada.setEnabled(true);
							}
						}
					}
				});
				scrollPane.setViewportView(tablaPersonal);
				tablaPersonal.setPreferredScrollableViewportSize(tablaPersonal.getPreferredSize());
			}
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					btnAccion = new JButton("Contratar candidatos seleccionados");
					btnAccion.setEnabled(true);
					btnAccion.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ArrayList<String> cedulaSeleccionadas = getCedulasSeleccionadas();
							int cantidadPlazasSeleccionadas = cedulaSeleccionadas.size();
							if(cantidadPlazasSeleccionadas == 0) {
								JOptionPane.showMessageDialog(null,
										"Seleccione al menos una persona.",
										"Error",
										JOptionPane.ERROR_MESSAGE);
							}
							else if(rdbtnContratacion.isSelected() && cantidadPlazasSeleccionadas > solicitudLoaded.getCantidadPlazasNecesarias()) {
								int option = JOptionPane.showConfirmDialog(null, "La cantidad de plazas seleccionadas sobrepasa la acordada en la solicitud. ¿Desea actualizar la cantidad de plazas a " + cantidadPlazasSeleccionadas + "?\nSi no actualiza, tendr\u00e1 que seleccionar una cantidad de plazas igual a " + solicitud.getCantidadPlazasNecesarias()+".", "Confirmaci\u00f3n | Cantidad de plazas", JOptionPane.YES_NO_OPTION);
								if(JOptionPane.YES_OPTION == option) {
									solicitudLoaded.setCantidadPlazasNecesarias(cantidadPlazasSeleccionadas);
									txtPlazasNecesarias.setText(String.valueOf(cantidadPlazasSeleccionadas));
									contratarPersonas(getDataSeleccionada(cedulaSeleccionadas));
								}
							}
							else {
								if(rdbtnContratacion.isSelected())
								{
									contratarPersonas(getDataSeleccionada(cedulaSeleccionadas));
								}
								else {
									int option = JOptionPane.showConfirmDialog(null, "¿Est\u00e1 seguro de que desea desemplear a estas " + cantidadPlazasSeleccionadas +" personas?", "Confirmaci\u00f3n", JOptionPane.YES_NO_OPTION);
									if(JOptionPane.YES_OPTION == option) {
										desemplearPersonas(getDataSeleccionada(cedulaSeleccionadas));
									}
								}
							}
						}
					});
					btnAccion.setActionCommand("OK");
					buttonPane.add(btnAccion);
					getRootPane().setDefaultButton(btnAccion);
				}
				{
					JButton cancelButton = new JButton("Cancelar");
					cancelButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});

					btnVerDetallesPersonaSeleccionada = new JButton("Ver detalles de la persona seleccionada");
					btnVerDetallesPersonaSeleccionada.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(personalSeleccionado != null) {
								PropiedadesCumplidasPersonal propiedadesCumplidasPersonal = new PropiedadesCumplidasPersonal(personalSeleccionado, dataCandidatos.get(personalSeleccionado), solicitudLoaded);
								propiedadesCumplidasPersonal.setModal(true);
								propiedadesCumplidasPersonal.setVisible(true);

								btnVerDetallesPersonaSeleccionada.setEnabled(false);
								personalSeleccionado = null;								
							}
						}
					});
					btnVerDetallesPersonaSeleccionada.setEnabled(false);
					btnVerDetallesPersonaSeleccionada.setActionCommand("OK");
					buttonPane.add(btnVerDetallesPersonaSeleccionada);

					btnVerDetallesSolicitud = new JButton("Ver todos los detalles de la solicitud");
					btnVerDetallesSolicitud.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(solicitudLoaded != null) {
								RegSolEmpresa detalles = new RegSolEmpresa(solicitudLoaded, false);
								detalles.setModal(true);
								detalles.setVisible(true);
							}
						}
					});
					btnVerDetallesSolicitud.setEnabled(this.tieneDatosIniciales);
					btnVerDetallesSolicitud.setActionCommand("OK");
					buttonPane.add(btnVerDetallesSolicitud);
					cancelButton.setActionCommand("Cancel");
					buttonPane.add(cancelButton);
				}
			}
		}

		if(tieneDatosIniciales) {
			cargarDatosSolicitud(solicitudLoaded);
		}
		cargarDatosTablaPersonal(true);
	}

	// Obtener row
	private Object[] getRowData(Personal personal, SolicitudPersonal solicitudPersonal){
		Object[] row = new Object[model.getColumnCount()];
		row[0] = false;
		row[1] = personal.getCedula();
		row[2] = personal.getNombre();
		row[3] = Utils.roundTo2(solicitudPersonal.getPorcentajeMatchAsignado()) + "%";
		return row;
	}

	// Llenar la tabla
	// Por alguna razon, se muestra el mensaje primero y despues la interfaz cuando se abre una solicitud sin listado
	// Entonces, firstRun arregla eso
	private void cargarDatosTablaPersonal(boolean firstRun) {
		model.setRowCount(0);

		if(solicitudLoaded != null) {
			BolsaTrabajo bolsaTrabajo = BolsaTrabajo.getInstance();
			this.dataCandidatos = bolsaTrabajo.getCandidatosByPorcentajeMatch(
					solicitudLoaded, 
					rdbtnContratacion.isSelected() ? bolsaTrabajo.getPersonalByID(null) : bolsaTrabajo.getPersonasContratadasBySolicitud(solicitudLoaded),
							rdbtnDesemplear.isSelected()
					);

			// Agregar datos a la tabla
			this.dataCandidatos.forEach((persona, currentSolicitud) -> {
				model.addRow(getRowData(persona, currentSolicitud));
			});

			sortearTabla();
			
			// Actualizar la tabla
			model.fireTableDataChanged();

			if(this.dataCandidatos.size() == 0 && !firstRun) {
				JOptionPane.showMessageDialog(null,
						"No existen datos que mostrar.\n" + (rdbtnContratacion.isSelected() ? "No hay personas que cumplan con los requisitos de la solcitud." : "No se ha empleado a nadie."),
						"Informaci\u00f3n",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}

		// Para evitar errores
		btnVerDetallesPersonaSeleccionada.setEnabled(false);
	}

	// Sortear elementos de mayor a menor con el porcentaje
	private void sortearTabla() {
		
	}

	private void cargarDatosSolicitud(SolicitudEmpresa solicitudLoaded) {
		if(tieneDatosIniciales) {
			txtIdSolicitud.setText(solicitudLoaded.getId());
		}

		spnPorcentajeMatch.setValue(Float.valueOf(solicitudLoaded.getPorcentajeMatchRequerido()));
		spnPorcentajeMatch.setEnabled(true);
		btnActualizarPorcentaje.setEnabled(true);
		txtIdSolicitud.setEditable(false);
		btnBuscarSolicitud.setEnabled(false);
		txtPlazasNecesarias.setText(String.valueOf(solicitudLoaded.getCantidadPlazasNecesarias()));
		txtTipoPersonalSolicitado.setText(solicitudLoaded.getTipoPersonalSolicitado());
		btnVerDetallesSolicitud.setEnabled(true);
		Empresa empresa = getDatosEmpresa(solicitudLoaded.getRNCEmpresa());
		if(empresa != null) {
			txtRNCEmpresa.setText(empresa.getRNC());
			txtNombreComercial.setText(empresa.getNombreComercial());
			txtTipodeEmpresa.setText(empresa.getTipo());
		}
		
		// Cambiar a desemplear si la solicitud esta satisfecha
		if(this.solicitudLoaded.getCedulasPersonasContratadas().size() == this.solicitudLoaded.getCantidadPlazasNecesarias()) {
			rdbtnDesemplear.doClick();
		}
	}

	private Empresa getDatosEmpresa(String RNC) {
		Empresa auxEmpresa = null;
		ArrayList<Empresa> result = BolsaTrabajo.getInstance().getEmpresasByID(RNC);
		if(result.size() > 0) {
			auxEmpresa = result.get(0);
		}

		return auxEmpresa;
	}

	// Obtener las cedulas de las personas seleccionadas en la tabla
	private ArrayList<String> getCedulasSeleccionadas() {
		ArrayList<String> cedulas = new ArrayList<String>();

		for (int rowIndex = 0; rowIndex < model.getRowCount(); rowIndex++) {
			if((boolean)(this.model.getValueAt(rowIndex, kColumnaCheckboxes))) {
				cedulas.add(this.model.getValueAt(rowIndex, 1).toString());
			}
		}

		return cedulas;
	}

	// Cambiar entre contratar y desemplear
	private void cambiarAccionVentana(boolean isForContratacion) {
		if(solicitudLoaded != null) {
			spnPorcentajeMatch.setEnabled(isForContratacion);
			btnActualizarPorcentaje.setEnabled(isForContratacion);			
		}

		this.titledBorder.setTitle(isForContratacion ? "Candidatos al empleo" : "Personal a desemplear");

		btnAccion.setText(isForContratacion
				? "Contratar candidatos seleccionados"
						: "Desemplear personas seleccionadas");

		// Limpiar tabla
		model.setRowCount(0);
		// Para actualizar el titulo
		panelCandidatos.repaint();
		personalSeleccionado = null;
		btnVerDetallesPersonaSeleccionada.setEnabled(false);
		cargarDatosTablaPersonal(false);
	}

	private Map<Personal, SolicitudPersonal> getDataSeleccionada(ArrayList<String> cedulas){
		Map<Personal, SolicitudPersonal> dataMap = new HashMap<Personal, SolicitudPersonal>();

		dataCandidatos.forEach((personal, solicitudPersonal) -> {
			if(cedulas.contains(personal.getCedula())){
				dataMap.put(personal, solicitudPersonal);
			}
		});

		return dataMap;
	}

	private void actualizarCantidadPlazas() {
		int incremento = 0;
		while(incremento <= 0) {
			try {
				incremento = Integer.parseInt(JOptionPane.showInputDialog(new JFrame(),"Ingrese en cu\u00e1nto incrementar la cantidad de plazas:"));
				if(incremento <= 0) {
					JOptionPane.showMessageDialog(null,"Ingrese un n\u00famero mayor que 0.","Error",JOptionPane.ERROR_MESSAGE); 
				}
				else {
					solicitudLoaded.setCantidadPlazasNecesarias(solicitudLoaded.getCantidadPlazasNecesarias() + incremento);
					txtPlazasNecesarias.setText(String.valueOf(solicitudLoaded.getCantidadPlazasNecesarias()));					
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Ingrese un n\u00famero correcto.","Error",JOptionPane.ERROR_MESSAGE); 
			}			
		}
	}

	private void checkSiYaFueSatisfecha() {
		if(solicitudLoaded != null) {
			if(solicitudLoaded.getCantidadPlazasNecesarias() == solicitudLoaded.getCedulasPersonasContratadas().size()) {
				int option = JOptionPane.showConfirmDialog(null, "La cantidad de plazas necesarias ya fue satisfecha.\n¿Desea incrementar la cantidad de plazas para poder seguir contratando?", "Confirmaci\u00f3n | Cantidad de plazas", JOptionPane.YES_NO_OPTION);
				if(JOptionPane.YES_OPTION == option) {
					actualizarCantidadPlazas();
				}
				else {
					// Si ya fue satisfecha, solo puede desemplear
					solicitudLoaded.setEstado(EstadoSolicitudEmpresa.SATISFECHA);
					accionGroup.setSelected(rdbtnDesemplear.getModel(), true);
					cambiarAccionVentana(false);
				}
			}
		}
	}

	private void contratarPersonas(Map<Personal, SolicitudPersonal> data) {
		if(data != null) {
			BolsaTrabajo bolsaTrabajo = BolsaTrabajo.getInstance();
			data.keySet().forEach(personal -> {
				bolsaTrabajo.contratarPersonal(personal, solicitudLoaded, data.get(personal).getId());
			});

			JOptionPane.showMessageDialog(null,
					"Contrataci\u00f3n exitosa.",
					"Informaci\u00f3n",
					JOptionPane.INFORMATION_MESSAGE);
			// Reiniciar la tabla
			cargarDatosTablaPersonal(false);
			// Saber si la solicitud fue satisfecha
			checkSiYaFueSatisfecha();
			return;
		}

		JOptionPane.showMessageDialog(null,
				"Hubo un error desconocido al intentar contratar a las personas.",
				"Error",
				JOptionPane.ERROR_MESSAGE);
	}

	// Si ya esta satisfecha y desempleo a alguien, tiene que cambiar
	private void actualizarEstadoSolicitud() {
		if(solicitudLoaded.getEstado() == EstadoSolicitudEmpresa.SATISFECHA) {
			solicitudLoaded.setEstado(EstadoSolicitudEmpresa.ACTIVA);
		}
	}
	
	private void desemplearPersonas(Map<Personal, SolicitudPersonal> data) {
		if(data.size() != 0) {
			BolsaTrabajo bolsaTrabajo = BolsaTrabajo.getInstance();
			data.keySet().forEach(personal -> {
				bolsaTrabajo.desemplearPersonal(personal, solicitudLoaded);				
			});
			
			JOptionPane.showMessageDialog(null,
					"Se desemplearon las personas de forma correcta.",
					"Informaci\u00f3n",
					JOptionPane.INFORMATION_MESSAGE);
			
			cargarDatosTablaPersonal(false);
			actualizarEstadoSolicitud();
			
			return;
		}

		JOptionPane.showMessageDialog(null,
				"Hubo un error desconocido al intentar desemplear a las personas.",
				"Error",
				JOptionPane.ERROR_MESSAGE);
	}
}
