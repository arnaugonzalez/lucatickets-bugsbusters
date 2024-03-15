package bugsbusters.lucatickets.eventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bugsbusters.lucatickets.eventos.model.Evento;
import bugsbusters.lucatickets.eventos.repository.EventosRepository;

/**
 * EventosServiceImpl
 * Es la implementación de la interfaz service para pasar las métodos de la aplicación
 * 14/03/2024
 * V1
 * bugs-ms-eventos
 */
@Service
public class EventosServiceImpl implements EventosService {
	
	@Autowired
	private EventosRepository repo;
	
	/**
	 * Método para mostrar la lista de eventos guardados en la base de datos
	 */
	@Override
	public List<Evento> listadoEventos() {
		return repo.findAll();
	}
	
	/**
	 * Método para añadir un evento en la base de datos
	 */
	@Override
	public Evento anadirEvento(Evento evento) {
		return repo.save(evento);

	}

}
