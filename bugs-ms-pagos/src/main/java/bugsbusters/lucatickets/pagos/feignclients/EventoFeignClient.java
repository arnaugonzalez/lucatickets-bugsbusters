package bugsbusters.lucatickets.pagos.feignclients;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import bugsbusters.lucatickets.pagos.model.response.EventoResponse;

/**
 * Feign client para llamar directamente a la lista de eventos
 */
@FeignClient(name = "evento", url = "http://localhost:6666")
public interface EventoFeignClient {
	/**
	 * Devuelve un evento en base a su id
	 * 
	 * @param id: id del evento que queremos encontrar
	 * @return: evento en base a su id
	 */
	@GetMapping("eventos/{id}")
	public EventoResponse getEvento(@PathVariable Long id);
}
