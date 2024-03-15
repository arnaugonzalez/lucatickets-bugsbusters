package bugsbusters.lucatickets.usuarios;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bugsbusters.lucatickets.usuarios.adapter.UsuarioAdapter;
import bugsbusters.lucatickets.usuarios.controller.UsuariosController;
import bugsbusters.lucatickets.usuarios.model.Usuario;
import bugsbusters.lucatickets.usuarios.model.response.UsuarioResponse;
import bugsbusters.lucatickets.usuarios.repository.UsuariosRepository;

@SpringBootTest
class BugsMsUsuariosApplicationTests {
	
	private static byte cont = 1;
	private static Logger logger;
	
	@Autowired
	private UsuariosRepository dao;
	
	@Autowired
	private UsuariosController control;
	
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
	 * Método ejecutado una vez antes de que se ejecuten las pruebas
	 */
	@BeforeAll
	public static void onceExecutedBeforeAll() {
		logger.info(">>> Iniciando pruebas unitarias...");
	}
	
	/**
	 * Método ejecutado antes de cada prueba
	 */
	@BeforeEach
	public void executedBeforeEach() {
		System.out.println("");
		logger.info(">>> PRUEBA UNITARIA " + (cont++) + " <<<");
	}
	
	/**
	 * Método ejecutado una vez después de que se ejecuten las pruebas
	 */
	@AfterAll
	public static void onceExecutedAfterAll() {
		logger.info(">>> Terminado las pruebas unitarias");
	}

	@Test
	void contextLoads() {
	}
	
	@Test
	void existeEventoController() {
		assertThat(control).isNotNull();
	}
	
	@Test
	 public void testListadoDevuelto2() {
		logger.info("Test::testListadoDevuelto(): Que la cantidad de usuarios a mostrar por el servicio sea igual a la longitud de la base de datos");
		int longitudBaseDatos = (int) dao.count();
		
		//número de usuarios en la base de datos.
		List<Usuario> listado = dao.findAll();
		
		//número de usuarios devueltos por un servicio
		List<UsuarioResponse> test = control.listadoUsuarios();

		//esta prueba unitaria verifica si el número de usuarios devueltos por un servicio es igual al número de usuarios en la base de datos.
		assertTrue(test.size() == listado.size());
	 }

}
