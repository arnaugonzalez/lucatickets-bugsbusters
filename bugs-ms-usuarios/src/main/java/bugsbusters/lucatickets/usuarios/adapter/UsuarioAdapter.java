package bugsbusters.lucatickets.usuarios.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import bugsbusters.lucatickets.usuarios.model.Usuario;
import bugsbusters.lucatickets.usuarios.model.response.UsuarioResponse;

/**
 * Clase para adaptar una entidad de usuario a un objeto Dto
 * 
 * @author adria
 */
@Component
public class UsuarioAdapter {
	
	/**
	 * Adapta a un solo usuario
	 * @param usuario Usuario a adaptar
	 * @return el usuario en objeto Dto
	 */
	public UsuarioResponse de(Usuario usuario) {
		UsuarioResponse usuarioDTO = new UsuarioResponse();
		usuarioDTO.setNombre(usuario.getNombre());
		usuarioDTO.setApellido(usuario.getApellido());
		usuarioDTO.setEmail(usuario.getEmail());
		usuarioDTO.setContrasena(usuario.getContrasena());
		usuarioDTO.setFecha_alta(usuario.getFecha_alta());
		return usuarioDTO;
	}
	
	/**
	 * Adapta a una lista de usuarios
	 * @param usuarios Usuarios a adaptar
	 * @return los usuarios en objeto Dto
	 */
	public List<UsuarioResponse> de(List<Usuario> usuarios) {
		return usuarios
				.stream()
				.map(e -> de(e))
				.collect(Collectors.toList());
	}
}