package bugsbusters.lucatickets.eventos.controller.error;

public class CiudadNotFoundException extends RuntimeException {
	public CiudadNotFoundException() {
		super("No existe el género");
	}
	public CiudadNotFoundException(String ciudad) {
		super("No existe el evento con ciudad: " + ciudad);
	}	
}
