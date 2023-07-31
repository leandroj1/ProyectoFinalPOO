package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import ficheros.UtilsFicheros;
import logico.BolsaTrabajo;
import logico.Empresa;
import logico.Ubicacion;
import logico.Utils;
import javax.swing.UIManager;

public class RegEmpresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField txtFRNC;
	private JComboBox cbxTipo;
	private JComboBox cbxSector;
	private JTextField txtRubro;
	private JTextField txtNombreComercial;
	private JTextField txtRazonSocial;
	private static JTextField txtCiudadResidencia;
	private static JTextField txtDireccion;
	private static JTextField txtPais;
	private static JTextField txtProvincia;
	private static JTextField txtNombreContacto;
	private static JTextField txtEmailContacto;
	private static JFormattedTextField txtFTelefono;
	private static JComboBox cbxCargoContacto;
	private static JButton btnRegistrar;
	private Empresa auxEmpresa = null;

	/**
	 * Create the dialog.
	 */
	public RegEmpresa(Empresa empresa) {	
		auxEmpresa = empresa;
		if(auxEmpresa == null ) {
			setTitle("Registro de Empresa");
		}else {
			setTitle("Modificar datos de la empresa " + auxEmpresa.getNombreComercial());

		}
		this.addWindowListener(UtilsFicheros.getWindowAdapterToSave());
		setModal(true);
		setBounds(100, 100, 733, 516);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);

			JLabel lblNewLabel = new JLabel("RNC:");
			lblNewLabel.setBounds(33, 32, 94, 14);
			panel.add(lblNewLabel);
			try{
				txtFRNC = new JFormattedTextField(Utils.getMaskCedula());
				txtFRNC.setForeground(Color.BLACK);
				txtFRNC.setToolTipText("");
				txtFRNC.setBounds(120, 29, 146, 20);
				panel.add(txtFRNC);
			}catch(Exception ex){}
			{
				JLabel lblNewLabel_1 = new JLabel("Tipo de empresa:");
				lblNewLabel_1.setBounds(382, 115, 98, 14);
				panel.add(lblNewLabel_1);
			}
			{
				cbxTipo = new JComboBox();
				cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Micro", "Mediana", "Peque\u00F1a", "Grande", "Emergente"}));

				cbxTipo.setBounds(502, 112, 156, 20);
				panel.add(cbxTipo);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Sector:");
				lblNewLabel_2.setBounds(382, 73, 98, 14);
				panel.add(lblNewLabel_2);
			}
			{
				JLabel lblNombre = new JLabel("Nombre Comercial:");
				lblNombre.setBounds(382, 32, 141, 14);
				panel.add(lblNombre);
			}
			{
				txtRubro = new JTextField();
				txtRubro.setColumns(10);
				txtRubro.setBounds(120, 112, 146, 20);
				panel.add(txtRubro);
			}			
			{
				txtNombreComercial = new JTextField();
				txtNombreComercial.setColumns(10);
				txtNombreComercial.setBounds(502, 29, 156, 20);
				panel.add(txtNombreComercial);
			}
			{
				cbxSector = new JComboBox();
				cbxSector.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Industrial", "Agricultura", "Alimentaci\u00F3n", "Comercio", "Construcci\u00F3n", "Educaci\u00F3n", "Hoteler\u00EDa", "Medios de comunicaci\u00F3n", "Miner\u00EDa", "Petrolero", "Telecomunicaciones", "Salud", "Financieros", "P\u00FAblico", "Silvicultura", "Textil", "Tecnol\u00F3gico", "Transporte"}));

				cbxSector.setBounds(502, 70, 156, 20);
				panel.add(cbxSector);
			}
			{
				txtRazonSocial = new JTextField();
				txtRazonSocial.setColumns(10);
				txtRazonSocial.setBounds(120, 70, 148, 20);
				panel.add(txtRazonSocial);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Rubro:");
				lblNewLabel_3.setBounds(33, 115, 46, 14);
				panel.add(lblNewLabel_3);
			}
			{
				JLabel lblRaznSocial = new JLabel("Raz\u00F3n Social:");
				lblRaznSocial.setBounds(33, 73, 98, 14);
				panel.add(lblRaznSocial);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBorder(new TitledBorder(null, "Datos de la Ubicaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(10, 290, 687, 117);
				panel.add(panel_1);
				{
					JLabel label = new JLabel("Ciudad de Residencia:");
					label.setBounds(23, 31, 195, 14);
					panel_1.add(label);
				}
				{
					txtCiudadResidencia = new JTextField();
					txtCiudadResidencia.setColumns(10);
					txtCiudadResidencia.setBounds(161, 31, 179, 20);
					panel_1.add(txtCiudadResidencia);
				}
				{
					JLabel label = new JLabel("Direcci\u00F3n:");
					label.setBounds(23, 72, 195, 14);
					panel_1.add(label);
				}
				{
					txtDireccion = new JTextField();
					txtDireccion.setColumns(10);
					txtDireccion.setBounds(161, 70, 179, 20);
					panel_1.add(txtDireccion);
				}
				{
					JLabel label = new JLabel("Provincia:");
					label.setBounds(372, 31, 195, 14);
					panel_1.add(label);
				}
				{
					JLabel label = new JLabel("Pa\u00EDs:");
					label.setBounds(372, 72, 195, 14);
					panel_1.add(label);
				}
				{
					txtPais = new JTextField();
					txtPais.setColumns(10);
					txtPais.setBounds(453, 70, 195, 20);
					panel_1.add(txtPais);
				}
				{
					txtProvincia = new JTextField();
					txtProvincia.setColumns(10);
					txtProvincia.setBounds(453, 31, 195, 20);
					panel_1.add(txtProvincia);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de Contacto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_1.setBounds(10, 160, 687, 117);
				panel.add(panel_1);
				{
					JLabel lblNombre_1 = new JLabel("Nombre:");
					lblNombre_1.setBounds(23, 31, 195, 14);
					panel_1.add(lblNombre_1);
				}
				{
					txtNombreContacto = new JTextField();
					txtNombreContacto.setColumns(10);
					txtNombreContacto.setBounds(81, 31, 175, 20);
					panel_1.add(txtNombreContacto);
				}
				{
					JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
					lblTelfono.setBounds(372, 31, 195, 14);
					panel_1.add(lblTelfono);
				}
				{
					JLabel lblEmail = new JLabel("Email:");
					lblEmail.setBounds(23, 72, 195, 14);
					panel_1.add(lblEmail);
				}
				{
					txtEmailContacto = new JTextField();
					txtEmailContacto.setColumns(10);
					txtEmailContacto.setBounds(81, 70, 175, 20);
					panel_1.add(txtEmailContacto);
				}
				{
					txtFTelefono = new JFormattedTextField(Utils.getMaskTelefono());
					txtFTelefono.setToolTipText("");
					txtFTelefono.setForeground(Color.BLACK);
					txtFTelefono.setBounds(453, 31, 195, 20);
					panel_1.add(txtFTelefono);
				}
				{
					JLabel lblCargo = new JLabel("Cargo:");
					lblCargo.setBounds(372, 72, 195, 14);
					panel_1.add(lblCargo);
				}
				{
					cbxCargoContacto = new JComboBox();
					cbxCargoContacto.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "CEO", "CTO", "RRHH", "Secretario/a del CEO", "Gerente de Log\u00EDstica", "Gerente de Comunicaciones", "Gerente de Operaciones", "Gerente de Servicios Administrativos", "Otro"}));
					cbxCargoContacto.setBounds(453, 69, 195, 20);
					panel_1.add(cbxCargoContacto);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton("Registrar");
				if(auxEmpresa != null) {
					btnRegistrar.setText("Actualizar");
				}
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Ubicacion ubicacion;
						String message = elemVacios();
						if(auxEmpresa == null) {
							if (!message.isEmpty()) {
								JOptionPane.showMessageDialog(null, message);
								return;								
							}
							else {	
								if (Utils.isAValidEmail(txtEmailContacto.getText().trim())) {
									ArrayList<Empresa> resultado = BolsaTrabajo.getInstance().getEmpresasByID(txtFRNC.getText());
									if (resultado.size() == 0) {
										ubicacion = new Ubicacion(txtPais.getText(), txtProvincia.getText(), txtCiudadResidencia.getText(), txtDireccion.getText());
										Empresa empresa = new Empresa(txtFRNC.getText(), txtNombreComercial.getText(), txtRazonSocial.getText(), txtRubro.getText(), cbxCargoContacto.getSelectedItem().toString(), txtNombreContacto.getText(), txtFTelefono.getText(), txtEmailContacto.getText().trim(), cbxSector.getSelectedItem().toString(), cbxTipo.getSelectedItem().toString(), ubicacion);
										try {
											BolsaTrabajo.getInstance().agregarEmpresa(empresa);
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										JOptionPane.showMessageDialog(null, "Registro exitoso.", "Informaci\u00f3n", JOptionPane.INFORMATION_MESSAGE);

										clean();
									}
									else {
										JOptionPane.showMessageDialog(null, "Esta empresa ya est\u00E1 registrada, por favor ingrese otra", "Advertencia", JOptionPane.WARNING_MESSAGE);
									}
								}
								else {
									JOptionPane.showMessageDialog(null, "El email ingresado no es v\u00E1lido, por favor ingrese otro", "Advertencia", JOptionPane.WARNING_MESSAGE);
								}
							}
						}
						else {
							if (!message.isEmpty()) {
								JOptionPane.showMessageDialog(null, message);
								return;								
							}
							else if (!(Utils.isAValidEmail(txtEmailContacto.getText().trim()))){
								JOptionPane.showMessageDialog(null, "El email ingresado no es v\u00E1lido, por favor ingrese otro", "Advertencia", JOptionPane.WARNING_MESSAGE);
							}
							else {
								ubicacion = auxEmpresa.getUbicacion();
								ubicacion.setCiudad(txtCiudadResidencia.getText());
								ubicacion.setDireccion(txtDireccion.getText());
								ubicacion.setPais(txtPais.getText());
								ubicacion.setProvincia(txtProvincia.getText());
								auxEmpresa.setUbicacion(ubicacion);
								auxEmpresa.setTelefonoContacto(txtFTelefono.getText());
								auxEmpresa.setNombreContacto(txtNombreContacto.getText());
								auxEmpresa.setEmailContacto(txtEmailContacto.getText().trim());
								auxEmpresa.setCargoContacto(cbxCargoContacto.getSelectedItem().toString());
								JOptionPane.showMessageDialog(null, "Actualizaci\u00f3n exitosa", "Informaci\u00f3n", JOptionPane.INFORMATION_MESSAGE);
								dispose();
							}
		

						}
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		loadEmpresa();
	}
	
	private void loadEmpresa() {
		if(auxEmpresa != null) {
			txtNombreComercial.setText(auxEmpresa.getNombreComercial());
			txtNombreContacto.setText(auxEmpresa.getNombreContacto());
			txtFRNC.setText(auxEmpresa.getRNC());
			txtPais.setText(auxEmpresa.getUbicacion().getPais());
			txtProvincia.setText(auxEmpresa.getUbicacion().getProvincia());
			txtCiudadResidencia.setText(auxEmpresa.getUbicacion().getCiudad());
			txtDireccion.setText(auxEmpresa.getUbicacion().getDireccion());
			txtFTelefono.setText(auxEmpresa.getTelefonoContacto());
			txtEmailContacto.setText(auxEmpresa.getEmailContacto());
			cbxCargoContacto.setSelectedItem(auxEmpresa.getCargoContacto());
			cbxSector.setSelectedItem(auxEmpresa.getSector());
			cbxTipo.setSelectedItem(auxEmpresa.getTipo());
			txtRazonSocial.setText(auxEmpresa.getRazonSocial());
			txtRubro.setText(auxEmpresa.getRubro());
			cbxSector.setEnabled(false);
			cbxTipo.setEnabled(false);
			txtFRNC.setEditable(false);
			txtNombreComercial.setEditable(false);
			txtRazonSocial.setEditable(false);
			txtRubro.setEditable(false);			
		}

	}
	
	public static void desactivado() {
		cbxCargoContacto.setEnabled(false);
		txtCiudadResidencia.setEditable(false);
		txtDireccion.setEditable(false);
		txtEmailContacto.setEditable(false);
		txtFTelefono.setEditable(false);
		txtNombreContacto.setEditable(false);
		txtPais.setEditable(false);
		txtProvincia.setEditable(false);
		btnRegistrar.setEnabled(false);
		btnRegistrar.setVisible(false);		
	}
	
	private  String elemVacios() {
		ArrayList<String> emptyFields = new ArrayList<String>();

		if (Utils.isCbxDefaultValue(cbxCargoContacto)) {
			emptyFields.add("Cargo de Contacto");
		}		
		if (Utils.isCbxDefaultValue(cbxSector)) {
			emptyFields.add("Sector");
		}		
		if (Utils.isCbxDefaultValue(cbxTipo)) {
			emptyFields.add("Tipo");
		}
		if (Utils.isMaskCedulaDefaultValue(txtFRNC.getText())) {
			emptyFields.add("RNC");
		}
		if (Utils.isMaskTelefonoDefaultValue(txtFTelefono.getText())) {
			emptyFields.add("Tel\u00E9fono");
		}
		if (txtCiudadResidencia.getText().isEmpty()) {
			emptyFields.add("Ciudad de Residencia");
		}
		if (txtDireccion.getText().isEmpty()) {
			emptyFields.add("Direcc\u00F3n");
		}
		if (txtEmailContacto.getText().trim().isEmpty()) {
			emptyFields.add("Email");
		}
		if (txtNombreComercial.getText().isEmpty()) {
			emptyFields.add("Nombre Comercial");
		}
		if (txtNombreContacto.getText().isEmpty()) {
			emptyFields.add("Nombre de Contacto");
		}
		if (txtPais.getText().isEmpty()) {
			emptyFields.add("Pa\u00EDs:");
		}
		if (txtProvincia.getText().isEmpty()) {
			emptyFields.add("Provincia");
		}
		if (txtRazonSocial.getText().isEmpty()) {
			emptyFields.add("Raz\u00F3n Social");
		}
		if (txtRubro.getText().isEmpty()) {
			emptyFields.add("Rubro");
		}
		String message = "";
		if (emptyFields.size() > 0) {
			message = "Los siguientes campos estan vacios o tienen un formato incorrecto: ";

			for (String emptyField : emptyFields)
				message += "\n\t- " + emptyField;
		}

		return message;
	}


	private void clean() {
		cbxCargoContacto.setSelectedIndex(0);
		cbxSector.setSelectedIndex(0);
		cbxTipo.setSelectedIndex(0);
		txtCiudadResidencia.setText("");
		txtDireccion.setText("");
		txtEmailContacto.setText("");
		txtFRNC.setText("");
		txtFTelefono.setText("");
		txtNombreComercial.setText("");
		txtNombreContacto.setText("");
		txtPais.setText("");
		txtProvincia.setText("");
		txtRazonSocial.setText("");
		txtRubro.setText("");
	}
}
