package bugsbusters.lucatickets.pagos;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import jakarta.ws.rs.core.MediaType;


/**
 * Clase que contiene pruebas unitarias para la aplicación de pagos.
 */
@SpringBootTest
@AutoConfigureMockMvc
class BugsMsPagosApplicationTests {

	@Autowired
	private MockMvc mockMvc;

//	@Autowired
//	private Validator validator; 

    /**
     * Configura el validador antes de cada prueba.
     */
	@BeforeEach 
	public void setUp() {
//        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * Prueba para asegurarse de que el contexto de la aplicación se carga correctamente.
     */
	@Test
	void contextLoads() {
	}

    /**
     * Prueba para validar que el nombre del titular de la tarjeta no esté vacío.
     * Si el nombre del titular de la tarjeta está vacío, debe haber una única violación de restricción.
     *
     * @param pago El objeto Pago a validar.
     * @return El número de violaciones de restricción encontradas.
     */
	
	// VALIDO QUE ESTAN RIP
	
//	 @Test
//	  public void testNombreTitularVacio() {
//	      // Creamos un objeto Pago con el campo nombreTitular vacío
//	      Pago pago = new Pago("", "4242424242424242", 12, 2025, 123, "VISA", "Compra en línea", 100.00);
//	        
//	      // Validamos el objeto Pago y esperamos que haya una única violación de restricción
//	      Set<ConstraintViolation<Pago>> violations = validator.validate(pago);
//	      assertEquals(1, violations.size());
//	        
//	      // Verificamos que el mensaje de error es el esperado
//	      ConstraintViolation<Pago> violation = violations.iterator().next();
//	      assertEquals("El nombre del titular de la tarjeta no puede estar vacío", violation.getMessage());
//	 }
	 
	 
	 
	 /**
	 * Prueba para validar que el número de tarjeta es inválido.
	 * Se espera que la solicitud de pago devuelva un mensaje de error adecuado.
	 *
	 * @param errorMessage El mensaje de error esperado en la respuesta JSON.
	 */
	@Test
	public void testNumeroTarjetaNoValido() throws Exception {
		String errorMessage = "400.0003.Número Tarjeta no correcto";

//	    Pago pago = new Pago("Mireia",
//	    					"4242424242424242",
//						12,
//						2025,
//						123,
//						"VISA",
//						"Compra en línea",
//						100.00);

		String tarjetaJson = "{\r\n" 
				+ "  \"nombreTitular\": \"Mireia\",\r\n"
				+ "  \"numeroTarjeta\": \"424-5678-9012-3456\",\r\n" 
				+ "  \"mesCaducidad\": 12,\r\n"
				+ "  \"yearCaducidad\": 2025,\r\n" 
				+ "  \"cvv\": 124,\r\n" 
				+ "  \"emisor\": \"VISA\",\r\n"
				+ "  \"concepto\": \"Compra en línea\",\r\n" 
				+ "  \"cantidad\": 100.00\r\n" 
				+ "}";
		
//		String expected = "{\"timestamp\":\"19/03/2024 15:24:34\","
//				+ "\"status\":\"400\",\"error\":\"400.0003.Número Tarjeta no correcto\","
//				+ "\"message\":[\"Si quieres hacer pruebas tontas, no me hagas perder el tiempo\""
//				+ ",\"El formato para Visa es: 4aaa-bbbb-cccc-dddd / 4aaabbbbccccdddd\","
//				+ "\"El formato para Mastercard es: 5xaa-bbbb-cccc-dddd / 5xaabbbbccccdddd   "
//				+ "donde x es un valor entre 1-5\",\"No llegas ni a lechón. Eres triste, torpe y polluelo.\"]}";

		mockMvc.perform(
				post("/pago/1/pagar?idEvento=1")
				.content(tarjetaJson).contentType(MediaType.APPLICATION_JSON))
//		.andExpect(content().json(expected))
				.andExpect(jsonPath("$.message").value(errorMessage))
				.andExpect(jsonPath("$.status").value("400"));
	}
	
    /**
     * Prueba para validar que el CVV es inválido.
     * Se espera que la solicitud de pago devuelva un mensaje de error adecuado.
     *
     * @param errorMessage El mensaje de error esperado en la respuesta JSON.
     */
	@Test
	public void testCVVNoValido() throws Exception {
		String errorMessage = "400.0004.Número Cvv no correcto";

		String tarjetaJson = "{\r\n" 
				+ "  \"nombreTitular\": \"Alejandro\",\r\n"
				+ "  \"numeroTarjeta\": \"4242-4242-4242-4242\",\r\n" 
				+ "  \"mesCaducidad\": 12,\r\n"
				+ "  \"yearCaducidad\": 2025,\r\n" 
				+ "  \"cvv\": 1234,\r\n" // CVV no valido (deberia tener solo // 3)
				+ "  \"emisor\": \"VISA\",\r\n" 
				+ "  \"concepto\": \"Compra en línea\",\r\n"
				+ "  \"cantidad\": 100.00\r\n" 
				+ "}";

		
//		String expected = "{\"timestamp\":\"19/03/2024 15:08:35\""
//				+ ",\"status\":\"400\",\"error\":\"400.0004.Número Cvv no correcto\""
//				+ ",\"message\":[\"Anda bonito, mira detrás de tu tarjeta\""
//				+ ",\"El CVV lo conforman 3 ó 4 dígitos\""
//				+ ",\"Collejón te daba si estuvieras cerca... por tonto\"]}";

		ResultActions resultActions = mockMvc.perform(
				post("/pago/1/pagar?idEvento=1")
				.content(tarjetaJson).contentType(MediaType.APPLICATION_JSON));
//		resultActions.andExpect(content().json(expected))
		resultActions.andExpect(jsonPath("$.message").value(errorMessage))
					.andExpect(jsonPath("$.status").value("400"));
	}

}
