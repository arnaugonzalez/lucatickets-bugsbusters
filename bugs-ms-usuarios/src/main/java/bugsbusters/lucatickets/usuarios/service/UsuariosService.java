package bugsbusters.lucatickets.usuarios.service;

import java.util.List;

import bugsbusters.lucatickets.usuarios.model.Usuario;

public interface UsuariosService {
	
	List<Usuario> listadoUsuarios();

	Usuario anadirUsuario(Usuario usuario);
	
}
