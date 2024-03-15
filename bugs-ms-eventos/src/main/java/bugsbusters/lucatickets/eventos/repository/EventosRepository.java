package bugsbusters.lucatickets.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bugsbusters.lucatickets.eventos.model.Evento;

public interface EventosRepository extends JpaRepository<Evento, Long> {

}
