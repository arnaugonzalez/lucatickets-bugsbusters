package bugsbusters.lucatickets.usuarios.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import bugsbusters.lucatickets.usuarios.model.Usuario;
import bugsbusters.lucatickets.usuarios.model.response.UsuarioResponse;


@Component
public class UsuarioAdapter {
	
	public UsuarioResponse de(Usuario usuario) {
		UsuarioResponse usuarioDTO = new UsuarioResponse();
		usuarioDTO.setNombre(usuario.getNombre());
		usuarioDTO.setApellido(usuario.getApellido());
		usuarioDTO.setEmail(usuario.getEmail());
		usuarioDTO.setContrasena(usuario.getContrasena());
		usuarioDTO.setFecha_alta(usuario.getFecha_alta());
		return usuarioDTO;
	}
	
	public List<UsuarioResponse> de(List<Usuario> usuarios) {
		return usuarios
				.stream()
				.map(e -> de(e))
				.collect(Collectors.toList());
	}
}