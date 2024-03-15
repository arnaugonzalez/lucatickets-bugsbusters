package bugsbusters.lucatickets.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bugsbusters.lucatickets.eventos.model.Evento;


/**
 * Interfaz de repositorio para la entidad Evento.
 * Esta interfaz proporciona métodos para interactuar con la base de datos para la entidad Evento, como guardar, actualizar, eliminar y buscar eventos.
 */
public interface EventosRepository extends JpaRepository<Evento, Long> {

}
