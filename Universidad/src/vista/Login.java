package vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;

import excepciones.ExcepcionStringANumero;

import servicios.LoginService;
import utils.Validaciones;

import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JDialog {
	private static final long serialVersionUID = 5L;
	private JTextField txtDocumento;
	private JPasswordField txtPassword;
	private JLabel lblMensajes;
	private LoginService loginService;
	private StringBuilder password;

	public Login() {
		this.loginService = new LoginService();
		setBounds(100, 100, 265, 176);
		
		JLabel lblDocumento = new JLabel("Documento:");
		
		txtDocumento = new JTextField();
		txtDocumento.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		
		txtPassword = new JPasswordField();
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				executeLogin();
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		lblMensajes = new JLabel("Ingrese la informaci\u00F3n solicitada.");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMensajes, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblDocumento)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtDocumento, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblContrasea)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtPassword))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnIngresar)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSalir))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDocumento)
						.addComponent(txtDocumento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContrasea)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIngresar)
						.addComponent(btnSalir))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMensajes)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	private void executeLogin() {
		this.password = new StringBuilder();
		int dni = 0;
		try {
			dni = Validaciones.convertirANumero(txtDocumento.getText().trim());
			char[] passwordAux = txtPassword.getPassword();
			for(int i=0; i<passwordAux.length; i++) {
				this.password.append(passwordAux[i]);
			}
			if(loginService.validarUsuario(dni, password.toString())) {
				Principal principal = new Principal();
				principal.setLocationRelativeTo(null);
				principal.setVisible(true);
				principal.setExtendedState(Frame.MAXIMIZED_BOTH);
				this.dispose();
			}else{
				lblMensajes.setText("Error: DNI o contrase–a incorrectos.");
			}
		} catch(ExcepcionStringANumero e) {
			lblMensajes.setText("Documento incorrecto!");
		}
	}
}
