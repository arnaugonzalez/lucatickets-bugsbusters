package bugsbusters.lucatickets.usuarios;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bugsbusters.lucatickets.usuarios.adapter.UsuarioAdapter;
import bugsbusters.lucatickets.usuarios.controller.UsuariosController;
import bugsbusters.lucatickets.usuarios.model.Usuario;
import bugsbusters.lucatickets.usuarios.model.response.UsuarioResponse;
import bugsbusters.lucatickets.usuarios.repository.UsuariosRepository;

/**
 * Clase que contiene los casos de prueba para la aplicación de gestión de
 * usuarios.
 *
 * @author Mireia, Andres
 */

@SpringBootTest
class BugsMsUsuariosApplicationTests {

	private static Logger logger;

	@Autowired
	private UsuariosController control;

	@Autowired
	private UsuariosRepository dao;

	@Autowired
	private UsuarioAdapter adapter;

	static {
		try {
			logger = LogManager.getLogger(BugsMsUsuariosApplicationTests.class);
		} catch (Throwable e) {
			System.out.println("No funciona JUnit");
		}
	}

	/**
	 * Verifica si el contexto de la aplicación se carga correctamente.
	 *
	 * <p>
	 * Este método asegura que la aplicación se inicie correctamente sin errores.
	 * </p>
	 */
	@Test
	void contextLoads() {
	}

	@Test
	void existeEventoController() {
		assertThat(control).isNotNull();
	}

	@Test
	public void longitudListadoUsuarios() {
		logger.info(
				"Test::longitudListadoUsuarios(): Que la cantidad de usuarios a mostrar por el servicio sea igual a la longitud de la base de datos");

		// número de usuarios en la base de datos.
		List<Usuario> listado = dao.findAll();

		// número de usuarios devueltos por un servicio
		List<UsuarioResponse> test = control.listadoUsuarios();

		// esta prueba unitaria verifica si el número de usuarios devueltos por un
		// servicio es igual al número de usuarios en la base de datos.
		assertTrue(test.size() == listado.size());
	}

	/**
	 * Prueba la funcionalidad de añadir un usuario.
	 *
	 * <p>
	 * Este método verifica que la respuesta al dar de alta un usuario nuevo sea
	 * igual al usuario creado.
	 * </p>
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

		Boolean resultado = (usuarioTest.getNombre().equals(usuarioAdaptado.getNombre()))
				&& (usuarioTest.getApellido().equals(usuarioAdaptado.getApellido()))
				&& (usuarioTest.getContrasena().equals(usuarioAdaptado.getContrasena()));

		// comprobamos que ambos usuarios son iguales
		assertTrue(resultado);
	}

	@Test
	public void testUsuarioPorId() {
		logger.info(
				"Test::testUsuarioPorId(): Comprobar que dameUsuarioPorID(id) y repo.findById(id) devuelvan el mismo usuario");

		long id = 3;

		UsuarioResponse u1 = control.dameUsuarioPorId(id);
		Optional<Usuario> u2_optional = dao.findById(id);
		UsuarioResponse u2 = adapter.de(u2_optional.get());

		assertEquals(u1, u2);
	}

	@Test
	public void testMostrarListadoUsuariosDespuesAgregar() {
		logger.info(
				"Test::testMostrarListadoUsuariosDespuesAgregar(): Verificar si se muestra correctamente el listado de usuarios después de agregar un nuevo usuario");

		int longitudAntes = control.listadoUsuarios().size();

		// agregamos un nuevo usuario
		Usuario usuarioTest = new Usuario(5555L, "Juan", "Garcia", "juangarcia@mail.com", "clave123", "2000-05-12");
		control.anadirUsuario(usuarioTest);

		// Obtener la longitud del listado de usuarios después de agregar un nuevo
		// usuario
		int longitudDespues = control.listadoUsuarios().size();

		// Verificar que la longitud después de agregar sea mayor que la longitud antes
		// de agregarlo
		assertTrue(longitudDespues > longitudAntes);
	}

}
