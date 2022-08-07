package visual;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import customs.NonEditableTable;
import ficheros.UtilsFicheros;
import logico.*;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ListarPersonal extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTable tablaPersonal;
	private DefaultTableModel model;
	private Object[] row;
	private Personal selectedPersonal = null;
	private JButton btnVerSolicitudesPendientes;
	private JTextField txtCedula;
	private JButton btnVerDetalles;
	private JButton btnModificar;

	/**
	 * Create the dialog.
	 */
	public ListarPersonal() {
		setTitle("Listado de personal");
		this.addWindowListener(UtilsFicheros.getWindowAdapterToSave());
		// TODO: agregar tipo de personal
		final String[] headers = { "Cedula", "Nombre", "Tipo", "Edad", "Nacionalidad", "Sexo", "Cantidad Solicitudes" };
		
		/* Data de prueba, borrar antes de hacer merge */
		ArrayList<String> idiomas = new ArrayList<String>();
		idiomas.add("Ingl\u00E9s");
		Date date = new Date();
		BolsaTrabajo.getInstance()
				.agregarPersonal(new Tecnico("111-1111111-1", "Jean", date, false, "(849)-351-5830", "(849)-350-5830",
						"Dominicano/a", idiomas, "Mercadeo",
						new Ubicacion("Republica Dominicana", "Santiago", "Santiago", "Calle Brigida"), "Masculino"));
		BolsaTrabajo.getInstance()
				.agregarPersonal(new Tecnico("111-1111111-2", "Jean", date, false, "(849)-351-5830", "(849)-350-5830",
						"Dominicano/a", idiomas, "Mercadeo",
						new Ubicacion("Republica Dominicana", "Santiago", "Santiago", "Calle Brigida"), "Masculino"));

		BolsaTrabajo.getInstance().agregarSolicitudEmpleado("111-1111111-1",
				new SolicitudPersonal("SP0000000001", "111-1111111-1", "ALGO", 10000, 5, "Tecnico", "Mercadeo",
						null, null, new ArrayList<String>(), true, true, "Tiempo Completo"));

		setResizable(false);
		setBounds(100, 100, 921, 570);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 904, 494);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(8, 78, 879, 395);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				{
					tablaPersonal = new NonEditableTable();
					tablaPersonal.getTableHeader().setReorderingAllowed(false);
					tablaPersonal.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							int index = tablaPersonal.getSelectedRow();
							if (index >= 0) {
								String codigoString = tablaPersonal.getValueAt(index, 0).toString();
								ArrayList<Personal> result = BolsaTrabajo.getInstance().getPersonalByID(codigoString);
								if (result.size() != 0) {
									selectedPersonal = result.get(0);
									if (selectedPersonal != null) {
										setButtonsState(true);
									}
								}
							}
						}
					});
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					tablaPersonal.setModel(model);
					scrollPane.setViewportView(tablaPersonal);
				}
			}

			JPanel panelFilter = new JPanel();
			panelFilter
					.setBorder(new TitledBorder(null, "Filtrado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelFilter.setBounds(8, 11, 879, 56);
			panel.add(panelFilter);
			panelFilter.setLayout(null);

			JLabel lblNewLabel = new JLabel("Cedula:");
			lblNewLabel.setBounds(10, 22, 57, 14);
			panelFilter.add(lblNewLabel);

			txtCedula = new JFormattedTextField(Utils.getMaskCedula());
			txtCedula.setBounds(79, 19, 414, 20);
			panelFilter.add(txtCedula);
			txtCedula.setColumns(10);

			JButton btnFilter = new JButton("Filtrar datos");
			btnFilter.setBounds(505, 19, 185, 23);
			panelFilter.add(btnFilter);

			JButton btnReset = new JButton("Limpiar Filtro");
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtCedula.setText("");
					loadRowsInTable(BolsaTrabajo.getInstance().getPersonalByID(""), null);
					btnReset.setEnabled(false);
				}
			});
			btnReset.setEnabled(false);
			btnReset.setBounds(700, 19, 169, 23);
			panelFilter.add(btnReset);

			btnFilter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (Utils.isMaskCedulaDefaultValue(txtCedula.getText())) {
						JOptionPane.showMessageDialog(null, "Tiene que completar la c\u00e9dula.", "Advertencia",
								JOptionPane.WARNING_MESSAGE);
					} else {
						ArrayList<Personal> resultado = BolsaTrabajo.getInstance().getPersonalByID(txtCedula.getText());
						if (resultado.size() > 0) {
							Personal e1 = resultado.get(0);
							loadRowsInTable(null, e1);
							btnReset.setEnabled(true);
						} else {
							JOptionPane.showMessageDialog(null, "Esta personal no existe", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
		}
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 494, 904, 33);
		getContentPane().add(buttonPane);
		{
			buttonPane.setLayout(null);
		}
		{
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(787, 5, 112, 23);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});

			btnCancelar.setActionCommand("Cancel");
			buttonPane.add(btnCancelar);
		}

		btnVerSolicitudesPendientes = new JButton("Ver solicitudes");
		btnVerSolicitudesPendientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (selectedPersonal != null) {
					ListadoSolicitudesPersonal listadoPersonal = new ListadoSolicitudesPersonal(selectedPersonal);
					listadoPersonal.setTitle("Listado de solicitudes de " + selectedPersonal.getNombre());
					listadoPersonal.setModal(true);
					listadoPersonal.setVisible(true);
					
					setButtonsState(false);
					selectedPersonal = null;
				}
			}
		});
		btnVerSolicitudesPendientes.setEnabled(false);
		btnVerSolicitudesPendientes.setBounds(565, 5, 210, 23);
		buttonPane.add(btnVerSolicitudesPendientes);

		btnVerDetalles = new JButton("Ver detalles");
		btnVerDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedPersonal != null) {
					RegPersonal personal = new RegPersonal(selectedPersonal, false);
					personal.setTitle("Personal");
					RegPersonal.desactivado();
					personal.setVisible(true);
					setButtonsState(false);
					selectedPersonal = null;
				}
			}
		});
		btnVerDetalles.setEnabled(false);
		btnVerDetalles.setBounds(410, 5, 143, 23);
		buttonPane.add(btnVerDetalles);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedPersonal != null) {
					RegPersonal personal = new RegPersonal(selectedPersonal, true);
					personal.setVisible(true);
					loadRowsInTable(BolsaTrabajo.getInstance().getPersonalByID(""), null);
					setButtonsState(false);
					selectedPersonal = null;
				}
			}
		});
		btnModificar.setEnabled(false);
		btnModificar.setBounds(309, 5, 89, 23);
		buttonPane.add(btnModificar);

		loadRowsInTable(BolsaTrabajo.getInstance().getPersonalByID(""), null);
	}

	// Cargar datos a la tabla
	private void loadRowsInTable(ArrayList<Personal> listaPersonal, Personal e1) {
		row = new Object[model.getColumnCount()];
		model.setRowCount(0);
		if (e1 == null) {
			for (Personal personal : listaPersonal) {
				addRowDataPersonal(personal);
			}
		} else {
			addRowDataPersonal(e1);
		}
	}

	private void addRowDataPersonal(Personal personal) {
		row = new Object[model.getColumnCount()];
		row[0] = personal.getCedula();
		row[1] = personal.getNombre();
		row[2] = personal.toString();
		row[3] = personal.getEdad();
		row[4] = personal.getNacionalidad();
		row[5] = personal.getGenero();
		row[6] = personal.getSolicitudes().size();
		model.addRow(row);
	}

	// Cambiar el estado de los botones de solicitudes
	private void setButtonsState(boolean isEnabled) {
		btnVerSolicitudesPendientes.setEnabled(isEnabled);
		btnVerDetalles.setEnabled(isEnabled);
		btnModificar.setEnabled(isEnabled);
	}
}
