package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

import logico.BolsaTrabajo;
import logico.Obrero;
import logico.Personal;
import logico.SolicitudPersonal;
import logico.Tecnico;
import logico.Universitario;
import logico.Utils;

import javax.swing.JRadioButton;
import java.awt.Checkbox;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

public class RegSolPersonal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCode;
	// Estos elementos deben colocarse
	private JFormattedTextField txtFCedulaP;
	private JLabel lblCode;
	private Checkbox ckFontanero;
	private Checkbox ckSastre;
	private Checkbox ckBarbero;
	private Checkbox ckSoldador;
	private Checkbox ckCerrajero;
	private Checkbox ckMecanico;
	private Checkbox ckPolicia;
	private Checkbox ckAlbagnil;
	private Checkbox ckExterminador;
	private Checkbox ckAgricultor;
	private JComboBox cbxUniversidad;
	private JComboBox cbxCarrera;
	private JComboBox cbxAreaTecnica;
	private JComboBox cbxModalidad;
	private JRadioButton rbSDispSalirCiudad;
	private JRadioButton rbSDispCambiarRes;
	private JRadioButton rbNDispSalirCiudad;
	private JRadioButton rbNDispCambiarRes;
	private JRadioButton rbUniversitario;
	private JRadioButton rbTecnico;
	private JRadioButton rbObrero;
	private ButtonGroup dispSalirCiudadGroup;
	private ButtonGroup dispCambiarResGroup;
	private ButtonGroup tipoPersonalGroup;
	private static JPanel pnUniversitario;
	private static JPanel pnTecnico;
	private static JPanel pnObrero;
	private static JPanel pnGeneral;
	private static JPanel pnTipoPersonal;
	private JButton btnCancelar;
	private JSpinner spnSalarioEsp;
	private JSpinner spnAgnosExp;
	private JTextPane txtPDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegSolPersonal dialog = new RegSolPersonal(null, null, false);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegSolPersonal(Personal personal, SolicitudPersonal solPersonal, boolean editing) {
		setResizable(false);
		setTitle("Solicitud de Personal");
		setModal(true);
		setBounds(100, 100, 599, 648);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				pnGeneral = new JPanel();
				pnGeneral.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				pnGeneral.setBounds(10, 11, 579, 378);
				panel.add(pnGeneral);
				pnGeneral.setLayout(null);
				{
					lblCode = new JLabel("C\u00F3digo:");
					lblCode.setBounds(81, 11, 152, 20);
					pnGeneral.add(lblCode);
				}
				{
					txtCode = new JTextField();
					txtCode.setBounds(301, 8, 195, 20);
					pnGeneral.add(txtCode);
					txtCode.setText(SolicitudPersonal.genID());
					txtCode.setEditable(false);
					txtCode.setColumns(10);
				}
				{
					JLabel lblCdulaDelPersonal = new JLabel("C\u00E9dula del Personal:");
					lblCdulaDelPersonal.setBounds(81, 50, 152, 20);
					pnGeneral.add(lblCdulaDelPersonal);
				}
				txtFCedulaP = new JFormattedTextField(Utils.getMaskCedula());
				txtFCedulaP.setBounds(301, 51, 195, 20);
				pnGeneral.add(txtFCedulaP);
				txtFCedulaP.setToolTipText("");
				txtFCedulaP.setForeground(Color.BLACK);
				{
					JLabel lblNewLabel = new JLabel("Salario Esperado:");
					lblNewLabel.setBounds(81, 92, 152, 20);
					pnGeneral.add(lblNewLabel);

					spnSalarioEsp = new JSpinner();
					spnSalarioEsp.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1000)));
					spnSalarioEsp.setBounds(301, 94, 195, 20);
					pnGeneral.add(spnSalarioEsp);

					JLabel label = new JLabel("A\u00F1os de Experiencia:");
					label.setBounds(81, 134, 152, 20);
					pnGeneral.add(label);

					spnAgnosExp = new JSpinner();
					spnAgnosExp.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
					spnAgnosExp.setBounds(301, 137, 195, 20);
					pnGeneral.add(spnAgnosExp);

					JLabel label3 = new JLabel("\u00BFPosee disponibilidad para salir de la ciudad?");
					label3.setBounds(46, 310, 330, 20);
					pnGeneral.add(label3);

					JLabel label2 = new JLabel("\u00BFPosee disponibilidad para cambiar de residencia?");
					label2.setBounds(46, 347, 330, 20);
					pnGeneral.add(label2);

					dispCambiarResGroup = new ButtonGroup();
					dispSalirCiudadGroup = new ButtonGroup();

					rbSDispSalirCiudad = new JRadioButton("S\u00ED");

					rbSDispSalirCiudad.setBounds(409, 313, 56, 14);
					pnGeneral.add(rbSDispSalirCiudad);
					dispSalirCiudadGroup.add(rbSDispSalirCiudad);

					rbSDispCambiarRes = new JRadioButton("S\u00ED");
					rbSDispCambiarRes.setBounds(409, 350, 56, 14);
					pnGeneral.add(rbSDispCambiarRes);
					dispCambiarResGroup.add(rbSDispCambiarRes);

					rbNDispSalirCiudad = new JRadioButton("No");
					rbNDispSalirCiudad.setBounds(477, 313, 51, 14);
					pnGeneral.add(rbNDispSalirCiudad);
					dispSalirCiudadGroup.add(rbNDispSalirCiudad);

					rbNDispCambiarRes = new JRadioButton("No");
					rbNDispCambiarRes.setBounds(477, 350, 51, 14);
					pnGeneral.add(rbNDispCambiarRes);
					dispCambiarResGroup.add(rbNDispCambiarRes);

					{
						JLabel lblTipoDeTrabajo = new JLabel("Modalidad de Trabajo:");
						lblTipoDeTrabajo.setBounds(81, 176, 152, 20);
						pnGeneral.add(lblTipoDeTrabajo);
					}
					{
						cbxModalidad = new JComboBox();
						cbxModalidad.setModel(new DefaultComboBoxModel(new String[] { "<Seleccione>", "Remoto",
								"Tiempo Completo", "Medio Tiempo", "Freelancer" }));
						cbxModalidad.setBounds(301, 180, 195, 20);
						pnGeneral.add(cbxModalidad);
					}
					{
						JLabel label5 = new JLabel("Descripci\u00F3n:");
						label5.setBounds(81, 218, 152, 20);
						pnGeneral.add(label5);
					}
				}

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(301, 218, 195, 48);
				pnGeneral.add(scrollPane);

				txtPDescripcion = new JTextPane();
				scrollPane.setViewportView(txtPDescripcion);
				txtPDescripcion.setDragEnabled(false);
				txtPDescripcion.setBorder(new LineBorder(new Color(192, 192, 192)));
				{
					pnTipoPersonal = new JPanel();
					pnTipoPersonal.setLayout(null);
					pnTipoPersonal.setBorder(new TitledBorder(null, "Tipo de Personal", TitledBorder.LEADING,
							TitledBorder.TOP, null, null));
					pnTipoPersonal.setBounds(10, 400, 579, 71);
					panel.add(pnTipoPersonal);

					tipoPersonalGroup = new ButtonGroup();

					rbUniversitario = new JRadioButton("Universitario");
					rbUniversitario.setSelected(true);
					rbUniversitario.setBounds(69, 29, 123, 23);
					pnTipoPersonal.add(rbUniversitario);
					rbUniversitario.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (rbUniversitario.isSelected()) {
								pnObrero.setVisible(false);
								pnTecnico.setVisible(false);
								pnUniversitario.setVisible(true);
							}
						}
					});
					tipoPersonalGroup.add(rbUniversitario);

					rbTecnico = new JRadioButton("T\u00E9cnico");
					rbTecnico.setBounds(231, 29, 123, 23);
					pnTipoPersonal.add(rbTecnico);
					rbTecnico.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (rbTecnico.isSelected()) {
								pnObrero.setVisible(false);
								pnTecnico.setVisible(true);
								pnUniversitario.setVisible(false);
							}
						}
					});
					tipoPersonalGroup.add(rbTecnico);

					rbObrero = new JRadioButton("Obrero");
					rbObrero.setBounds(393, 29, 123, 23);
					pnTipoPersonal.add(rbObrero);
					rbObrero.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (rbObrero.isSelected()) {
								pnTecnico.setVisible(false);
								pnObrero.setVisible(true);
								pnUniversitario.setVisible(false);
							}
						}
					});
					tipoPersonalGroup.add(rbObrero);

					pnUniversitario = new JPanel();
					pnUniversitario.setLayout(null);
					pnUniversitario
					.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					pnUniversitario.setBounds(10, 475, 579, 71);
					panel.add(pnUniversitario);
					{
						JLabel label = new JLabel("Universidad:");
						label.setBounds(22, 11, 136, 14);
						pnUniversitario.add(label);
					}
					{
						cbxUniversidad = new JComboBox();
						cbxUniversidad.setModel(new DefaultComboBoxModel(
								new String[] { "<Seleccione>", "PUCMM", "UTESA", "O&M", "UASD", "INTEC", "APEC", "UAPA",
										"UNPHU", "UNIBE", "UNEV", "UCDEP", "UNAPEC", "UCSD" }));
						cbxUniversidad.setBounds(22, 36, 159, 20);
						pnUniversitario.add(cbxUniversidad);
					}
					{
						JLabel label = new JLabel("Carrera:");
						label.setBounds(243, 11, 136, 14);
						pnUniversitario.add(label);
					}
					{
						cbxCarrera = new JComboBox();
						cbxCarrera.setModel(new DefaultComboBoxModel(new String[] { "<Seleccione>",
								"Direcci\u00F3n Empresarial", "Administraci\u00F3n Hotelera", "Arquitectura",
								"Comunicaci\u00F3n Social", "Derecho", "Dise\u00F1o e Interiorismo", "Econom\u00EDa",
								"Educaci\u00F3n", "Estomatolog\u00EDa", "Filosof\u00EDa",
								"Gesti\u00F3n Financiera y Auditor\u00EDa", "Ingenier\u00EDa Civil",
								"Ingenier\u00EDa Mec\u00E1nica", "Ingenier\u00EDa El\u00E9ctrica",
								"Ingenier\u00EDa Industrial y de Sistemas", "Ingenier\u00EDa en Mecatr\u00F3nica",
								"Ingenier\u00EDa de Ciencias de la Computaci\u00F3n", "Ingenier\u00EDa Telem\u00E1tica",
								"Ingenier\u00EDa Ambiental", "Medicina", "Marketing", "Nutrici\u00F3n y Diet\u00E9tica",
								"Psicolog\u00EDa", "Terapia F\u00EDsica", "Trabajo Social",
						"Hospitalidad y Turismo" }));
						cbxCarrera.setBounds(243, 36, 273, 20);
						pnUniversitario.add(cbxCarrera);
					}
					pnTecnico = new JPanel();
					pnTecnico.setVisible(false);
					pnTecnico.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					pnTecnico.setBounds(10, 475, 579, 71);
					panel.add(pnTecnico);
					pnTecnico.setLayout(null);
					{
						JLabel label = new JLabel("\u00C1rea T\u00E9cnica:");
						label.setBounds(22, 11, 265, 14);
						pnTecnico.add(label);
					}
					{
						cbxAreaTecnica = new JComboBox();
						cbxAreaTecnica.setModel(new DefaultComboBoxModel(new String[] { "<Seleccione>",
								"Administraci\u00F3n de Micro, Peque\u00F1as y Medianas Empresas", "Artes Culinarias",
								"Automatizaci\u00F3n", "Dise\u00F1o Gr\u00E1fico", "Enfermer\u00EDa",
								"Gesti\u00F3n Social y Comunitaria", "Mercadeo", "Microfinanzas",
								"Publicidad y Medios Digitales", "Redes de Datos", "Log\u00EDstica Integral",
						"Programaci\u00F3n Web" }));
						cbxAreaTecnica.setBounds(22, 36, 273, 20);
						pnTecnico.add(cbxAreaTecnica);
					}
				}

				pnObrero = new JPanel();
				pnObrero.setVisible(false);
				pnObrero.setLayout(null);
				pnObrero.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Oficios",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				pnObrero.setBounds(10, 475, 579, 82);
				panel.add(pnObrero);
				{
					ckFontanero = new Checkbox("Fontanero");
					ckFontanero.setBounds(10, 21, 102, 22);
					pnObrero.add(ckFontanero);
				}
				{
					ckSastre = new Checkbox("Sastre");
					ckSastre.setBounds(10, 49, 102, 22);
					pnObrero.add(ckSastre);
				}
				{
					ckBarbero = new Checkbox("Barbero");
					ckBarbero.setBounds(118, 21, 102, 22);
					pnObrero.add(ckBarbero);
				}
				{
					ckSoldador = new Checkbox("Soldador");
					ckSoldador.setBounds(118, 49, 102, 22);
					pnObrero.add(ckSoldador);
				}
				{
					ckCerrajero = new Checkbox("Cerrajero");
					ckCerrajero.setBounds(226, 21, 102, 22);
					pnObrero.add(ckCerrajero);
				}
				{
					ckMecanico = new Checkbox("Mec\u00E1nico");
					ckMecanico.setBounds(226, 49, 102, 22);
					pnObrero.add(ckMecanico);
				}
				{
					ckPolicia = new Checkbox("Polic\u00EDa");
					ckPolicia.setBounds(334, 21, 102, 22);
					pnObrero.add(ckPolicia);
				}
				{
					ckAlbagnil = new Checkbox("Alba\u00F1il");
					ckAlbagnil.setBounds(334, 50, 102, 22);
					pnObrero.add(ckAlbagnil);
				}
				{
					ckExterminador = new Checkbox("Exterminador");
					ckExterminador.setBounds(442, 21, 102, 22);
					pnObrero.add(ckExterminador);
				}
				{
					ckAgricultor = new Checkbox("Agricultor");
					ckAgricultor.setBounds(442, 50, 102, 22);
					pnObrero.add(ckAgricultor);
				}

				{
					JPanel buttonPane = new JPanel();
					buttonPane
					.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
					getContentPane().add(buttonPane, BorderLayout.SOUTH);
					{
						JButton btnSolicitar = new JButton("Solicitar");
						btnSolicitar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								String message = comprobarCampos();
								if (!message.isEmpty()) {
									JOptionPane.showMessageDialog(null, message);
									return;
								}

								String cedula = txtFCedulaP.getText();

								if(BolsaTrabajo.getInstance().getPersonalByID(cedula).size() == 0) {
									JOptionPane.showMessageDialog(null, "No existe una persona con esa c\u00e9dula.", "Error",
											JOptionPane.ERROR_MESSAGE);
									return;
								}

								String codigo = txtCode.getText();
								String descripcion = txtPDescripcion.getText();
								float salarioEsperado = Utils.getSpinnerFloatValue(spnSalarioEsp);
								int agnosExperiencia = (int) spnAgnosExp.getValue();
								String modalidadTrabajo = (String) cbxModalidad.getSelectedItem();
								boolean dispSalirCiudad = Utils.getSelectedRadioButtonText(dispCambiarResGroup)
										.equalsIgnoreCase("si");
								boolean dispCambiarResidencia = Utils.getSelectedRadioButtonText(dispCambiarResGroup)
										.equalsIgnoreCase("si");

								ArrayList<String> oficios = new ArrayList<String>();
								String areaTecnica = new String();
								String universidad = new String();
								String carrera = new String();
								String tipoPersonal = new String();
								if (rbObrero.isSelected()) {
									oficios = getOficiosSelected();
									tipoPersonal = "Obrero";
								} else if (rbTecnico.isSelected()) {
									areaTecnica = (String) cbxAreaTecnica.getSelectedItem();
									tipoPersonal = "Tecnico";
								} else if (rbUniversitario.isSelected()) {
									universidad = (String) cbxUniversidad.getSelectedItem();
									carrera = (String) cbxCarrera.getSelectedItem();
									tipoPersonal = "Universitario";
								}

								if (editing) {
									SolicitudPersonal solPersonalAux = BolsaTrabajo.getInstance()
											.getSolicitudesPersonalByID(codigo).get(0);

									if (solPersonal == null) {
										JOptionPane.showMessageDialog(null,
												"La solicitud que intenta modificar no existe", null, JOptionPane.ERROR_MESSAGE);
										return;
									} else {
										solPersonalAux.setAgnosExperiencia(agnosExperiencia);
										solPersonalAux.setTipoPersonal(tipoPersonal);
										solPersonalAux.setCarrera(null);
										solPersonalAux.setUniversidad(null);
										solPersonalAux.setAreaTecnica(null);
										solPersonalAux.setOficios(new ArrayList<String>());
										solPersonalAux.setDisponibilidadCambioResidencia(dispCambiarResidencia);
										solPersonalAux.setDisponibilidadSalirCiudad(dispSalirCiudad);
										solPersonalAux.setSalarioEsperado(salarioEsperado);
										solPersonalAux.setDescripcion(descripcion);
										solPersonalAux.setModalidadDeTrabajo(modalidadTrabajo);

										if (tipoPersonal.equalsIgnoreCase("Universitario")) {
											solPersonalAux.setCarrera(carrera);
											solPersonalAux.setUniversidad(universidad);

										} else if (tipoPersonal.equalsIgnoreCase("tecnico"))
											solPersonalAux.setAreaTecnica(areaTecnica);
										else if (tipoPersonal.equalsIgnoreCase("obrero"))
											solPersonalAux.setOficios(oficios);
									}
								} else {
									BolsaTrabajo.getInstance().agregarSolicitudEmpleado(cedula,
											new SolicitudPersonal(codigo, cedula, descripcion, salarioEsperado,
													agnosExperiencia, tipoPersonal, areaTecnica, carrera, universidad,
													oficios, dispSalirCiudad, dispCambiarResidencia, modalidadTrabajo));
								}

								if (BolsaTrabajo.getInstance().getSolicitudesPersonalByID(codigo).size() != 1) {
									JOptionPane.showMessageDialog(null, "La solicitud ha fallado en agregarse.", null,
											JOptionPane.ERROR_MESSAGE);
									return;
								}

								if (BolsaTrabajo.getInstance().getPersonalByID(cedula).get(0)
										.getIdEmpresaContratacion() != null) {
									JOptionPane.showMessageDialog(null,
											"El candidato ya est\u00e1 contratado.\nIntente otra vez con otro usuario.", null,
											JOptionPane.WARNING_MESSAGE);
									return;
								}

								if (JOptionPane.showConfirmDialog(null, "La solicitud se agreg\u00f3 correctamente.\n�Quiere hacer otra solicitud?", "Informaci\u00f3n",
										JOptionPane.YES_NO_OPTION) == 1)
									dispose();

								clean();
								loadPersonal(personal, false);
							}
						});
						btnSolicitar.setActionCommand("OK");
						buttonPane.add(btnSolicitar);
						getRootPane().setDefaultButton(btnSolicitar);
					}
					{
						btnCancelar = new JButton("Cancelar");
						btnCancelar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								dispose();
							}
						});
						btnCancelar.setActionCommand("Cancel");
						buttonPane.add(btnCancelar);
					}
				}
			}
		}

		if (personal != null)
			loadPersonal(personal, editing);
		else if (solPersonal != null)
			loadSolPersonal(solPersonal, editing);
	}

	private void loadSolPersonal(SolicitudPersonal solPersonal, boolean editing) {
		btnCancelar.setEnabled(true);
		txtFCedulaP.setText(solPersonal.getCedulaPersonal());
		txtCode.setText(solPersonal.getId());
		txtPDescripcion.setText(solPersonal.getDescripcion());
		txtPDescripcion.setEnabled(editing);
		spnSalarioEsp.setValue(solPersonal.getSalarioEsperado());
		spnAgnosExp.setValue(solPersonal.getAgnosExperiencia());
		for (int index = 0; cbxUniversidad.getItemCount() > index; index++)
			if (solPersonal.getModalidadDeTrabajo().equalsIgnoreCase((String) cbxModalidad.getItemAt(index)))
				cbxModalidad.setSelectedIndex(index);
		dispCambiarResGroup.clearSelection();
		dispSalirCiudadGroup.clearSelection();
		if (solPersonal.isDisponibilidadCambioResidencia())
			dispCambiarResGroup.setSelected(rbSDispCambiarRes.getModel(), true);
		else
			dispCambiarResGroup.setSelected(rbNDispCambiarRes.getModel(), true);

		if (solPersonal.isDisponibilidadSalirCiudad())
			dispSalirCiudadGroup.setSelected(rbSDispSalirCiudad.getModel(), true);
		else
			dispSalirCiudadGroup.setSelected(rbNDispSalirCiudad.getModel(), true);

		if (solPersonal.getTipoPersonal().equalsIgnoreCase("universitario")) {
			rbUniversitario.doClick();

			for (int index = 0; cbxUniversidad.getItemCount() > index; index++)
				if (solPersonal.getUniversidad().equalsIgnoreCase((String) cbxUniversidad.getItemAt(index)))
					cbxUniversidad.setSelectedIndex(index);

			for (int index = 0; cbxCarrera.getItemCount() > index; index++)
				if (solPersonal.getCarrera().equalsIgnoreCase((String) cbxCarrera.getItemAt(index)))
					cbxCarrera.setSelectedIndex(index);
		} else if (solPersonal.getTipoPersonal().equalsIgnoreCase("obrero")) {
			rbObrero.doClick();
			ArrayList<String> oficios = solPersonal.getOficios();
			Utils.activarCheckboxEnPanel(pnObrero, oficios);
		} else if (solPersonal.getTipoPersonal().equalsIgnoreCase("tecnico")) {

			rbTecnico.doClick();
			for (int index = 0; cbxAreaTecnica.getItemCount() > index; index++)
				if (solPersonal.getAreaTecnica().equalsIgnoreCase((String) cbxAreaTecnica.getItemAt(index)))
					cbxAreaTecnica.setSelectedIndex(index);
		}
	}

	private String comprobarCampos() {
		ArrayList<String> emptyFields = new ArrayList<String>();

		if (txtFCedulaP.getText().equals(Utils.getMaskCedula().getMask().replace('#', '_')))
			emptyFields.add("C\u00e9dula");
		if (Utils.getSpinnerFloatValue(spnSalarioEsp) <= 0)
			emptyFields.add("Salario Esperado");
		if (Utils.getSpinnerIntValue(spnAgnosExp) <= 0)
			emptyFields.add("A�os de experiencia");
		if (((String) cbxModalidad.getSelectedItem()).isEmpty())
			emptyFields.add("Modalidad de trabajo");
		if (txtPDescripcion.getText().trim().isEmpty())
			emptyFields.add("Descripci\u00f3n");
		if (Utils.getSelectedRadioButtonText(dispCambiarResGroup) == null)
			emptyFields.add("Disponibilidad para cambiar de residencia");
		if (Utils.getSelectedRadioButtonText(dispSalirCiudadGroup) == null)
			emptyFields.add("Disponibilidad para salir de la ciudad");

		if (rbObrero.isSelected() && getOficiosSelected().isEmpty())
			emptyFields.add("Ningun oficio seleccionado");
		else if (rbTecnico.isSelected() && cbxAreaTecnica.getSelectedIndex() <= 0)
			emptyFields.add("Area Tecnica");
		else if (rbUniversitario.isSelected()) {
			if (cbxUniversidad.getSelectedIndex() <= 0)
				emptyFields.add("Universidad");
			if (cbxCarrera.getSelectedIndex() <= 0)
				emptyFields.add("Carrera");
		}

		String message = "";

		if (emptyFields.size() > 0) {
			message = "Los siguientes campos est\u00e1n vac\u00edos o tienen un formato incorrecto: ";

			for (String emptyField : emptyFields)
				message += "\n\t- " + emptyField;
		}

		return message;
	}

	private ArrayList<String> getOficiosSelected() {
		ArrayList<String> oficios = new ArrayList<String>();
		if (ckAgricultor.getState())
			oficios.add(ckAgricultor.getLabel());
		if (ckAlbagnil.getState())
			oficios.add(ckAlbagnil.getLabel());
		if (ckBarbero.getState())
			oficios.add(ckBarbero.getLabel());
		if (ckCerrajero.getState())
			oficios.add(ckCerrajero.getLabel());
		if (ckExterminador.getState())
			oficios.add(ckExterminador.getLabel());
		if (ckFontanero.getState())
			oficios.add(ckFontanero.getLabel());
		if (ckMecanico.getState())
			oficios.add(ckMecanico.getLabel());
		if (ckPolicia.getState())
			oficios.add(ckPolicia.getLabel());
		if (ckSastre.getState())
			oficios.add(ckSastre.getLabel());
		if (ckSoldador.getState())
			oficios.add(ckSoldador.getLabel());

		return oficios;
	}

	private void setComponentsEspecificosState(boolean state) {
		Utils.setEachAbstractButtonState(tipoPersonalGroup, state);
		// Hay deshabilitar cada campo para evitar acceder a ellos por el TAB
		cbxCarrera.setEnabled(state);
		cbxUniversidad.setEnabled(state);
		cbxAreaTecnica.setEnabled(state);

		Component[] components = pnObrero.getComponents();
		for (Component component : components) {
			if(component instanceof Checkbox) {
				component.setEnabled(state);
			}
		}
	}

	private void loadPersonal(Personal personal, boolean firstRequest) {
		// Como la solicitud inicial se hace con un tipo especifico, no se
		// pueden cambiar los datos de tipo (e.g. carrera, etc)

		if(personal != null) {			
			btnCancelar.setEnabled(false);
			txtFCedulaP.setText(personal.getCedula());
			txtFCedulaP.setEditable(false);
			
			if(firstRequest) {
				if (personal.toString().equalsIgnoreCase("universitario")) {
					rbUniversitario.doClick();
					
					for (int index = 0; cbxUniversidad.getItemCount() > index; index++)
						if (((Universitario) personal).getUniversidad()
								.equalsIgnoreCase((String) cbxUniversidad.getItemAt(index)))
							cbxUniversidad.setSelectedIndex(index);
					
					for (int index = 0; cbxCarrera.getItemCount() > index; index++)
						if (((Universitario) personal).getCarrera().equalsIgnoreCase((String) cbxCarrera.getItemAt(index)))
							cbxCarrera.setSelectedIndex(index);
				} else if (personal.toString().equalsIgnoreCase("obrero")) {
					rbObrero.doClick();
					ArrayList<String> oficios = ((Obrero) personal).getOficios();
					
					if (oficios.contains(ckAgricultor.getLabel()))
						ckAgricultor.setState(true);
					if (oficios.contains(ckAlbagnil.getLabel()))
						ckAlbagnil.setState(true);
					if (oficios.contains(ckBarbero.getLabel()))
						ckBarbero.setState(true);
					if (oficios.contains(ckCerrajero.getLabel()))
						ckCerrajero.setState(true);
					if (oficios.contains(ckExterminador.getLabel()))
						ckExterminador.setState(true);
					if (oficios.contains(ckMecanico.getLabel()))
						ckMecanico.setState(true);
					if (oficios.contains(ckFontanero.getLabel()))
						ckFontanero.setState(true);
					if (oficios.contains(ckPolicia.getLabel()))
						ckPolicia.setState(true);
					if (oficios.contains(ckSastre.getLabel()))
						ckSastre.setState(true);
					if (oficios.contains(ckSoldador.getLabel()))
						ckSoldador.setState(true);
				} else if (personal.toString().equalsIgnoreCase("tecnico")) {
					
					rbTecnico.doClick();
					for (int index = 0; cbxAreaTecnica.getItemCount() > index; index++)
						if (((Tecnico) personal).getAreaTecnica().equalsIgnoreCase((String) cbxAreaTecnica.getItemAt(index)))
							cbxAreaTecnica.setSelectedIndex(index);
				}
				setComponentsEspecificosState(false);
				return;
			}
		}
		rbUniversitario.doClick();
		setComponentsEspecificosState(true);
	}

	private void clean() {
		btnCancelar.setEnabled(true);
		txtFCedulaP.setText("");
		txtFCedulaP.setEditable(true);
		cbxUniversidad.setSelectedIndex(0);
		cbxCarrera.setSelectedIndex(0);
		ckAgricultor.setState(false);
		ckAlbagnil.setState(false);
		ckBarbero.setState(false);
		ckCerrajero.setState(false);
		ckExterminador.setState(false);
		ckMecanico.setState(false);
		ckFontanero.setState(false);
		ckPolicia.setState(false);
		ckSastre.setState(false);
		ckSoldador.setState(false);
		cbxAreaTecnica.setSelectedIndex(0);
		txtCode.setText(SolicitudPersonal.genID());
		txtPDescripcion.setText("");
		spnSalarioEsp.setValue(0);
		spnAgnosExp.setValue(0);
		cbxModalidad.setSelectedIndex(0);
		dispCambiarResGroup.clearSelection();
		dispSalirCiudadGroup.clearSelection();
		btnCancelar.setEnabled(true);
		Utils.setEachAbstractButtonState(tipoPersonalGroup, true);
	}

	public static void desactivar() {
		Utils.desactivarPanel(pnGeneral);
		Utils.desactivarPanel(pnTipoPersonal);
		Utils.desactivarPanel(pnObrero);
		Utils.desactivarPanel(pnTecnico);
		Utils.desactivarPanel(pnUniversitario);
	}
}
