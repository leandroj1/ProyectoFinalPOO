package visual;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Bolsa de Trabajo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 443);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Personal");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registro de personal");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmListado = new JMenuItem("Listado");
		mnNewMenu.add(mntmListado);
		
		JMenu mnEmpresas = new JMenu("Empresas");
		menuBar.add(mnEmpresas);
		
		JMenuItem mntmRegistroDeEmpresas = new JMenuItem("Registro de empresas");
		mnEmpresas.add(mntmRegistroDeEmpresas);
		
		JMenuItem mntmListadoDeEmpresas = new JMenuItem("Listado de empresas");
		mnEmpresas.add(mntmListadoDeEmpresas);
		
		JMenu mnSolicitudes = new JMenu("Solicitudes");
		menuBar.add(mnSolicitudes);
		
		JMenuItem mntmSolicitarTrabajo = new JMenuItem("Solicitar trabajo");
		mnSolicitudes.add(mntmSolicitarTrabajo);
		
		JMenuItem mntmSolicitarTrabajadores = new JMenuItem("Solicitar trabajadores");
		mnSolicitudes.add(mntmSolicitarTrabajadores);
		
		JMenuItem mntmListado_1 = new JMenuItem("Listado de solicitudes de trabajo");
		mnSolicitudes.add(mntmListado_1);
		
		JMenuItem mntmListadoDeSolicitudes = new JMenuItem("Listado de solicitudes de trabajores");
		mnSolicitudes.add(mntmListadoDeSolicitudes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
