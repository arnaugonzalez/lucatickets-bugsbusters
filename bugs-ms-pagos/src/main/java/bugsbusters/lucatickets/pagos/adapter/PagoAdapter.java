package bugsbusters.lucatickets.pagos.adapter;

import org.springframework.stereotype.Component;

import bugsbusters.lucatickets.pagos.model.Pago;
import bugsbusters.lucatickets.pagos.model.Tarjeta;

/**
 * Clase que proporciona métodos para adaptar objetos de tarjeta a objetos de
 * pago.
 */
@Component
public class PagoAdapter {

	/**
	 * Crea un objeto de pago a partir de la información proporcionada.
	 *
	 * @param emisor   El emisor de la tarjeta.
	 * @param concepto El concepto o motivo del pago.
	 * @param cantidad La cantidad a pagar.
	 * @param tarjeta  El objeto de tarjeta con los detalles de la tarjeta de
	 *                 crédito.
	 * @return Objeto de pago creado a partir de los parámetros proporcionados.
	 */
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
