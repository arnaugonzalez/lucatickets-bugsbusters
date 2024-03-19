package bugsbusters.lucatickets.pagos.service;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

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
import bugsbusters.lucatickets.pagos.model.Pago;
import bugsbusters.lucatickets.pagos.model.Tarjeta;
import bugsbusters.lucatickets.pagos.model.response.EventoResponse;
import bugsbusters.lucatickets.pagos.model.response.ResultadoCompraResponse;
import bugsbusters.lucatickets.pagos.model.response.ResultadoPagoResponse;
import bugsbusters.lucatickets.pagos.model.response.UsuarioResponse;
import bugsbusters.lucatickets.pagos.repository.PagosRepository;
import feign.FeignException;

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
	
	/*
	 * Método para 
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
						"Compra entradas",
						importe,
						tarjeta);
		
		ResultadoPagoResponse resultadoPago = null;
		try {
			resultadoPago = pasarelaClient.datosValidacion(pago);
		} catch (FeignException ex) {
			throw ex;
		}
			
		
		
//		ResultadoCompraResponse resultadoCompra;
		
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
	
	//ayuda ChatGPT
	public String parseaError(Optional<ByteBuffer> byteBuffer) {
        
		if(byteBuffer.isEmpty())
			return "Error de Lechón: Valor vacío";
		else {
			ByteBuffer bytes = byteBuffer.get();
			// Decode ByteBuffer to a string
			String responseBody = StandardCharsets.UTF_8.decode(bytes).toString();

			// Split the string by the delimiter
			String[] values = responseBody.split("\n");

			return values[2];
		}
		
    }
	
}
