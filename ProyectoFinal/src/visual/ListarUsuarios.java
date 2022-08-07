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

public class ListarUsuarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private JTextField txtNombreUsuario;
	private JCheckBox ckSoloAdmin;

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
		scrollPane.setBounds(6, 69, 435, 195);
		contentPanel.add(scrollPane);

		table = new NonEditableTable();
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
		txtNombreUsuario.setBounds(6, 34, 198, 26);
		contentPanel.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);

		ckSoloAdmin = new JCheckBox("Solo administradores");
		ckSoloAdmin.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				loadTableContent();
			}
		});
		ckSoloAdmin.setBounds(216, 34, 128, 23);
		contentPanel.add(ckSoloAdmin);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Cambiar Contrase\u00f1a");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Usuario currUsuario = BolsaTrabajo.getInstance().getUsuario((String) table.getModel().getValueAt(table.getSelectedRow(), 0));
						CambiarContrasegna cambiarContrasegna = new CambiarContrasegna(currUsuario);
						cambiarContrasegna.setVisible(true);
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
