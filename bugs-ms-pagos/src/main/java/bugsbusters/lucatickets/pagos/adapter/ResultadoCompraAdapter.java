package bugsbusters.lucatickets.pagos.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import bugsbusters.lucatickets.pagos.model.Compra;
import bugsbusters.lucatickets.pagos.model.response.ResultadoCompraResponse;
import bugsbusters.lucatickets.pagos.model.response.ResultadoPagoResponse;

/**
 * ResultadoCompraAdapter
 * Microservicio pagos
 * 18/03/2024
 * V1
 * BugsBusters
 */
@Component
public class ResultadoCompraAdapter {
	
	/**
	 * Este metodo 
	 * @param resultadoPagoResponse
	 * @param compra
	 * @return resultado ResultadoCompraResponse
	 */
	
	public ResultadoCompraResponse crearResultadoCompra(ResultadoPagoResponse resultadoPagoResponse, Compra compra) {
		ResultadoCompraResponse resultado = new ResultadoCompraResponse();
		resultado.setIdCompra(compra.getId_compra());
		resultado.setIdUsuario(compra.getId_usuario());
		resultado.setIdEvento(compra.getId_evento());
		
		//leer 8 caracteres message
		resultado.setCodigo(resultadoPagoResponse.getError()
				.substring(0, Math.min(resultadoPagoResponse.getError().length(), 8)));
		
//		List<String> mensajes = new ArrayList<String>();
//		int i = 0;
//		for(String m: resultadoPagoResponse.getMessage())
//			mensajes.add(m);
		resultado.setMensaje(resultadoPagoResponse.getError()
				.substring(10, resultadoPagoResponse.getError().length()));

		resultado.setCompra(compra);

		return resultado;

	}
}
