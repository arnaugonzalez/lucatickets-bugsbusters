package bugsbusters.lucatickets.eventos;

import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class BugsMsEventosApplicationTests {
	
	private static byte cont = 1;
	private static Logger logger;
	
	@Autowired
	private EventosService service;

	@Autowired
	private EventosRepository dao;
	
	@Autowired
	private EventosController control;

	
	
	/**
	 * Método ejecutado una vez antes de que se ejecuten las pruebas
	 */
	@BeforeAll
	public static void onceExecutedBeforeAll() {
		logger.info(">>> Iniciando pruebas...");
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
	 public void testListadoDevuelto() {
		logger.info("Test::testListadoDevuelto(): Que la cantidad de eventos a mostrar por el servicio sea igual a la longitud de la base de datos");
		int longitudBaseDatos = (int) dao.count();
		
		//número de eventos en la base de datos.
		List<Evento> listado = service.findAll();
		
		//número de eventos devueltos por un servicio
		List<EventoResponse> test = control.listadoEventos();

		//esta prueba unitaria verifica si el número de eventos devueltos por un servicio es igual al número de eventos en la base de datos.
		assertTrue(test.size() == listado.size());
	 }
}
