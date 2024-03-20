package bugsbusters.lucatickets.eventos.controller.error;

public class EventoNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public EventoNotFoundException() {
		super("No existe el evento");
	}
	public EventoNotFoundException(Long id) {
		super("No existe el evento con ID: "+ id);
	}	
	public EventoNotFoundException(String nombre) {
		super("No existe el evento con ID: "+ nombre);
	}	
}
