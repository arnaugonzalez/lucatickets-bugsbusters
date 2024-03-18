package bugsbusters.lucatickets.pagos.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import bugsbusters.lucatickets.pagos.model.response.UsuarioResponse;

/**
 * Feign client para llamar directamente a la lista de usuarios
 */
@FeignClient(name = "usuario", url = "http://localhost:7777")
public interface UsuarioFeignClient {
	/**
	 * Devuelve un usuario en base a su id
	 * 
	 * @param id: id del usuario que queremos encontrar
	 * @return: usuario en base a su id
	 */
	@GetMapping("usuarios/{id}")
	public UsuarioResponse getEvento(@PathVariable Long id);
}
