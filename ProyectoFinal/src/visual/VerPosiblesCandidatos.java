package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import customs.CheckBoxsEditableTable;
import logico.SolicitudEmpresa;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VerPosiblesCandidatos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private SolicitudEmpresa solicitudLoaded = null;
	private JButton btnContratar;

	private int kColumnaCheckboxes = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VerPosiblesCandidatos dialog = new VerPosiblesCandidatos(new SolicitudEmpresa(null, null, 1, 2, 2, 2, 1, null, null, null, false, false, null, false, null, null, null, 70));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VerPosiblesCandidatos(SolicitudEmpresa solicitud) {
		solicitudLoaded = solicitud;
		final Object[] headers = {"Selección", "Nombre del candidato", "Porcentaje de March"};
		this.model = new DefaultTableModel();
		model.setColumnIdentifiers(headers);

		setBounds(100, 100, 615, 433);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane);
			{
				table = new CheckBoxsEditableTable(this.model, kColumnaCheckboxes);
				table.setPreferredScrollableViewportSize(table.getPreferredSize());
				scrollPane.setViewportView(table);
			}
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					btnContratar = new JButton("Contratar candidatos seleccionados");
					btnContratar.setEnabled(true);
					btnContratar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ArrayList<Integer> indicesFilasSeleccionadas = getIndexesFilasSeleccionadas();
							int cantidadPlazasSeleccionadas = indicesFilasSeleccionadas.size();
							if(cantidadPlazasSeleccionadas == 0) {
								JOptionPane.showMessageDialog(null,
										"Seleccione al menos un candidato.",
										"Error",
										JOptionPane.ERROR_MESSAGE);
							}
							else if(cantidadPlazasSeleccionadas > solicitudLoaded.getCantidadPlazasNecesarias()) {
								int option = JOptionPane.showConfirmDialog(null, "La cantidad de plazas seleccionadas sobrepasa la acordada en la solicitud. ¿Desea actualizar la cantidad de plazas a " + cantidadPlazasSeleccionadas + "?\nSi no actualiza, tendr\u00e1 que seleccionar una cantidad de plazas igual a " + solicitud.getCantidadPlazasNecesarias()+".", "Confirmación | Cantidad de plazas", JOptionPane.YES_NO_OPTION);
								if(JOptionPane.YES_OPTION == option) {
									solicitudLoaded.setCantidadPlazasNecesarias(cantidadPlazasSeleccionadas);
									contratar();
								}
							}
							else {
								contratar();
							}
						}
					});
					btnContratar.setActionCommand("OK");
					buttonPane.add(btnContratar);
					getRootPane().setDefaultButton(btnContratar);
				}
				{
					JButton cancelButton = new JButton("Cancelar");
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

	private ArrayList<Integer> getIndexesFilasSeleccionadas() {
		ArrayList<Integer> indexes = new ArrayList<Integer>();

		for (int rowIndex = 0; rowIndex < model.getRowCount(); rowIndex++) {
			if((boolean)(this.model.getValueAt(rowIndex, kColumnaCheckboxes))) {
				indexes.add(Integer.valueOf(rowIndex));
			}
		}

		return indexes;
	}

	private void contratar() {
		return;
	}
}
