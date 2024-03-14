package bugsbusters.lucatickets.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bugsbusters.lucatickets.usuarios.adapter.UsuarioAdapter;
import bugsbusters.lucatickets.usuarios.model.Usuario;
import bugsbusters.lucatickets.usuarios.model.response.UsuarioResponse;
import bugsbusters.lucatickets.usuarios.service.UsuariosServiceImpl;



@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private UsuariosServiceImpl servicio;
	
	@Autowired
	private UsuarioAdapter adaptador;
	
	@GetMapping("/listado") //Devolver la lista de usuarios desde el administrador
	public List<UsuarioResponse> listadoUsuarios() {
		final List<Usuario> usuarios = servicio.listadoUsuarios();
		return adaptador.de(usuarios);
	}
	
	@PostMapping("/nuevo") //Devolver un usuario buscado por id
	public UsuarioResponse anadirUsuario(@RequestBody Usuario usuario){
		final Usuario usuarioDevuelto = servicio.anadirUsuario(usuario);
		return adaptador.de(usuarioDevuelto);
	}
}