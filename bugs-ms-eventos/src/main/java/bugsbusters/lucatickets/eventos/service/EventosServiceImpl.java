package bugsbusters.lucatickets.eventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import bugsbusters.lucatickets.eventos.model.Evento;
import bugsbusters.lucatickets.eventos.repository.EventosRepository;

/**
 * EventosServiceImpl
 * Es la implementación de la interfaz service para pasar las métodos de la aplicación
 * 14/03/2024
 * V1
 * bugs-ms-eventos
 */
public class EventosServiceImpl implements EventosService{
	
	@Autowired
	private EventosRepository eventosRepository;
	
	/**
	 * Método para mostrar la lista de eventos guardados en la base de datos
	 */
	@Override
	public List<Evento> listadoEventos() {
		return eventosRepository.findAll();
	}
	
	/**
	 * Método para añadir un evento en la base de datos
	 */
	@Override
	public Evento anadirEvento(Evento evento) {
		Evento eventoGuardado = eventosRepository.save(evento);
		
		return eventoGuardado;
	}

}
