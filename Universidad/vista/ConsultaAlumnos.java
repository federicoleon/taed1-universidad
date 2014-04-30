package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Alumno;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaAlumnos extends JDialog {

	private static final long serialVersionUID = -3785736010532024967L;
	private final JPanel contentPanel = new JPanel();
	private Principal principal;
	private JPanel panel = new JPanel();
	private JTable table;

	public ConsultaAlumnos(JFrame principal) {
		this.principal = (Principal)principal;
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 39, 438, 233);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"Apellidos", "Nombres", "DNI", "Legajo", "Carrera"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(362, 6, 82, 29);
		panel.add(btnCerrar);
		
		JLabel lblPuedeEncontrarEl = new JLabel("Puede encontrar el listado completo de alumnos.");
		lblPuedeEncontrarEl.setBounds(6, 11, 344, 16);
		panel.add(lblPuedeEncontrarEl);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.cargarAlumnos();
	}
	
	private void cargarAlumnos() {
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
		table.setModel(modelo);
	}
}
