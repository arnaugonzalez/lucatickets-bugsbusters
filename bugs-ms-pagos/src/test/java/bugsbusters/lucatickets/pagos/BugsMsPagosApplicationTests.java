package bugsbusters.lucatickets.pagos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import bugsbusters.lucatickets.pagos.model.Pago;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.ws.rs.core.MediaType;


/**
 * Clase que contiene pruebas unitarias para la aplicación de pagos.
 */
@SpringBootTest
@AutoConfigureMockMvc
class BugsMsPagosApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	private Validator validator; 

    /**
     * Configura el validador antes de cada prueba.
     */
	@BeforeEach 
	public void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
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
	 @Test
	  public void testNombreTitularVacio() {
	      // Creamos un objeto Pago con el campo nombreTitular vacío
	      Pago pago = new Pago("", "4242424242424242", 12, 2025, 123, "VISA", "Compra en línea", 100.00);
	        
	      // Validamos el objeto Pago y esperamos que haya una única violación de restricción
	      Set<ConstraintViolation<Pago>> violations = validator.validate(pago);
	      assertEquals(1, violations.size());
	        
	      // Verificamos que el mensaje de error es el esperado
	      ConstraintViolation<Pago> violation = violations.iterator().next();
	      assertEquals("El nombre del titular de la tarjeta no puede estar vacío", violation.getMessage());
	 }
	 
	 
	 
	 /**
	 * Prueba para validar que el número de tarjeta es inválido.
	 * Se espera que la solicitud de pago devuelva un mensaje de error adecuado.
	 *
	 * @param errorMessage El mensaje de error esperado en la respuesta JSON.
	 */
	@Test
	public void testNumeroTarjetaNoValido() throws Exception {
		String errorMessage = "El número de la tarjeta no es válido";

		String tarjetaJson = "{\r\n" 
				+ "  \"nombreTitular\": \"Mireia\",\r\n"
				+ "  \"numeroTarjeta\": \"424-5678-9012-3456\",\r\n" 
				+ "  \"mesCaducidad\": \"12\",\r\n"
				+ "  \"yearCaducidad\": \"2025\",\r\n" 
				+ "  \"cvv\": \"124\",\r\n" 
				+ "  \"emisor\": \"VISA\",\r\n"
				+ "  \"concepto\": \"Compra en línea\",\r\n" 
				+ "  \"cantidad\": 100.00\r\n" 
				+ "}";

		mockMvc.perform(
				post("/pago?idUsuario=3&idEvento=1").content(tarjetaJson).contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.message").value(errorMessage)).andExpect(jsonPath("$.status").value("400"));
	}
	
    /**
     * Prueba para validar que el CVV es inválido.
     * Se espera que la solicitud de pago devuelva un mensaje de error adecuado.
     *
     * @param errorMessage El mensaje de error esperado en la respuesta JSON.
     */
	@Test
	public void testCVVNoValido() throws Exception {
		String errorMessage = "El CVV no es válido";

		String tarjetaJson = "{\r\n" 
				+ "  \"nombreTitular\": \"Alejandro\",\r\n"
				+ "  \"numeroTarjeta\": \"4242 4242 4242 4242\",\r\n" 
				+ "  \"mesCaducidad\": \"12\",\r\n"
				+ "  \"yearCaducidad\": \"2025\",\r\n" 
				+ "  \"cvv\": \"1234\",\r\n" // CVV no valido (deberia tener solo // 3)
				+ "  \"emisor\": \"VISA\",\r\n" 
				+ "  \"concepto\": \"Compra en línea\",\r\n"
				+ "  \"cantidad\": 100.00\r\n" 
				+ "}";

		ResultActions resultActions = mockMvc.perform(
				post("/pago?idUsuario=3&idEvento=1").content(tarjetaJson).contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(jsonPath("$.message").value(errorMessage)).andExpect(jsonPath("$.status").value("400"));
	}

}
