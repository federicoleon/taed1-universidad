package vista;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import modelo.Alumno;
import modelo.Materia;
import enums.EstadoMateria;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class MateriasXAlumno extends JDialog {

	private static final long serialVersionUID = -8478742341388148281L;
	private Principal principal;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTable table;
	private JComboBox comboALumno;
	private JLabel lblNombreCarrera;

	public MateriasXAlumno(JFrame principal) {
		this.principal = (Principal)principal;
		setBounds(100, 100, 570, 377);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			scrollPane = new JScrollPane();
		}
		
		JLabel lblCarrera = new JLabel("Carrera:");
		
		lblNombreCarrera = new JLabel("Alumno no seleccionado");
		
		JLabel lblAlumno = new JLabel("Alumno:");
		
		comboALumno = new JComboBox();
		comboALumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getMateriasPorAlumno();
			}
		});
		comboALumno.setModel(new DefaultComboBoxModel(new String[] {"[Seleccione el alumno]"}));
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblAlumno)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboALumno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
							.addComponent(btnCerrar))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblCarrera)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNombreCarrera, GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAlumno)
						.addComponent(comboALumno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCerrar))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCarrera)
						.addComponent(lblNombreCarrera))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		{
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"ID", "A\u00F1o", "Semestre", "Materia", "Estado Actual" 
				}
			));
			scrollPane.setViewportView(table);
		}
		contentPanel.setLayout(gl_contentPanel);
		this.inicializarAlumnos();
	}
	
	private void inicializarAlumnos() {
		DefaultComboBoxModel modelo = (DefaultComboBoxModel) this.comboALumno.getModel();
		ArrayList <Alumno> alumnos = this.principal.getUniversidad().getAlumnos();
		Iterator<Alumno> iterator = alumnos.iterator();
		while(iterator.hasNext()) {
		    AlumnoEnLista alumno = new AlumnoEnLista(iterator.next());
		    modelo.addElement(alumno);
		}
		this.comboALumno.setModel(modelo);
	}
	
	private void getMateriasPorAlumno() {
		AlumnoEnLista aux = (AlumnoEnLista)this.comboALumno.getSelectedItem();
		StringBuilder nombreCompleto = new StringBuilder(aux.getAlumno().getApellido().toUpperCase());
		nombreCompleto.append(", ");
		nombreCompleto.append(aux.getAlumno().getNombre().toUpperCase());
		this.lblNombreCarrera.setText(nombreCompleto.toString());
		Alumno alumno = this.principal.getUniversidad().getAlumno(aux.getAlumno().getIdAlumno());
		ArrayList<Materia> materias = alumno.getCarrera().getMaterias();
		DefaultTableModel modelo = new DefaultTableModel(
			new Object[][] {},
			new String[] {
					"ID", "A\u00F1o", "Semestre", "Materia", "Estado Actual" 
		});
		Iterator<Materia> iterador = materias.iterator();
		while(iterador.hasNext()) {
			Materia materia = iterador.next();
			Object[] fila = new Object[5];
			fila[0] = materia.getId();
			fila[1] = materia.getAnioDictado();
			fila[2] = materia.getSemestreDictado();
			fila[3] = materia.getNombre();
			fila[4] = EstadoMateria.getNombreEstado(materia.getEstado()).toUpperCase();
			modelo.addRow(fila);
		}
		this.table.setModel(modelo);
	}
	
	class AlumnoEnLista {
		private Alumno alumno;
		
		public AlumnoEnLista(Alumno alumno) {
			this.alumno = alumno;
		}
		
		public Alumno getAlumno() {
			return this.alumno;
		}
		
		public String toString() {
			return (this.alumno.getApellido().concat(", ").concat(this.alumno.getNombre())).toUpperCase();
		}
	}
}
