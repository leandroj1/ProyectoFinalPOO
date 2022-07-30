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
import logico.*;

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

public class ListarEmpresas extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTable tablaEmpresas;
	private DefaultTableModel model;
	private Object[] row;
	private JButton btnVerSolicitudes;
	private Empresa selectedEmpresa = null;
	private JButton btnVerSolicitudesPendientes;
	private JTextField txtRNC;
	private JButton btnVerDetalles;
	private JButton btnModificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarEmpresas dialog = new ListarEmpresas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarEmpresas() {
		setTitle("Listado de empresas");
		// TODO: agregar tipo de empresa
		final String[] headers = {
				"RNC",
				"Nombre comercial",
				"Raz\u00F3n social",
				"Sector",
				"Rubro",
				"Ubicaci\u00F3n"
		};

		setResizable(false);
		setBounds(100, 100, 921, 570);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 904, 494);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0)); {
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(8, 78, 879, 395);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane); {
					tablaEmpresas = new NonEditableTable();
					tablaEmpresas.getTableHeader().setReorderingAllowed(false);
					tablaEmpresas.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							int index = tablaEmpresas.getSelectedRow();
							if(index >= 0) {
								String codigoString = tablaEmpresas.getValueAt(index, 0).toString();
								ArrayList<Empresa> result = BolsaTrabajo.getInstance().getEmpresasByID(codigoString);
								if(result.size() != 0) {
									selectedEmpresa = result.get(0);									
									if(selectedEmpresa != null) {
										setButtonsState(true);
									}
								}
							}
						}
					});
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					tablaEmpresas.setModel(model);
					scrollPane.setViewportView(tablaEmpresas);
				}
			}

			JPanel panelFilter = new JPanel();
			panelFilter.setBorder(new TitledBorder(null, "Filtrado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelFilter.setBounds(8, 11, 879, 56);
			panel.add(panelFilter);
			panelFilter.setLayout(null);

			JLabel lblNewLabel = new JLabel("RNC:");
			lblNewLabel.setBounds(10, 22, 46, 14);
			panelFilter.add(lblNewLabel);

			txtRNC = new JFormattedTextField(Utils.getMaskCedula());
			txtRNC.setBounds(43, 19, 457, 20);
			panelFilter.add(txtRNC);
			txtRNC.setColumns(10);

			JButton btnFilter = new JButton("Filtrar datos");
			btnFilter.setBounds(510, 17, 138, 23);
			panelFilter.add(btnFilter);

			JButton btnReset = new JButton("Mostrar todas las empresas");
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtRNC.setText("");
					loadRowsInTable(BolsaTrabajo.getInstance().getEmpresasByID(""), null);
					btnReset.setEnabled(false);
				}
			});
			btnReset.setEnabled(false);
			btnReset.setBounds(658, 17, 211, 23);
			panelFilter.add(btnReset);
			
			btnFilter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(Utils.isMaskCedulaDefaultValue(txtRNC.getText())) {
						JOptionPane.showMessageDialog(null, "Tiene que completar la c\u00e9dula.", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
					else {
						Empresa e1 = BolsaTrabajo.getInstance().buscarEmpresaByRNC(txtRNC.getText());
						if(e1 != null) {
							loadRowsInTable(null,e1);
							btnReset.setEnabled(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "Esta empresa no existe", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
		} 
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 494, 904, 33);
		getContentPane().add(buttonPane); {
			btnVerSolicitudes = new JButton("Ver solicitudes de trabajadores");
			btnVerSolicitudes.setBounds(553, 5, 224, 23);
			btnVerSolicitudes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(selectedEmpresa != null) {
						ListadoSolicitudesEmpresa listadoSolicitudesEmpresa = new ListadoSolicitudesEmpresa(selectedEmpresa);
						listadoSolicitudesEmpresa.setVisible(true);

						// Para evitar errores
						setButtonsState(false);
						selectedEmpresa = null;
					}
				}
			});
			buttonPane.setLayout(null);
			btnVerSolicitudes.setEnabled(false);
			buttonPane.add(btnVerSolicitudes);
		}{
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
		
		btnVerSolicitudesPendientes = new JButton("Ver solicitudes pendientes");
		btnVerSolicitudesPendientes.setEnabled(false);
		btnVerSolicitudesPendientes.setBounds(357, 5, 186, 23);
		buttonPane.add(btnVerSolicitudesPendientes);

		btnVerDetalles = new JButton("Ver detalles");
		btnVerDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedEmpresa != null) {
					RegEmpresa empresa = new RegEmpresa(selectedEmpresa);
					empresa.setTitle("Empresa");
					RegEmpresa.desactivado();
					empresa.setVisible(true);
					setButtonsState(false);
					selectedEmpresa = null;
				}
			}
		});
		btnVerDetalles.setEnabled(false);
		btnVerDetalles.setBounds(194, 5, 143, 23);
		buttonPane.add(btnVerDetalles);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedEmpresa != null) {
					RegEmpresa empresa = new RegEmpresa(selectedEmpresa);
					empresa.setVisible(true);
					loadRowsInTable(BolsaTrabajo.getInstance().getEmpresasByID(""), null);
					setButtonsState(false);
					selectedEmpresa = null;
				}
			}
		});
		btnModificar.setEnabled(false);
		btnModificar.setBounds(95, 5, 89, 23);
		buttonPane.add(btnModificar);

		loadRowsInTable(BolsaTrabajo.getInstance().getEmpresasByID(""), null);
	}

	// Cargar datos a la tabla
	private void loadRowsInTable(ArrayList<Empresa> empresas, Empresa e1) {
		row = new Object[model.getColumnCount()];
		if(e1 == null) {
			model.setRowCount(0);
			for (Empresa empresa : empresas) {
				row[0] = empresa.getRNC();
				row[1] = empresa.getNombreComercial();
				row[2] = empresa.getRazonSocial();
				row[3] = empresa.getSector();
				row[4] = empresa.getRubro();
				row[5] = empresa.getUbicacion().toString();
				model.addRow(row);
			}
		}
		else {
			model.setRowCount(0);
			row[0] = e1.getRNC();
			row[1] = e1.getNombreComercial();
			row[2] = e1.getRazonSocial();
			row[3] = e1.getSector();
			row[4] = e1.getRubro();
			row[5] = e1.getUbicacion().toString();	
			model.addRow(row);
		}
	}

	// Cambiar el estado de los botones de solicitudes
	private void setButtonsState(boolean isEnabled) {
		btnVerSolicitudes.setEnabled(isEnabled);
		btnVerSolicitudesPendientes.setEnabled(isEnabled);
		btnVerDetalles.setEnabled(isEnabled);
		btnModificar.setEnabled(isEnabled);
		
	}
}
