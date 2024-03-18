package bugsbusters.lucatickets.pagos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bugsbusters.lucatickets.pagos.model.Tarjeta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/pago")
@Tag(name = "pago", description = "Controlador para la gestión de pagos")
public class PagosController {
	
	@Autowired
	PagosService service;
	
	@Operation(summary = "Pagar evento", description = "Realiza la transacción para el pago del evento", tags = {
	"evento" })
	@ApiResponse(responseCode = "200", description = "Pago realizado")
	@ApiResponse(responseCode = "500", description = "El servidor no está disponible", content = @Content)
	@PostMapping("/{idUsuario}/pagar")
	public ResultadoCompra pagarEvento(@PathVariable Long idUsuario,
										@RequestParam Long idEvento,
										@RequestParam(defaultValue = "1") Integer cantidad,
										@RequestBody Tarjeta tarjeta) {
		
		return service.pagarEvento(idUsuario, idEvento, cantidad, tarjeta);
	}
}
