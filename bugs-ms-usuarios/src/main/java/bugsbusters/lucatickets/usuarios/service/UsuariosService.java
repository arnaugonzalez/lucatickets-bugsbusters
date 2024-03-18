package bugsbusters.lucatickets.usuarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bugsbusters.lucatickets.usuarios.model.Usuario;

/**
 * Interfaz de los servicios del usuario
 * 
 * @author adria
 */
@Service
public interface UsuariosService {

	/**
	 * Método para mostrar la lista de usuarios guardados en la base de datos
	 * 
	 * @return la lista de usuarios
	 */
	List<Usuario> listadoUsuarios();

	/**
	 * Método para encontrar un evento en la base de datos por un ID
	 * @param id ID para buscar el Usuario
	 * @return Usuario añadido si existe, sino es un Optional.EMPTY
	 */
	
	Optional<Usuario> dameUsuarioPorId(long id);
	
	
	/**
	 * Método para añadir un usuario en la base de datos
	 * 
	 * 
	 * @param Usuario a añadir
	 * @return Usuario añadido
	 */
	Usuario anadirUsuario(Usuario usuario);

}
