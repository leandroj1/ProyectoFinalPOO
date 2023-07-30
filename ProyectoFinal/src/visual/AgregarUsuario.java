package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ficheros.UtilsFicheros;
import logico.BolsaTrabajo;
import logico.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AgregarUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField psContrasegna;
	private JTextField txtNombreUsuario;
	private JPasswordField psConfirmarContrasegna;

	/**
	 * Create the dialog.
	 */
	public AgregarUsuario(Usuario usuario) {
		if(usuario != null)
			setTitle("Modificar datos de " + usuario.getNombreUsuario());
		else
			setTitle("Agregar usuario");

		this.addWindowListener(UtilsFicheros.getWindowAdapterToSave());
		setBounds(100, 100, 421, 272);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNombreUsuario = new JLabel("Nombre de Usuario:");
		lblNombreUsuario.setBounds(32, 31, 159, 16);
		contentPanel.add(lblNombreUsuario);

		JLabel lblContrasegna = new JLabel("Contrase\u00f1a:");
		lblContrasegna.setBounds(32, 74, 159, 16);
		contentPanel.add(lblContrasegna);

		psContrasegna = new JPasswordField();
		psContrasegna.setToolTipText("");
		psContrasegna.setBounds(211, 69, 178, 26);
		contentPanel.add(psContrasegna);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setColumns(10);
		txtNombreUsuario.setBounds(211, 26, 178, 26);
		contentPanel.add(txtNombreUsuario);

		JLabel lblConfirmarContrasea = new JLabel("Confirmar contrase\u00f1a:");
		lblConfirmarContrasea.setBounds(32, 115, 159, 16);
		contentPanel.add(lblConfirmarContrasea);

		psConfirmarContrasegna = new JPasswordField();
		psConfirmarContrasegna.setToolTipText("");
		psConfirmarContrasegna.setBounds(211, 110, 178, 26);
		contentPanel.add(psConfirmarContrasegna);

		JCheckBox ckAdmin = new JCheckBox("Admin");
		ckAdmin.setBounds(211, 163, 128, 23);
		contentPanel.add(ckAdmin);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Agregar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String nombreUsuario = txtNombreUsuario.getText();
						String contrasegna = String.valueOf(psContrasegna.getPassword());
						String confirmarContrasegna = String.valueOf(psConfirmarContrasegna.getPassword());
						boolean esAdmin = ckAdmin.isSelected();

						if (BolsaTrabajo.getInstance().getUsuario(nombreUsuario) != null) {
							JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe", null, JOptionPane.ERROR_MESSAGE);
							return;
						}

						if (!contrasegna.equals(confirmarContrasegna)) {
							JOptionPane.showMessageDialog(null, "Las contrase\u00f1as no coinciden");
							return;
						}

						Usuario usuario = new Usuario(nombreUsuario, contrasegna, esAdmin);
						try {
							BolsaTrabajo.getInstance().agregarUsuario(usuario);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						if (BolsaTrabajo.getInstance().getUsuario(nombreUsuario) == null) {
							JOptionPane.showMessageDialog(null, "El usuario no pudo ser agregado conrrectamente, intente de nuevo mas tarde", null, JOptionPane.ERROR_MESSAGE);
							return;
						} else {
							if (JOptionPane.showConfirmDialog(null, "Usuario creado correctamente\nQuiere crear otro usuario?", null, JOptionPane.YES_NO_OPTION) == 0) {
								clear();
								return;
							} else {
								dispose();
							}
						}
					}

					private void clear() {
						txtNombreUsuario.setText("");
						psContrasegna.setText("");
						psConfirmarContrasegna.setText("");
						ckAdmin.setSelected(false);
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
