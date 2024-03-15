package bugsbusters.lucatickets.eventos.adapter;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

import bugsbusters.lucatickets.eventos.model.Evento;
import bugsbusters.lucatickets.eventos.model.response.EventoResponse;

/**
 * Clase que proporciona métodos para adaptar objetos de tipo Evento a objetos de tipo EventoResponse y viceversa.
 * <p>Esta clase es responsable de convertir objetos del modelo de datos a objetos DTO (Data Transfer Object) y viceversa.</p>
 */
@Component
public class EventoAdapter {
	
	/**
	 * Convierte un objeto de tipo Evento a un objeto de tipo EventoResponse.
	 *
	 * @param evento El objeto de tipo Evento que se va a convertir.
	 * @return Un objeto de tipo EventoResponse convertido desde el objeto de tipo Evento proporcionado.
	 */

	public EventoResponse de(Evento evento) {
		EventoResponse eventoDTO = new EventoResponse();
		eventoDTO.setNombre(evento.getNombre());
		eventoDTO.setDescripcion_corta(evento.getDescripcion_corta());
		eventoDTO.setDescripcion_extendida(evento.getDescripcion_extendida());
		eventoDTO.setFoto(evento.getFoto());
		eventoDTO.setFecha(evento.getFecha());
		eventoDTO.setHora(evento.getHora());
		eventoDTO.setPrecio(evento.getPrecio());
		eventoDTO.setNormas(evento.getNormas());
		eventoDTO.setSala(evento.getSala());
		eventoDTO.setCiudad(evento.getSala().getCiudad());
		return eventoDTO;
	}
	

	
	/**
	 * Convierte una lista de objetos de tipo Evento a una lista de objetos de tipo EventoResponse.
	 *
	 * @param eventos La lista de objetos de tipo Evento que se va a convertir.
	 * @return Una lista de objetos de tipo EventoResponse convertidos desde la lista de objetos de tipo Evento proporcionada.
	 */
	public List<EventoResponse> de(List<Evento> eventos) {
		return eventos
				.stream()
				.map(e -> de(e))
				.collect(Collectors.toList());
	}
}
