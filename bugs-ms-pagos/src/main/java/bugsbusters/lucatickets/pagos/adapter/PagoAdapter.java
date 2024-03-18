package bugsbusters.lucatickets.pagos.adapter;

import bugsbusters.lucatickets.pagos.model.Pago;
import bugsbusters.lucatickets.pagos.model.Tarjeta;

public class PagoAdapter {

	    public static Pago crearPago(String emisor, String concepto, int cantidad, Tarjeta tarjeta) {
	        Pago pagoDTO = new Pago();
	        pagoDTO.setEmisor(emisor);
	        pagoDTO.setConcepto(concepto);
	        pagoDTO.setCantidad(cantidad);
	        pagoDTO.setNombreTitular(tarjeta.getNombreTitular());
	        pagoDTO.setNumeroTarjeta(tarjeta.getNumeroTarjeta());
	        pagoDTO.setMesCaducidad(tarjeta.getMesCaducidad());
	        pagoDTO.setAñoCaducidad(tarjeta.getAñoCaducidad());
	        pagoDTO.setCvv(tarjeta.getCvv());
	        return pagoDTO;
	    }
}
