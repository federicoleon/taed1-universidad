package servicios;

public class LoginService {
	
	private UsuarioService usuarioService;
	
	public LoginService() {
		this.usuarioService = new UsuarioService();
	}
	
	public boolean validarUsuario(int dni, String password) {
		return usuarioService.validarExistenciaUsuario(dni, password);
	}
}