package bugsbusters.lucatickets.eventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bugsbusters.lucatickets.eventos.adapter.EventoAdapter;
import bugsbusters.lucatickets.eventos.model.Evento;
import bugsbusters.lucatickets.eventos.service.EventosService;
import bugsbusters.lucatickets.eventos.model.response.EventoResponse;

@RestController
@ComponentScan(basePackages = {"bugsbusters.lucatickets"})
@RequestMapping("/eventos")
public class EventosController {
	
	
	@Autowired
	private EventosService servicio;
	
	@Autowired
	private EventoAdapter adaptador;
	
	@GetMapping("/listado") //Devolver la lista de eventos desde el administrador
	public List<EventoResponse> listadoEventos() {
		final List<Evento> eventos = servicio.listadoEventos();
		return adaptador.de(eventos);
	}
	@PostMapping("/nuevo") //Crear un nuevo evento en la BBDD
	public EventoResponse anadirEvento(@RequestBody Evento evento){
		final Evento eventoDevuelto = servicio.anadirEvento(evento);
		return adaptador.de(eventoDevuelto);
	}
}
