package bugsbusters.lucatickets.pagos.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuario", url = "http://localhost:7777")
public interface UsuarioFeignClient {
	@GetMapping("usuarios/{id}")
	public UsuarioResponse getEvento(@PathVariable Long id);
}
