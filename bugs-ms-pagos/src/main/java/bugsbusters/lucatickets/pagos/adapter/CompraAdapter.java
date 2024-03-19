package bugsbusters.lucatickets.pagos.adapter;

import org.springframework.stereotype.Component;

import bugsbusters.lucatickets.pagos.model.Compra;
import bugsbusters.lucatickets.pagos.model.response.EventoResponse;
import bugsbusters.lucatickets.pagos.model.response.UsuarioResponse;

@Component

/**
 * Clase que proporciona métodos para adaptar objetos de usuario y evento a
 * objetos de compra.
 */
public class CompraAdapter {

	/**
	 * Convierte objetos de usuario, evento, cantidad y precio en un objeto de
	 * compra.
	 *
	 * @param usuario  Objeto de respuesta del usuario.
	 * @param evento   Objeto de respuesta del evento.
	 * @param cantidad La cantidad de entradas compradas.
	 * @param precio   El precio total de la compra.
	 * @return Objeto de compra generado a partir de los parámetros proporcionados.
	 */
	public Compra de(UsuarioResponse usuario, EventoResponse evento, Integer cantidad, double precio) {

		Compra compraDTO = new Compra();
		compraDTO.setId_usuario(usuario.getId());
		compraDTO.setId_evento(evento.getId());
		compraDTO.setNombre_usuario(usuario.getNombre() + " " + usuario.getApellido());
		compraDTO.setNombre_evento(evento.getNombre());
		compraDTO.setPrecio(precio);
		compraDTO.setCantidad(cantidad);

		return compraDTO;
	}
}
