package visual;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import customs.NonEditableTable;
import logico.Banco;
import logico.BolsaTrabajo;
import logico.Empresa;
import logico.SolicitudEmpresa;
import logico.Utils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ListadoSolicitudesEmpresa extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTable tablaSolicitudes;
	private DefaultTableModel model;
	private Object[] row;
	private JButton btnVerDetalles;
	private JButton btnAnular;
	private JTextField txtIDSolicitud;
	private JButton btnModificarCondiciones;
	private JButton btnReset;
	private JButton btnVerPosiblesCandidatos;

	private Empresa selectedEmpresa = null;
	private SolicitudEmpresa selectedSolicitud = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoSolicitudesEmpresa dialog = new ListadoSolicitudesEmpresa(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoSolicitudesEmpresa(Empresa empresa) {
		final String[] headers = {
				"ID",
				"Fecha",
				"RNC de la Empresa",
				"Tipo de personal solicitado",
				"Plazas necesarias",
				"Estado"
		};

		if(empresa == null) {
			setTitle("Listado de solicitudes");			
		}
		else {
			selectedEmpresa = empresa;
			setTitle("Listado de solicitudes de " + empresa.getNombreComercial() + " (" + empresa.getRNC() + ")");
		}

		setResizable(false);
		setBounds(100, 100, 978, 570);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 962, 494);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0)); {
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(8, 78, 934, 395);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane); {
					tablaSolicitudes = new NonEditableTable();
					tablaSolicitudes.getTableHeader().setReorderingAllowed(false);
					tablaSolicitudes.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							int index = tablaSolicitudes.getSelectedRow();
							if(index >= 0) {
								String codigoString = tablaSolicitudes.getValueAt(index, 0).toString();
								ArrayList<SolicitudEmpresa> result = getDataSolicitudes(selectedEmpresa, codigoString);
								if(result.size() != 0) {
									selectedSolicitud = result.get(0);
									setButtonsState(true);
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
			panelFilter.setBorder(new TitledBorder(null, "Filtrado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelFilter.setBounds(8, 11, 934, 56);
			panel.add(panelFilter);
			panelFilter.setLayout(null);

			JLabel lblNewLabel = new JLabel("ID:");
			lblNewLabel.setBounds(10, 21, 46, 14);
			panelFilter.add(lblNewLabel);

			txtIDSolicitud = new JTextField();
			txtIDSolicitud.setBounds(43, 18, 457, 20);
			panelFilter.add(txtIDSolicitud);
			txtIDSolicitud.setColumns(10);

			JButton btnFilter = new JButton("Filtrar datos");
			btnFilter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Si es mayor que 12, no es un ID valido
					if(!txtIDSolicitud.getText().startsWith("SE") || txtIDSolicitud.getText().length() > 12) {
						JOptionPane.showMessageDialog(null,
								"Ingrese un ID válido para poder filtrar las solicitudes.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
					}
					else {
						loadRowsInTable(getDataSolicitudes(selectedEmpresa, txtIDSolicitud.getText()));
						btnReset.setEnabled(true);
						setButtonsState(false);
					}
				}
			});
			btnFilter.setBounds(510, 16, 193, 23);
			panelFilter.add(btnFilter);

			btnReset = new JButton("Mostrar todas las solicitudes");
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loadRowsInTable(getDataSolicitudes(selectedEmpresa, ""));
					setButtonsState(false);
					btnReset.setEnabled(false);
					txtIDSolicitud.setText("");
				}
			});
			btnReset.setEnabled(false);
			btnReset.setBounds(713, 17, 211, 23);
			panelFilter.add(btnReset);
		} 
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 494, 962, 33);
		getContentPane().add(buttonPane); {
			btnVerDetalles = new JButton("Ver detalles");
			btnVerDetalles.setBounds(664, 5, 166, 23);
			btnVerDetalles.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(selectedEmpresa != null) {
						// Abrir ventana

						// Para evitar errores
						setButtonsState(false);
					}
				}
			});
			buttonPane.setLayout(null);
			btnVerDetalles.setEnabled(false);
			buttonPane.add(btnVerDetalles);
		}{
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(840, 5, 112, 23);
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
				int option = JOptionPane.showConfirmDialog(null, "¿Desea anular la solicitud de código " + selectedSolicitud.getId() + "? Se desemplearan los candidatos asociados.", "Confirmación", JOptionPane.WARNING_MESSAGE);

				if(JOptionPane.YES_OPTION == option) {
					BolsaTrabajo.getInstance().anularSolicitudEmpresa(selectedSolicitud);
					loadRowsInTable(getDataSolicitudes(selectedEmpresa, txtIDSolicitud.getText()));
					setButtonsState(false);
				}
			}
		});
		btnAnular.setEnabled(false);
		btnAnular.setBounds(468, 5, 186, 23);
		buttonPane.add(btnAnular);

		btnModificarCondiciones = new JButton("Modificar condiciones");
		btnModificarCondiciones.setEnabled(false);
		btnModificarCondiciones.setBounds(272, 5, 186, 23);
		buttonPane.add(btnModificarCondiciones);

		btnVerPosiblesCandidatos = new JButton("Ver posibles candidatos");
		btnVerPosiblesCandidatos.setEnabled(false);
		btnVerPosiblesCandidatos.setBounds(76, 5, 186, 23);
		buttonPane.add(btnVerPosiblesCandidatos);

		loadRowsInTable(getDataSolicitudes(selectedEmpresa, ""));
	}

	private ArrayList<SolicitudEmpresa> getDataSolicitudes(Empresa selectedEmpresa, String id){
		BolsaTrabajo instanceBolsaTrabajo = BolsaTrabajo.getInstance();

		// En caso de ser un listado general
		if(selectedEmpresa == null) {
			return instanceBolsaTrabajo.getSolicitudesEmpresaByID(id);
		}

		// En caso de ser un listado para una entidad especifica
		return instanceBolsaTrabajo.getSolicitudesEmpresaByID(selectedEmpresa.getRNC(), id);
	}

	// Cargar datos a la tabla
	private void loadRowsInTable(ArrayList<SolicitudEmpresa> solicitudes) {
		row = new Object[model.getColumnCount()];
		for (SolicitudEmpresa solicitud : solicitudes) {
			row[0] = solicitud.getId();
			row[1] = Utils.getDateFormatted(solicitud.getFecha());
			row[3] = solicitud.getRNCEmpresa();
			row[4] = solicitud.getTipoPersonalSolicitado();
			row[5] = solicitud.getCantidadPlazasNecesarias();
			row[6] = solicitud.getEstado().toString();
		}
	}

	// Cambiar el estado de los botones de solicitudes
	private void setButtonsState(boolean isEnabled) {
		btnVerDetalles.setEnabled(isEnabled);
		btnAnular.setEnabled(isEnabled);
		btnModificarCondiciones.setEnabled(isEnabled);
		btnVerPosiblesCandidatos.setEnabled(isEnabled);
	}
}
