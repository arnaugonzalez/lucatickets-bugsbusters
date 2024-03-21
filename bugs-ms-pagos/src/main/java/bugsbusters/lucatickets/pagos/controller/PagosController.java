package bugsbusters.lucatickets.pagos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bugsbusters.lucatickets.pagos.controller.error.TarjetaNoValidaException;
import bugsbusters.lucatickets.pagos.model.Tarjeta;
import bugsbusters.lucatickets.pagos.model.response.ResultadoCompraResponse;
import bugsbusters.lucatickets.pagos.service.PagosService;
import io.micrometer.common.util.StringUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * Controlador para la gestión de pagos.
 */
@RestController
@RequestMapping("/pago")
@Tag(name = "pago", description = "Controlador para la gestión de pagos")
public class PagosController {

	@Autowired
	PagosService service;

	/**
	 * Realiza la transacción para el pago del evento.
	 *
	 * @param idUsuario El ID del usuario que realiza el pago.
	 * @param idEvento  El ID del evento que se va a pagar.
	 * @param cantidad  La cantidad de entradas que se van a comprar.
	 * @param tarjeta   Objeto de tarjeta que contiene los detalles de la tarjeta de
	 *                  crédito.
	 * @return Objeto de respuesta que indica el resultado de la transacción de
	 *         pago.
	 */
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
	public ResultadoCompraResponse pagarEvento(@PathVariable Long idUsuario, @RequestParam Long idEvento,
			@RequestParam(defaultValue = "1") Integer cantidad, @RequestBody @Valid Tarjeta tarjeta) {
		if (!tarjeta.getNumeroTarjeta().matches("\\d{4}-\\d{4}-\\d{4}-\\d{4}")) {
	        throw new TarjetaNoValidaException(tarjeta.getNumeroTarjeta());
	    }
		else {
			return service.pagarEvento(idUsuario, idEvento, cantidad, tarjeta);
		}
		
	}
}
