package bugsbusters.lucatickets.eventos.controller.error;

public class CiudadNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CiudadNotFoundException() {
		super("No existe el género");
	}
	public CiudadNotFoundException(String ciudad) {
		super("No existe el evento con ciudad: " + ciudad);
	}	
}
