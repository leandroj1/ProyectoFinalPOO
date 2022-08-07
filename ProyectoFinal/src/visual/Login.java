package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.BolsaTrabajo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreUsuario;
	private JPasswordField psContrasegna;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setBounds(100, 100, 349, 195);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNombreUsuario = new JLabel("Nombre de Usuario:");
		lblNombreUsuario.setBounds(20, 30, 130, 16);
		contentPanel.add(lblNombreUsuario);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setBounds(170, 25, 159, 26);
		contentPanel.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);

		JLabel lblContrasegna = new JLabel("Contraseña:");
		lblContrasegna.setBounds(20, 73, 130, 16);
		contentPanel.add(lblContrasegna);
		
		psContrasegna = new JPasswordField();
		psContrasegna.setToolTipText("");
		psContrasegna.setBounds(170, 68, 159, 26);
		contentPanel.add(psContrasegna);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Login");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String nombreUsuario = txtNombreUsuario.getText();
						String contrasegna = String.valueOf(psContrasegna.getPassword());

						if (BolsaTrabajo.getInstance().authUsuario(nombreUsuario, contrasegna)) {
							Principal principal = new Principal(
									BolsaTrabajo.getInstance().getUsuarios(nombreUsuario).get(0));
							setVisible(false);
							principal.setVisible(true);
						} else
							JOptionPane.showMessageDialog(null, "El usuario o la contrase\u00f1a son incorrectos", null,
									JOptionPane.ERROR_MESSAGE);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
