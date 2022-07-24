package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import logico.Utils;

import javax.swing.JSpinner;
import java.awt.Checkbox;
import javax.swing.UIManager;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;

public class RegSolEmpresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCode;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFemenino;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegSolEmpresa dialog = new RegSolEmpresa();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegSolEmpresa() {
		setResizable(false);
		setTitle("Solicitud de Empresa");
		setModal(true);
		setBounds(100, 100, 748, 699);
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
					txtCode.setText("SE-");
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
					JFormattedTextField txtFRNC = new JFormattedTextField(Utils.getMaskCedula());
					txtFRNC.setToolTipText("");
					txtFRNC.setForeground(Color.BLACK);
					txtFRNC.setBounds(139, 39, 154, 20);
					panel_1.add(txtFRNC);
				}
				{
					JLabel label = new JLabel("Cantidad de Plazas Necesarias:");
					label.setBounds(367, 11, 182, 14);
					panel_1.add(label);
				}
				{
					JSpinner spnCantPlazas = new JSpinner();
					spnCantPlazas.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
					spnCantPlazas.setBounds(554, 8, 136, 20);
					panel_1.add(spnCantPlazas);
				}
			}
			{
				JPanel pnRequisitos = new JPanel();
				pnRequisitos.setBorder(new TitledBorder(null, "Requisitos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				pnRequisitos.setBounds(10, 106, 711, 505);
				panel.add(pnRequisitos);
				pnRequisitos.setLayout(null);
				{
					Checkbox ckDispSC = new Checkbox("Disponibilidad para salir de la Ciudad");
					ckDispSC.setBounds(19, 27, 263, 22);
					pnRequisitos.add(ckDispSC);
				}
				{
					Checkbox ckDispCR = new Checkbox("Disponibilidad para cambiar de Residencia");
					ckDispCR.setBounds(19, 55, 263, 22);
					pnRequisitos.add(ckDispCR);
				}
				{
					Checkbox ckTiempoCompleto = new Checkbox("Tiempo Completo");
					ckTiempoCompleto.setBounds(367, 55, 144, 22);
					pnRequisitos.add(ckTiempoCompleto);
				}
				{
					Checkbox ckSoltero = new Checkbox("Soltero");
					ckSoltero.setBounds(367, 27, 95, 22);
					pnRequisitos.add(ckSoltero);
				}
				{
					JPanel pnIdiomas = new JPanel();
					pnIdiomas.setLayout(null);
					pnIdiomas.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Idiomas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
					pnIdiomas.setBounds(10, 96, 691, 102);
					pnRequisitos.add(pnIdiomas);
					{
						Checkbox ckEspagnol = new Checkbox("Espa\u00F1ol");
						ckEspagnol.setBounds(10, 31, 72, 22);
						pnIdiomas.add(ckEspagnol);
					}
					{
						Checkbox ckIngles = new Checkbox("Ingl\u00E9s");
						ckIngles.setBounds(10, 65, 72, 22);
						pnIdiomas.add(ckIngles);
					}
					{
						Checkbox ckHindi = new Checkbox("Hindi");
						ckHindi.setBounds(246, 30, 72, 22);
						pnIdiomas.add(ckHindi);
					}
					{
						Checkbox ckRuso = new Checkbox("Ruso");
						ckRuso.setBounds(246, 65, 72, 22);
						pnIdiomas.add(ckRuso);
					}
					{
						Checkbox ckFrances = new Checkbox("Franc\u00E9s");
						ckFrances.setBounds(107, 31, 95, 22);
						pnIdiomas.add(ckFrances);
					}
					{
						Checkbox ckMandarin = new Checkbox("Mandar\u00EDn");
						ckMandarin.setBounds(107, 65, 95, 22);
						pnIdiomas.add(ckMandarin);
					}
					{
						Checkbox ckPortugues = new Checkbox("Portugu\u00E9s");
						ckPortugues.setBounds(357, 30, 95, 22);
						pnIdiomas.add(ckPortugues);
					}
					{
						Checkbox ckAleman = new Checkbox("Alem\u00E1n");
						ckAleman.setBounds(357, 65, 95, 22);
						pnIdiomas.add(ckAleman);
					}
				}
				{
					JLabel label = new JLabel("Salario M\u00EDnimo:");
					label.setBounds(19, 223, 165, 14);
					pnRequisitos.add(label);
				}
				{
					JSpinner spnSalarioMin = new JSpinner();
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
					JSpinner spnAgnosExp = new JSpinner();
					spnAgnosExp.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
					spnAgnosExp.setBounds(148, 261, 154, 20);
					pnRequisitos.add(spnAgnosExp);
				}
				{
					JLabel label = new JLabel("Salario M\u00E1ximo:");
					label.setBounds(367, 223, 165, 14);
					pnRequisitos.add(label);
				}
				{
					JSpinner spnSalarioMax = new JSpinner();
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
					JSpinner spnEdad = new JSpinner();
					spnEdad.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
					spnEdad.setBounds(476, 261, 136, 20);
					pnRequisitos.add(spnEdad);
				}
				{
					JPanel pnTipoPersonal = new JPanel();
					pnTipoPersonal.setLayout(null);
					pnTipoPersonal.setBorder(new TitledBorder(null, "Tipo de Personal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					pnTipoPersonal.setBounds(10, 343, 691, 71);
					pnRequisitos.add(pnTipoPersonal);

					JRadioButton rbUniversitario = new JRadioButton("Universitario");
					rbUniversitario.setSelected(true);
					rbUniversitario.setBounds(29, 30, 109, 23);
					pnTipoPersonal.add(rbUniversitario);

					JRadioButton rbTecnico = new JRadioButton("T\u00E9cnico");
					rbTecnico.setBounds(179, 30, 109, 23);
					pnTipoPersonal.add(rbTecnico);

					JRadioButton rbObrero = new JRadioButton("Obrero");
					rbObrero.setBounds(329, 30, 109, 23);
					pnTipoPersonal.add(rbObrero);

					JPanel pnUniversitario = new JPanel();
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
						JComboBox cbxUniversidad = new JComboBox();
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
						JComboBox cbxCarrera = new JComboBox();
						cbxCarrera.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Direcci\u00F3n Empresarial", "Administraci\u00F3n Hotelera", "Arquitectura", "Comunicaci\u00F3n Social", "Derecho", "Dise\u00F1o e Interiorismo", "Econom\u00EDa", "Educaci\u00F3n", "Estomatolog\u00EDa", "Filosof\u00EDa", "Gesti\u00F3n Financiera y Auditor\u00EDa", "Ingenier\u00EDa Civil", "Ingenier\u00EDa Mec\u00E1nica", "Ingenier\u00EDa El\u00E9ctrica", "Ingenier\u00EDa Industrial y de Sistemas", "Ingenier\u00EDa en Mecatr\u00F3nica", "Ingenier\u00EDa de Ciencias de la Computaci\u00F3n", "Ingenier\u00EDa Telem\u00E1tica", "Ingenier\u00EDa Ambiental", "Medicina", "Marketing", "Nutrici\u00F3n y Diet\u00E9tica", "Psicolog\u00EDa", "Terapia F\u00EDsica", "Trabajo Social", "Hospitalidad y Turismo"}));
						cbxCarrera.setBounds(336, 36, 273, 20);
						pnUniversitario.add(cbxCarrera);
					}
					JPanel pnTecnico = new JPanel();
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
						JComboBox cbxAreaTecnica = new JComboBox();
						cbxAreaTecnica.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Administraci\u00F3n de Micro, Peque\u00F1as y Medianas Empresas", "Artes Culinarias", "Automatizaci\u00F3n", "Dise\u00F1o Gr\u00E1fico", "Enfermer\u00EDa", "Gesti\u00F3n Social y Comunitaria", "Mercadeo", "Microfinanzas", "Publicidad y Medios Digitales", "Redes de Datos", "Log\u00EDstica Integral", "Programaci\u00F3n Web", ""}));
						cbxAreaTecnica.setBounds(22, 36, 273, 20);
						pnTecnico.add(cbxAreaTecnica);
					}

					JPanel pnObrero = new JPanel();
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
						Checkbox ckFontanero = new Checkbox("Fontanero");
						ckFontanero.setBounds(85, 11, 72, 22);
						pnObrero.add(ckFontanero);
					}
					{
						Checkbox ckSastre = new Checkbox("Sastre");
						ckSastre.setBounds(85, 39, 72, 22);
						pnObrero.add(ckSastre);
					}
					{
						Checkbox ckBarbero = new Checkbox("Barbero");
						ckBarbero.setBounds(197, 11, 95, 22);
						pnObrero.add(ckBarbero);
					}
					{
						Checkbox ckSoldador = new Checkbox("Soldador");
						ckSoldador.setBounds(197, 39, 95, 22);
						pnObrero.add(ckSoldador);
					}
					{
						Checkbox ckCerrajero = new Checkbox("Cerrajero");
						ckCerrajero.setBounds(307, 10, 72, 22);
						pnObrero.add(ckCerrajero);
					}
					{
						Checkbox ckMecanico = new Checkbox("Mec\u00E1nico");
						ckMecanico.setBounds(307, 39, 72, 22);
						pnObrero.add(ckMecanico);
					}
					{
						Checkbox ckPolicia = new Checkbox("Polic\u00EDa");
						ckPolicia.setBounds(416, 11, 66, 22);
						pnObrero.add(ckPolicia);
					}
					{
						Checkbox ckAlbagnil = new Checkbox("Alba\u00F1il");
						ckAlbagnil.setBounds(416, 40, 66, 22);
						pnObrero.add(ckAlbagnil);
					}
					{
						Checkbox ckAgricultor = new Checkbox("Agricultor");
						ckAgricultor.setBounds(514, 40, 95, 22);
						pnObrero.add(ckAgricultor);
					}
					{
						Checkbox ckExterminador = new Checkbox("Exterminador");
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

					rdbtnMasculino.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(rdbtnMasculino.isSelected()) {
								rdbtnFemenino.setSelected(false);
							}
						}
					});

					rdbtnFemenino.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(rdbtnFemenino.isSelected()) {
								rdbtnMasculino.setSelected(false);
							}
						}
					});

					JComboBox cbxNacionalidad = new JComboBox();
					cbxNacionalidad.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Dominicano/a", "Argentino/a", "Brasile\u00F1o/a", "Canadiense", "Chino/a", "Colombiano/a", "Cubano/a", "Espa\u00F1ol/a", "Estadounidense", "Haitiano/a", "Mexicano/a", "Ruso/a", "Venezolano/a"}));
					cbxNacionalidad.setBounds(148, 302, 154, 20);
					pnRequisitos.add(cbxNacionalidad);


					rbUniversitario.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(rbUniversitario.isSelected()) {
								rbObrero.setSelected(false);
								rbTecnico.setSelected(false);
								pnObrero.setVisible(false);
								pnTecnico.setVisible(false);
								pnUniversitario.setVisible(true);
							}
						}
					});

					rbTecnico.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(rbTecnico.isSelected()) {
								rbObrero.setSelected(false);
								rbUniversitario.setSelected(false);
								pnObrero.setVisible(false);
								pnTecnico.setVisible(true);
								pnUniversitario.setVisible(false);
							}
						}
					});

					rbObrero.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(rbObrero.isSelected()) {
								rbTecnico.setSelected(false);
								rbUniversitario.setSelected(false);
								pnTecnico.setVisible(false);
								pnObrero.setVisible(true);
								pnUniversitario.setVisible(false);
							}
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
	}
}

