package bugsbusters.lucatickets.pagos;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import jakarta.ws.rs.core.MediaType;

@SpringBootTest
@AutoConfigureMockMvc
class BugsMsPagosApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

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
				.andExpect(jsonPath("$.message").value(errorMessage))
				.andExpect(jsonPath("$.status").value("400"));
	}
	
	
	 @Test
	    public void testCVVNoValido() throws Exception {
	        String errorMessage = "El CVV no es válido";
	        
	        String tarjetaJson = "{\r\n"
	                + "  \"nombreTitular\": \"Alejandro\",\r\n"
	                + "  \"numeroTarjeta\": \"4242 4242 4242 4242\",\r\n"
	                + "  \"mesCaducidad\": \"12\",\r\n"
	                + "  \"yearCaducidad\": \"2025\",\r\n"
	                + "  \"cvv\": \"1234\",\r\n"  // CVV no valido (deberia tener solo 3)
	                + "  \"emisor\": \"VISA\",\r\n"
	                + "  \"concepto\": \"Compra en línea\",\r\n"
	                + "  \"cantidad\": 100.00\r\n"
	                + "}";
	        
	        ResultActions resultActions = mockMvc.perform(
	                post("/pago?idUsuario=3&idEvento=1").content(tarjetaJson).contentType(MediaType.APPLICATION_JSON));

	        resultActions.andExpect(jsonPath("$.message").value(errorMessage))
	                     .andExpect(jsonPath("$.status").value("400"));
	    }

}
