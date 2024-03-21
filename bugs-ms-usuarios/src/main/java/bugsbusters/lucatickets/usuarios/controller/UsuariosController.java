package bugsbusters.lucatickets.usuarios.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bugsbusters.lucatickets.usuarios.adapter.UsuarioAdapter;
import bugsbusters.lucatickets.usuarios.controller.error.UsuarioNotFoundException;
import bugsbusters.lucatickets.usuarios.model.Usuario;
import bugsbusters.lucatickets.usuarios.model.response.UsuarioResponse;
import bugsbusters.lucatickets.usuarios.service.UsuariosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@RequestMapping("/usuarios")
@Tag(name = "usuario", description = "LucaTickets API")
public class UsuariosController {
	
	
	@Autowired
	private UsuariosService servicio;
	 
	@Autowired
	private UsuarioAdapter adaptador;
	
	@Operation(
			summary = "Listar usuarios", description = "Carga la lista de usuarios de la base de datos", tags= {"usuario"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista cargada", content = {
							@Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class))}),
			@ApiResponse(responseCode = "400", description = "No valido ", content = @Content),
			@ApiResponse(responseCode = "404", description = "No se ha encontrado la base de datos", content = @Content)})
	@GetMapping("/listado") //Devolver la lista de usuarios desde el administrador
	public List<UsuarioResponse> listadoUsuarios() {
		final List<Usuario> usuarios = servicio.listadoUsuarios();
		return adaptador.de(usuarios);
	}
	
	@Operation(summary = "BuscaUsuario por ID", description = "Dado un ID, devuelve un objeto Usuario", tags= {"evento"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuario localizado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class)) }),
			@ApiResponse(responseCode = "404", description = "Usuario no encontrado (NO implementado)", content = @Content) })
	@GetMapping("/{id}")
	public UsuarioResponse dameUsuarioPorId(
			@Parameter(description = "ID del usuario a localizar", required=true) 
			@PathVariable Long id) {			
		Optional<Usuario> respuesta = servicio.dameUsuarioPorId(id);
		if(respuesta.isPresent())
			return adaptador.de(respuesta.get());
		else throw new UsuarioNotFoundException(id);
	}
	
	
	@Operation(
			summary = "Añadir usuario", description = "Añade un nuevo usuario a la base de datos", tags= {"usuario"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuario añadido", content = {
							@Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class))}),
			@ApiResponse(responseCode = "400", description = "No valido ", content = @Content),
			@ApiResponse(responseCode = "404", description = "No se ha encontrado la base de datos", content = @Content)})
	@PostMapping("/nuevo") //Devolver un usuario buscado por id
	public UsuarioResponse anadirUsuario(@Valid @RequestBody Usuario usuario){
		final Usuario usuarioDevuelto = servicio.anadirUsuario(usuario);
		return adaptador.de(usuarioDevuelto);
	}
}