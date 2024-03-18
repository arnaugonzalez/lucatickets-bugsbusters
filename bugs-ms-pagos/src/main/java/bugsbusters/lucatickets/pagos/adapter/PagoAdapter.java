package bugsbusters.lucatickets.pagos.adapter;

import org.springframework.stereotype.Component;

import bugsbusters.lucatickets.pagos.model.Pago;
import bugsbusters.lucatickets.pagos.model.Tarjeta;

@Component
public class PagoAdapter {

	    public Pago crearPago(String emisor, String concepto, double cantidad, Tarjeta tarjeta) {
	        Pago pagoDTO = new Pago();
	        pagoDTO.setEmisor(emisor);
	        pagoDTO.setConcepto(concepto);
	        pagoDTO.setCantidad(cantidad);
	        pagoDTO.setNombreTitular(tarjeta.getNombreTitular());
	        pagoDTO.setNumeroTarjeta(tarjeta.getNumeroTarjeta());
	        pagoDTO.setMesCaducidad(tarjeta.getMesCaducidad());
	        pagoDTO.setYearCaducidad(tarjeta.getYearCaducidad());
	        pagoDTO.setCvv(tarjeta.getCvv());
	        return pagoDTO;
	    }
}
