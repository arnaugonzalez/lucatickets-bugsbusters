package bugsbusters.lucatickets.pagos.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "pasarela", url = "blablabla")
public interface PasarelaFeignClient {
//	@PostMapping("/pasarela/validaruser?user=Grupo03&password=AntoniosRules")
//	public Token getToken();
	
	@PostMapping("/pasarela/validacion")
	public ResultadoPago datosValidacion(@RequestBody Pago pago);
}
