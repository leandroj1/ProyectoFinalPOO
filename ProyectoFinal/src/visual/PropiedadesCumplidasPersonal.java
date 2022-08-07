package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ficheros.UtilsFicheros;
import logico.Personal;
import logico.SolicitudEmpresa;
import logico.SolicitudPersonal;
import logico.Utils;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
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
	private JLabel iconOficios;
	private JLabel lblTipoDePersonal;
	private JLabel iconAreaTecnica;
	private JLabel lblNewLabel;
	private JLabel lblPorcentajeMatch;

	/**
	 * Create the dialog.
	 */
	public PropiedadesCumplidasPersonal(Personal personal, SolicitudPersonal solicitudPersonal, SolicitudEmpresa solicitudEmpresa) {
		setTitle("Condiciones de los requisitos para " + personal.getNombre());
		currentPersonal = personal;
		currentSolicitudEmpresa = solicitudEmpresa;
		currentSolicitudPersonal = solicitudPersonal;
		ImageIcon iconDefault = new ImageIcon("img/error.png");
		this.addWindowListener(UtilsFicheros.getWindowAdapterToSave());
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 627, 550);
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
			iconSexo.setIcon(iconDefault);
			contentPanel.add(iconSexo);
		}
		{
			lblSexo = new JLabel("___");
			contentPanel.add(lblSexo);
		}
		{
			iconEdad = new JLabel("Edad:");
			iconEdad.setIcon(iconDefault);
			contentPanel.add(iconEdad);
		}
		{
			lblEdad = new JLabel("___");
			contentPanel.add(lblEdad);
		}
		{
			iconNacionalidad = new JLabel("Nacionalidad:");
			iconNacionalidad.setIcon(iconDefault);
			contentPanel.add(iconNacionalidad);
		}
		{
			lblNacionalidad = new JLabel("___");
			contentPanel.add(lblNacionalidad);
		}
		{
			iconCasado = new JLabel("\u00BFEst\u00E1 casado?:");
			iconCasado.setIcon(iconDefault);
			contentPanel.add(iconCasado);
		}
		{
			lblCasado = new JLabel("___");
			contentPanel.add(lblCasado);
		}
		{
			iconExp = new JLabel("A\u00F1os de experiencia:");
			iconExp.setIcon(iconDefault);
			contentPanel.add(iconExp);
		}
		{
			lblExp = new JLabel("___");
			contentPanel.add(lblExp);
		}
		{
			iconCambioResidencia = new JLabel("Disponibilidad para cambiar de residencia:");
			iconCambioResidencia.setIcon(iconDefault);
			contentPanel.add(iconCambioResidencia);
		}
		{
			lblCambioResidencia = new JLabel("___");
			contentPanel.add(lblCambioResidencia);
		}
		{
			lblDisponibilidadParaSalir = new JLabel("Disponibilidad para salir de la ciudad:");
			lblDisponibilidadParaSalir.setIcon(iconDefault);
			contentPanel.add(lblDisponibilidadParaSalir);
		}
		{
			lblSalirCiudad = new JLabel("___");
			contentPanel.add(lblSalirCiudad);
		}
		{
			iconModalidadDelTrabajo = new JLabel("Modalidad del trabajo:");
			iconModalidadDelTrabajo.setIcon(iconDefault);
			contentPanel.add(iconModalidadDelTrabajo);
		}
		{
			lblModalidadTrabajo = new JLabel("___");
			contentPanel.add(lblModalidadTrabajo);
		}
		{
			iconIdiomas = new JLabel("Idiomas:");
			iconIdiomas.setIcon(iconDefault);
			contentPanel.add(iconIdiomas);
		}
		{
			lblIdiomas = new JLabel("___");
			contentPanel.add(lblIdiomas);
		}
		{
			iconSalario = new JLabel("Salario esperado:");
			iconSalario.setIcon(iconDefault);
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
			iconUniversidad.setIcon(iconDefault);
			contentPanel.add(iconUniversidad);
		}
		{
			lblUniversidad = new JLabel("N/A");
			contentPanel.add(lblUniversidad);
		}
		{
			iconCarrera = new JLabel("Carrera:");
			iconCarrera.setIcon(iconDefault);
			contentPanel.add(iconCarrera);
		}
		{
			lblCarrera = new JLabel("N/A");
			contentPanel.add(lblCarrera);
		}
		{
			iconAreaTecnica = new JLabel("\u00C1rea t\u00E9cnica:");
			iconAreaTecnica.setIcon(iconDefault);
			contentPanel.add(iconAreaTecnica);
		}
		{
			lblAreaTecnica = new JLabel("N/A");
			contentPanel.add(lblAreaTecnica);
		}
		{
			iconOficios = new JLabel("Oficios:");
			iconOficios.setIcon(iconDefault);
			contentPanel.add(iconOficios);
		}
		{
			lblOficios = new JLabel("N/A");
			contentPanel.add(lblOficios);
		}
		{
			lblNewLabel = new JLabel("Porcentaje de match:");
			contentPanel.add(lblNewLabel);
		}
		{
			lblPorcentajeMatch = new JLabel("New label");
			contentPanel.add(lblPorcentajeMatch);
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
		loadIcons();
	}

	public ArrayList<String> getElementosDiferentes(ArrayList<String> arr1, ArrayList<String> arr2) {
		ArrayList<String> result = new ArrayList<String>();

		for (String str1 : arr1) {
			if(!arr2.contains(str1)) {
				result.add(str1);
			}
		}

		return result;
	}

	private void loadIcons() {
		ImageIcon[] icons = {new ImageIcon("img/check.png"), new ImageIcon("img/error.png"), new ImageIcon("img/not.png")};
		
		String sexoRequerido = currentSolicitudEmpresa.getSexo();
		if (sexoRequerido.equalsIgnoreCase("N/A")) {
			iconSexo.setIcon(icons[2]);
		} else {
			if (currentPersonal.getGenero().equalsIgnoreCase(currentSolicitudEmpresa.getSexo()))
				iconSexo.setIcon(icons[0]);
		}

		if (currentSolicitudPersonal.getSalarioEsperado() >= currentSolicitudEmpresa.getSalarioMin()
				&& currentSolicitudPersonal.getSalarioEsperado() <= currentSolicitudEmpresa.getSalarioMax())
			iconSalario.setIcon(icons[0]);
		else if(currentSolicitudPersonal.getSalarioEsperado() <= currentSolicitudEmpresa.getSalarioMin())
			iconSalario.setIcon(icons[0]);

		if (currentPersonal.getEdad() >= currentSolicitudEmpresa.getEdad())
			iconEdad.setIcon(icons[0]);
		if (currentSolicitudPersonal.getAgnosExperiencia() >= currentSolicitudEmpresa.getAgnosExperiencia())
			iconExp.setIcon(icons[0]);

		if(!currentSolicitudEmpresa.isDisponibilidadCambioResidencia()) {
			iconCambioResidencia.setIcon(icons[2]);
		}
		else {
			if (currentSolicitudEmpresa.isDisponibilidadCambioResidencia() == currentSolicitudPersonal.isDisponibilidadCambioResidencia())
				iconCambioResidencia.setIcon(icons[0]);
		}
		if(!currentSolicitudEmpresa.isDisponibilidadSalirCiudad()) {
			lblDisponibilidadParaSalir.setIcon(icons[2]);
		}
		else {
			if (currentSolicitudEmpresa.isDisponibilidadSalirCiudad() == currentSolicitudPersonal.isDisponibilidadSalirCiudad())
				lblDisponibilidadParaSalir.setIcon(icons[0]);
		}

		// Si no prefiere una nacionalidad
		if(currentSolicitudEmpresa.getNacionalidad().equalsIgnoreCase("Sin preferencia")) {
			iconNacionalidad.setIcon(icons[2]);
		}
		else {
			if(currentSolicitudEmpresa.getNacionalidad().equalsIgnoreCase(currentPersonal.getNacionalidad())) {
				iconNacionalidad.setIcon(icons[0]);
			}
		}

		if (currentSolicitudPersonal.getModalidadDeTrabajo().equalsIgnoreCase(currentSolicitudEmpresa.getTipoDeTrabajo()))
			iconModalidadDelTrabajo.setIcon(icons[0]);

		// Si tiene la propiedad como true significa que no importa si es casado o no
		if (currentSolicitudEmpresa.isEsCasado()) {
			iconCasado.setIcon(icons[2]);
		}
		// Si es falso, significa que quiere que sea soltero
		else if (currentSolicitudEmpresa.isEsCasado() == currentPersonal.isEsCasado()) {
			iconCasado.setIcon(icons[0]);
		}

		ArrayList<String> idiomasDiferentes = getElementosDiferentes(currentSolicitudEmpresa.getIdiomas(), currentPersonal.getIdiomas());
		ArrayList<String> idiomasMostrar;
		String messageIdiomas = "";
		if(idiomasDiferentes.size() == 0) {
			idiomasMostrar = currentPersonal.getIdiomas();
			iconIdiomas.setIcon(icons[0]);
		}
		else {
			iconIdiomas.setIcon(icons[1]);
			messageIdiomas = "Falta: ";
			idiomasMostrar = idiomasDiferentes;
		}
		for (int i = 0; i < idiomasMostrar.size(); i++) {
			messageIdiomas += idiomasMostrar.get(i) + (i == idiomasMostrar.size() - 1 ? "": ", ");
		}
		lblIdiomas.setText(messageIdiomas);

		if(currentSolicitudEmpresa.getTipoPersonalSolicitado().equalsIgnoreCase("obrero")) {
			ArrayList<String> oficiosDiferentes = getElementosDiferentes(currentSolicitudEmpresa.getIdiomas(), currentPersonal.getIdiomas());
			ArrayList<String> oficiosMostrar;
			String messageOficios = "";
			if(idiomasDiferentes.size() == 0) {
				oficiosMostrar = currentSolicitudPersonal.getOficios();
				iconOficios.setIcon(icons[0]);
			}
			else {
				iconOficios.setIcon(icons[1]);
				messageOficios = "Falta: ";
				oficiosMostrar = oficiosDiferentes;
			}
			for (int i = 0; i < oficiosMostrar.size(); i++) {
				messageOficios += oficiosMostrar.get(i) + (i == oficiosMostrar.size() - 1 ? "": ", ");
			}
			lblOficios.setText(messageOficios);		
			
			iconAreaTecnica.setIcon(icons[2]);
			iconUniversidad.setIcon(icons[2]);
			iconCarrera.setIcon(icons[2]);
		}
		else if(currentSolicitudEmpresa.getTipoPersonalSolicitado().equalsIgnoreCase("universitario")) {
			if(currentSolicitudEmpresa.getCarrera().equalsIgnoreCase(currentSolicitudPersonal.getCarrera())) {
				iconCarrera.setIcon(icons[0]);
			}
			if(currentSolicitudEmpresa.getUniversidad().equalsIgnoreCase(currentSolicitudPersonal.getUniversidad())) {
				iconUniversidad.setIcon(icons[0]);
			}

			iconOficios.setIcon(icons[2]);
			iconAreaTecnica.setIcon(icons[2]);
		}
		else {
			if(currentSolicitudEmpresa.getAreaTecnica().equalsIgnoreCase(currentSolicitudPersonal.getAreaTecnica())) {
				iconAreaTecnica.setIcon(icons[0]);				
			}
			
			iconOficios.setIcon(icons[2]);
			iconUniversidad.setIcon(icons[2]);
			iconCarrera.setIcon(icons[2]);
		}
	}

	private void loadData() {
		lblNombre.setText(currentPersonal.getNombre());
		lblCedula.setText(currentPersonal.getCedula());
		lblSexo.setText(currentPersonal.getGenero());
		lblEdad.setText(String.valueOf(currentPersonal.getEdad()));
		lblNacionalidad.setText(currentPersonal.getNacionalidad());
		lblCasado.setText(!currentPersonal.isEsCasado() ? "S\u00ed" : "No");
		lblExp.setText(String.valueOf(currentSolicitudPersonal.getAgnosExperiencia()));
		lblSalirCiudad.setText(currentSolicitudPersonal.isDisponibilidadSalirCiudad() ? "S\u00ed" : "No");
		lblCambioResidencia.setText(currentSolicitudPersonal.isDisponibilidadCambioResidencia() ? "S\u00ed" : "No");
		lblModalidadTrabajo.setText(currentSolicitudPersonal.getModalidadDeTrabajo());
		lblSalarioEsperado.setText("RD$ " + String.valueOf(currentSolicitudPersonal.getSalarioEsperado()));
		lblTipoTrabajador.setText(currentSolicitudEmpresa.getTipoPersonalSolicitado());
		if(currentSolicitudEmpresa.getTipoPersonalSolicitado().equalsIgnoreCase("universitario")) {
			lblUniversidad.setText(currentSolicitudPersonal.getUniversidad());
			lblCarrera.setText(currentSolicitudPersonal.getCarrera());
		}
		else if(currentSolicitudEmpresa.getTipoPersonalSolicitado().equalsIgnoreCase("obrero")) {
			lblOficios.setText("");
		}
		else {
			lblAreaTecnica.setText(currentSolicitudPersonal.getAreaTecnica());
		}
		lblPorcentajeMatch.setText(Utils.roundTo2(currentSolicitudPersonal.getPorcentajeMatchAsignado()) + " %");
	}

}
