package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import customs.CheckBoxsEditableTable;
import customs.NonEditableTable;
import logico.SolicitudEmpresa;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerPosiblesCandidatos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private SolicitudEmpresa solicitudLoaded = null;
	private JButton btnContratar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VerPosiblesCandidatos dialog = new VerPosiblesCandidatos(null);
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

		final Object[] columnNames = {"Selección", "Nombre del candidato", "Porcentaje de March"};
        Object[][] data = {};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);


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
				table = new CheckBoxsEditableTable(model, 0);
		        table.setPreferredScrollableViewportSize(table.getPreferredSize());
				scrollPane.setViewportView(table);
			}
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					btnContratar = new JButton("Contratar candidatos seleccionados");
					btnContratar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
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
	}}