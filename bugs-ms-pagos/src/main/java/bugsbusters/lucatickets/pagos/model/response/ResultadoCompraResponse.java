package bugsbusters.lucatickets.pagos.model.response;

import bugsbusters.lucatickets.pagos.model.Compra;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ResultadoCompraResponse
 * Clase  de el response del resultado de las compras
 * 18/03/2024
 * V1
 * BugsBusters
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ResultadoCompraResponse {
	
	//id de la compra
	private long idCompra;
	
	//id del usuario
	private long idUsuario;
	
	//id del evento
	private long idEvento;
	
	//codigo de la compra
	private String codigo;
	
	//mensaje de la compra
	private String mensaje;
	
	//la compra
	private Compra compra;
    
	
}
