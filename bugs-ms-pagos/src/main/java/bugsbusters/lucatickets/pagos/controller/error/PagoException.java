package bugsbusters.lucatickets.pagos.controller.error;

public class PagoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public PagoException() {
		super("Error no esperado, #seguimosSiendoLechones");
	}
	
	public PagoException(String error) {
		super(error);
//		switch(error.substring(0, 8)) {
//		case "400.0001": super("");
//				break;
//		default:;
		}
	
	public PagoException(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}	
}
