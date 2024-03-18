package bugsbusters.lucatickets.pagos.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "evento", url = "http://localhost:6666")
public interface EventoFeignClient {
	@GetMapping("eventos/{id}")
	public EventoResponse getEvento(@PathVariable Long id);
}
