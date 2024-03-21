package bugsbusters.lucatickets.pagos.controller.error;

public class TarjetaNoValidaException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public TarjetaNoValidaException() {
		super("Número de tarjeta no válido");
	}
	public TarjetaNoValidaException(String numeroTarjeta) {
		super("Número de tarjeta no válido"+ numeroTarjeta);
	}	

}
