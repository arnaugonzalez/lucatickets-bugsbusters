package bugsbusters.lucatickets.usuarios.service;

import java.util.List;

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
	 * @return la lista de usuarios
	 */
	List<Usuario> listadoUsuarios();
	
	/**
	 * Método para añadir un usuario en la base de datos
	 * @param Usuario a añadir
	 * @return Usuario añadido
	 */
	Usuario anadirUsuario(Usuario usuario);
	
}
