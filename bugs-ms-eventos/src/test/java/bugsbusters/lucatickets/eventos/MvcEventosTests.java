package bugsbusters.lucatickets.eventos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;



//@WebMvcTest(EventosController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MvcEventosTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void eventoAnadidoMock() throws Exception {

		MvcResult test = mockMvc
				.perform(get("/").param("id", "99999"))
				.andReturn();		

		String errorMessage = "No existe el evento con ID: 99999";
		
		assertEquals(errorMessage, test.getResponse());
			   
	}
	
}
