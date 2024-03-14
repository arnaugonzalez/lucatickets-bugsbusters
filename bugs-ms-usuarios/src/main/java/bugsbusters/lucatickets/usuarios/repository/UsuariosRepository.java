package bugsbusters.lucatickets.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bugsbusters.lucatickets.usuarios.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Long> {

}
