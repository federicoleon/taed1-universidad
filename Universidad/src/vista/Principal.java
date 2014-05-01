package vista;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import modelo.Universidad;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	final JFrame principal;
	
	private Universidad universidad;
	
	/**
	 * Create the frame.
	 */
	public Principal() {
		this.principal = this;
		this.universidad = new Universidad();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu MainMenu = new JMenu("Alumnos");
		menuBar.add(MainMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Nuevo alumno");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				NuevoAlumno nuevoAlumno = new NuevoAlumno(principal);
				nuevoAlumno.setLocationRelativeTo(null);
				nuevoAlumno.setVisible(true);
			}
		});
		MainMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmConsultaAlumnos = new JMenuItem("Consulta alumnos");
		mntmConsultaAlumnos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ConsultaAlumnos consultaAlumnos = new ConsultaAlumnos(principal);
				consultaAlumnos.setLocationRelativeTo(null);
				consultaAlumnos.setVisible(true);
			}
		});
		MainMenu.add(mntmConsultaAlumnos);
		
		JMenu mnMaterias = new JMenu("Materias");
		menuBar.add(mnMaterias);
		
		JMenuItem mntmMateriasPorAlumno = new JMenuItem("Materias por alumno");
		mntmMateriasPorAlumno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MateriasXAlumno materias = new MateriasXAlumno(principal);
				materias.setLocationRelativeTo(null);
				materias.setVisible(true);
			}
		});
		mnMaterias.add(mntmMateriasPorAlumno);
		
		JMenu mnSesinActual = new JMenu("Sesi\u00F3n actual");
		menuBar.add(mnSesinActual);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnSesinActual.add(mntmSalir);
	}
	
	public Universidad getUniversidad() {
		return this.universidad;
	}
}