package bugsbusters.lucatickets.pagos.model.response;

import bugsbusters.lucatickets.pagos.model.Compra;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ResultadoCompraResponse
 * Microservicio pagos
 * 18/03/2024
 * V1
 * BugsBusters
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ResultadoCompraResponse {
	
	//
	private long idCompra;
	
	//
	private long idUsuario;
	
	//
	private long idEvento;
	
	//
	private String codigo;
	
	//
	private String mensaje;
	
	//
	private Compra compra;
    
	
}
