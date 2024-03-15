package bugsbusters.lucatickets.eventos;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import bugsbusters.lucatickets.eventos.controller.EventosController;
import bugsbusters.lucatickets.eventos.model.Evento;
import bugsbusters.lucatickets.eventos.model.Sala;


//@WebMvcTest(EventosController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MvcEventosTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void eventoAnadidoMock() throws Exception {

		mockMvc.perform(post("/nuevo"))
			   .andDo(print())
			   .andExpect(status().isOk())
			   .andExpect(content().contentType(MediaType.APPLICATION_JSON));
			   
	}
	
}
