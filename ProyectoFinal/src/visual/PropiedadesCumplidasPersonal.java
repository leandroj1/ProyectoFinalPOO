package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Personal;
import logico.SolicitudEmpresa;
import logico.SolicitudPersonal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;

public class PropiedadesCumplidasPersonal extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private Personal currentPersonal;
	private SolicitudEmpresa currentSolicitudEmpresa;
	private SolicitudPersonal currentSolicitudPersonal;
	private JLabel lblCedula;
	private JLabel iconModalidadDelTrabajo;
	private JLabel iconNombre;
	private JLabel iconSexo;
	private JLabel iconEdad;
	private JLabel iconNacionalidad;
	private JLabel iconCasado;
	private JLabel iconExp;
	private JLabel iconCambioResidencia;
	private JLabel lblDisponibilidadParaSalir;
	private JLabel iconIdiomas;
	private JLabel iconSalario;
	private JLabel iconUniversidad;
	private JLabel lblTipoDePersonal;
	private JLabel iconCarrera;
	private JLabel lblNombre;
	private JLabel lblSexo;
	private JLabel lblEdad;
	private JLabel lblNacionalidad;
	private JLabel lblCasado;
	private JLabel lblExp;
	private JLabel lblSalirCiudad;
	private JLabel lblCambioResidencia;
	private JLabel lblModalidadTrabajo;
	private JLabel lblIdiomas;
	private JLabel lblSalarioEsperado;
	private JLabel lblTipoTrabajador;
	private JLabel lblUniversidad;
	private JLabel lblCarrera;
	private JLabel lblAreaTecnica;
	private JLabel lblOficios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PropiedadesCumplidasPersonal dialog = new PropiedadesCumplidasPersonal(null, null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public PropiedadesCumplidasPersonal(Personal personal, SolicitudPersonal solicitudPersonal, SolicitudEmpresa solicitudEmpresa) {
		setTitle("Condiciones de los requisitos para ");
		currentPersonal = personal;
		currentSolicitudEmpresa = solicitudEmpresa;
		currentSolicitudPersonal = solicitudPersonal;

		setModal(true);
		setResizable(false);
		setBounds(100, 100, 598, 550);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 8));
		{
			iconNombre = new JLabel("Nombre:");
			contentPanel.add(iconNombre);
		}
		{
			lblNombre = new JLabel("___");
			contentPanel.add(lblNombre);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("C\u00E9dula:");
			contentPanel.add(lblNewLabel_1);
		}
		{
			lblCedula = new JLabel("___");
			contentPanel.add(lblCedula);
		}
		{
			iconSexo = new JLabel("Sexo:");
			contentPanel.add(iconSexo);
		}
		{
			lblSexo = new JLabel("___");
			contentPanel.add(lblSexo);
		}
		{
			iconEdad = new JLabel("Edad:");
			contentPanel.add(iconEdad);
		}
		{
			lblEdad = new JLabel("___");
			contentPanel.add(lblEdad);
		}
		{
			iconNacionalidad = new JLabel("Nacionalidad:");
			contentPanel.add(iconNacionalidad);
		}
		{
			lblNacionalidad = new JLabel("___");
			contentPanel.add(lblNacionalidad);
		}
		{
			iconCasado = new JLabel("\u00BFEst\u00E1 casado?:");
			contentPanel.add(iconCasado);
		}
		{
			lblCasado = new JLabel("___");
			contentPanel.add(lblCasado);
		}
		{
			iconExp = new JLabel("A\u00F1os de experiencia:");
			contentPanel.add(iconExp);
		}
		{
			lblExp = new JLabel("___");
			contentPanel.add(lblExp);
		}
		{
			iconCambioResidencia = new JLabel("Disponibilidad para cambiar de residencia:");
			contentPanel.add(iconCambioResidencia);
		}
		{
			lblCambioResidencia = new JLabel("___");
			contentPanel.add(lblCambioResidencia);
		}
		{
			lblDisponibilidadParaSalir = new JLabel("Disponibilidad para salir de la ciudad:");
			contentPanel.add(lblDisponibilidadParaSalir);
		}
		{
			lblSalirCiudad = new JLabel("___");
			contentPanel.add(lblSalirCiudad);
		}
		{
			iconModalidadDelTrabajo = new JLabel("Modalidad del trabajo:");
			contentPanel.add(iconModalidadDelTrabajo);
		}
		{
			lblModalidadTrabajo = new JLabel("___");
			contentPanel.add(lblModalidadTrabajo);
		}
		{
			iconIdiomas = new JLabel("Idiomas:");
			contentPanel.add(iconIdiomas);
		}
		{
			lblIdiomas = new JLabel("___");
			contentPanel.add(lblIdiomas);
		}
		{
			iconSalario = new JLabel("Salario esperado:");
			contentPanel.add(iconSalario);
		}
		{
			lblSalarioEsperado = new JLabel("___");
			contentPanel.add(lblSalarioEsperado);
		}
		{
			lblTipoDePersonal = new JLabel("Tipo de personal requerido");
			lblTipoDePersonal.setIcon(new ImageIcon("img/check.png"));
			contentPanel.add(lblTipoDePersonal);
		}
		{
			lblTipoTrabajador = new JLabel("___");
			contentPanel.add(lblTipoTrabajador);
		}
		{
			iconUniversidad = new JLabel("Universidad");
			contentPanel.add(iconUniversidad);
		}
		{
			lblUniversidad = new JLabel("N/A");
			contentPanel.add(lblUniversidad);
		}
		{
			iconCarrera = new JLabel("Carrera:");
			contentPanel.add(iconCarrera);
		}
		{
			lblCarrera = new JLabel("N/A");
			contentPanel.add(lblCarrera);
		}
		{
			JLabel iconAreaTecnica = new JLabel("\u00C1rea t\u00E9cnica:");
			contentPanel.add(iconAreaTecnica);
		}
		{
			lblAreaTecnica = new JLabel("N/A");
			contentPanel.add(lblAreaTecnica);
		}
		{
			JLabel iconOficios = new JLabel("Oficios:");
			contentPanel.add(iconOficios);
		}
		{
			lblOficios = new JLabel("N/A");
			contentPanel.add(lblOficios);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		loadData();
	}

	private void loadData() {
		// TODO Auto-generated method stub
		
	}
	
}
