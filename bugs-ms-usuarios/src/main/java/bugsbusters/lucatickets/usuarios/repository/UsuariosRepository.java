package bugsbusters.lucatickets.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bugsbusters.lucatickets.usuarios.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Long> {
	
	/**
	 * Este metodo comprueba si existe un usuario con un email en concreto
	 * @param email Email a buscar
	 * @return Booleano que devuelve true si existe o false en caso contrario
	 */
	boolean existsByEmail(String email);

}
