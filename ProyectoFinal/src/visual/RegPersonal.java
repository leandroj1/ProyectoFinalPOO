package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Date;

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
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.BolsaTrabajo;
import logico.Obrero;
import logico.Personal;
import logico.Tecnico;
import logico.Ubicacion;
import logico.Universitario;
import logico.Utils;

import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;

import javax.swing.UIManager;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class RegPersonal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreCompleto;
	private JTextField txtCiudadRes;
	private JFormattedTextField txtFTelefono;
	private JFormattedTextField txtFCedulaP;
	private JFormattedTextField txtFTelSec;
	private JDateChooser dcFechaNacimiento;
	private JComboBox cbxNacionalidad;
	private Personal auxPersonal = null;
	private JTextField txtDireccion;
	private JTextField txtPais;
	private JTextField txtProvincia;
	private JRadioButton rdbtnFemenino;
	private JRadioButton rdbtnMasculino;
	private ButtonGroup generoGroup;
	private JCheckBox chckbxCasado;
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
	private JRadioButton rbUniversitario;
	private JRadioButton rbTecnico;
	private JRadioButton rbObrero;
	private Checkbox ckEspagnol;
	private Checkbox ckIngles;
	private Checkbox ckAleman;
	private Checkbox ckFrances;
	private Checkbox ckHindi;
	private Checkbox ckRuso;
	private Checkbox ckPortugues;
	private Checkbox ckMandarin;
	private JComboBox cbxUniversidad;
	private JComboBox cbxCarrera;
	private JComboBox cbxAreaTecnica;

	private CheckboxGroup idiomasGroup;
	private ButtonGroup oficiosGroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegPersonal dialog = new RegPersonal(null); // pasar null, donde se que no edito un personal le paso null.
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */ // Pasar clientes
	public RegPersonal(Personal personal) {
		setResizable(false);
		setTitle("Registro de Personal");
		auxPersonal = personal;
		if (auxPersonal == null) {
			setTitle("Registrar Personal");
		} else {
			setTitle("Modificar Personal");
		}
		setModal(true);
		setBounds(100, 100, 744, 716);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);

			try {

				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(10, 11, 706, 246);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblCdulaDelPersonal = new JLabel("C\u00E9dula del Personal:");
					lblCdulaDelPersonal.setBounds(29, 11, 136, 14);
					panel_1.add(lblCdulaDelPersonal);
				}
				txtFCedulaP = new JFormattedTextField(Utils.getMaskCedula());
				txtFCedulaP.setBounds(29, 36, 183, 20);
				panel_1.add(txtFCedulaP);
				txtFCedulaP.setToolTipText("");
				txtFCedulaP.setForeground(Color.BLACK);
				{
					JLabel lblNewLabel = new JLabel("Nombre Completo:");
					lblNewLabel.setBounds(363, 11, 136, 14);
					panel_1.add(lblNewLabel);
				}
				{
					txtNombreCompleto = new JTextField();
					txtNombreCompleto.setBounds(363, 36, 273, 20);
					panel_1.add(txtNombreCompleto);
					txtNombreCompleto.setColumns(10);
				}
				{
					JLabel lblFechaNac = new JLabel("Fecha de Nacimiento:");
					lblFechaNac.setBounds(29, 67, 147, 14);
					panel_1.add(lblFechaNac);
				}

				dcFechaNacimiento = new JDateChooser();
				dcFechaNacimiento.setBounds(29, 92, 183, 20);
				panel_1.add(dcFechaNacimiento);
				{
					JLabel lblTelfono = new JLabel("Tel\u00E9fono Principal:");
					lblTelfono.setBounds(29, 130, 156, 14);
					panel_1.add(lblTelfono);
				}
				txtFTelefono = new JFormattedTextField(Utils.getMaskTelefono());
				txtFTelefono.setBounds(29, 155, 183, 20);
				panel_1.add(txtFTelefono);
				txtFTelefono.setToolTipText("");
				txtFTelefono.setForeground(Color.BLACK);

				JLabel lblTelfonoSecundario = new JLabel("Tel\u00E9fono Secundario:");
				lblTelfonoSecundario.setBounds(29, 190, 156, 14);
				panel_1.add(lblTelfonoSecundario);

				txtFTelSec = new JFormattedTextField(Utils.getMaskTelefono());
				txtFTelSec.setToolTipText("");
				txtFTelSec.setForeground(Color.BLACK);
				txtFTelSec.setBounds(29, 215, 183, 20);
				panel_1.add(txtFTelSec);

				JLabel lblNacionalidad = new JLabel("Nacionalidad:");
				lblNacionalidad.setBounds(363, 67, 195, 14);
				panel_1.add(lblNacionalidad);

				JLabel lblSexo = new JLabel("Sexo:");
				lblSexo.setBounds(363, 130, 48, 14);
				panel_1.add(lblSexo);

				rdbtnFemenino = new JRadioButton("Femenino");
				rdbtnFemenino.setBounds(363, 152, 108, 23);
				panel_1.add(rdbtnFemenino);

				rdbtnMasculino = new JRadioButton("Masculino");
				rdbtnMasculino.setBounds(495, 152, 117, 23);
				panel_1.add(rdbtnMasculino);

				generoGroup = new ButtonGroup();
				generoGroup.add(rdbtnFemenino);
				generoGroup.add(rdbtnMasculino);

				cbxNacionalidad = new JComboBox();
				cbxNacionalidad.setModel(new DefaultComboBoxModel(new String[] { "<Seleccione>", "Dominicano/a",
						"Argentino/a", "Brasile\u00F1o/a", "Canadiense", "Chino/a", "Colombiano/a", "Cubano/a",
						"Espa\u00F1ol/a", "Estadounidense", "Haitiano/a", "Mexicano/a", "Ruso/a", "Venezolano/a" }));
				cbxNacionalidad.setBounds(363, 92, 273, 20);
				panel_1.add(cbxNacionalidad);

				chckbxCasado = new JCheckBox("Casado");
				chckbxCasado.setHorizontalTextPosition(SwingConstants.RIGHT);
				chckbxCasado.setBounds(363, 190, 128, 23);
				panel_1.add(chckbxCasado);
				JPanel pnObrero = new JPanel();
				pnObrero.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				pnObrero.setVisible(false);
				pnObrero.setBounds(10, 560, 706, 71);
				panel.add(pnObrero);
				pnObrero.setLayout(null);

				JLabel label = new JLabel("Oficios:");
				label.setBounds(32, 19, 52, 14);
				pnObrero.add(label);

				ckFontanero = new Checkbox("Fontanero");
				ckFontanero.setBounds(97, 11, 95, 22);
				pnObrero.add(ckFontanero);

				ckSastre = new Checkbox("Sastre");
				ckSastre.setBounds(97, 39, 95, 22);
				pnObrero.add(ckSastre);

				ckBarbero = new Checkbox("Barbero");
				ckBarbero.setBounds(209, 11, 95, 22);
				pnObrero.add(ckBarbero);

				ckSoldador = new Checkbox("Soldador");
				ckSoldador.setBounds(209, 39, 95, 22);
				pnObrero.add(ckSoldador);

				ckCerrajero = new Checkbox("Cerrajero");
				ckCerrajero.setBounds(319, 10, 95, 22);
				pnObrero.add(ckCerrajero);

				ckMecanico = new Checkbox("Mec\u00E1nico");
				ckMecanico.setBounds(319, 39, 95, 22);
				pnObrero.add(ckMecanico);

				ckPolicia = new Checkbox("Polic\u00EDa");
				ckPolicia.setBounds(428, 11, 95, 22);
				pnObrero.add(ckPolicia);

				ckAlbagnil = new Checkbox("Alba\u00F1il");
				ckAlbagnil.setBounds(428, 40, 95, 22);
				pnObrero.add(ckAlbagnil);

				ckExterminador = new Checkbox("Exterminador");
				ckExterminador.setBounds(536, 10, 116, 22);
				pnObrero.add(ckExterminador);

				ckAgricultor = new Checkbox("Agricultor");
				ckAgricultor.setBounds(536, 39, 95, 22);
				pnObrero.add(ckAgricultor);

				JPanel pnTipoPersonal = new JPanel();
				pnTipoPersonal.setBorder(
						new TitledBorder(null, "Tipo de Personal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				pnTipoPersonal.setBounds(10, 481, 706, 71);
				panel.add(pnTipoPersonal);
				pnTipoPersonal.setLayout(null);

				rbUniversitario = new JRadioButton("Universitario");
				rbUniversitario.setSelected(true);
				rbUniversitario.setBounds(29, 30, 138, 23);
				pnTipoPersonal.add(rbUniversitario);

				rbTecnico = new JRadioButton("T\u00E9cnico");
				rbTecnico.setBounds(267, 30, 109, 23);
				pnTipoPersonal.add(rbTecnico);

				rbObrero = new JRadioButton("Obrero");
				rbObrero.setBounds(505, 30, 109, 23);
				pnTipoPersonal.add(rbObrero);

				JPanel pnUniversitario = new JPanel();
				pnUniversitario
						.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				pnUniversitario.setBounds(10, 560, 706, 71);
				panel.add(pnUniversitario);
				pnUniversitario.setLayout(null);

				JLabel lblUniversidad = new JLabel("Universidad:");
				lblUniversidad.setBounds(29, 11, 136, 14);
				pnUniversitario.add(lblUniversidad);

				cbxUniversidad = new JComboBox();
				cbxUniversidad.setModel(new DefaultComboBoxModel(new String[] { "<Seleccione>", "PUCMM", "UTESA", "O&M",
						"UASD", "INTEC", "APEC", "UAPA", "UNPHU", "UNIBE", "UNEV", "UCDEP", "UNAPEC", "UCSD" }));
				cbxUniversidad.setBounds(29, 36, 193, 20);
				pnUniversitario.add(cbxUniversidad);

				JLabel lblCarrera = new JLabel("Carrera:");
				lblCarrera.setBounds(336, 11, 136, 14);
				pnUniversitario.add(lblCarrera);

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
						"Psicolog\u00EDa", "Terapia F\u00EDsica", "Trabajo Social", "Hospitalidad y Turismo" }));
				cbxCarrera.setBounds(336, 36, 273, 20);
				pnUniversitario.add(cbxCarrera);

				JPanel pnTecnico = new JPanel();
				pnTecnico.setVisible(false);
				pnTecnico.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				pnTecnico.setBounds(10, 560, 706, 71);
				panel.add(pnTecnico);
				pnTecnico.setLayout(null);

				JLabel lblreaTcnica = new JLabel("\u00C1rea T\u00E9cnica:");
				lblreaTcnica.setBounds(29, 15, 265, 14);
				pnTecnico.add(lblreaTcnica);

				cbxAreaTecnica = new JComboBox();
				cbxAreaTecnica.setModel(new DefaultComboBoxModel(new String[] { "<Seleccione>",
						"Administraci\u00F3n de Micro, Peque\u00F1as y Medianas Empresas", "Artes Culinarias",
						"Automatizaci\u00F3n", "Dise\u00F1o Gr\u00E1fico", "Enfermer\u00EDa",
						"Gesti\u00F3n Social y Comunitaria", "Mercadeo", "Microfinanzas",
						"Publicidad y Medios Digitales", "Redes de Datos", "Log\u00EDstica Integral",
						"Programaci\u00F3n Web"}));

				cbxAreaTecnica.setBounds(29, 40, 273, 20);
				pnTecnico.add(cbxAreaTecnica);

				JPanel pnUbicacion = new JPanel();
				pnUbicacion.setBorder(new TitledBorder(null, "Datos de la Ubicaci\u00F3n", TitledBorder.LEADING,
						TitledBorder.TOP, null, null));
				pnUbicacion.setBounds(10, 268, 706, 102);
				panel.add(pnUbicacion);
				pnUbicacion.setLayout(null);
				{
					JLabel lblCiudad = new JLabel("Ciudad:");
					lblCiudad.setBounds(29, 63, 77, 14);
					pnUbicacion.add(lblCiudad);
				}
				{
					txtCiudadRes = new JTextField();
					txtCiudadRes.setBounds(118, 60, 195, 20);
					pnUbicacion.add(txtCiudadRes);
					txtCiudadRes.setColumns(10);
				}

				JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
				lblDireccin.setBounds(369, 63, 84, 14);
				pnUbicacion.add(lblDireccin);

				txtDireccion = new JTextField();
				txtDireccion.setColumns(10);
				txtDireccion.setBounds(465, 60, 210, 20);
				pnUbicacion.add(txtDireccion);

				JLabel lblProvincia = new JLabel("Provincia:");
				lblProvincia.setBounds(369, 34, 84, 14);
				pnUbicacion.add(lblProvincia);

				JLabel lblPais = new JLabel("Pa\u00EDs:");
				lblPais.setBounds(29, 31, 68, 14);
				pnUbicacion.add(lblPais);

				txtPais = new JTextField();
				txtPais.setColumns(10);
				txtPais.setBounds(118, 28, 195, 20);
				pnUbicacion.add(txtPais);

				txtProvincia = new JTextField();
				txtProvincia.setColumns(10);
				txtProvincia.setBounds(465, 28, 210, 20);
				pnUbicacion.add(txtProvincia);

				JPanel panel_2 = new JPanel();
				panel_2.setLayout(null);
				panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Idiomas",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_2.setBounds(10, 375, 706, 102);
				panel.add(panel_2);

				ckEspagnol = new Checkbox("Espa\u00F1ol");
				ckEspagnol.setBounds(33, 25, 95, 22);
				panel_2.add(ckEspagnol);

				ckIngles = new Checkbox("Ingl\u00E9s");
				ckIngles.setBounds(33, 59, 95, 22);
				panel_2.add(ckIngles);

				ckHindi = new Checkbox("Hindi");
				ckHindi.setBounds(267, 24, 95, 22);
				panel_2.add(ckHindi);

				ckRuso = new Checkbox("Ruso");
				ckRuso.setBounds(267, 59, 95, 22);
				panel_2.add(ckRuso);

				ckFrances = new Checkbox("Franc\u00E9s");
				ckFrances.setBounds(150, 25, 95, 22);
				panel_2.add(ckFrances);

				ckMandarin = new Checkbox("Mandar\u00EDn");
				ckMandarin.setBounds(150, 59, 95, 22);
				panel_2.add(ckMandarin);

				ckPortugues = new Checkbox("Portugu\u00E9s");
				ckPortugues.setBounds(384, 24, 95, 22);
				panel_2.add(ckPortugues);

				ckAleman = new Checkbox("Alem\u00E1n");
				ckAleman.setBounds(384, 59, 95, 22);
				panel_2.add(ckAleman);

				rbUniversitario.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (rbUniversitario.isSelected()) {
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
						if (rbTecnico.isSelected()) {
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
						if (rbObrero.isSelected()) {
							rbTecnico.setSelected(false);
							rbUniversitario.setSelected(false);
							pnTecnico.setVisible(false);
							pnObrero.setVisible(true);
							pnUniversitario.setVisible(false);
						}
					}
				});

			} catch (Exception ex) {
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Personal auxPersonal = null;

						String message = comprobarCampos();
						if (!message.isEmpty()) {
							JOptionPane.showMessageDialog(null, message);
							return;
						}

						String cedula = txtFCedulaP.getText();
						String nombre = txtNombreCompleto.getText();
						Date fechaNacimiento = dcFechaNacimiento.getDate();
						String nacionalidad = (String) cbxNacionalidad.getSelectedItem();
						String telefonoPrincipal = txtFTelefono.getText();
						String telefonoSecundario = txtFTelSec.getText();
						String genero = Utils.getSelectedRadioButtonText(generoGroup);
						boolean casado = chckbxCasado.isSelected();
						Ubicacion ubicacion = new Ubicacion(txtPais.getText(), txtProvincia.getText(),
								txtCiudadRes.getText(), txtDireccion.getText());
						ArrayList<String> idiomas = getIdiomasSelected();

						if (rbObrero.isSelected()) {
							ArrayList<String> oficios = getOficiosSelected();
							auxPersonal = new Obrero(cedula, nombre, fechaNacimiento, casado, telefonoPrincipal,
									telefonoSecundario, nacionalidad, idiomas, ubicacion, genero, oficios);
						} else if (rbTecnico.isSelected()) {
							String areaTecnica = (String) cbxAreaTecnica.getSelectedItem();

							auxPersonal = new Tecnico(cedula, nombre, fechaNacimiento, casado, telefonoPrincipal,
									telefonoSecundario, nacionalidad, idiomas, areaTecnica, ubicacion, genero);
						} else if (rbUniversitario.isSelected()) {
							String universidad = (String) cbxUniversidad.getSelectedItem();
							String carrera = (String) cbxCarrera.getSelectedItem();

							auxPersonal = new Universitario(cedula, nombre, fechaNacimiento, casado, telefonoPrincipal,
									telefonoSecundario, nacionalidad, idiomas, carrera, universidad, ubicacion, genero);
						}

						if (auxPersonal == null) {
							JOptionPane.showMessageDialog(null, "No se ha podido registrar el usuario", null, JOptionPane.ERROR_MESSAGE);
							return;
						}

						BolsaTrabajo.getInstance().agregarPersonal(auxPersonal);

						RegSolPersonal nuevaSolicitudEmpleado = new RegSolPersonal(auxPersonal);
						nuevaSolicitudEmpleado.addWindowListener(new WindowListener() {
							@Override
							public void windowClosed(WindowEvent e) {
								// TODO Auto-generated method stub
								if (JOptionPane.showConfirmDialog(null, "Desea crear otro usuario?", null, JOptionPane.YES_NO_OPTION) == 1)
									dispose();

								clear();
							}

							@Override
							public void windowActivated(WindowEvent e) {
								// TODO Auto-generated method stub

							}

							@Override
							public void windowOpened(WindowEvent e) {
								// TODO Auto-generated method stub

							}

							@Override
							public void windowClosing(WindowEvent e) {
								// TODO Auto-generated method stub

							}

							@Override
							public void windowIconified(WindowEvent e) {
								// TODO Auto-generated method stub

							}

							@Override
							public void windowDeiconified(WindowEvent e) {
								// TODO Auto-generated method stub

							}

							@Override
							public void windowDeactivated(WindowEvent e) {
								// TODO Auto-generated method stub

							}
						});
						nuevaSolicitudEmpleado.setVisible(true);
					}
				});
				if (auxPersonal != null) {
					btnRegistrar.setText("Actualizar");
				}
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
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

	// Implementacion pendiente
	private void clear() {
		txtFCedulaP.setText("");
		txtNombreCompleto.setText("");
		dcFechaNacimiento.setDate(new Date());
		cbxNacionalidad.setSelectedIndex(0);
		txtFTelefono.setText("");
		txtFTelSec.setText("");
		generoGroup.clearSelection();
		chckbxCasado.setSelected(false);
		txtPais.setText("");
		txtProvincia.setText("");
		txtCiudadRes.setText("");
		txtDireccion.setText("");
		cbxAreaTecnica.setSelectedIndex(0);
		cbxUniversidad.setSelectedIndex(0);
		cbxCarrera.setSelectedIndex(0);
	}

	private ArrayList<String> getIdiomasSelected() {
		ArrayList<String> idiomas = new ArrayList<String>();

		if (ckEspagnol.getState())
			idiomas.add(ckEspagnol.getLabel());
		if (ckIngles.getState())
			idiomas.add(ckIngles.getLabel());
		if (ckFrances.getState())
			idiomas.add(ckFrances.getLabel());
		if (ckRuso.getState())
			idiomas.add(ckRuso.getLabel());
		if (ckPortugues.getState())
			idiomas.add(ckPortugues.getLabel());
		if (ckHindi.getState())
			idiomas.add(ckHindi.getLabel());
		if (ckAleman.getState())
			idiomas.add(ckAleman.getLabel());
		if (ckMandarin.getState())
			idiomas.add(ckMandarin.getLabel());

		return idiomas;
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

	private String comprobarCampos() {
		ArrayList<String> emptyFields = new ArrayList<String>();

		if (Utils.isMaskCedulaDefaultValue(txtFCedulaP.getText()))
			emptyFields.add("Cedula");
		if (txtNombreCompleto.getText().isEmpty())
			emptyFields.add("Nombre");
		if (dcFechaNacimiento.isValid())
			emptyFields.add("Fecha de Nacimiento");
		if (((String) cbxNacionalidad.getSelectedItem()).isEmpty())
			emptyFields.add("Nacionalidad");
		if (Utils.isMaskTelefonoDefaultValue(txtFTelefono.getText()))
			emptyFields.add("Telefono Principal");
		if (Utils.isMaskTelefonoDefaultValue(txtFTelSec.getText()))
			emptyFields.add("Telefono Secundario");
		if (Utils.getSelectedRadioButtonText(generoGroup) == null)
			emptyFields.add("Genero");
		if (txtPais.getText().isEmpty())
			emptyFields.add("Pais");
		if (txtProvincia.getText().isEmpty())
			emptyFields.add("Provincia");
		if (txtCiudadRes.getText().isEmpty())
			emptyFields.add("Ciudad de Residencia");
		if (txtDireccion.getText().isEmpty())
			emptyFields.add("Direccion");

		ArrayList<String> idiomas = getIdiomasSelected();
		if (idiomas.size() == 0)
			emptyFields.add("Ningun idioma seleccionado");

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
			message = "Los siguientes campos estan vacios o tienen un formato incorrecto: ";

			for (String emptyField : emptyFields)
				message += "\n\t- " + emptyField;
		}

		return message;
	}
}
