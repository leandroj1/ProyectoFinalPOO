package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import logico.BolsaTrabajo;
import logico.Empresa;
import logico.SolicitudEmpresa;
import logico.Utils;

import javax.swing.JSpinner;
import java.awt.Checkbox;

import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;

public class RegSolEmpresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCode;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFemenino;
	private Checkbox ckIngles;
	private Checkbox ckEspagnol;
	private Checkbox ckFrances;
	private Checkbox ckMandarin;
	private Checkbox ckHindi;
	private Checkbox ckPortugues;
	private Checkbox ckAleman;
	private Checkbox ckRuso;
	private Checkbox ckFontanero;
	private Checkbox ckSastre;
	private Checkbox ckBarbero;
	private Checkbox ckSoldador;
	private Checkbox ckMecanico;
	private Checkbox ckPolicia;
	private Checkbox ckAlbagnil;
	private Checkbox ckAgricultor;
	private Checkbox ckExterminador;
	private Checkbox ckCerrajero;
	private JButton btnBuscarEmpresa;
	private Checkbox ckDispSalirCiudad;
	private Checkbox ckSoltero;
	private JSpinner spnEdad;
	private JLabel label_1;
	private JSpinner spnAgnosExp;
	private JLabel label_2;
	private JComboBox cbxNacionalidad;
	private JSpinner spnCantPlazas;
	private JFormattedTextField txtFRNC;
	private JTextField txtNombreComercial;
	private JComboBox cbxModalidadTrabajo;
	private JSpinner spnPorcentajeMatch;
	private JSpinner spnSalarioMax;
	private JSpinner spnSalarioMin;
	private JRadioButton rbUniversitario;
	private JRadioButton rbTecnico;
	private JRadioButton rbObrero;
	private JComboBox cbxUniversidad;
	private JComboBox cbxCarrera;
	private JComboBox cbxAreaTecnica;

	private ButtonGroup sexoButtonGroup;
	private ButtonGroup tipoPersonalButtonGroup;
	private ArrayList<Checkbox> idiomasGroup;
	private ArrayList<Checkbox> oficiosGroup;
	private Empresa selectedEmpresa;
	private Checkbox ckDispCambioResidencia;
	private JPanel pnTipoPersonal;
	private JPanel pnUniversitario;
	private JPanel pnTecnico;
	private JPanel pnObrero;
	private JPanel pnIdiomas;

	private SolicitudEmpresa solicitudLoaded = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegSolEmpresa dialog = new RegSolEmpresa(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegSolEmpresa(SolicitudEmpresa solicitud) {
		solicitudLoaded = solicitud;
		setResizable(false);
		setTitle("Solicitud de Empresa");
		setModal(true);
		setBounds(100, 100, 748, 699);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		idiomasGroup = new ArrayList<Checkbox>();
		oficiosGroup = new ArrayList<Checkbox>();

		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(10, 11, 711, 84);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel label = new JLabel("C\u00F3digo:");
					label.setBounds(19, 11, 46, 14);
					panel_1.add(label);
				}
				{
					txtCode = new JTextField();
					txtCode.setText(SolicitudEmpresa.genID());
					txtCode.setEditable(false);
					txtCode.setColumns(10);
					txtCode.setBounds(139, 8, 154, 20);
					panel_1.add(txtCode);
				}
				{
					JLabel label = new JLabel("RNC de la Empresa:");
					label.setBounds(19, 42, 182, 14);
					panel_1.add(label);
				}
				{
					txtFRNC = new JFormattedTextField(Utils.getMaskCedula());
					txtFRNC.setToolTipText("");
					txtFRNC.setForeground(Color.BLACK);
					txtFRNC.setBounds(139, 39, 154, 20);
					panel_1.add(txtFRNC);
				}
				{
					JLabel label = new JLabel("Cantidad de Plazas Necesarias:");
					label.setBounds(408, 11, 182, 14);
					panel_1.add(label);
				}
				{
					spnCantPlazas = new JSpinner();
					spnCantPlazas.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
					spnCantPlazas.setBounds(596, 8, 94, 20);
					panel_1.add(spnCantPlazas);
				}

				btnBuscarEmpresa = new JButton("Buscar");
				btnBuscarEmpresa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(Utils.isMaskCedulaDefaultValue(txtFRNC.getText())) {
							JOptionPane.showMessageDialog(null,
									"Ingrese un RNC.",
									"Error",
									JOptionPane.ERROR_MESSAGE);
							return;
						}

						// Cargar datos de Empresa
						selectedEmpresa = getDatosEmpresa(txtFRNC.getText().trim());
						if(selectedEmpresa == null) {
							JOptionPane.showMessageDialog(null,
									"No existe una empresa con este RNC.",
									"Error",
									JOptionPane.ERROR_MESSAGE);
						}
						else {
							txtNombreComercial.setText(selectedEmpresa.getNombreComercial());

							// Deshabilitar los botones y campos
							btnBuscarEmpresa.setEnabled(false);
							txtFRNC.setEditable(false);
						}
					}
				});
				btnBuscarEmpresa.setActionCommand("OK");
				btnBuscarEmpresa.setBounds(307, 38, 80, 23);
				panel_1.add(btnBuscarEmpresa);

				JLabel lblNombreComercial = new JLabel("Nombre comercial:");
				lblNombreComercial.setBounds(408, 42, 182, 14);
				panel_1.add(lblNombreComercial);

				txtNombreComercial = new JTextField();
				txtNombreComercial.setEditable(false);
				txtNombreComercial.setBounds(526, 39, 164, 20);
				panel_1.add(txtNombreComercial);
				txtNombreComercial.setColumns(10);
			}
			{
				JPanel pnRequisitos = new JPanel();
				pnRequisitos.setBorder(new TitledBorder(null, "Requisitos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				pnRequisitos.setBounds(10, 106, 711, 505);
				panel.add(pnRequisitos);
				pnRequisitos.setLayout(null);

				cbxNacionalidad = new JComboBox();
				cbxNacionalidad.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Dominicano/a", "Argentino/a", "Brasile\u00F1o/a", "Canadiense", "Chino/a", "Colombiano/a", "Cubano/a", "Espa\u00F1ol/a", "Estadounidense", "Haitiano/a", "Mexicano/a", "Ruso/a", "Venezolano/a"}));
				cbxNacionalidad.setBounds(148, 302, 154, 20);
				pnRequisitos.add(cbxNacionalidad);
				{
					ckDispSalirCiudad = new Checkbox("Disponibilidad para salir de la Ciudad");
					ckDispSalirCiudad.setBounds(19, 27, 249, 22);
					pnRequisitos.add(ckDispSalirCiudad);
				}
				{
					ckDispCambioResidencia = new Checkbox("Disponibilidad para cambiar de Residencia");
					ckDispCambioResidencia.setBounds(19, 55, 263, 22);
					pnRequisitos.add(ckDispCambioResidencia);
				}
				{
					ckSoltero = new Checkbox("Soltero");
					ckSoltero.setBounds(277, 27, 95, 22);
					pnRequisitos.add(ckSoltero);
				}
				{
					pnIdiomas = new JPanel();
					pnIdiomas.setLayout(null);
					pnIdiomas.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Idiomas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
					pnIdiomas.setBounds(10, 96, 691, 102);
					pnRequisitos.add(pnIdiomas);
					{
						ckEspagnol = new Checkbox("Espa\u00F1ol");
						ckEspagnol.setBounds(10, 31, 72, 22);
						pnIdiomas.add(ckEspagnol);
					}
					{
						ckIngles = new Checkbox("Ingl\u00E9s");
						ckIngles.setBounds(10, 65, 72, 22);
						pnIdiomas.add(ckIngles);
					}
					{
						ckHindi = new Checkbox("Hindi");
						ckHindi.setBounds(246, 30, 72, 22);
						pnIdiomas.add(ckHindi);
					}
					{
						ckRuso = new Checkbox("Ruso");
						ckRuso.setBounds(246, 65, 72, 22);
						pnIdiomas.add(ckRuso);
					}
					{
						ckFrances = new Checkbox("Franc\u00E9s");
						ckFrances.setBounds(107, 31, 95, 22);
						pnIdiomas.add(ckFrances);
					}
					{
						ckMandarin = new Checkbox("Mandar\u00EDn");
						ckMandarin.setBounds(107, 65, 95, 22);
						pnIdiomas.add(ckMandarin);
					}
					{
						ckPortugues = new Checkbox("Portugu\u00E9s");
						ckPortugues.setBounds(357, 30, 95, 22);
						pnIdiomas.add(ckPortugues);
					}
					{
						ckAleman = new Checkbox("Alem\u00E1n");
						ckAleman.setBounds(357, 65, 95, 22);
						pnIdiomas.add(ckAleman);
					}
				}
				{
					label_2 = new JLabel("Salario M\u00EDnimo:");
					label_2.setBounds(19, 223, 165, 14);
					pnRequisitos.add(label_2);
				}
				{
					spnSalarioMin = new JSpinner();
					spnSalarioMin.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
					spnSalarioMin.setBounds(148, 220, 154, 20);
					pnRequisitos.add(spnSalarioMin);
				}
				{
					JLabel label = new JLabel("A\u00F1os de Experiencia:");
					label.setBounds(19, 264, 182, 14);
					pnRequisitos.add(label);
				}
				{
					spnAgnosExp = new JSpinner();
					spnAgnosExp.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
					spnAgnosExp.setBounds(148, 261, 154, 20);
					pnRequisitos.add(spnAgnosExp);
				}
				{
					label_1 = new JLabel("Salario M\u00E1ximo:");
					label_1.setBounds(367, 223, 165, 14);
					pnRequisitos.add(label_1);
				}
				{
					spnSalarioMax = new JSpinner();
					spnSalarioMax.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
					spnSalarioMax.setBounds(476, 220, 136, 20);
					pnRequisitos.add(spnSalarioMax);
				}
				{
					JLabel label = new JLabel("Edad M\u00EDnima:");
					label.setBounds(367, 264, 165, 14);
					pnRequisitos.add(label);
				}
				{
					spnEdad = new JSpinner();
					spnEdad.setModel(new SpinnerNumberModel(new Integer(18), new Integer(18), null, new Integer(1)));
					spnEdad.setBounds(476, 261, 136, 20);
					pnRequisitos.add(spnEdad);
				}
				{
					pnTipoPersonal = new JPanel();
					pnTipoPersonal.setLayout(null);
					pnTipoPersonal.setBorder(new TitledBorder(null, "Tipo de Personal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					pnTipoPersonal.setBounds(10, 343, 691, 71);
					pnRequisitos.add(pnTipoPersonal);

					rbUniversitario = new JRadioButton("Universitario");
					rbUniversitario.setSelected(true);
					rbUniversitario.setBounds(29, 30, 109, 23);
					pnTipoPersonal.add(rbUniversitario);

					rbTecnico = new JRadioButton("T\u00E9cnico");
					rbTecnico.setBounds(179, 30, 109, 23);
					pnTipoPersonal.add(rbTecnico);

					rbObrero = new JRadioButton("Obrero");
					rbObrero.setBounds(329, 30, 109, 23);
					pnTipoPersonal.add(rbObrero);

					// Tipo de personal button group
					tipoPersonalButtonGroup = new ButtonGroup();
					tipoPersonalButtonGroup.add(rbUniversitario);
					tipoPersonalButtonGroup.add(rbObrero);
					tipoPersonalButtonGroup.add(rbTecnico);

					pnUniversitario = new JPanel();
					pnUniversitario.setLayout(null);
					pnUniversitario.setBorder(null);
					pnUniversitario.setBounds(10, 420, 691, 71);
					pnRequisitos.add(pnUniversitario);
					{
						JLabel label = new JLabel("Universidad:");
						label.setBounds(29, 11, 136, 14);
						pnUniversitario.add(label);
					}
					{
						cbxUniversidad = new JComboBox();
						cbxUniversidad.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "PUCMM", "UTESA", "O&M", "UASD", "INTEC", "APEC", "UAPA", "UNPHU", "UNIBE", "UNEV", "UCDEP", "UNAPEC", "UCSD"}));
						cbxUniversidad.setBounds(29, 36, 193, 20);
						pnUniversitario.add(cbxUniversidad);
					}
					{
						JLabel label = new JLabel("Carrera:");
						label.setBounds(336, 11, 136, 14);
						pnUniversitario.add(label);
					}
					{
						cbxCarrera = new JComboBox();
						cbxCarrera.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Direcci\u00F3n Empresarial", "Administraci\u00F3n Hotelera", "Arquitectura", "Comunicaci\u00F3n Social", "Derecho", "Dise\u00F1o e Interiorismo", "Econom\u00EDa", "Educaci\u00F3n", "Estomatolog\u00EDa", "Filosof\u00EDa", "Gesti\u00F3n Financiera y Auditor\u00EDa", "Ingenier\u00EDa Civil", "Ingenier\u00EDa Mec\u00E1nica", "Ingenier\u00EDa El\u00E9ctrica", "Ingenier\u00EDa Industrial y de Sistemas", "Ingenier\u00EDa en Mecatr\u00F3nica", "Ingenier\u00EDa de Ciencias de la Computaci\u00F3n", "Ingenier\u00EDa Telem\u00E1tica", "Ingenier\u00EDa Ambiental", "Medicina", "Marketing", "Nutrici\u00F3n y Diet\u00E9tica", "Psicolog\u00EDa", "Terapia F\u00EDsica", "Trabajo Social", "Hospitalidad y Turismo"}));
						cbxCarrera.setBounds(336, 36, 273, 20);
						pnUniversitario.add(cbxCarrera);
					}
					pnTecnico = new JPanel();
					pnTecnico.setVisible(false);
					pnTecnico.setLayout(null);
					pnTecnico.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					pnTecnico.setBounds(10, 420, 691, 71);
					pnRequisitos.add(pnTecnico);
					{
						JLabel label = new JLabel("\u00C1rea T\u00E9cnica:");
						label.setBounds(22, 11, 265, 14);
						pnTecnico.add(label);
					}
					{
						cbxAreaTecnica = new JComboBox();
						cbxAreaTecnica.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Administraci\u00F3n de Micro, Peque\u00F1as y Medianas Empresas", "Artes Culinarias", "Automatizaci\u00F3n", "Dise\u00F1o Gr\u00E1fico", "Enfermer\u00EDa", "Gesti\u00F3n Social y Comunitaria", "Mercadeo", "Microfinanzas", "Publicidad y Medios Digitales", "Redes de Datos", "Log\u00EDstica Integral", "Programaci\u00F3n Web", ""}));
						cbxAreaTecnica.setBounds(22, 36, 273, 20);
						pnTecnico.add(cbxAreaTecnica);
					}

					pnObrero = new JPanel();
					pnObrero.setVisible(false);
					pnObrero.setLayout(null);
					pnObrero.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					pnObrero.setBounds(10, 420, 691, 71);
					pnRequisitos.add(pnObrero);
					{
						JLabel label = new JLabel("Oficios:");
						label.setBounds(20, 19, 52, 14);
						pnObrero.add(label);
					}
					{
						ckFontanero = new Checkbox("Fontanero");
						ckFontanero.setBounds(85, 11, 72, 22);
						pnObrero.add(ckFontanero);
					}
					{
						ckSastre = new Checkbox("Sastre");
						ckSastre.setBounds(85, 39, 72, 22);
						pnObrero.add(ckSastre);
					}
					{
						ckBarbero = new Checkbox("Barbero");
						ckBarbero.setBounds(197, 11, 95, 22);
						pnObrero.add(ckBarbero);
					}
					{
						ckSoldador = new Checkbox("Soldador");
						ckSoldador.setBounds(197, 39, 95, 22);
						pnObrero.add(ckSoldador);
					}
					{
						ckCerrajero = new Checkbox("Cerrajero");
						ckCerrajero.setBounds(307, 10, 72, 22);
						pnObrero.add(ckCerrajero);
					}
					{
						ckMecanico = new Checkbox("Mec\u00E1nico");
						ckMecanico.setBounds(307, 39, 72, 22);
						pnObrero.add(ckMecanico);
					}
					{
						ckPolicia = new Checkbox("Polic\u00EDa");
						ckPolicia.setBounds(416, 11, 66, 22);
						pnObrero.add(ckPolicia);
					}
					{
						ckAlbagnil = new Checkbox("Alba\u00F1il");
						ckAlbagnil.setBounds(416, 40, 66, 22);
						pnObrero.add(ckAlbagnil);
					}
					{
						ckAgricultor = new Checkbox("Agricultor");
						ckAgricultor.setBounds(514, 40, 95, 22);
						pnObrero.add(ckAgricultor);
					}
					{
						ckExterminador = new Checkbox("Exterminador");
						ckExterminador.setBounds(514, 11, 95, 22);
						pnObrero.add(ckExterminador);
					}
					{
						JLabel label = new JLabel("Nacionalidad:");
						label.setBounds(19, 305, 195, 14);
						pnRequisitos.add(label);
					}
					{
						JLabel label = new JLabel("Sexo:");
						label.setBounds(367, 305, 48, 14);
						pnRequisitos.add(label);
					}
					rdbtnFemenino = new JRadioButton("Femenino");
					rdbtnFemenino.setBounds(421, 300, 100, 23);
					pnRequisitos.add(rdbtnFemenino);
					rdbtnMasculino = new JRadioButton("Masculino");
					rdbtnMasculino.setBounds(523, 300, 88, 23);
					pnRequisitos.add(rdbtnMasculino);

					sexoButtonGroup = new ButtonGroup();
					sexoButtonGroup.add(rdbtnFemenino);
					sexoButtonGroup.add(rdbtnMasculino);

					cbxModalidadTrabajo = new JComboBox();
					cbxModalidadTrabajo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Remoto", "Tiempo completo", "Medio tiempo", "Freelancer"}));
					cbxModalidadTrabajo.setBounds(535, 57, 154, 20);
					pnRequisitos.add(cbxModalidadTrabajo);

					JLabel label = new JLabel("Modalidad del trabajo:");
					label.setBounds(398, 59, 165, 14);
					pnRequisitos.add(label);

					JLabel lblPorcentajeDeMatch = new JLabel("Porcentaje de match requerido:");
					lblPorcentajeDeMatch.setBounds(398, 30, 182, 14);
					pnRequisitos.add(lblPorcentajeDeMatch);

					spnPorcentajeMatch = new JSpinner();
					spnPorcentajeMatch.setModel(new SpinnerNumberModel(new Float(0), new Float(0), new Float(100), new Float(1)));
					spnPorcentajeMatch.setBounds(590, 27, 81, 20);
					pnRequisitos.add(spnPorcentajeMatch);

					JLabel label_3 = new JLabel("%");
					label_3.setBounds(676, 30, 25, 14);
					pnRequisitos.add(label_3);


					rbUniversitario.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							pnObrero.setVisible(false);
							pnTecnico.setVisible(false);
							pnUniversitario.setVisible(true);
						}
					});

					rbTecnico.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							pnObrero.setVisible(false);
							pnTecnico.setVisible(true);
							pnUniversitario.setVisible(false);
						}
					});

					rbObrero.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							pnTecnico.setVisible(false);
							pnObrero.setVisible(true);
							pnUniversitario.setVisible(false);
						}
					});
				}
				{
					JPanel buttonPane = new JPanel();
					buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
					getContentPane().add(buttonPane, BorderLayout.SOUTH);
					{
						JButton btnSolicitar = new JButton("Solicitar");
						btnSolicitar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if(Utils.getSpinnerFloatValue(spnSalarioMin) >= Utils.getSpinnerFloatValue(spnSalarioMax)) {
									JOptionPane.showMessageDialog(null,
											"El salario m\u00ednimo tiene que ser menor que el salario m\u00e1ximo.",
											"Advertencia",
											JOptionPane.WARNING_MESSAGE);
								}
								else if(selectedEmpresa == null) {
									JOptionPane.showMessageDialog(null,
											"Ingrese el RNC de la empresa para poder registrar la solicitud.",
											"Error",
											JOptionPane.ERROR_MESSAGE);
								}
								else if(faltanDatos()) {
									JOptionPane.showMessageDialog(null,
											"Faltan datos para registrar la solicitud.",
											"Error",
											JOptionPane.ERROR_MESSAGE);
								}
								else {
									if(crearSolicitud()) {
										JOptionPane.showMessageDialog(null,
												"Solicitud creada correctamente.",
												"Informaci\u00f3n",
												JOptionPane.INFORMATION_MESSAGE);
										clearForm();
									}
									else {
										JOptionPane.showMessageDialog(null,
												"Hubo un error desconocido al intentar crear la solicitud.",
												"Error",
												JOptionPane.ERROR_MESSAGE);
									}
								}
							}
						});
						btnSolicitar.setActionCommand("OK");
						buttonPane.add(btnSolicitar);
						getRootPane().setDefaultButton(btnSolicitar);
					}
					{
						JButton btnCancelar = new JButton("Cancelar");
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

		// Agregar todos los idiomas al group de idiomas
		for (Component component : pnIdiomas.getComponents()) {
			if(component instanceof Checkbox)
				idiomasGroup.add((Checkbox) component);
		}

		// Agregar todos los oficios al group de oficios
		for (Component component : pnObrero.getComponents()) {
			if(component instanceof Checkbox)
				oficiosGroup.add((Checkbox) component);
		}
	}

	// Obtener todos los idiomas seleccionados
	private ArrayList<String> getIdiomasSelected() {
		ArrayList<String> idiomas = new ArrayList<String>();

		for (Checkbox idiomaCheckbox : idiomasGroup) {
			if(idiomaCheckbox.getState()) {
				idiomas.add(idiomaCheckbox.getLabel());
			}
		}

		return idiomas;
	}

	// Obtener todos los oficios seleccionados
	private ArrayList<String> getOficiosSelected() {
		ArrayList<String> oficios = new ArrayList<String>();

		for (Checkbox oficioCheckbox : oficiosGroup) {
			if(oficioCheckbox.getState()) {
				oficios.add(oficioCheckbox.getLabel());
			}
		}

		return oficios;
	}

	// Saber si hay oficios seleccionados
	private boolean hayOficiosSeleccionados() {
		return this.getOficiosSelected().size() > 0;
	}

	private boolean faltanDatos() {
		boolean faltan = false;

		// No importa si elige un sexo o no
		if(Utils.getSpinnerFloatValue(spnPorcentajeMatch) == 0.0f
				|| Utils.getSpinnerIntValue(spnCantPlazas) == 0
				|| Utils.isCbxDefaultValue(cbxNacionalidad) 
				|| Utils.isCbxDefaultValue(cbxModalidadTrabajo)) {
			faltan = true;
		}

		if(rbUniversitario.isSelected()) {
			if(Utils.isCbxDefaultValue(cbxUniversidad) || Utils.isCbxDefaultValue(cbxCarrera)) {
				faltan = true;
			}
		}
		else if(rbTecnico.isSelected()) {
			if(Utils.isCbxDefaultValue(cbxAreaTecnica)) {
				faltan = true;
			}
		}
		else {
			if(!hayOficiosSeleccionados()) {
				faltan = true;
			}
		}

		return faltan;
	}

	private Empresa getDatosEmpresa(String RNC) {
		Empresa auxEmpresa = null;
		ArrayList<Empresa> result = BolsaTrabajo.getInstance().getEmpresasByID(RNC);
		if(result.size() > 0) {
			auxEmpresa = result.get(0);
		}

		return auxEmpresa;
	}

	private boolean crearSolicitud() {
		boolean exito = false;
		String tipoPersonal = Utils.getSelectedRadioButtonText(tipoPersonalButtonGroup);
		if(tipoPersonal != null) {
			// Quitar el acento de tecnico para comparaciones en el algoritmo
			tipoPersonal = tipoPersonal.replace('�', 'e');

			// Cargar datos del tipo de personal
			String carrera = null, universidad = null, areaTecnica = null;
			ArrayList<String> oficios = null;
			if(tipoPersonal.equalsIgnoreCase("Tecnico")) {
				areaTecnica = cbxAreaTecnica.getSelectedItem().toString();
			}
			else if(tipoPersonal.equalsIgnoreCase("Universitario")) {
				carrera = cbxCarrera.getSelectedItem().toString();
				universidad = cbxUniversidad.getSelectedItem().toString();
			}
			else {
				oficios = getIdiomasSelected();
			}

			SolicitudEmpresa solicitudEmpresa = new SolicitudEmpresa(
					SolicitudEmpresa.genID(),
					selectedEmpresa.getRNC(),
					Utils.getSpinnerIntValue(spnCantPlazas),
					Utils.getSpinnerFloatValue(spnSalarioMax),
					Utils.getSpinnerFloatValue(spnSalarioMin), 
					Utils.getSpinnerIntValue(spnEdad), 
					Utils.getSpinnerIntValue(spnAgnosExp),
					tipoPersonal,
					Utils.getSelectedRadioButtonText(sexoButtonGroup),
					ckDispSalirCiudad.getState(),
					ckDispCambioResidencia.getState(), 
					cbxModalidadTrabajo.getSelectedItem().toString(),
					!ckSoltero.getState(), 
					carrera,
					universidad,
					areaTecnica,
					Utils.getSpinnerFloatValue(spnPorcentajeMatch)
					);

			// Cargar oficios en solicitud
			if(oficios != null) {
				solicitudEmpresa.getOficios().addAll(oficios);
			}

			BolsaTrabajo.getInstance().agregarSolicitudEmpresa(selectedEmpresa.getRNC(), solicitudEmpresa);
			exito = true;
		}
		return exito;
	}

	private void clearForm() {
		txtCode.setText(SolicitudEmpresa.genID());
		spnCantPlazas.setValue(Integer.valueOf(0));
		spnAgnosExp.setValue(Integer.valueOf(0));
		spnEdad.setValue(Integer.valueOf(18));
		sexoButtonGroup.clearSelection();
		cbxNacionalidad.setSelectedIndex(0);
		cbxModalidadTrabajo.setSelectedIndex(0);
		spnSalarioMax.setValue(Float.valueOf(0.0f));
		spnSalarioMin.setValue(Float.valueOf(0.0f));
		spnPorcentajeMatch.setValue(Float.valueOf(0.0f));
		txtFRNC.setText("");
		txtFRNC.setEditable(true);
		btnBuscarEmpresa.setEnabled(true);
		txtNombreComercial.setText("");
		idiomasGroup.forEach((checkbox) -> checkbox.setState(false));
		ckDispSalirCiudad.setState(false);
		ckDispCambioResidencia.setState(false);
		ckSoltero.setState(false);

		// Datos del tipo de personal
		tipoPersonalButtonGroup.setSelected(rbUniversitario.getModel(), true);
		pnObrero.setVisible(false);
		pnTecnico.setVisible(false);
		pnUniversitario.setVisible(true);
		cbxUniversidad.setSelectedIndex(0);
		cbxCarrera.setSelectedIndex(0);
		cbxAreaTecnica.setSelectedIndex(0);
		oficiosGroup.forEach((checkbox) -> checkbox.setState(false));
	}
}
