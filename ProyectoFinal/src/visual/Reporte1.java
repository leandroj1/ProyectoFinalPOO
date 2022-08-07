package visual;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import customs.NonEditableTable;
import ficheros.UtilsFicheros;
import logico.BolsaTrabajo;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Rectangle;

public class Reporte1 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DefaultTableModel model;
	private Object[] row;
	private ButtonGroup tiposGroup;
	NonEditableTable tablaReporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Reporte1 dialog = new Reporte1();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Reporte1() {
		setTitle("Rep1: Cantidad de personas empleadas por tipo");
		// TODO: agregar tipo de empresa
		final String[] headers = {
				"Cantidad de personas empleadas"
		};
		tiposGroup = new ButtonGroup();

		this.addWindowListener(UtilsFicheros.getWindowAdapterToSave());
		setResizable(false);
		setBounds(100, 100, 361, 234);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 326, 56);
		getContentPane().add(panel);

		JRadioButton rbUniversitario = new JRadioButton("Universitario");
		rbUniversitario.setSelected(true);
		rbUniversitario.setBounds(6, 17, 109, 23);
		panel.add(rbUniversitario);
		tiposGroup.add(rbUniversitario);

		JRadioButton rbTecnico = new JRadioButton("T\u00E9cnico");
		rbTecnico.setBounds(117, 17, 109, 23);
		panel.add(rbTecnico);
		tiposGroup.add(rbTecnico);

		JRadioButton rbObrero = new JRadioButton("Obrero");
		rbObrero.setBounds(223, 17, 97, 23);
		panel.add(rbObrero);
		tiposGroup.add(rbObrero);

		rbUniversitario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbUniversitario.isSelected()) {
					rbObrero.setSelected(false);
					rbTecnico.setSelected(false);
					loadRowsInTable(rbUniversitario.getText());
				}
			}
		});

		rbTecnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbTecnico.isSelected()) {
					rbObrero.setSelected(false);
					rbUniversitario.setSelected(false);
					loadRowsInTable(rbTecnico.getText());
				}
			}
		});

		rbObrero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbObrero.isSelected()) {
					rbTecnico.setSelected(false);
					rbUniversitario.setSelected(false);
					loadRowsInTable(rbObrero.getText());
				}
			}
		});

		{
			model = new DefaultTableModel();
			model.setColumnIdentifiers(headers);
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			panel_1.setBounds(10, 78, 326, 48);
			getContentPane().add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(new Rectangle(10, 78, 296, 56));
			scrollPane.setBackground(Color.WHITE);
			panel_1.add(scrollPane);
			tablaReporte = new NonEditableTable();
			tablaReporte.setRowHeight(25);
			tablaReporte.setGridColor(Color.WHITE);
			tablaReporte.setSelectionForeground(Color.WHITE);
			tablaReporte.setBackground(Color.WHITE);
			tablaReporte.setBounds(new Rectangle(5, 5, 5, 25));
			tablaReporte.setRowSelectionAllowed(false);
			tablaReporte.setShowVerticalLines(false);
			tablaReporte.setShowGrid(false);
			tablaReporte.setShowHorizontalLines(false);
			tablaReporte.getTableHeader().setReorderingAllowed(false);
			tablaReporte.setModel(model);
			scrollPane.setViewportView(tablaReporte);
		}
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 149, 326, 33);
		getContentPane().add(panel_1);

		JButton button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setActionCommand("Cancel");
		button.setBounds(210, 5, 112, 23);
		panel_1.add(button);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tablaReporte.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		loadRowsInTable(rbUniversitario.getText());
	}
	private void loadRowsInTable(String tipo) {
		tipo = tipo.replace('é', 'e');
		row = new Object[1];
		model.setRowCount(0);
		BolsaTrabajo bolsaTrabajo = BolsaTrabajo.getInstance();
		if(tipo.equalsIgnoreCase("Universitario")) {
			row[0] = bolsaTrabajo.getCantidadUniversitariosContratados();
		}
		else if(tipo.equalsIgnoreCase("Obrero")) {
			row[0] = bolsaTrabajo.getCantidadObrerosContratados();
		}
		else if(tipo.equalsIgnoreCase("Tecnico")) {
			row[0] = bolsaTrabajo.getCantidadTecnicosContratados();
		}
		model.addRow(row);
	}

}
