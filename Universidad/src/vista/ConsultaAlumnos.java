package vista;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import modelo.Alumno;
import javax.swing.ListSelectionModel;

public class ConsultaAlumnos extends JDialog {

	private static final long serialVersionUID = 3L;
	private Principal principal;
	private JTable tblAlumnos;

	public ConsultaAlumnos(JFrame ventanaPrincipal) {
		this.principal = (Principal)ventanaPrincipal;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 556, 300);
		
		tblAlumnos = new JTable();
		tblAlumnos.setSurrendersFocusOnKeystroke(true);
		tblAlumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblAlumnos.setBorder(null);
		tblAlumnos.setColumnSelectionAllowed(true);
		tblAlumnos.setFillsViewportHeight(true);
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Apellido");
		modelo.addColumn("Nombres");
		modelo.addColumn("DNI");
		modelo.addColumn("Legajo");
		modelo.addColumn("Carrera");
		ArrayList <Alumno> alumnos = this.principal.getUniversidad().getAlumnos();
		Iterator<Alumno> iterator = alumnos.iterator();
		while(iterator.hasNext()) {
		    Alumno alumno = iterator.next();
		    Object fila[] = new Object[5];
		    fila[0] = alumno.getApellido();
		    fila[1] = alumno.getNombre();
		    fila[2] = alumno.getDni();
		    fila[3] = alumno.getLegajo();
		    fila[4] = alumno.getCarrera().getNombre();
		    modelo.addRow(fila);
		}
		tblAlumnos.setModel(modelo);
		JTableHeader header = tblAlumnos.getTableHeader();
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(tblAlumnos);
		getContentPane().add(header, BorderLayout.NORTH);
		getContentPane().add(tblAlumnos, BorderLayout.CENTER);
	}
}
