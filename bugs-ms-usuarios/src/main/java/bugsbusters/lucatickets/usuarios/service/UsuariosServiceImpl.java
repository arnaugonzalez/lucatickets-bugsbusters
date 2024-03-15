package bugsbusters.lucatickets.usuarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bugsbusters.lucatickets.usuarios.model.Usuario;
import bugsbusters.lucatickets.usuarios.repository.UsuariosRepository;

/**
 * Interfaz de los servicios del usuario con los métodos definidos
 * 
 * @author adria
 */
@Service
public class UsuariosServiceImpl implements UsuariosService {

	@Autowired
	private UsuariosRepository repo;
	
	/**
	 * Método para mostrar la lista de usuarios guardados en la base de datos
	 * @return la lista de usuarios
	 */
	public List<Usuario> listadoUsuarios() {
		return repo.findAll();
	}
	
	/**
	 * Método para añadir un usuario en la base de datos
	 * @param Usuario a añadir
	 * @return Usuario añadido
	 */
	public Usuario anadirUsuario(Usuario usuario) {
		return repo.save(usuario);
	}

}
