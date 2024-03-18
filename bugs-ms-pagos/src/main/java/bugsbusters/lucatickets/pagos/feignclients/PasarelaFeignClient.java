package bugsbusters.lucatickets.pagos.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import bugsbusters.lucatickets.pagos.model.Pago;
import bugsbusters.lucatickets.pagos.model.response.ResultadoPagoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * Feign Client para controlar la validación de datos y devolverlos.
 * 
 * Para hacer la llamada, se necesita de un servidor de Amazon Web Service.
 */
@FeignClient(name = "pasarela", url = "http://banco-env.eba-ui2d2xf3.us-east-1.elasticbeanstalk.com/pasarela")
public interface PasarelaFeignClient {
	
	/**
	 * Endpoint que actúa como clave de acceso para obtener el token de acceso
	 * 
	 * @return: Token con el usuario, contraseña y token de acceso
	 */
//	@PostMapping("/pasarela/validaruser?user=Grupo03&password=AntoniosRules")
	
//	public Token getToken();
	
	/**
	 * Devuelve el resultado del pago una vez los datos del pago hayan sido validados
	 * 
	 * @param pago: Pago a realizar
	 * @return: devuelve la información del pago realizado
	 */
	@PostMapping("/validacion")
	public ResultadoPagoResponse datosValidacion(@RequestBody Pago pago);
}
