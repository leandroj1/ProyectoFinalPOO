package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import logico.Personal;
import logico.Utils;

import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import java.awt.Checkbox;
import javax.swing.UIManager;


public class RegPersonal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreCompleto;
	private JTextField txtCiudadRes;
	private JFormattedTextField txtFTelefono;
	private JFormattedTextField txtFCedulaP;
	private Personal auxPersonal = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegPersonal dialog = new RegPersonal(null); //pasar null, donde se que no edito un personal le paso null.
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */ //Pasar clientes
	public RegPersonal(Personal personal) {
		setResizable(false);
		setTitle("Registro de Personal");
		auxPersonal = personal;
		if(auxPersonal == null ) {
			setTitle("Registrar Personal");
		}else {
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
			{
			}
			try{		
				JPanel pnObrero = new JPanel();
				pnObrero.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				pnObrero.setVisible(false);
				pnObrero.setBounds(10, 560, 706, 71);
				panel.add(pnObrero);
				pnObrero.setLayout(null);
				
				JLabel label = new JLabel("Oficios:");
				label.setBounds(32, 19, 52, 14);
				pnObrero.add(label);
				
				Checkbox ckFontanero = new Checkbox("Fontanero");
				ckFontanero.setBounds(97, 11, 72, 22);
				pnObrero.add(ckFontanero);
				
				Checkbox ckSastre = new Checkbox("Sastre");
				ckSastre.setBounds(97, 39, 72, 22);
				pnObrero.add(ckSastre);
				
				Checkbox ckBarbero = new Checkbox("Barbero");
				ckBarbero.setBounds(209, 11, 95, 22);
				pnObrero.add(ckBarbero);
				
				Checkbox ckSoldador = new Checkbox("Soldador");
				ckSoldador.setBounds(209, 39, 95, 22);
				pnObrero.add(ckSoldador);
				
				Checkbox ckCerrajero = new Checkbox("Cerrajero");
				ckCerrajero.setBounds(319, 10, 72, 22);
				pnObrero.add(ckCerrajero);
				
				Checkbox ckMecanico = new Checkbox("Mec\u00E1nico");
				ckMecanico.setBounds(319, 39, 72, 22);
				pnObrero.add(ckMecanico);
				
				Checkbox ckPolicia = new Checkbox("Polic\u00EDa");
				ckPolicia.setBounds(428, 11, 66, 22);
				pnObrero.add(ckPolicia);
				
				Checkbox ckAlbagnil = new Checkbox("Alba\u00F1il");
				ckAlbagnil.setBounds(428, 40, 66, 22);
				pnObrero.add(ckAlbagnil);
				
				Checkbox ckExterminador = new Checkbox("Exterminador");
				ckExterminador.setBounds(526, 11, 95, 22);
				pnObrero.add(ckExterminador);
				
				Checkbox ckAgricultor = new Checkbox("Agricultor");
				ckAgricultor.setBounds(526, 40, 95, 22);
				pnObrero.add(ckAgricultor);
				
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
				
				JDateChooser dateChooser = new JDateChooser();
				dateChooser.setBounds(29, 92, 183, 20);
				panel_1.add(dateChooser);
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
				
				JFormattedTextField txtFTelSec = new JFormattedTextField(Utils.getMaskTelefono());
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
				
				JRadioButton rdbtnFemenino = new JRadioButton("Femenino");
				rdbtnFemenino.setBounds(363, 152, 88, 23);
				panel_1.add(rdbtnFemenino);
				
				JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
				rdbtnMasculino.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(rdbtnMasculino.isSelected()) {
							rdbtnFemenino.setSelected(false);
						}
					}
				});
				rdbtnMasculino.setBounds(463, 151, 117, 23);
				panel_1.add(rdbtnMasculino);
				
				JComboBox comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Dominicano/a", "Argentino/a", "Brasile\u00F1o/a", "Canadiense", "Chino/a", "Colombiano/a", "Cubano/a", "Espa\u00F1ol/a", "Estadounidense", "Haitiano/a", "Mexicano/a", "Ruso/a", "Venezolano/a"}));
				comboBox.setBounds(363, 92, 273, 20);
				panel_1.add(comboBox);
				{
					{
						JLabel lblesCasado = new JLabel("\u00BFEs casado?");
						lblesCasado.setBounds(363, 190, 88, 14);
						panel_1.add(lblesCasado);
					}
					
					JRadioButton rbnSCasado = new JRadioButton("S\u00ED");
					rbnSCasado.setBounds(363, 215, 56, 23);
					panel_1.add(rbnSCasado);
					
					JRadioButton rbnNCasado = new JRadioButton("No");
					rbnNCasado.setBounds(463, 215, 56, 23);
					panel_1.add(rbnNCasado);
					rbnNCasado.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(rbnNCasado.isSelected()) {
								rbnSCasado.setSelected(false);
							}
						}
					});
					
					rbnSCasado.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(rbnSCasado.isSelected()) {
								rbnNCasado.setSelected(false);
							}
						}
					});
				}
				
				rdbtnFemenino.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(rdbtnFemenino.isSelected()) {
							rdbtnMasculino.setSelected(false);
						}
					}
				});
				
				JPanel pnTipoPersonal = new JPanel();
				pnTipoPersonal.setBorder(new TitledBorder(null, "Tipo de Personal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				pnTipoPersonal.setBounds(10, 481, 706, 71);
				panel.add(pnTipoPersonal);
				pnTipoPersonal.setLayout(null);
				
				JRadioButton rbUniversitario = new JRadioButton("Universitario");				
				rbUniversitario.setSelected(true);
				rbUniversitario.setBounds(29, 30, 109, 23);
				pnTipoPersonal.add(rbUniversitario);
				
				JRadioButton rbTecnico = new JRadioButton("T\u00E9cnico");
				rbTecnico.setBounds(267, 30, 109, 23);
				pnTipoPersonal.add(rbTecnico);
				
				JRadioButton rbObrero = new JRadioButton("Obrero");
				rbObrero.setBounds(505, 30, 109, 23);
				pnTipoPersonal.add(rbObrero);
				
				JPanel pnUniversitario = new JPanel();
				pnUniversitario.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				pnUniversitario.setBounds(10, 560, 706, 71);
				panel.add(pnUniversitario);
				pnUniversitario.setLayout(null);
				
				JLabel lblUniversidad = new JLabel("Universidad:");
				lblUniversidad.setBounds(29, 11, 136, 14);
				pnUniversitario.add(lblUniversidad);
								
				JComboBox cbxUniversidad = new JComboBox();
				cbxUniversidad.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "PUCMM", "UTESA", "O&M", "UASD", "INTEC", "APEC", "UAPA", "UNPHU", "UNIBE", "UNEV", "UCDEP", "UNAPEC", "UCSD"}));
				cbxUniversidad.setBounds(29, 36, 193, 20);
				pnUniversitario.add(cbxUniversidad);
				
				JLabel lblCarrera = new JLabel("Carrera:");
				lblCarrera.setBounds(336, 11, 136, 14);
				pnUniversitario.add(lblCarrera);
				
				JComboBox cbxCarrera = new JComboBox();
				cbxCarrera.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Direcci\u00F3n Empresarial", "Administraci\u00F3n Hotelera", "Arquitectura", "Comunicaci\u00F3n Social", "Derecho", "Dise\u00F1o e Interiorismo", "Econom\u00EDa", "Educaci\u00F3n", "Estomatolog\u00EDa", "Filosof\u00EDa", "Gesti\u00F3n Financiera y Auditor\u00EDa", "Ingenier\u00EDa Civil", "Ingenier\u00EDa Mec\u00E1nica", "Ingenier\u00EDa El\u00E9ctrica", "Ingenier\u00EDa Industrial y de Sistemas", "Ingenier\u00EDa en Mecatr\u00F3nica", "Ingenier\u00EDa de Ciencias de la Computaci\u00F3n", "Ingenier\u00EDa Telem\u00E1tica", "Ingenier\u00EDa Ambiental", "Medicina", "Marketing", "Nutrici\u00F3n y Diet\u00E9tica", "Psicolog\u00EDa", "Terapia F\u00EDsica", "Trabajo Social", "Hospitalidad y Turismo"}));
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
				
				JComboBox cbxAreaTecnica = new JComboBox();
				cbxAreaTecnica.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Administraci\u00F3n de Micro, Peque\u00F1as y Medianas Empresas", "Artes Culinarias", "Automatizaci\u00F3n", "Dise\u00F1o Gr\u00E1fico", "Enfermer\u00EDa", "Gesti\u00F3n Social y Comunitaria", "Mercadeo", "Microfinanzas", "Publicidad y Medios Digitales", "Redes de Datos", "Log\u00EDstica Integral", "Programaci\u00F3n Web", ""}));
				cbxAreaTecnica.setBounds(29, 40, 273, 20);
				pnTecnico.add(cbxAreaTecnica);
				
				JPanel panel_2 = new JPanel();
				panel_2.setLayout(null);
				panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Idiomas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_2.setBounds(10, 375, 706, 102);
				panel.add(panel_2);
				
				Checkbox checkbox = new Checkbox("Espa\u00F1ol");
				checkbox.setBounds(33, 25, 72, 22);
				panel_2.add(checkbox);
				
				Checkbox checkbox_1 = new Checkbox("Ingl\u00E9s");
				checkbox_1.setBounds(33, 59, 72, 22);
				panel_2.add(checkbox_1);
				
				Checkbox checkbox_2 = new Checkbox("Hindi");
				checkbox_2.setBounds(267, 24, 72, 22);
				panel_2.add(checkbox_2);
				
				Checkbox checkbox_3 = new Checkbox("Ruso");
				checkbox_3.setBounds(267, 59, 72, 22);
				panel_2.add(checkbox_3);
				
				Checkbox checkbox_4 = new Checkbox("Franc\u00E9s");
				checkbox_4.setBounds(150, 25, 95, 22);
				panel_2.add(checkbox_4);
				
				Checkbox checkbox_5 = new Checkbox("Mandar\u00EDn");
				checkbox_5.setBounds(150, 59, 95, 22);
				panel_2.add(checkbox_5);
				
				Checkbox checkbox_6 = new Checkbox("Portugu\u00E9s");
				checkbox_6.setBounds(384, 24, 95, 22);
				panel_2.add(checkbox_6);
				
				Checkbox checkbox_7 = new Checkbox("Alem\u00E1n");
				checkbox_7.setBounds(384, 59, 95, 22);
				panel_2.add(checkbox_7);
				
				JPanel pnUbicacion = new JPanel();
				pnUbicacion.setBorder(new TitledBorder(null, "Datos de la Ubicaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				pnUbicacion.setBounds(10, 268, 706, 102);
				panel.add(pnUbicacion);
				pnUbicacion.setLayout(null);
				{
					JLabel lblCiudad = new JLabel("Ciudad de Residencia:");
					lblCiudad.setBounds(29, 31, 195, 14);
					pnUbicacion.add(lblCiudad);
				}
				{
					txtCiudadRes = new JTextField();
					txtCiudadRes.setBounds(174, 25, 179, 20);
					pnUbicacion.add(txtCiudadRes);
					txtCiudadRes.setColumns(10);
				}
				
				JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
				lblDireccin.setBounds(29, 59, 195, 14);
				pnUbicacion.add(lblDireccin);
				
				textField = new JTextField();
				textField.setColumns(10);
				textField.setBounds(174, 53, 179, 20);
				pnUbicacion.add(textField);
				
				JLabel lblProvincia = new JLabel("Provincia:");
				lblProvincia.setBounds(386, 28, 195, 14);
				pnUbicacion.add(lblProvincia);
				
				JLabel lblPas = new JLabel("Pa\u00EDs:");
				lblPas.setBounds(386, 56, 195, 14);
				pnUbicacion.add(lblPas);
				
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(458, 53, 210, 20);
				pnUbicacion.add(textField_1);
				
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(458, 25, 210, 20);
				pnUbicacion.add(textField_2);
				
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
				
			}catch(Exception ex){}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				if(auxPersonal != null) {
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
}
