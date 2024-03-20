package bugsbusters.lucatickets.eventos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bugsbusters.lucatickets.eventos.adapter.EventoAdapter;
import bugsbusters.lucatickets.eventos.controller.error.EventoNotFoundException;
import bugsbusters.lucatickets.eventos.controller.error.GeneroNotFoundException;
import bugsbusters.lucatickets.eventos.model.Evento;
import bugsbusters.lucatickets.eventos.service.EventosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import bugsbusters.lucatickets.eventos.model.response.EventoResponse;

/**
 * Controlador para la gestión de eventos en la aplicación LucaTickets.
 * <p>
 * Este controlador proporciona puntos finales para listar eventos y añadir
 * nuevos eventos.
 * </p>
 */

@RestController
@ComponentScan(basePackages = { "bugsbusters.lucatickets" })
@RequestMapping("/eventos")
@Tag(name = "evento", description = "LucaTickets API")
public class EventosController {

	@Autowired
	private EventosService servicio;

	@Autowired
	private EventoAdapter adaptador;

	/**
	 * Obtiene un listado de eventos desde la base de datos.
	 *
	 * @return Una lista de objetos EventoResponse que representan los eventos
	 *         cargados desde la base de datos.
	 */

	@Operation(summary = "Listar eventos", description = "Carga la lista de eventos de la base de datos", tags = {
			"evento" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista cargada", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Evento.class)) }),
			@ApiResponse(responseCode = "400", description = "No valido ", content = @Content),
			@ApiResponse(responseCode = "404", description = "No se ha encontrado la base de datos", content = @Content) })
	@GetMapping("/listado") // Devolver la lista de eventos desde el administrador
	public List<EventoResponse> listadoEventos() {
		final List<Evento> eventos = servicio.listadoEventos();
		return adaptador.de(eventos);
	}

	@Operation(summary = "BuscaEvento por ID", description = "Dado un ID, devuelve un objeto Evento", tags = {
			"evento" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Evento localizado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Evento.class)) }),
			@ApiResponse(responseCode = "404", description = "Evento no encontrado (NO implementado)", content = @Content) })
	@GetMapping("/{id}")
	public EventoResponse dameEventoPorId(
			@Parameter(description = "ID del evento a localizar", required = true) @PathVariable Long id) {
		Optional<Evento> respuesta = servicio.dameEventoPorId(id);
		if (respuesta.isPresent())
			return adaptador.de(respuesta.get());
		else
			throw new EventoNotFoundException(id);
	}

	/**
	 * Añade un nuevo evento a la base de datos.
	 *
	 * @param evento El objeto Evento que se va a añadir a la base de datos.
	 * @return Un objeto EventoResponse que representa el evento añadido a la base
	 *         de datos.
	 */

	@Operation(summary = "Añadir evento", description = "Añade un nuevo evento a la base de datos", tags = { "evento" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Evento añadido", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Evento.class)) }),
			@ApiResponse(responseCode = "400", description = "No valido ", content = @Content),
			@ApiResponse(responseCode = "404", description = "No se ha encontrado la base de datos", content = @Content) })
	@PostMapping("/nuevo") // Crear un nuevo evento en la BBDD
	public EventoResponse anadirEvento(@RequestBody Evento evento) {
		final Evento eventoDevuelto = servicio.anadirEvento(evento);
		return adaptador.de(eventoDevuelto);
	}

	/**
	 * Mustra una lista de eventos filtrada por género de música
	 * 
	 * @param musica El string música por el que se va a filtrar en la base de datos
	 * @return Una lista de objetos EventoResponse que representan los eventos
	 *         filtrados por género desde la base de datos.
	 */
	@GetMapping("/genero/{musica}")
	public List<EventoResponse> listadoEventosPorMusica(String musica) {
		final List<Evento> eventos = servicio.listadoEventosPorMusica(musica);

		if (eventos.size() > 0)
			return adaptador.de(eventos);
		else
			throw new GeneroNotFoundException(musica);

	}
}
