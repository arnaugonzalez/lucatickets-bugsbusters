package bugsbusters.lucatickets.eventos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MultiValueMap;

import bugsbusters.lucatickets.eventos.adapter.EventoAdapter;
import bugsbusters.lucatickets.eventos.controller.EventosController;
import bugsbusters.lucatickets.eventos.model.Evento;
import bugsbusters.lucatickets.eventos.model.Sala;
import bugsbusters.lucatickets.eventos.model.response.EventoResponse;
import bugsbusters.lucatickets.eventos.repository.EventosRepository;
import bugsbusters.lucatickets.eventos.service.EventosService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

@SpringBootTest
class BugsMsEventosApplicationTests {
	
	private static byte cont = 1;
	private static Logger logger;
	
	@Autowired
	private EventosRepository dao;
	
	@Autowired
	private EventosController control;
	
	@Autowired
	private EventoAdapter adapter;

	static {
		try {
			logger = LogManager.getLogger(BugsMsEventosApplicationTests.class);
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
	public void longitudListadoEventos() {
		logger.info("Test::longitudListadoEventos(): Que la cantidad de eventos a mostrar por el servicio sea igual a la longitud de la base de datos");
		
		//número de eventos en la base de datos.
		List<Evento> listado = dao.findAll();
		
		//número de eventos devueltos por un servicio
		List<EventoResponse> test = control.listadoEventos();

		//esta prueba unitaria verifica si el número de eventos devueltos por un servicio es igual al número de eventos en la base de datos.
		assertTrue(test.size() == listado.size());
	 }
	 
	

}
