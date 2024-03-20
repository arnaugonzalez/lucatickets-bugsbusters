package bugsbusters.lucatickets.eventos.service;

import java.util.List;
import java.util.Optional;

//import org.springframework.stereotype.Service;

import bugsbusters.lucatickets.eventos.model.Evento;

/**
 * EventosService
 * Es la interfaz service para pasar las métodos de la aplicación
 * 14/03/2024
 * V1
 * bugs-ms-eventos
 */
public interface EventosService {
	
	/**
	 * Método para mostrar la lista de eventos guardados en la base de datos
	 * @return la lista de eventos
	 */
	List<Evento> listadoEventos();
	
	/**
	 * Método para encontrar un evento en la base de datos por un ID
	 * @param id ID para buscar el Evento
	 * @return Evento añadido si existe, sino es un Optional.EMPTY
	 */
	
	Optional<Evento> dameEventoPorId(long id);
	
	/**
	 * Recupera una lista de eventos que coincidan con el nombre especificado.
	 *
	 * @param nombre El nombre a buscar para filtrar los eventos.
	 * @return Una lista de eventos cuyos nombres coinciden con el proporcionado.
	 */
	List<Evento> listadoEventosPorNombre(String nombre);
	
	/**
	 * Método para añadir un evento en la base de datos
	 * @param Evento a añadir
	 * @return Evento añadido
	 */
	public Evento anadirEvento(Evento evento);
	
	/**
	 * Método para filtrar la lista de eventos por género de música
	 * @param musica El string música para filtrar por género
	 * @return La lista de eventos filtrados por género
	 */
	public List<Evento> listadoEventosPorMusica(String musica);
	
	/**
	 * Método para filtrar la lista de evento por ciudad de la sala
	 * @param ciudad String por el que queremos filtrar
	 * @return La lista de eventos filtrados por ciudad
	 */
	public List<Evento> listadoEventosPorCiudad(String ciudad);
}
