package bugsbusters.lucatickets.eventos.controller.error;

/**
 * Clase excepción por si no encuentra el género
 */
public class GeneroNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public GeneroNotFoundException() {
		super("No existe el género");
	}
	public GeneroNotFoundException(String musica) {
		super("No existe el evento con género: "+ musica);
	}	

}
