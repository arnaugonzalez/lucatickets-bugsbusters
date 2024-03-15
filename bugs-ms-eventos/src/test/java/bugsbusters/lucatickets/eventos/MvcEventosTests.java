package bugsbusters.lucatickets.eventos;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import bugsbusters.lucatickets.eventos.controller.EventosController;
import bugsbusters.lucatickets.eventos.repository.EventosRepository;
import bugsbusters.lucatickets.eventos.service.EventosService;
import bugsbusters.lucatickets.eventos.service.EventosServiceImpl;

@WebMvcTest(EventosController.class)
public class MvcEventosTests {

	private static byte cont = 1;
	private static Logger logger;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private EventosService service;
	
	@Autowired
	private EventosRepository repo;
	
	static {
		try {
			logger = LogManager.getLogger(MvcEventosTests.class);
		} catch (Throwable e) {
			System.out.println("No funciona JUnit");
		}
	}
	
	/**
	 * Método ejecutado una vez antes de que se ejecuten las pruebas
	 */
	@BeforeAll
	public static void onceExecutedBeforeAll() {
		logger.info(">>> Iniciando pruebas mvc...");
	}
	
	/**
	 * Método ejecutado antes de cada prueba
	 */
	@BeforeEach
	public void executedBeforeEach() {
		System.out.println("");
		logger.info(">>> PRUEBA MVC " + (cont++) + " <<<");
	}
	
	/**
	 * Método ejecutado una vez después de que se ejecuten las pruebas
	 */
	@AfterAll
	public static void onceExecutedAfterAll() {
		logger.info(">>> Terminado las pruebas mvc");
	}

	@Test
	void contextLoads() {
	}
	
	@Test
	public void eventoAnadidoMock() throws Exception {
		logger.info("Test::eventoAnadidoMock(): Que tras añadir un evento nuevo, el HTTP Response Body contenga dicho Evento");

		mockMvc.perform(post("/eventos/nuevo")
						.contentType("Evento"))
			   .andDo(print())
			   .andExpect(status().isOk())
			   .andExpect(content().contentType(MediaType.APPLICATION_JSON));
			   
	}
	
}
