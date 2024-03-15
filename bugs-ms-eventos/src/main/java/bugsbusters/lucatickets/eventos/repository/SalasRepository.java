package bugsbusters.lucatickets.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bugsbusters.lucatickets.eventos.model.Sala;

public interface SalasRepository extends JpaRepository<Sala, Long> {

}
