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
	 * Create the dialog.
	 */
	public CambiarContrasegna(Usuario usuario) {
		setTitle("Cambiar contrase\u00f1a de " + usuario.getNombreUsuario());
		this.addWindowListener(UtilsFicheros.getWindowAdapterToSave());
		setBounds(100, 100, 478, 276);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblContrasegna = new JLabel("Contrase\u00f1a actual:");
			lblContrasegna.setHorizontalAlignment(SwingConstants.RIGHT);
			lblContrasegna.setBounds(39, 40, 197, 16);
			contentPanel.add(lblContrasegna);
		}
		{
			JLabel lblNuevaContrasegna = new JLabel("Nueva contrase\u00f1a:");
			lblNuevaContrasegna.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNuevaContrasegna.setBounds(39, 96, 197, 16);
			contentPanel.add(lblNuevaContrasegna);
		}
		{
			JLabel lblNewLabel = new JLabel("Confirmacion de contrase\u00f1a:");
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
						String contrasegnaActual = String.valueOf(psContrasegnaActual.getPassword()).trim();
						String nuevaContrasegna = String.valueOf(psNuevaContrasegna.getPassword()).trim();
						String confirmarContrasegna = String.valueOf(psConfirmacionContrasegna.getPassword()).trim();

						if(nuevaContrasegna.isEmpty() || confirmarContrasegna.isEmpty() || contrasegnaActual.isEmpty()) {
							JOptionPane.showMessageDialog(null,
									"Ingrese los datos necesarios para cambiar la contrase\u00f1a  ", "Error",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						
						if (!usuario.getContrasegna().equals(contrasegnaActual)) {
							JOptionPane.showMessageDialog(null,
									"La contrase\u00f1a no coincide con su contrase\u00f1a actual", "Advertencia",
									JOptionPane.WARNING_MESSAGE);
							return;
						} else if (usuario.getContrasegna().equals(nuevaContrasegna)) {
							JOptionPane.showMessageDialog(null,
									"Su nueva contrase\u00f1a no puede ser igual a la antigua", "Advertencia",
									JOptionPane.WARNING_MESSAGE);
							return;
						} else if (!confirmarContrasegna.equals(nuevaContrasegna)) {
							JOptionPane.showMessageDialog(null, "Las contrase\u00f1as no coinciden", "Advertencia",
									JOptionPane.WARNING_MESSAGE);
							return;
						}
						
						usuario.setContrasegna(nuevaContrasegna);
						JOptionPane.showMessageDialog(null, "La contrase\u00f1a ha sido cambiada correctamente", "\u00c9xito", JOptionPane.INFORMATION_MESSAGE);
						dispose();
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
