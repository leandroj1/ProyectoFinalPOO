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
import javax.swing.text.MaskFormatter;

import logico.Personal;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import java.awt.Checkbox;


public class RegPersonal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreCompleto;
	private JTextField txtCiudadRes;
	private JFormattedTextField txtFTelefono;
	private JFormattedTextField txtFCedula;
	private Personal auxPersonal = null;
	private JTextField textField_1;
	private JTextField textField;
	private MaskFormatter mascara2;

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
		setBounds(100, 100, 744, 687);
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
				try{
					mascara2 = new MaskFormatter("###-#######-#");
					mascara2.setPlaceholderCharacter('_');
				}catch(Exception ex){}

			}
			try{
				MaskFormatter mascara = new MaskFormatter("###-###-####");
				mascara.setPlaceholderCharacter('_');
				
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
				txtFCedula = new JFormattedTextField(mascara2);
				txtFCedula.setBounds(29, 36, 183, 20);
				panel_1.add(txtFCedula);
				txtFCedula.setToolTipText("");
				txtFCedula.setForeground(Color.BLACK);
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
					JLabel lblApellidos_1 = new JLabel("Ciudad de Residencia:");
					lblApellidos_1.setBounds(363, 67, 195, 14);
					panel_1.add(lblApellidos_1);
				}
				{
					txtCiudadRes = new JTextField();
					txtCiudadRes.setBounds(363, 92, 273, 20);
					panel_1.add(txtCiudadRes);
					txtCiudadRes.setColumns(10);
				}
				
				JSpinner spnAgnosExp = new JSpinner();
				spnAgnosExp.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
				spnAgnosExp.setBounds(363, 155, 205, 20);
				panel_1.add(spnAgnosExp);
				{
					JLabel lblTelfono = new JLabel("Tel\u00E9fono Principal:");
					lblTelfono.setBounds(29, 130, 156, 14);
					panel_1.add(lblTelfono);
				}
				txtFTelefono = new JFormattedTextField(mascara);
				txtFTelefono.setBounds(29, 155, 183, 20);
				panel_1.add(txtFTelefono);
				txtFTelefono.setToolTipText("");
				txtFTelefono.setForeground(Color.BLACK);
				
				JLabel lblTelfonoSecundario = new JLabel("Tel\u00E9fono Secundario:");
				lblTelfonoSecundario.setBounds(29, 190, 156, 14);
				panel_1.add(lblTelfonoSecundario);
				
				JFormattedTextField txtFTelSec = new JFormattedTextField(mascara);
				txtFTelSec.setToolTipText("");
				txtFTelSec.setForeground(Color.BLACK);
				txtFTelSec.setBounds(29, 215, 183, 20);
				panel_1.add(txtFTelSec);
				
				JLabel lblNewLabel_1 = new JLabel("A\u00F1os de Experiencia:");
				lblNewLabel_1.setBounds(363, 130, 265, 14);
				panel_1.add(lblNewLabel_1);
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					panel_2.setBounds(10, 263, 467, 176);
					panel.add(panel_2);
					panel_2.setLayout(null);
					{
						JLabel lblesCasado = new JLabel("\u00BFEs casado?");
						lblesCasado.setBounds(29, 21, 136, 14);
						panel_2.add(lblesCasado);
					}
					
					JRadioButton rbnSCasado = new JRadioButton("S\u00ED");
					rbnSCasado.setBounds(322, 21, 56, 23);
					panel_2.add(rbnSCasado);
					
					JRadioButton rbnNCasado = new JRadioButton("No");
					rbnNCasado.setBounds(380, 21, 56, 23);
					panel_2.add(rbnNCasado);
					
					JLabel lblbuscaUnTrabajo = new JLabel("\u00BFBusca un trabajo por tiempo completo?");
					lblbuscaUnTrabajo.setBounds(29, 81, 295, 14);
					panel_2.add(lblbuscaUnTrabajo);
					
					JLabel lblestDesempleado = new JLabel("\u00BFEst\u00E1 desempleado?");
					lblestDesempleado.setBounds(29, 51, 136, 14);
					panel_2.add(lblestDesempleado);
					
					JLabel lblposeeDisponibilidadPara = new JLabel("\u00BFPosee disponibilidad para salir de la ciudad?");
					lblposeeDisponibilidadPara.setBounds(29, 111, 295, 14);
					panel_2.add(lblposeeDisponibilidadPara);
					
					JLabel lblposeeDisponibilidadPara_1 = new JLabel("\u00BFPosee disponibilidad para cambiar de residencia?");
					lblposeeDisponibilidadPara_1.setBounds(29, 141, 295, 14);
					panel_2.add(lblposeeDisponibilidadPara_1);
					
					JRadioButton rbnSDesempleado = new JRadioButton("S\u00ED");
					rbnSDesempleado.setBounds(322, 47, 56, 23);
					panel_2.add(rbnSDesempleado);
					
					JRadioButton rbnNDesempleado = new JRadioButton("No");
					rbnNDesempleado.setBounds(380, 47, 48, 23);
					panel_2.add(rbnNDesempleado);
					
					JRadioButton rbnSTiempoCompleto = new JRadioButton("S\u00ED");
					rbnSTiempoCompleto.setBounds(322, 77, 56, 23);
					panel_2.add(rbnSTiempoCompleto);
					
					JRadioButton rbnNTiempoCompleto = new JRadioButton("No");
					rbnNTiempoCompleto.setBounds(380, 77, 48, 23);
					panel_2.add(rbnNTiempoCompleto);
					
					JRadioButton rbnSDispCiudad = new JRadioButton("S\u00ED");
					rbnSDispCiudad.setBounds(322, 107, 56, 23);
					panel_2.add(rbnSDispCiudad);
					
					JRadioButton rbnNDispCiudad = new JRadioButton("No");
					rbnNDispCiudad.setBounds(380, 107, 48, 23);
					panel_2.add(rbnNDispCiudad);
					
					JRadioButton radioButton_6 = new JRadioButton("S\u00ED");
					radioButton_6.setBounds(322, 137, 56, 23);
					panel_2.add(radioButton_6);
					
					JRadioButton radioButton_7 = new JRadioButton("No");
					radioButton_7.setBounds(380, 137, 48, 23);
					panel_2.add(radioButton_7);
				}
				
				JPanel panel_2 = new JPanel();
				panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_2.setBounds(490, 263, 226, 176);
				panel.add(panel_2);
				panel_2.setLayout(null);
				
				JLabel lblIdiomas = new JLabel("Idiomas:");
				lblIdiomas.setBounds(10, 11, 136, 14);
				panel_2.add(lblIdiomas);
				
				Checkbox checkbox = new Checkbox("Espa\u00F1ol");
				checkbox.setBounds(10, 31, 95, 22);
				panel_2.add(checkbox);
				
				Checkbox checkbox_1 = new Checkbox("Ingl\u00E9s");
				checkbox_1.setBounds(10, 65, 95, 22);
				panel_2.add(checkbox_1);
				
				Checkbox checkbox_2 = new Checkbox("Hindi");
				checkbox_2.setBounds(10, 93, 95, 22);
				panel_2.add(checkbox_2);
				
				Checkbox checkbox_3 = new Checkbox("Ruso");
				checkbox_3.setBounds(10, 128, 95, 22);
				panel_2.add(checkbox_3);
				
				Checkbox checkbox_4 = new Checkbox("Franc\u00E9s");
				checkbox_4.setBounds(121, 31, 95, 22);
				panel_2.add(checkbox_4);
				
				Checkbox checkbox_5 = new Checkbox("Mandar\u00EDn");
				checkbox_5.setBounds(121, 65, 95, 22);
				panel_2.add(checkbox_5);
				
				Checkbox checkbox_6 = new Checkbox("Portugu\u00E9s");
				checkbox_6.setBounds(121, 93, 95, 22);
				panel_2.add(checkbox_6);
				
				Checkbox checkbox_7 = new Checkbox("Alem\u00E1n");
				checkbox_7.setBounds(121, 128, 95, 22);
				panel_2.add(checkbox_7);
				
				JPanel pnTipoPersonal = new JPanel();
				pnTipoPersonal.setBorder(new TitledBorder(null, "Tipo de Personal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				pnTipoPersonal.setBounds(10, 450, 706, 71);
				panel.add(pnTipoPersonal);
				pnTipoPersonal.setLayout(null);
				
				JRadioButton rdbtnNewRadioButton = new JRadioButton("Universitario");
				rdbtnNewRadioButton.setSelected(true);
				rdbtnNewRadioButton.setBounds(29, 30, 109, 23);
				pnTipoPersonal.add(rdbtnNewRadioButton);
				
				JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("T\u00E9cnico");
				rdbtnNewRadioButton_1.setBounds(179, 30, 109, 23);
				pnTipoPersonal.add(rdbtnNewRadioButton_1);
				
				JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Obrero");
				rdbtnNewRadioButton_2.setBounds(329, 30, 109, 23);
				pnTipoPersonal.add(rdbtnNewRadioButton_2);
				
				JPanel panel_3 = new JPanel();
				panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_3.setBounds(10, 524, 706, 71);
				panel.add(panel_3);
				panel_3.setLayout(null);
				
				JLabel lblUniversidad = new JLabel("Universidad:");
				lblUniversidad.setBounds(29, 11, 136, 14);
				panel_3.add(lblUniversidad);
				
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(336, 36, 273, 20);
				panel_3.add(textField_1);
				
				JComboBox comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "PUCMM", "UTESA", "O&M", "UASD", "INTEC", "APEC", "UAPA", "UNPHU", "UNIBE", "UNEV", "UCDEP", "UNAPEC", "UCSD"}));
				comboBox.setBounds(29, 36, 193, 20);
				panel_3.add(comboBox);
				
				JLabel lblCarrera = new JLabel("Carrera:");
				lblCarrera.setBounds(336, 11, 136, 14);
				panel_3.add(lblCarrera);
				
				JPanel panel_4 = new JPanel();
				panel_4.setVisible(false);
				panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_4.setBounds(10, 524, 706, 71);
				panel.add(panel_4);
				panel_4.setLayout(null);
				
				JLabel lblreaTcnica = new JLabel("\u00C1rea T\u00E9cnica:");
				lblreaTcnica.setBounds(29, 15, 265, 14);
				panel_4.add(lblreaTcnica);
				
				textField = new JTextField();
				textField.setColumns(10);
				textField.setBounds(29, 40, 273, 20);
				panel_4.add(textField);
				
				JPanel panel_5 = new JPanel();
				panel_5.setVisible(false);
				panel_5.setBounds(10, 524, 706, 71);
				panel.add(panel_5);
				panel_5.setLayout(null);
				
				JLabel lblOficios = new JLabel("Oficios:");
				lblOficios.setBounds(29, 11, 136, 14);
				panel_5.add(lblOficios);
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
				JButton btnCancelar = new JButton("Cancel");
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
