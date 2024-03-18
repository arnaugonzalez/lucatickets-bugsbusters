package bugsbusters.lucatickets.pagos.adapter;

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
		resultado.setCodigo(resultadoPagoResponse.getStatus());
		resultado.setMensaje(resultadoPagoResponse.getMessage());

		return resultado;

	}
}
