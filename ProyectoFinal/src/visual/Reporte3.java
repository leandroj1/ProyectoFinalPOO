package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import customs.NonEditableTable;
import logico.BolsaTrabajo;
import logico.Empresa;

public class Reporte3 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tablaReporte;
	private DefaultTableModel model;
	private Object[] row;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Reporte3 dialog = new Reporte3();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Reporte3() {
		setTitle("Rep3: Cantidad de Solicitudes por sector");
		// TODO: agregar tipo de empresa
		final String[] headers = {
				"Sector",
				"Cantidad de Solicitudes de Empresa"
		};
		setResizable(false);
		setBounds(100, 100, 624, 398);
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
				scrollPane.setBounds(0, 0, 600, 311);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane); {
					tablaReporte = new NonEditableTable();
					tablaReporte.getTableHeader().setReorderingAllowed(false);
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					tablaReporte.setModel(model);
					scrollPane.setViewportView(tablaReporte);
				}
			}
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 314, 600, 33);
			panel.add(buttonPane);
			{
			buttonPane.setLayout(null);
		}
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancelar.setActionCommand("Cancel");
			btnCancelar.setBounds(480, 5, 112, 23);
			buttonPane.add(btnCancelar);

		}
		{
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(JLabel.CENTER);
			tablaReporte.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
			tablaReporte.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
			loadRowsInTable();
		}

	}
	private void loadRowsInTable() {
		Map<String, Integer> data = BolsaTrabajo.getInstance().testRP3();
		row = new Object[model.getColumnCount()];
		model.setRowCount(0);
		data.forEach((sector, cantPersonas) -> {
			row[0] = sector;
			row[1] = cantPersonas;
			model.addRow(row);
		});
	}
}
