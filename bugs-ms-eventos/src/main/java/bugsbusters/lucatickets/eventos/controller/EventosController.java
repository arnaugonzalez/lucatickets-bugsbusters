package bugsbusters.lucatickets.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bugsbusters.lucatickets.eventos.repository.EventosRepository;

@RestController
@RequestMapping("/eventos")
public class EventosController {
	@Autowired
	private EventosService servicio;
	
	@Autowired
	private EventoResponse adaptador;
	
	@GetMapping() //Devolver la lista de eventos desde el administrador
	public List<EventoResponse> listadoEventos() {
		final List<Evento> eventos = servicio.listadoEventos();
		return adaptador.eventoADto(eventos);
	}
}
