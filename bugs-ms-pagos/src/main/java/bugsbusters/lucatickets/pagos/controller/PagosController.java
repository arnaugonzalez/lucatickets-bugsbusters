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
	"pago" })
	@ApiResponse(responseCode = "200.0001", description = "Transacción correcta")
	@ApiResponse(responseCode = "400.0001", description = "No hay fondos suficientes en la cuenta")
	@ApiResponse(responseCode = "400.0002", description = "No se encuentran los datos del cliente")
	@ApiResponse(responseCode = "400.0003", description = "El número de la tarjeta no es válido")
	@ApiResponse(responseCode = "400.0004", description = "El formato del cvv no es válido")
	@ApiResponse(responseCode = "400.0005", description = "El mes (caducidad) no es correcto")
	@ApiResponse(responseCode = "400.0006", description = "El año (caducidad) no es correcto")
	@ApiResponse(responseCode = "400.0007", description = "La fecha de caducidad debe ser posterior al día actual")
	@ApiResponse(responseCode = "400.0008", description = "El formato del nombre no es correcto")
	@ApiResponse(responseCode = "500.0001", description = "El sistema se encuentra inestable")
	@PostMapping("/{idUsuario}/pagar")
	public ResultadoCompra pagarEvento(@PathVariable Long idUsuario,
										@RequestParam Long idEvento,
										@RequestParam(defaultValue = "1") Integer cantidad,
										@RequestBody Tarjeta tarjeta) {
		
		return service.pagarEvento(idUsuario, idEvento, cantidad, tarjeta);
	}
}
