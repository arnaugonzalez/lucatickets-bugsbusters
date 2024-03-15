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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import bugsbusters.lucatickets.eventos.model.response.EventoResponse;

@RestController
@ComponentScan(basePackages = {"bugsbusters.lucatickets"})
@RequestMapping("/eventos")
@Tag(name = "evento", description = "LucaTickets API")
public class EventosController {
	
	
	@Autowired
	private EventosService servicio;
	
	@Autowired
	private EventoAdapter adaptador;
	
	@Operation(
			summary = "Listar eventos", description = "Carga la lista de eventos de la base de datos", tags= {"evento"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista cargada", content = {
							@Content(mediaType = "application/json", schema = @Schema(implementation = Evento.class))}),
			@ApiResponse(responseCode = "400", description = "No valido ", content = @Content),
			@ApiResponse(responseCode = "404", description = "No se ha encontrado la base de datos", content = @Content)})
	@GetMapping("/listado") //Devolver la lista de eventos desde el administrador
	public List<EventoResponse> listadoEventos() {
		final List<Evento> eventos = servicio.listadoEventos();
		return adaptador.de(eventos);
	}
	
	@Operation(
			summary = "Añadir evento", description = "Añade un nuevo evento a la base de datos", tags= {"evento"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Evento añadido", content = {
							@Content(mediaType = "application/json", schema = @Schema(implementation = Evento.class))}),
			@ApiResponse(responseCode = "400", description = "No valido ", content = @Content),
			@ApiResponse(responseCode = "404", description = "No se ha encontrado la base de datos", content = @Content)})
	@PostMapping("/nuevo") //Crear un nuevo evento en la BBDD
	public EventoResponse anadirEvento(@RequestBody Evento evento){
		final Evento eventoDevuelto = servicio.anadirEvento(evento);
		return adaptador.de(eventoDevuelto);
	}
}
