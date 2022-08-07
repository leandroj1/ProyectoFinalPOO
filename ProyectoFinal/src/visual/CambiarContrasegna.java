package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.BolsaTrabajo;
import logico.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CambiarContrasegna extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField psContrasegnaActual;
	private JPasswordField psNuevaContrasegna;
	private JPasswordField psConfirmacionContrasegna;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CambiarContrasegna dialog = new CambiarContrasegna(BolsaTrabajo.getInstance().getUsuario("admin"));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CambiarContrasegna(Usuario usuario) {
		setBounds(100, 100, 478, 276);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblContrasegna = new JLabel("Contraseña actual:");
			lblContrasegna.setHorizontalAlignment(SwingConstants.RIGHT);
			lblContrasegna.setBounds(39, 40, 197, 16);
			contentPanel.add(lblContrasegna);
		}
		{
			JLabel lblNuevaContrasegna = new JLabel("Nueva contraseña:");
			lblNuevaContrasegna.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNuevaContrasegna.setBounds(39, 96, 197, 16);
			contentPanel.add(lblNuevaContrasegna);
		}
		{
			JLabel lblNewLabel = new JLabel("Confirmacion de contraseña:");
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setBounds(39, 152, 197, 16);
			contentPanel.add(lblNewLabel);
		}
		{
			psContrasegnaActual = new JPasswordField();
			psContrasegnaActual.setBounds(248, 35, 197, 26);
			contentPanel.add(psContrasegnaActual);
		}
		{
			psNuevaContrasegna = new JPasswordField();
			psNuevaContrasegna.setBounds(248, 91, 197, 26);
			contentPanel.add(psNuevaContrasegna);
		}
		{
			psConfirmacionContrasegna = new JPasswordField();
			psConfirmacionContrasegna.setBounds(248, 147, 197, 26);
			contentPanel.add(psConfirmacionContrasegna);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String contrasegnaActual = String.valueOf(psContrasegnaActual.getPassword());
						String nuevaContrasegna = String.valueOf(psNuevaContrasegna.getPassword());
						String confirmarContrasegna = String.valueOf(psConfirmacionContrasegna.getPassword());

						if (!usuario.getContrasegna().equals(contrasegnaActual)) {
							JOptionPane.showMessageDialog(null,
									"La contrase\u00f1a no coincide con su contrase\u00f1a actual", null,
									JOptionPane.WARNING_MESSAGE);
							return;
						} else if (usuario.getContrasegna().equals(nuevaContrasegna)) {
							JOptionPane.showMessageDialog(null,
									"Su nueva contrase\u00f1a no puede ser igual a la antigua", null,
									JOptionPane.WARNING_MESSAGE);
							return;
						} else if (!confirmarContrasegna.equals(nuevaContrasegna)) {
							JOptionPane.showMessageDialog(null, "Las contrase\u00f1as no coinciden", null,
									JOptionPane.WARNING_MESSAGE);
							return;
						}
						
						usuario.setContrasegna(nuevaContrasegna);
						JOptionPane.showConfirmDialog(null, "La contrase\u00f1a ha sido cambiada correctamente");
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
