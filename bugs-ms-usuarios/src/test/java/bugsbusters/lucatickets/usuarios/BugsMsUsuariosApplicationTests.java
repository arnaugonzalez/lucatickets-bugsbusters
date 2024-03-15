package bugsbusters.lucatickets.usuarios;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bugsbusters.lucatickets.usuarios.adapter.UsuarioAdapter;
import bugsbusters.lucatickets.usuarios.controller.UsuariosController;
import bugsbusters.lucatickets.usuarios.model.Usuario;
import bugsbusters.lucatickets.usuarios.model.response.UsuarioResponse;

/**
 * Clase que contiene los casos de prueba para la aplicación de gestión de
 * usuarios.
 * 
 * <p>Autor: Mireia</p>
 */

@SpringBootTest
class BugsMsUsuariosApplicationTests {
	private static Logger logger;

	@Autowired
	private UsuariosController control;

	@Autowired
	private UsuarioAdapter adapter;

	/**
	 * Verifica si el contexto de la aplicación se carga correctamente.
	 * 
	 * <p>Este método asegura que la aplicación se inicie correctamente sin errores.</p>
	 */

	@Test
	void contextLoads() {
	}

	/**
	 * Prueba la funcionalidad de añadir un usuario.
	 * 
	 * <p>Este método verifica que la respuesta al dar de alta un usuario nuevo sea igual al usuario creado.</p>
	 */
	@Test
	public void testAnadirUsuario() {
		logger.info(
				"Test::testAnadirUsuario(): Que la respuesta dando de alta un usuario nuevo sea igual ha dicho usuario creado");

		// usuario de prueba
		Usuario usuario = new Usuario(1L, "Mireia", "Suero", "mir@suero.com", "patata", "01-01-2000");

		// añadimos el usuario
		UsuarioResponse usuarioTest = control.anadirUsuario(usuario);

		UsuarioResponse usuarioAdaptado = adapter.de(usuario);

		// comprobamos que ambos usuarios son iguales
		assertTrue(usuarioTest == usuarioAdaptado);
	}

}
