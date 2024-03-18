package bugsbusters.lucatickets.pagos.controller.error;

public class UsuarioNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public UsuarioNotFoundException() {
		super("No existe el usuario");
	}
	public UsuarioNotFoundException(Long id) {
		super("No existe el usuario con ID: "+ id);
	}	
}
