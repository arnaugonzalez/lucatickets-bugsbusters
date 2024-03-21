package bugsbusters.lucatickets.usuarios.controller.error;

public class UsuarioExistsException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public UsuarioExistsException() {
		super("Ya existe el usuario con ese email");
	}
	public UsuarioExistsException(String email) {
		super("Ya existe el usuario con email: "+ email);
	}	

}
