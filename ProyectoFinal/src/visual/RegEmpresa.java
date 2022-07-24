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

public class RegEmpresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField txtFCedCliente;
	private JComboBox cbxTipo;
	private JTextField txtCodigo;
	private JTextField textField;

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
	setBounds(100, 100, 450, 300);
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
		lblNewLabel.setBounds(90, 28, 136, 14);
		panel.add(lblNewLabel);
		try{
			txtFCedCliente = new JFormattedTextField(Utils.getMaskCedula());
			txtFCedCliente.setForeground(Color.BLACK);
			txtFCedCliente.setToolTipText("");
			txtFCedCliente.setBounds(198, 25, 156, 20);
			panel.add(txtFCedCliente);
		}catch(Exception ex){}
		{
			JLabel lblNewLabel_1 = new JLabel("Tipo de empresa:");
			lblNewLabel_1.setBounds(90, 117, 98, 14);
			panel.add(lblNewLabel_1);
		}
		{
		    cbxTipo = new JComboBox();
			cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "P\u00FAblica", "Privada", "Semiprivada"}));
			cbxTipo.setBounds(198, 117, 156, 20);
			panel.add(cbxTipo);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Sector:");
			lblNewLabel_2.setBounds(90, 164, 98, 14);
			panel.add(lblNewLabel_2);
		}
		{
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(90, 68, 98, 14);
			panel.add(lblNombre);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setColumns(10);
			txtCodigo.setBounds(197, 65, 156, 20);
			panel.add(txtCodigo);
		}			
		{
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(198, 159, 156, 20);
			panel.add(textField);
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
