package bugsbusters.lucatickets.eventos.adapter;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

import bugsbusters.lucatickets.eventos.model.Evento;
import bugsbusters.lucatickets.eventos.model.response.EventoResponse;

@Component
public class EventoAdapter {
	
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
	
	public List<EventoResponse> de(List<Evento> eventos) {
		return eventos
				.stream()
				.map(e -> de(e))
				.collect(Collectors.toList());
	}
}
