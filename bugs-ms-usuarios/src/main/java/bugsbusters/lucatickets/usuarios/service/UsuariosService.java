package bugsbusters.lucatickets.usuarios.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bugsbusters.lucatickets.usuarios.model.Usuario;

@Service
public interface UsuariosService {
	
	List<Usuario> listadoUsuarios();

	Usuario anadirUsuario(Usuario usuario);
	
}
