package bugsbusters.lucatickets.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bugsbusters.lucatickets.eventos.model.Sala;


/**
 * Interfaz de repositorio para la entidad Sala.
 * Esta interfaz proporciona métodos para interactuar con la base de datos para la entidad Sala, como guardar, actualizar, eliminar y buscar salas.
 */
public interface SalasRepository extends JpaRepository<Sala, Long> {

}
