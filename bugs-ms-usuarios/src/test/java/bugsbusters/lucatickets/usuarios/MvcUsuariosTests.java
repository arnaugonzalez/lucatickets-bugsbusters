package bugsbusters.lucatickets.usuarios;

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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import bugsbusters.lucatickets.usuarios.MvcUsuariosTests;
import bugsbusters.lucatickets.usuarios.controller.UsuariosController;
import bugsbusters.lucatickets.usuarios.repository.UsuariosRepository;
import bugsbusters.lucatickets.usuarios.service.UsuariosServiceImpl;

@WebMvcTest(UsuariosController.class)
public class MvcUsuariosTests {

	private static byte cont = 1;
	private static Logger logger;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private UsuariosServiceImpl service;
	
	@Autowired
	private UsuariosRepository repo;
	
	static {
		try {
			logger = LogManager.getLogger(MvcUsuariosTests.class);
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
	public void usuarioAnadidoMock() throws Exception {
		logger.info("Test::usuarioAnadidoMock(): Que tras añadir un usuario nuevo, el HTTP Response Body contenga dicho Usuario");

		mockMvc.perform(post("/usuarios/nuevo")
						.contentType("Usuario"))
			   .andDo(print())
			   .andExpect(status().isOk())
			   .andExpect(content().contentType(MediaType.APPLICATION_JSON));
			   
	}
	
}