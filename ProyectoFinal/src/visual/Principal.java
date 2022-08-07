package visual;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.BolsaTrabajo;
import logico.Usuario;
import ficheros.UtilsFicheros;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;

	/**
	 * Create the frame.
	 */
	public Principal() {
		this.addWindowListener(UtilsFicheros.getWindowAdapterToSave());
		setTitle("Bolsa de Trabajo BJL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		// Ajustar el tamano de la ventana 
		dim = getToolkit().getScreenSize();		
		setSize(dim.width, dim.height-35);

		// Centrar en la pantalla ( va debajo del setSize() )
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Empresa");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Registrar Empresa");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegEmpresa regEmpresa = new RegEmpresa(null);
				regEmpresa.setModal(true);
				regEmpresa.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listar Empresa");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarEmpresas listarEmpresas = new ListarEmpresas();
				listarEmpresas.setModal(true);
				listarEmpresas.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_1 = new JMenu("Personal");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Registrar Personal");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegPersonal regPersonal = new RegPersonal(null);
				regPersonal.setModal(true);
				regPersonal.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Listar Personal");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);

		JMenu mnNewMenu_3 = new JMenu("Solicitud de Empresa");
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Registro de Solicitud de Empresa");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegSolEmpresa solEmpresa = new RegSolEmpresa(null, false);
				solEmpresa.setModal(true);
				solEmpresa.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_6);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Listado de Solicitudes de Empresa");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoSolicitudesEmpresa listadoSolicitudesEmpresa = new ListadoSolicitudesEmpresa(null);
				listadoSolicitudesEmpresa.setModal(true);
				listadoSolicitudesEmpresa.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_7);

		JMenuItem mntmContratacin = new JMenuItem("Contrataci\u00F3n");
		mntmContratacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManejoDeCandidatos manejoDeCandidatos = new ManejoDeCandidatos(null);
				manejoDeCandidatos.setModal(true);
				manejoDeCandidatos.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmContratacin);

		JMenu mnNewMenu_2 = new JMenu("Solicitud de Personal");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Registro de Solicitud de Personal");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegSolPersonal solPersonal = new RegSolPersonal(null);
				solPersonal.setModal(true);
				solPersonal.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Listado de Solicitudes de Personal");
		mnNewMenu_2.add(mntmNewMenuItem_5);

		JMenu mnNewMenu_4 = new JMenu("Reportes");
		menuBar.add(mnNewMenu_4);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Rep1: Cantidad de personas empleadas por tipo");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reporte1 reporte1 = new Reporte1();
				reporte1.setModal(true);
				reporte1.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_8);

		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Rep2: Cantidad de personas empleadas por sexo");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reporte2 reporte2 = new Reporte2();
				reporte2.setModal(true);
				reporte2.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_9);

		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Rep3: Cantidad de Solicitudes por sector");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reporte3 reporte3 = new Reporte3();
				reporte3.setModal(true);
				reporte3.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_10);

		Usuario userLogged = BolsaTrabajo.getInstance().getLoggedUsuario();

		JMenu mnAdmin = new JMenu("Administraci\u00f3n");
		if(userLogged == null)
			mnAdmin.setEnabled(true);
		else {
			mnAdmin.setEnabled(userLogged.esAdmin());
		}
		menuBar.add(mnAdmin);

		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Crear Usuario");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarUsuario agregarUsuario = new AgregarUsuario(null);
				agregarUsuario.setModal(true);
				agregarUsuario.setVisible(true);
			}
		});
		mnAdmin.add(mntmNewMenuItem_11);

		JMenuItem mntmListarUsuarios = new JMenuItem("Listar Usuarios");
		mntmListarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarUsuarios listarUsuarios = new ListarUsuarios();
				listarUsuarios.setModal(true);
				listarUsuarios.setVisible(true);
			}
		});
		mnAdmin.add(mntmListarUsuarios);

		JMenu cerrarSesion = new JMenu("Cerrar sesi\u00F3n");
		cerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				setVisible(false);
				login.setVisible(true);
			}
		});
		menuBar.add(cerrarSesion);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}

}
