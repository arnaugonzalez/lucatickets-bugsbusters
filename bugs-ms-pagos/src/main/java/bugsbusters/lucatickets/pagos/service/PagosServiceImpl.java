package bugsbusters.lucatickets.pagos.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bugsbusters.lucatickets.pagos.adapter.CompraAdapter;
import bugsbusters.lucatickets.pagos.adapter.PagoAdapter;
import bugsbusters.lucatickets.pagos.adapter.ResultadoCompraAdapter;
import bugsbusters.lucatickets.pagos.controller.error.EventoNotFoundException;
import bugsbusters.lucatickets.pagos.controller.PagosController;
import bugsbusters.lucatickets.pagos.controller.error.UsuarioNotFoundException;
import bugsbusters.lucatickets.pagos.feignclients.EventoFeignClient;
import bugsbusters.lucatickets.pagos.feignclients.PasarelaFeignClient;
import bugsbusters.lucatickets.pagos.feignclients.UsuarioFeignClient;
import bugsbusters.lucatickets.pagos.model.Compra;
import bugsbusters.lucatickets.pagos.model.Credenciales;
import bugsbusters.lucatickets.pagos.model.Pago;
import bugsbusters.lucatickets.pagos.model.Tarjeta;
import bugsbusters.lucatickets.pagos.model.response.EventoResponse;
import bugsbusters.lucatickets.pagos.model.response.ResultadoCompraResponse;
import bugsbusters.lucatickets.pagos.model.response.ResultadoPagoResponse;
import bugsbusters.lucatickets.pagos.model.response.UsuarioResponse;
import bugsbusters.lucatickets.pagos.repository.PagosRepository;
import feign.FeignException;

/**
 * @author arnau gonzález
 * 
 * @EventosServiceImpl
 * 
 * Es la implementación de la interfaz {@code PagosService}
 * 
 * 20/03/2024
 * V1
 * bugs-ms-pagos
 */

@Service
public class PagosServiceImpl implements PagosService {

	private static final Logger logger = LoggerFactory.getLogger(PagosController.class);
	
	@Autowired
	EventoFeignClient eventoClient;
	
	@Autowired
	UsuarioFeignClient usuarioClient;
	
	@Autowired
	PasarelaFeignClient pasarelaClient;
	
	@Autowired
	PagoAdapter pagoAdapter;
	
	@Autowired
	CompraAdapter compraAdapter;
	
	@Autowired
	ResultadoCompraAdapter resultadoCompraAdapter;
	
	@Autowired
	PagosRepository repo;
	
	/**
	 * Método para recuperar un @code Evento y un @code Usuario a través 
	 * del @code EventoFeignClient y el @code UsuarioFeignClient para validar un 
	 * token con @code PasarelaFeignClient y guardarlo en @code ComprasRepository
	 * 
	 * @param usuarioId: id del usuario que paga
	 * @param eventoId: id del evento a pagar
	 * @param cantidad: numero de entradas a comprar
	 * @param tarjeta: @code Tarjeta que validará los datos de la compra
	 * 
	 * @return: ResultadoCompraResponse que contiene el resultado de la compra satisfactoria
	 * 
	 * @exception UsuarioNotFoundException: no se encuentra el usuario con el @param usuarioId
	 * @exception EventoNotFoundException: no se encuentra el evento con el @param eventoId
	 * @exception FeignException: para controlar que la validación no sea correcta
	 */
	
	@Override
	public ResultadoCompraResponse pagarEvento(Long usuarioId, Long eventoId, Integer cantidad, Tarjeta tarjeta) {
		
		UsuarioResponse usuario = null;
		try {
			usuario = usuarioClient.getUsuario(usuarioId);
		} catch (FeignException.NotFound ex) {
			throw new UsuarioNotFoundException(usuarioId);
		}
		
		EventoResponse evento = null;
		try {
			evento = eventoClient.getEvento(eventoId);
		} catch (FeignException.NotFound ex) {
			throw new EventoNotFoundException(eventoId);
		}
		
		double importe = evento.getPrecio() * cantidad;
		Pago pago = pagoAdapter.crearPago(
				"LucaTickets",
				"Compra entradas " + usuario.getNombre() + " " + usuario.getApellido(),
				importe,
				tarjeta);
		
		Credenciales creds = null;
		try {
			creds = pasarelaClient.validarUser(
							"Grupo03", //user
							"AntoniosRules"); //password
		} catch (FeignException ex) {
			throw ex;
		}
		
		ResultadoPagoResponse resultadoPago = null;
		try {
			resultadoPago = pasarelaClient.datosValidacionToken(creds.getToken(), pago);
		} catch (FeignException ex) {
			throw ex;
		}
					
		Compra compra = compraAdapter.de(
					usuario, evento,
					cantidad, importe);
		if(resultadoPago.getStatus().equals("200")) {
			repo.save(compra);			
		}
		return resultadoCompraAdapter
						.crearResultadoCompra(
								resultadoPago,
								compra);
	}
	
}
