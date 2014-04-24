package vista;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import enums.Carreras;
import javax.swing.JTable;
import carreras.IngenieriaEnSoftware;
import modelo.Carrera;
import modelo.Materia;

public class MateriasXCarrera extends JDialog {
	
	private static final long serialVersionUID = 4L;
	private Principal principal;
	private JComboBox lstCarrera;
	private JTable tblMaterias;
	
	public MateriasXCarrera(JFrame ventanaPrincipal) {
		this.principal = (Principal)ventanaPrincipal;
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		{
			lstCarrera = new JComboBox();
			lstCarrera.setModel(new DefaultComboBoxModel(this.principal.getUniversidad().getListadoCarreras()));
			getContentPane().add(lstCarrera, BorderLayout.NORTH);
		}
		
		tblMaterias = new JTable();
		tblMaterias.setSurrendersFocusOnKeystroke(true);
		tblMaterias.setFillsViewportHeight(true);
		tblMaterias.setColumnSelectionAllowed(true);
		tblMaterias.setCellSelectionEnabled(true);
		getContentPane().add(tblMaterias, BorderLayout.SOUTH);
		DefaultTableModel modelo = this.generarDatosTablaMaterias();
		tblMaterias.setModel(modelo);
		JTableHeader header = tblMaterias.getTableHeader();
		getContentPane().add(header, BorderLayout.CENTER);
		((DefaultTableModel) tblMaterias.getModel()).fireTableDataChanged();
	}
	
	private DefaultTableModel generarDatosTablaMaterias() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Nombre");
		modelo.addColumn("A–o");
		modelo.addColumn("Semestre");
		Carreras aux = (Carreras)lstCarrera.getSelectedItem();
		Carrera carrera = null;
		switch(aux.getId()) {
			case 1:
				carrera = new IngenieriaEnSoftware();
			break;
		}
		if(carrera != null) {
			for (int i=0; i<carrera.getMaterias().size(); i++) {
			    Materia materia = carrera.getMaterias().get(i+1);
			    Object fila[] = new Object[4];
			    fila[0] = materia.getId();
			    fila[1] = materia.getNombre();
			    fila[2] = materia.getAnioDictado();
			    fila[3] = materia.getSemestreDictado();
			    modelo.addRow(fila);
			}
		}
		return modelo;
	}
}
