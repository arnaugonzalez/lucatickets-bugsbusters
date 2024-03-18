package bugsbusters.lucatickets.pagos.service;

import bugsbusters.lucatickets.pagos.model.Tarjeta;
import bugsbusters.lucatickets.pagos.model.response.ResultadoCompraResponse;

public interface PagosService {
	
	ResultadoCompraResponse pagarEvento(Long userId, Long eventoId, Integer cantidad, Tarjeta tarjeta);

}
