package vista;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.WindowConstants;

import modelo.Alumno;
import modelo.Carrera;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import utils.Validaciones;

import carreras.IngenieriaEnSoftware;
import enums.Carreras;
import excepciones.ExcepcionStringANumero;

public class NuevoAlumno extends JDialog {

	private static final long serialVersionUID = 2L;

	private Principal principal;
	
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtDni;
	private JLabel lblMensajes;
	private JComboBox lstCarrera;
	
	
	public NuevoAlumno(JFrame principal) {
		this.principal = (Principal)principal;
		
		setResizable(false);
		setTitle("Nuevo alumno");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 340, 292);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Apellido: *");
		lblNewLabel.setBounds(22, 26, 89, 16);
		getContentPane().add(lblNewLabel);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(123, 20, 202, 28);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombres: *");
		lblNombre.setBounds(22, 66, 89, 16);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(123, 60, 202, 28);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Documento: *");
		lblNewLabel_1.setBounds(22, 110, 89, 16);
		getContentPane().add(lblNewLabel_1);
		
		txtDni = new JTextField();
		txtDni.setBounds(123, 104, 202, 28);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		this.getRootPane().setDefaultButton(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				crearAlumno();
			}
		});
		btnAceptar.setBounds(22, 199, 117, 29);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(208, 199, 117, 29);
		getContentPane().add(btnCancelar);
		
		lblMensajes = new JLabel("* Todos los campos son obligatorios.");
		lblMensajes.setBounds(32, 240, 285, 16);
		getContentPane().add(lblMensajes);
		
		lstCarrera = new JComboBox();
		lstCarrera.setModel(new DefaultComboBoxModel(this.principal.getUniversidad().getListadoCarreras()));
		lstCarrera.setBounds(95, 151, 230, 27);
		getContentPane().add(lstCarrera);
		
		JLabel lblCarrera = new JLabel("Carrera:");
		lblCarrera.setBounds(22, 155, 61, 16);
		getContentPane().add(lblCarrera);
	}
	
	private void crearAlumno() {
		String apellido = this.txtApellido.getText().trim();
		String nombres = this.txtNombre.getText().trim();
		String dniAux = this.txtDni.getText().trim();
		Carreras carrera = (Carreras)this.lstCarrera.getSelectedItem();
		if(apellido.length() == 0) {
			this.lblMensajes.setText("Ingrese el apellido del alumno.");
			this.txtApellido.requestFocus();
		}else if(nombres.length() == 0) {
			this.lblMensajes.setText("Ingrese el nombre del alumno.");
			this.txtNombre.requestFocus();
		}else if(dniAux.length() == 0) {
			this.lblMensajes.setText("Ingrese el documento del alumno.");
			this.txtDni.requestFocus();
		}else{
			try {
				int dni = Validaciones.convertirANumero(dniAux);
				Alumno alumno = new Alumno(apellido, nombres, dni);
				alumno.setLegajo(String.valueOf(dni));
				switch(carrera.getId()) {
					case 1:
						Carrera aux = new IngenieriaEnSoftware();
						alumno.setCarrera(aux);
					break;
				}
				if(principal.getUniversidad().agregarAlumno(alumno) == null) {
					this.lblMensajes.setText("El documento ingresado ya existe.");
				}else{
					this.dispose();
				}
			}catch(ExcepcionStringANumero e) {
				this.lblMensajes.setText("El documento del alumno debe ser numérico.");
				this.txtDni.requestFocus();
			}catch(Exception e) {}
		}
	}
}
