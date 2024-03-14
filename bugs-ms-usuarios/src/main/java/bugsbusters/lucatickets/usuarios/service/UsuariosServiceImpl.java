package bugsbusters.lucatickets.usuarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bugsbusters.lucatickets.usuarios.model.Usuario;
import bugsbusters.lucatickets.usuarios.repository.UsuariosRepository;

@Service
public class UsuariosServiceImpl implements UsuariosService {

	@Autowired
	private UsuariosRepository repo;
	
	public List<Usuario> listadoUsuarios() {
		return repo.findAll();
	}

	public Usuario anadirUsuario(Usuario usuario) {
		return repo.save(usuario);
	}

}
