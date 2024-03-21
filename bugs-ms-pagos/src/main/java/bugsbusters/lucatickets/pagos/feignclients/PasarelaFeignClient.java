package bugsbusters.lucatickets.pagos.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import bugsbusters.lucatickets.pagos.model.Credenciales;
import bugsbusters.lucatickets.pagos.model.Pago;
import bugsbusters.lucatickets.pagos.model.response.ResultadoPagoResponse;

/**
 * Feign Client para controlar la validación de datos y devolverlos.
 * 
 * Para hacer la llamada, se necesita de un servidor de Amazon Web Service.
 */
@FeignClient(name = "pasarela", url = "http://banco-env.eba-ui2d2xf3.us-east-1.elasticbeanstalk.com/pasarela")
public interface PasarelaFeignClient {
	
	/**
	 * Endpoint que actúa como clave de acceso para obtener el token que validará
	 * la llamada datosValidacionToken(...)
	 * 
	 * @param credenciales: user y password para el body a enviar
	 * @return: String token de acceso 
	 */
	@PostMapping("/validaruser/")
	public String validarUser(@RequestBody Credenciales credenciales);
	
	
	/**
	 * Devuelve el resultado del pago una vez los datos del pago hayan sido validados
	 * 
	 * @param pago: Pago a realizar
	 * @return: devuelve la información del pago realizado
	 */
	@PostMapping("/validacion/")
	public ResultadoPagoResponse datosValidacionToken(
			@RequestHeader("Authorization") String token,
			@RequestBody Pago pago);
	
	
	/**
	 * Devuelve el resultado del pago una vez los datos del pago hayan sido validados
	 * 
	 * @param pago: Pago a realizar
	 * @return: devuelve la información del pago realizado
	 */
	@PostMapping("/compra")
	public ResultadoPagoResponse datosValidacion(@RequestBody Pago pago);
}
