package bugsbusters.lucatickets.eventos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bugsbusters.lucatickets.eventos.model.Evento;

/**
 * EventosService
 * Es la interfaz service para pasar las métodos de la aplicación
 * 14/03/2024
 * V1
 * bugs-ms-eventos
 * @author Andrés
 */
public interface EventosService {
	
	/**
	 * Método para mostrar la lista de eventos guardados en la base de datos
	 * @return la lista de eventos
	 */
	List<Evento> listadoEventos();
	
	/**
	 * Método para añadir un evento en la base de datos
	 * @param evento Evento a añadir
	 * @return Evento añadido
	 */
	public Evento anadirEvento(Evento evento);

}
