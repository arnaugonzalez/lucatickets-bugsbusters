package bugsbusters.lucatickets.pagos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import bugsbusters.lucatickets.pagos.model.Tarjeta;
import jakarta.ws.rs.core.MediaType;


/**
 * Clase que contiene pruebas unitarias para la aplicación de pagos.
 */
@SpringBootTest
@AutoConfigureMockMvc
class BugsMsPagosApplicationTests {
	
	private static byte cont = 1;
	private static Logger logger;
	
	@Autowired
	private MockMvc mockMvc;

	static {
		try {
			logger = LogManager.getLogger(BugsMsPagosApplicationTests.class);
		} catch (Throwable e) {
			System.out.println("No funciona Spring Boot Testing");
		}
	}
	
	/**
	 * Método ejecutado una vez antes de que se ejecuten las pruebas
	 */
	@BeforeAll
	public static void onceExecutedBeforeAll() {
		logger.info(">>> Iniciando pruebas Mock del servicio de Pagos...");
	}
	
	/**
	 * Método ejecutado antes de cada prueba
	 */
	@BeforeEach
	public void executedBeforeEach() {
		System.out.println("");
		logger.info(">>> PRUEBA MOCK " + (cont++) + " <<<");
	}
	
	/**
	 * Método ejecutado una vez después de que se ejecuten las pruebas
	 */
	@AfterAll
	public static void onceExecutedAfterAll() {
		logger.info(">>> Terminado las pruebas Mock");
	}

    /**
     * Prueba para asegurarse de que el contexto de la aplicación se carga correctamente.
     */
	@Test
	void contextLoads() {
	}


	 /**
	 * Prueba para validar que el número de tarjeta es inválido.
	 * Se espera que la solicitud de pago devuelva un mensaje de error adecuado.
	 *
	 * @param errorMessage El mensaje de error esperado en la respuesta JSON.
	 */
	@Test
	public void testBadRequestTarjetaNoValida() throws Exception {
		
		logger.info("Test::testBadRequestTarjetaNoValida(): La Tarjeta envía un {numeroTarjeta} no válido y se comprueba que el resultado devuelva un status 400: Bad Request");
		
		Tarjeta tarjetaTest = new Tarjeta(
				"Arnau Gonzalez",
				"424-5678-9012-3456", //NUMERO TARJETA NO VÁLIDO
				12, 2025, 454);
		
		ObjectMapper om = new ObjectMapper();
		String tarjetaJSONtest = om.writeValueAsString(tarjetaTest);
		
		mockMvc.perform(
					post("/pago/1/pagar?idEvento=1&cantidad=2")
				.content(tarjetaJSONtest).contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());			
				
	}
	
	 /**
		 * Prueba para validar que el número de tarjeta es inválido.
		 * Se espera que la solicitud de pago devuelva un mensaje de error adecuado.
		 *
		 * @param errorMessage El mensaje de error esperado en la respuesta JSON.
	*/
	@Test
	public void testErrorMensajeTarjetaNoValida() throws Exception {
			
		logger.info("Test::testErrorMensajeTarjetaNoValida(): La Tarjeta envía un {numeroTarjeta} no válido y se comprueba que el resultado devuelva el mensaje de error esperado");

		Tarjeta tarjetaTest = new Tarjeta(
					"Arnau Gonzalez",
					"424-5678-9012-3456", //NUMERO TARJETA NO VÁLIDO
					12, 2025, 454);
			
		ObjectMapper om = new ObjectMapper();
		String tarjetaJSONtest = om.writeValueAsString(tarjetaTest);
			
		MvcResult test = mockMvc
				.perform(post("/pago/1/pagar?idEvento=1&cantidad=2")
					.content(tarjetaJSONtest).contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))
				.andReturn();				

		String errorMessage = "400.0003.Número Tarjeta no correcto";
			
		assertEquals(errorMessage, test.getResponse().getErrorMessage());
			
	}
		
	
    /**
     * Prueba para validar que el CVV es inválido.
     * Se espera que la solicitud de pago devuelva un mensaje de error adecuado.
     *
     * @param errorMessage El mensaje de error esperado en la respuesta JSON.
     */
	@Test
	public void testMensajeErrorCvvNoValido() throws Exception {

		logger.info("Test::testMensajeErrorCvvNoValido(): La Tarjeta envía un {Cvv} no válido y se comprueba que el resultado devuelva el mensaje de error esperado");

		Tarjeta tarjetaTest = new Tarjeta(
				"Arnau Gonzalez",
				"4424-5678-9012-3456",
				12, 2025, 
				45444); //EL CVV NO ES VÁLIDO
		
		ObjectMapper om = new ObjectMapper();
		String tarjetaJSONtest = om.writeValueAsString(tarjetaTest);
		
		MvcResult test = mockMvc
				.perform(post("/pago/1/pagar?idEvento=1&cantidad=2")
						.content(tarjetaJSONtest).contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andReturn();		

		String errorMessage = "400.0004.Número Cvv no correcto";
		
		assertEquals(errorMessage, test.getResponse().getErrorMessage());
	}

}
