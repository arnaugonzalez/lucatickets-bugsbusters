package bugsbusters.lucatickets.usuarios.controller.error;

public class FechaAltaPosteriorException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public FechaAltaPosteriorException() {
		super("La fecha es posterior al día de hoy.");
	}
	public FechaAltaPosteriorException(String fecha) {
		super("La fecha es posterior al día de hoy: " + fecha);
	}	
}
