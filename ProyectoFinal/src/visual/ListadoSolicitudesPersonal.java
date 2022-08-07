package visual;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import customs.NonEditableTable;
import enums.EstadoSolicitudPersonal;
import enums.EstadoSolicitudPersonal;
import logico.BolsaTrabajo;
import logico.Personal;
import logico.Personal;
import logico.SolicitudPersonal;
import logico.SolicitudPersonal;
import logico.Utils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ListadoSolicitudesPersonal extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTable tablaSolicitudes;
	private static DefaultTableModel model;
	private static Object[] row;
	private JButton btnVerDetalles;
	private JButton btnAnular;
	private JTextField txtIDSolicitud;
	private JButton btnModificarCondiciones;
	private JButton btnReset;

	private Personal selectedPersonal = null;
	private SolicitudPersonal selectedSolicitud = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoSolicitudesPersonal dialog = new ListadoSolicitudesPersonal(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoSolicitudesPersonal(Personal personal) {
		final String[] headers = { "ID", "Fecha", "Cedula Personal", "Tipo de personal", "Estado" };

		if (selectedPersonal == null) {
			setTitle("Listado de solicitudes");
		} else {
			selectedPersonal = personal;
			setTitle("Listado de solicitudes de " + selectedPersonal.getNombre() + " (" + selectedPersonal.getCedula()
					+ ")");
		}

		setResizable(false);
		setBounds(100, 100, 1107, 570);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 1091, 494);
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
				scrollPane.setBounds(8, 78, 1063, 395);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				{
					tablaSolicitudes = new NonEditableTable();
					tablaSolicitudes.getTableHeader().setReorderingAllowed(false);
					tablaSolicitudes.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							int index = tablaSolicitudes.getSelectedRow();
							if (index >= 0) {
								String codigoString = tablaSolicitudes.getValueAt(index, 0).toString();
								ArrayList<SolicitudPersonal> result = getDataSolicitudes(selectedPersonal,
										codigoString);
								if (result.size() != 0) {
									selectedSolicitud = result.get(0);
									setButtonsState(true);
									if (selectedSolicitud.getEstado() == EstadoSolicitudPersonal.ANULADA
											|| selectedSolicitud.getEstado() == EstadoSolicitudPersonal.SATISFECHA) {
										btnAnular.setEnabled(false);
										btnModificarCondiciones.setEnabled(false);
									}
								}
							}
						}
					});
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					tablaSolicitudes.setModel(model);
					scrollPane.setViewportView(tablaSolicitudes);
				}
			}

			JPanel panelFilter = new JPanel();
			panelFilter
					.setBorder(new TitledBorder(null, "Filtrado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelFilter.setBounds(8, 11, 1063, 56);
			panel.add(panelFilter);
			panelFilter.setLayout(null);

			JLabel lblNewLabel = new JLabel("ID de la solicitud:");
			lblNewLabel.setBounds(10, 21, 115, 14);
			panelFilter.add(lblNewLabel);

			txtIDSolicitud = new JTextField();
			txtIDSolicitud.setBounds(139, 18, 386, 20);
			panelFilter.add(txtIDSolicitud);
			txtIDSolicitud.setColumns(12);

			JButton btnFilter = new JButton("Filtrar datos");
			btnFilter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Si es mayor que 12, no es un ID valido
					String id = txtIDSolicitud.getText().toUpperCase();
					if (!id.startsWith("SE") || id.length() > 12) {
						JOptionPane.showMessageDialog(null,
								"Ingrese un ID v\u00e1lido para poder filtrar las solicitudes.", "Error",
								JOptionPane.ERROR_MESSAGE);
						txtIDSolicitud.requestFocus();
					} else {
						ArrayList<SolicitudPersonal> solicitudes = getDataSolicitudes(selectedPersonal, id);
						// ID completo
						if (solicitudes.size() == 0) {
							if (id.length() == 12) {
								JOptionPane.showMessageDialog(null, "No hay datos asociados al ID '" + id + "'.",
										"Advertencia", JOptionPane.WARNING_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null,
										"No existen datos asociados al filtro '" + id + "'.", "Advertencia",
										JOptionPane.WARNING_MESSAGE);
							}
							txtIDSolicitud.requestFocus();
						} else {
							loadRowsInTable(solicitudes);
							btnReset.setEnabled(true);
							selectedSolicitud = null;
							setButtonsState(false);
						}
					}
				}
			});
			btnFilter.setBounds(535, 17, 254, 23);
			panelFilter.add(btnFilter);

			btnReset = new JButton("Mostrar todas las solicitudes");
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loadRowsInTable(getDataSolicitudes(selectedPersonal, ""));
					setButtonsState(false);
					btnReset.setEnabled(false);
					txtIDSolicitud.setText("");
				}
			});
			btnReset.setEnabled(false);
			btnReset.setBounds(799, 17, 254, 23);
			panelFilter.add(btnReset);
		}
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 494, 1091, 33);
		getContentPane().add(buttonPane);
		{
			btnVerDetalles = new JButton("Ver detalles");
			btnVerDetalles.setBounds(793, 5, 166, 23);
			btnVerDetalles.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					openRegSolicitudPersonal(false);
				}
			});
			buttonPane.setLayout(null);
			btnVerDetalles.setEnabled(false);
			buttonPane.add(btnVerDetalles);
		}
		{
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(969, 5, 112, 23);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});

			btnCancelar.setActionCommand("Cancel");
			buttonPane.add(btnCancelar);
		}
		btnAnular = new JButton("Anular solicitud");
		btnAnular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedSolicitud != null) {
					int option = JOptionPane.showConfirmDialog(null,
							"�Desea anular la solicitud de c\u00f3digo " + selectedSolicitud.getId()
									+ "? Se desemplearan los candidatos asociados.",
							"Confirmaci\u00f3n", JOptionPane.WARNING_MESSAGE);

					if (JOptionPane.YES_OPTION == option) {
						BolsaTrabajo.getInstance().anularSolicitudPersonal(selectedSolicitud);
						JOptionPane.showMessageDialog(null, "Solicitud anulada correctamente.", "Informaci\u00f3n",
								JOptionPane.INFORMATION_MESSAGE);
						loadRowsInTable(getDataSolicitudes(selectedPersonal, txtIDSolicitud.getText()));
					}

					// Para evitar errores
					selectedSolicitud = null;
					setButtonsState(false);
				}
			}
		});
		btnAnular.setEnabled(false);
		btnAnular.setBounds(597, 5, 186, 23);
		buttonPane.add(btnAnular);

		btnModificarCondiciones = new JButton("Modificar");
		btnModificarCondiciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openRegSolicitudPersonal(true);
			}
		});
		btnModificarCondiciones.setEnabled(false);
		btnModificarCondiciones.setBounds(457, 5, 130, 23);
		buttonPane.add(btnModificarCondiciones);

		loadRowsInTable(getDataSolicitudes(selectedPersonal, ""));
	}

	// Abrir la ventana de registrar solicitud para modificar o ver detalles
	private void openRegSolicitudPersonal(boolean isForModify) {
		if (selectedSolicitud != null) {
			RegSolPersonal detalles = new RegSolPersonal(null, selectedSolicitud, isForModify);
			if (!isForModify)
				RegSolPersonal.desactivar();
			
			detalles.setModal(true);
			detalles.setVisible(true);

			// Para evitar errores
			setButtonsState(false);
			selectedSolicitud = null;
			loadRowsInTable(getDataSolicitudes(selectedPersonal, txtIDSolicitud.getText()));
		}
	}

	// Obtener los datos de las solicitudes dependiendo del tipo de listado
	private ArrayList<SolicitudPersonal> getDataSolicitudes(Personal selectedPersonalAux, String id) {
		BolsaTrabajo instanceBolsaTrabajo = BolsaTrabajo.getInstance();

		// En caso de ser un listado general
		if (selectedPersonalAux == null) {
			return instanceBolsaTrabajo.getSolicitudesPersonalByID(id);
		}

		// En caso de ser un listado para una entidad especifica
		return instanceBolsaTrabajo.getSolicitudesPersonalByID(selectedPersonalAux.getCedula(), id);
	}

	// Cargar datos a la tabla
	private static void loadRowsInTable(ArrayList<SolicitudPersonal> solicitudes) {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for (SolicitudPersonal solicitud : solicitudes) {
			row[0] = solicitud.getId();
			row[1] = Utils.getDateFormatted(solicitud.getFecha());
			row[2] = solicitud.getCedulaPersonal();
			row[3] = solicitud.getTipoPersonal();
			row[4] = solicitud.getEstado();
			model.addRow(row);
		}
	}

	// Cambiar el estado de los botones de solicitudes
	private void setButtonsState(boolean isEnabled) {
		btnVerDetalles.setEnabled(isEnabled);
		btnAnular.setEnabled(isEnabled);
		btnModificarCondiciones.setEnabled(isEnabled);
	}
}
