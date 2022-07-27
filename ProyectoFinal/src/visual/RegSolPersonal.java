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

import logico.Utils;

import javax.swing.JRadioButton;
import java.awt.Checkbox;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class RegSolPersonal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCode;
	//Estos elementos deben colocarse
	private JFormattedTextField txtFRNC;
	private JFormattedTextField txtFCedulaP;
	private JLabel lblCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegSolPersonal dialog = new RegSolPersonal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegSolPersonal() {
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
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_1.setBounds(10, 11, 557, 378);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					lblCode = new JLabel("C\u00F3digo:");
					lblCode.setBounds(37, 11, 46, 14);
					panel_1.add(lblCode);
				}
				{
					txtCode = new JTextField();
					txtCode.setBounds(35, 34, 159, 20);
					panel_1.add(txtCode);
					txtCode.setText("SP-");
					txtCode.setEditable(false);
					txtCode.setColumns(10);
				}
				{
					JLabel lblCdulaDelPersonal = new JLabel("C\u00E9dula del Personal:");
					lblCdulaDelPersonal.setBounds(330, 11, 165, 14);
					panel_1.add(lblCdulaDelPersonal);
				}
				txtFCedulaP = new JFormattedTextField(Utils.getMaskCedula());
				txtFCedulaP.setBounds(330, 34, 159, 20);
				panel_1.add(txtFCedulaP);
				txtFCedulaP.setToolTipText("");
				txtFCedulaP.setForeground(Color.BLACK);
				{
					JLabel lblRNC = new JLabel("RNC de la Empresa:");
					lblRNC.setBounds(35, 82, 182, 14);
					panel_1.add(lblRNC);
				}
				txtFRNC = new JFormattedTextField(Utils.getMaskCedula());
				txtFRNC.setBounds(35, 107, 159, 20);
				panel_1.add(txtFRNC);
				txtFRNC.setToolTipText("");
				txtFRNC.setForeground(Color.BLACK);
				{
					JLabel lblNewLabel = new JLabel("Salario Esperado:");
					lblNewLabel.setBounds(330, 82, 165, 14);
					panel_1.add(lblNewLabel);
				}
				{
					JSpinner spnSalarioEsp = new JSpinner();
					spnSalarioEsp.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
					spnSalarioEsp.setBounds(330, 107, 159, 20);
					panel_1.add(spnSalarioEsp);
				}
				{
					JLabel label = new JLabel("A\u00F1os de Experiencia:");
					label.setBounds(35, 149, 182, 14);
					panel_1.add(label);
				}
				{
					JSpinner spnAgnosExp = new JSpinner();
					spnAgnosExp.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
					spnAgnosExp.setBounds(35, 174, 159, 20);
					panel_1.add(spnAgnosExp);
				}
				{
					JLabel label = new JLabel("\u00BFPosee disponibilidad para salir de la ciudad?");
					label.setBounds(35, 309, 269, 14);
					panel_1.add(label);
				}
				{
					JLabel label = new JLabel("\u00BFPosee disponibilidad para cambiar de residencia?");
					label.setBounds(35, 339, 269, 14);
					panel_1.add(label);
				}
				{
					JRadioButton radioButton = new JRadioButton("S\u00ED");
					radioButton.setBounds(367, 306, 56, 23);
					panel_1.add(radioButton);
				}
				{
					JRadioButton radioButton = new JRadioButton("S\u00ED");
					radioButton.setBounds(367, 336, 56, 23);
					panel_1.add(radioButton);
				}
				{
					JRadioButton radioButton = new JRadioButton("No");
					radioButton.setBounds(445, 306, 48, 23);
					panel_1.add(radioButton);
				}
				{
					JRadioButton radioButton = new JRadioButton("No");
					radioButton.setBounds(445, 336, 48, 23);
					panel_1.add(radioButton);
				}
				{
					JLabel lblTipoDeTrabajo = new JLabel("Modalidad de Trabajo:");
					lblTipoDeTrabajo.setBounds(330, 149, 182, 14);
					panel_1.add(lblTipoDeTrabajo);
				}
				{
					JComboBox cbxModalidad = new JComboBox();
					cbxModalidad.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Remoto", "Tiempo Completo", "Medio Tiempo", "Freelancer"}));
					cbxModalidad.setBounds(330, 174, 159, 20);
					panel_1.add(cbxModalidad);
				}
				{
					JLabel label = new JLabel("Descripci\u00F3n:");
					label.setBounds(37, 217, 102, 14);
					panel_1.add(label);
				}
				
				JTextPane textPane = new JTextPane();
				textPane.setBorder(new LineBorder(new Color(192, 192, 192)));
				textPane.setBounds(37, 242, 458, 48);
				panel_1.add(textPane);
			}
			{
				JPanel pnTipoPersonal = new JPanel();
				pnTipoPersonal.setLayout(null);
				pnTipoPersonal.setBorder(new TitledBorder(null, "Tipo de Personal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				pnTipoPersonal.setBounds(10, 400, 557, 71);
				panel.add(pnTipoPersonal);
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
				pnUniversitario.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				pnUniversitario.setBounds(10, 475, 557, 71);
				panel.add(pnUniversitario);
				{
					JLabel label = new JLabel("Universidad:");
					label.setBounds(22, 11, 136, 14);
					pnUniversitario.add(label);
				}
				{
					JComboBox cbxUniversidad = new JComboBox();
					cbxUniversidad.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "PUCMM", "UTESA", "O&M", "UASD", "INTEC", "APEC", "UAPA", "UNPHU", "UNIBE", "UNEV", "UCDEP", "UNAPEC", "UCSD"}));
					cbxUniversidad.setBounds(22, 36, 159, 20);
					pnUniversitario.add(cbxUniversidad);
				}
				{
					JLabel label = new JLabel("Carrera:");
					label.setBounds(243, 11, 136, 14);
					pnUniversitario.add(label);
				}
				{
					JComboBox cbxCarrera = new JComboBox();
					cbxCarrera.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Direcci\u00F3n Empresarial", "Administraci\u00F3n Hotelera", "Arquitectura", "Comunicaci\u00F3n Social", "Derecho", "Dise\u00F1o e Interiorismo", "Econom\u00EDa", "Educaci\u00F3n", "Estomatolog\u00EDa", "Filosof\u00EDa", "Gesti\u00F3n Financiera y Auditor\u00EDa", "Ingenier\u00EDa Civil", "Ingenier\u00EDa Mec\u00E1nica", "Ingenier\u00EDa El\u00E9ctrica", "Ingenier\u00EDa Industrial y de Sistemas", "Ingenier\u00EDa en Mecatr\u00F3nica", "Ingenier\u00EDa de Ciencias de la Computaci\u00F3n", "Ingenier\u00EDa Telem\u00E1tica", "Ingenier\u00EDa Ambiental", "Medicina", "Marketing", "Nutrici\u00F3n y Diet\u00E9tica", "Psicolog\u00EDa", "Terapia F\u00EDsica", "Trabajo Social", "Hospitalidad y Turismo"}));
					cbxCarrera.setBounds(243, 36, 273, 20);
					pnUniversitario.add(cbxCarrera);
				}
				JPanel pnTecnico = new JPanel();
				pnTecnico.setVisible(false);
				pnTecnico.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				pnTecnico.setBounds(10, 475, 557, 71);
				panel.add(pnTecnico);
				pnTecnico.setLayout(null);
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
				pnObrero.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Oficios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				pnObrero.setBounds(10, 475, 557, 82);
				panel.add(pnObrero);
				{
					Checkbox ckFontanero = new Checkbox("Fontanero");
					ckFontanero.setBounds(23, 21, 72, 22);
					pnObrero.add(ckFontanero);
				}
				{
					Checkbox ckSastre = new Checkbox("Sastre");
					ckSastre.setBounds(23, 49, 72, 22);
					pnObrero.add(ckSastre);
				}
				{
					Checkbox ckBarbero = new Checkbox("Barbero");
					ckBarbero.setBounds(135, 21, 95, 22);
					pnObrero.add(ckBarbero);
				}
				{
					Checkbox ckSoldador = new Checkbox("Soldador");
					ckSoldador.setBounds(135, 49, 95, 22);
					pnObrero.add(ckSoldador);
				}
				{
					Checkbox ckCerrajero = new Checkbox("Cerrajero");
					ckCerrajero.setBounds(245, 20, 72, 22);
					pnObrero.add(ckCerrajero);
				}
				{
					Checkbox ckMecanico = new Checkbox("Mec\u00E1nico");
					ckMecanico.setBounds(245, 49, 72, 22);
					pnObrero.add(ckMecanico);
				}
				{
					Checkbox ckPolicia = new Checkbox("Polic\u00EDa");
					ckPolicia.setBounds(354, 21, 66, 22);
					pnObrero.add(ckPolicia);
				}
				{
					Checkbox ckAlbagnil = new Checkbox("Alba\u00F1il");
					ckAlbagnil.setBounds(354, 50, 66, 22);
					pnObrero.add(ckAlbagnil);
				}
				{
					Checkbox ckExterminador = new Checkbox("Exterminador");
					ckExterminador.setBounds(452, 21, 95, 22);
					pnObrero.add(ckExterminador);
				}
				{
					Checkbox ckAgricultor = new Checkbox("Agricultor");
					ckAgricultor.setBounds(452, 50, 95, 22);
					pnObrero.add(ckAgricultor);
				}

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
