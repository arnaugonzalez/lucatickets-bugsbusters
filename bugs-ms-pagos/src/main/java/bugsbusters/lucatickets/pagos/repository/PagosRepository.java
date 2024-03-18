package bugsbusters.lucatickets.pagos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bugsbusters.lucatickets.pagos.model.Compra;



/**
 * Interfaz de repositorio para la entidad Compra.
 * Esta interfaz proporciona métodos para interactuar con la base de datos para la entidad Compra, como guardar, actualizar, eliminar y buscar.
 */
public interface PagosRepository extends JpaRepository<Compra, Long> {

}
