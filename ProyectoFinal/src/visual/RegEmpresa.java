package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
import javax.swing.UIManager;

public class RegEmpresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField txtFCedCliente;
	private JComboBox cbxTipo;
	private JTextField txtCodigo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegEmpresa dialog = new RegEmpresa();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegEmpresa() {		
	setModal(true);
	setTitle("Registro de Empresa");
	setBounds(100, 100, 733, 522);
	setLocationRelativeTo(null);
	getContentPane().setLayout(new BorderLayout());
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	contentPanel.setLayout(new BorderLayout(0, 0));
	{
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("RNC:");
		lblNewLabel.setBounds(33, 32, 94, 14);
		panel.add(lblNewLabel);
		try{
			txtFCedCliente = new JFormattedTextField(Utils.getMaskCedula());
			txtFCedCliente.setForeground(Color.BLACK);
			txtFCedCliente.setToolTipText("");
			txtFCedCliente.setBounds(120, 29, 146, 20);
			panel.add(txtFCedCliente);
		}catch(Exception ex){}
		{
			JLabel lblNewLabel_1 = new JLabel("Tipo de empresa:");
			lblNewLabel_1.setBounds(382, 115, 98, 14);
			panel.add(lblNewLabel_1);
		}
		{
		    cbxTipo = new JComboBox();
			cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Micro", "Mediana", "Peque\u00F1a ", "Grande", "Emergente"}));
			cbxTipo.setBounds(502, 112, 156, 20);
			panel.add(cbxTipo);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Sector:");
			lblNewLabel_2.setBounds(382, 73, 98, 14);
			panel.add(lblNewLabel_2);
		}
		{
			JLabel lblNombre = new JLabel("Nombre Comercial:");
			lblNombre.setBounds(382, 32, 141, 14);
			panel.add(lblNombre);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setColumns(10);
			txtCodigo.setBounds(120, 112, 146, 20);
			panel.add(txtCodigo);
		}			
		{
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(502, 29, 156, 20);
			panel.add(textField);
		}
		{
			JComboBox cbxSector = new JComboBox();
			cbxSector.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Industrial", "Agricultura ", "Alimentaci\u00F3n", "Comercio ", "Construcci\u00F3n", "Educaci\u00F3n ", "Hoteler\u00EDa", "Medios de comunicaci\u00F3n ", "Miner\u00EDa ", "Petrolero ", "Telecomunicaciones ", "Salud ", "Financieros", "P\u00FAblico ", "Silvicultura ", "Textil ", "Tecnol\u00F3gico", "Transporte"}));
			cbxSector.setBounds(502, 70, 156, 20);
			panel.add(cbxSector);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(120, 70, 148, 20);
			panel.add(textField_1);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Rubro:");
			lblNewLabel_3.setBounds(33, 115, 46, 14);
			panel.add(lblNewLabel_3);
		}
		{
			JLabel lblRaznSocial = new JLabel("Raz\u00F3n Social:");
			lblRaznSocial.setBounds(33, 73, 98, 14);
			panel.add(lblRaznSocial);
		}
		{
			JPanel panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBorder(new TitledBorder(null, "Datos de la Ubicaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 290, 687, 117);
			panel.add(panel_1);
			{
				JLabel label = new JLabel("Ciudad de Residencia:");
				label.setBounds(23, 31, 195, 14);
				panel_1.add(label);
			}
			{
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(161, 31, 179, 20);
				panel_1.add(textField_2);
			}
			{
				JLabel label = new JLabel("Direcci\u00F3n:");
				label.setBounds(23, 72, 195, 14);
				panel_1.add(label);
			}
			{
				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(161, 70, 179, 20);
				panel_1.add(textField_3);
			}
			{
				JLabel label = new JLabel("Provincia:");
				label.setBounds(372, 31, 195, 14);
				panel_1.add(label);
			}
			{
				JLabel label = new JLabel("Pa\u00EDs:");
				label.setBounds(372, 72, 195, 14);
				panel_1.add(label);
			}
			{
				textField_4 = new JTextField();
				textField_4.setColumns(10);
				textField_4.setBounds(443, 70, 195, 20);
				panel_1.add(textField_4);
			}
			{
				textField_5 = new JTextField();
				textField_5.setColumns(10);
				textField_5.setBounds(443, 31, 195, 20);
				panel_1.add(textField_5);
			}
		}
		{
			JPanel panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de Contacto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(10, 160, 687, 117);
			panel.add(panel_1);
			{
				JLabel lblNombre_1 = new JLabel("Nombre:");
				lblNombre_1.setBounds(23, 31, 195, 14);
				panel_1.add(lblNombre_1);
			}
			{
				textField_6 = new JTextField();
				textField_6.setColumns(10);
				textField_6.setBounds(81, 31, 175, 20);
				panel_1.add(textField_6);
			}
			{
				JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
				lblTelfono.setBounds(372, 31, 195, 14);
				panel_1.add(lblTelfono);
			}
			{
				JLabel lblEmail = new JLabel("Email:");
				lblEmail.setBounds(23, 72, 195, 14);
				panel_1.add(lblEmail);
			}
			{
				textField_9 = new JTextField();
				textField_9.setColumns(10);
				textField_9.setBounds(81, 70, 175, 20);
				panel_1.add(textField_9);
			}
			{
				JFormattedTextField txtFTelefono = new JFormattedTextField(Utils.getMaskTelefono());
				txtFTelefono.setToolTipText("");
				txtFTelefono.setForeground(Color.BLACK);
				txtFTelefono.setBounds(436, 31, 156, 20);
				panel_1.add(txtFTelefono);
			}
			{
				JLabel lblCargo = new JLabel("Cargo:");
				lblCargo.setBounds(372, 72, 195, 14);
				panel_1.add(lblCargo);
			}
			{
				JComboBox cbxCargoContacto = new JComboBox();
				cbxCargoContacto.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "CEO", "CTO", "RRHH", "Secretario/a del CEO"}));
				cbxCargoContacto.setBounds(436, 69, 156, 20);
				panel_1.add(cbxCargoContacto);
			}
		}
	}
	{
		JPanel buttonPane = new JPanel();
		buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			JButton btnRegistrar = new JButton("Registrar");
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
