package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import customs.NonEditableTable;
import ficheros.UtilsFicheros;
import logico.BolsaTrabajo;
import logico.Usuario;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListarUsuarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private JTextField txtNombreUsuario;
	private JCheckBox ckSoloAdmin;
	private Usuario selectedUser = null;
	private JButton btnCambiarPass;

	/**
	 * Create the dialog.
	 */
	public ListarUsuarios() {
		this.addWindowListener(UtilsFicheros.getWindowAdapterToSave());
		setBounds(100, 100, 447, 337);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 69, 415, 195);
		contentPanel.add(scrollPane);

		table = new NonEditableTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				String username = table.getValueAt(index, 0).toString();
				selectedUser = BolsaTrabajo.getInstance().getUsuario(username);
				if(selectedUser != null) {
					btnCambiarPass.setEnabled(true);
				}
			}	
		});
		String[] headers = { "Nombre de usuario", "Es administrador?" };
		model = new DefaultTableModel();
		model.setColumnIdentifiers(headers);
		table.setModel(model);
		scrollPane.setViewportView(table);

		JLabel lblNombreUsuario = new JLabel("Nombre de usuario:");
		lblNombreUsuario.setBounds(6, 6, 133, 16);
		contentPanel.add(lblNombreUsuario);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				loadTableContent();
			}
		});
		txtNombreUsuario.setBounds(6, 34, 222, 26);
		contentPanel.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);

		ckSoloAdmin = new JCheckBox("Solo administradores");
		ckSoloAdmin.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				loadTableContent();
			}
		});
		ckSoloAdmin.setBounds(234, 36, 191, 23);
		contentPanel.add(ckSoloAdmin);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnCambiarPass = new JButton("Cambiar Contrase\u00f1a");
				btnCambiarPass.setEnabled(false);
				btnCambiarPass.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(selectedUser != null) {
							CambiarContrasegna cambiarContrasegna = new CambiarContrasegna(selectedUser);
							cambiarContrasegna.setModal(true);
							cambiarContrasegna.setVisible(true);
							btnCambiarPass.setEnabled(false);
						}
					}
				});
				btnCambiarPass.setActionCommand("OK");
				buttonPane.add(btnCambiarPass);
				getRootPane().setDefaultButton(btnCambiarPass);
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

		loadTableContent();
	}

	private void loadTableContent() {
		Object[] row = new Object[model.getColumnCount()];
		model.setRowCount(0);
		for (Usuario usuario : BolsaTrabajo.getInstance().getUsuarios(txtNombreUsuario.getText())) {
			if ((ckSoloAdmin.isSelected() && usuario.esAdmin()) || !ckSoloAdmin.isSelected()) {
				row[0] = usuario.getNombreUsuario();
				row[1] = usuario.esAdmin() ? "S\u00ed" : "No";
				model.addRow(row);				
			}
		}

	}
}
