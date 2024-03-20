package bugsbusters.lucatickets.eventos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bugsbusters.lucatickets.eventos.model.Evento;

/**
 * Interfaz de repositorio para la entidad Evento.
 * Esta interfaz proporciona métodos para interactuar con la base de datos para la entidad Evento, como guardar, actualizar, eliminar y buscar eventos.
 */

public interface EventosRepository extends JpaRepository<Evento, Long> {
	
	/**
	 * Método predefinido para filtrar la lista de eventos por género de música
	 * @return La lista de eventos filtrados por género
	 */
	List<Evento> findByMusica(String musica);
	
	/**
	 * Método con una query personalizada para devolver los eventos filtrados por ciudad
	 * @param ciudad String por el que queremos buscar
	 * @return Lista de eventos filtrados por ciudad
	 */
	@Query("SELECT e FROM Evento e JOIN e.sala s WHERE s.ciudad = :ciudad")
	public List<Evento> listadoEventosPorCiudad(String ciudad);

}
