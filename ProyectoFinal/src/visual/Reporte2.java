package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
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

public class Reporte2 extends JDialog {
	private JTable tablaReporte;
	private DefaultTableModel model;
	private Object[] row;
	private ButtonGroup generoGroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Reporte2 dialog = new Reporte2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Reporte2() {
		setTitle("Rep2-Sexo");
		// TODO: agregar tipo de empresa
		final String[] headers = {
				"Cantidad de personas empleadas"
		};
		
		setResizable(false);
		setBounds(100, 100, 330, 209);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 296, 56);
		getContentPane().add(panel);
		
		JRadioButton rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnFemenino.isSelected()) {
					loadRowsInTable(rdbtnFemenino.getText());
				}
			}
		});
		rdbtnFemenino.setSelected(true);
		rdbtnFemenino.setBounds(17, 17, 109, 23);
		panel.add(rdbtnFemenino);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnMasculino.isSelected()) {
					loadRowsInTable(rdbtnMasculino.getText());
				}				
			}
		});
		rdbtnMasculino.setBounds(181, 17, 109, 23);
		panel.add(rdbtnMasculino);
		generoGroup = new ButtonGroup();
		generoGroup.add(rdbtnFemenino);
		generoGroup.add(rdbtnMasculino);
		{
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
 {
			tablaReporte = new NonEditableTable();
			tablaReporte.setIntercellSpacing(new Dimension(0, 0));
			tablaReporte.setGridColor(Color.WHITE);
			tablaReporte.setRowHeight(33);
			tablaReporte.getTableHeader().setReorderingAllowed(false);
			model = new DefaultTableModel();
			model.setColumnIdentifiers(headers);
			tablaReporte.setModel(model);
			scrollPane.setViewportView(tablaReporte);
		}
		scrollPane.setBounds(10, 78, 296, 56);
		getContentPane().add(scrollPane);
	}
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 141, 303, 33);
		getContentPane().add(panel_1);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setActionCommand("Cancel");
		btnCancelar.setBounds(181, 0, 112, 23);
		panel_1.add(btnCancelar);
		
		JButton button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setActionCommand("Cancel");
		button.setBounds(190, 5, 112, 23);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tablaReporte.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		loadRowsInTable(rdbtnFemenino.getText());
	}
	private void loadRowsInTable(String sexo) {
		row = new Object[1];
		model.setRowCount(0);
		if(sexo.equalsIgnoreCase("Femenino")) {
			row[0] = BolsaTrabajo.cantPersonalFem;
		}
		else if(sexo.equalsIgnoreCase("Masculino")) {
			row[0] = BolsaTrabajo.cantPersonalMasc;
		}

		model.addRow(row);
	}
}
