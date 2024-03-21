
package bugsbusters.lucatickets.eventos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import bugsbusters.lucatickets.eventos.adapter.EventoAdapter;
import bugsbusters.lucatickets.eventos.controller.EventosController;
import bugsbusters.lucatickets.eventos.model.Evento;
import bugsbusters.lucatickets.eventos.model.Sala;
import bugsbusters.lucatickets.eventos.model.response.EventoResponse;
import bugsbusters.lucatickets.eventos.repository.EventosRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Clase que contiene los casos de prueba para la aplicación de gestión de
 * usuarios.
 *
 * @author Arnau, Mireia
 */

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

	/**
	 * Verifica si el contexto de la aplicación se carga correctamente.
	 *
	 * <p>
	 * Se asegura de que la aplicación se inicie correctamente sin errores.
	 * </p>
	 */

	@Test
	void contextLoads() {
	}
	
	/**
	 * Verifica si el controlador de eventos no es nulo.
	 */
	@Test
	void existeEventoController() {
		assertThat(control).isNotNull();
	}

	/**
	 * Prueba para verificar si el listado de eventos devuelto por el servicio es
	 * igual a la longitud de la base de datos.
	 *
	 * <p>
	 * Se verifica que el número de eventos devueltos por el servicio coincida con
	 * el número de eventos en la base de datos.
	 * </p>
	 */

	@Test
	public void longitudListadoEventos() {
		logger.info(
				"Test::longitudListadoEventos(): Que la cantidad de eventos a mostrar por el servicio sea igual a la longitud de la base de datos");

		// número de eventos en la base de datos.
		List<Evento> listado = dao.findAll();

		// número de eventos devueltos por un servicio
		List<EventoResponse> test = control.listadoEventos();

		// esta prueba unitaria verifica si el número de eventos devueltos por un
		// servicio es igual al número de eventos en la base de datos.
		assertTrue(test.size() == listado.size());
	}

	/**
	 * Prueba unitaria para verificar si el número de eventos devueltos por el
	 * servicio es igual al número de eventos en la base de datos con un nombre
	 * específico.
	 * 
	 * <p>
	 * Se verifica que el número de eventos devueltos por el servicio al filtrar por
	 * nombre sea igual al número de eventos en la base de datos que tienen el
	 * nombre específico proporcionado.
	 * </p>
	 */
	@Test
	public void longitudListadoEventosNombre() {
		logger.info(
				"Test::longitudListadoEventosNombres(): Que el número de eventos devueltos por el servicio es igual al número de eventos en la base de datos que tienen un nombre específico");

		// número de eventos en la base de datos.
		List<Evento> listado = dao.findByNombre("Noche de Metal");

		// número de eventos devueltos por un servicio
		List<EventoResponse> test = control.listadoEventosPorNombre("Noche de Metal");

		// esta prueba unitaria verifica si el número de eventos devueltos por un
		// servicio es igual al número de eventos en la base de datos.
		assertTrue(test.size() == listado.size());
	}
	
	/**
	 * Prueba unitaria para verificar que el filtrado por ciudades es correcto
	 */
	@Test
	public void testListadoEventosCiudad() {
		logger.info("Test::testListadoEventosCiudad(): Comprobar que cada ciudad de las salas coincida con la búsqueda");
		
		String ciudad = "Barcelona";
		int eventos = 0;
		
		List<EventoResponse> listado = control.listadoEventosPorCiudad(ciudad);
		for(int i = 0; i < listado.size(); i++) {
			if (listado.get(i).getCiudad().equals(ciudad)) {
				eventos++;
			}
		}
		
		assertEquals(listado.size(), eventos);
	}

	/**
	 * Prueba para verificar si el evento añadido devuelve la respuesta esperada.
	 *
	 * <p>
	 * Se añade un evento nuevo y se verifica que la respuesta del controlador
	 * coincida con la respuesta esperada.
	 * </p>
	 */

	@Test
	public void eventoAnadidoResponse() {
		logger.info(
				"Test::eventoAnadidoResponse(): Que tras añadir un evento nuevo, el HTTP Response Body contenga dicho Evento");

		Sala salaA = new Sala(1L, "Sala A", "Villarobledo", "Calle de la birra", "Al aire libre", 600);

		Evento eventoTest = new Evento();
		eventoTest.setId(9994449L);
		eventoTest.setNombre("Claptest2");
		eventoTest.setDescripcion_corta("Disco Mataró");
		eventoTest.setDescripcion_extendida("Discoteca multitudinaria, hacen varios eventos");
		eventoTest.setFoto("https://www.capgros.com/uploads/s1/55/54/29/clap_11_1280x644.jpeg");
		eventoTest.setFecha(LocalDate.parse("2024-04-23"));
		eventoTest.setHora(LocalTime.parse("23:59:00"));
		eventoTest.setPrecio(18.0);
		eventoTest.setMusica("Hip-Hop");
		eventoTest.setNormas("Código de vestimenta y prohibido acosar a nadie");
		eventoTest.setSala(salaA);

		EventoResponse eventoAdaptado = adapter.de(eventoTest);

		EventoResponse test = control.anadirEvento(eventoTest);

		Boolean resultado = (test.getNombre().equals(eventoAdaptado.getNombre()))
				&& (test.getDescripcion_corta().equals(eventoAdaptado.getDescripcion_corta()))
				&& (test.getMusica().equals(eventoAdaptado.getMusica()));

		assertTrue(resultado);
//		assertTrue(test.equals(eventoAdaptado));
	}
	
	/**
	 * Prueba la funcionalidad de añadir un evento y verificar si la longitud del listado de eventos aumenta 
	 */
	@Test
	public void eventoAnadidoLongitudListado() {
		logger.info(
				"Test::eventoAnadidoLongitudListado(): Que tras añadir un evento nuevo, que el listado devuelto sea igual de largo que antes de anadirlo + 1");

		int longitud_listado_antes = dao.findAll().size();

		Sala salaA = new Sala(1L, "Sala A", "Villarobledo", "Calle de la birra", "Al aire libre", 600);

		Evento eventoTest = new Evento();
		eventoTest.setId(999779L);
		eventoTest.setNombre("Claptest2b");
		eventoTest.setDescripcion_corta("Disco Mataró");
		eventoTest.setDescripcion_extendida(
				"Discoteca multitudinaria, hacen varios tipos de eventos con variedad musical amplia");
		eventoTest.setFoto("https://www.capgros.com/uploads/s1/55/54/29/clap_11_1280x644.jpeg");
		eventoTest.setFecha(LocalDate.parse("2024-04-23"));
		eventoTest.setHora(LocalTime.parse("23:59:00"));
		eventoTest.setPrecio(18.0);
		eventoTest.setMusica("Hip-Hop");
		eventoTest.setNormas("Código de vestimenta y prohibido acosar a nadie");
		eventoTest.setSala(salaA);

		control.anadirEvento(eventoTest);

		int longitud_listado_despues = dao.findAll().size();

		assertEquals(longitud_listado_antes + 1, longitud_listado_despues);
	}
	
	/**
	 * Prueba la funcionalidad de obtener un evento por su ID y Comprueba que el evento devuelto por dameEventoPorID del controlador 
	 * y el evento obtenido del repositorio por su ID sean iguales.
	 */
	@Test
	public void testEventoPorId() {
		logger.info(
				"Test::testEventoPorId(): Comprobar que dameEventoPorID(id) y repo.findById(id) devuelvan el mismo evento");

		long id = 3;

		EventoResponse e1 = control.dameEventoPorId(id);
		Optional<Evento> e2_optional = dao.findById(id);
		EventoResponse e2 = adapter.de(e2_optional.get());

		assertEquals(e1, e2);
	}
	
	/**
	 * Comprueba que la longitud del listado de eventos después de agregar un nuevo evento sea mayor que la longitud antes de agregarlo
	 */
	@Test
	public void testMostrarListadoEventosDespuesAgregar() {
		logger.info(
				"Test::testMostrarListadoEventosDespuesAgregar(): Verificar si se muestra correctamente el listado de eventos después de agregar un nuevo evento");

		// Obtener la longitud del listado de eventos antes de agregar un nuevo evento
		int longitudAntes = control.listadoEventos().size();

		// agregamos un nuevo evento
		Sala salaA = new Sala(1L, "Sala A", "Villarobledo", "Calle de la birra", "Al aire libre", 600);

		Evento eventoTest = new Evento();
		eventoTest.setId(9999L);
		eventoTest.setNombre("Clap");
		eventoTest.setDescripcion_corta("Disco Mataró");
		eventoTest.setDescripcion_extendida(
				"Discoteca multitudinaria, hacen varios tipos de eventos con variedad musical amplia");
		eventoTest.setFoto("https://www.capgros.com/uploads/s1/55/54/29/clap_11_1280x644.jpeg");
		eventoTest.setFecha(LocalDate.parse("2024-04-23"));
		eventoTest.setHora(LocalTime.parse("23:59:00"));
		eventoTest.setPrecio(18.0);
		eventoTest.setMusica("Hip-Hop");
		eventoTest.setNormas("Código de vestimenta y prohibido acosar a nadie");
		eventoTest.setSala(salaA);

		control.anadirEvento(eventoTest);

		// Obtener la longitud del listado de eventos después de agregar un nuevo evento
		int longitudDespues = control.listadoEventos().size();

		// Verificar que la longitud después de agregar sea mayor que la longitud antes
		// de agregar
		assertTrue(longitudDespues > longitudAntes);

		// Verificar que la longitud después de agregar sea mayor que la longitud antes
		// de agregar
		assertTrue(longitudDespues > longitudAntes);

	}
	
	/**
	 * Prueba para verificar si el listado de eventos devuelto por el servicio es
	 * igual a la longitud de la base de datos filtrado por un género.
	 *
	 * <p>Se verifica que el número de eventos devueltos por el servicio coincida con el número de eventos en la base de datos filtrado por género.</p>
	 */
	
	@Test
	public void longitudListadoPorGenero() {
		logger.info("Test::longitudListadoPorGenero(): Que la cantidad de eventos del género a mostrar por el servicio sea igual a la longitud de la base de datos del género");
		
		String musica = "Rock";
		//número de eventos del género en la base de datos.
		List<Evento> listado = dao.findByMusica(musica);
		
		//número de eventos del género devueltos por un servicio
		List<EventoResponse> test = control.listadoEventosPorMusica(musica);

		//esta prueba unitaria verifica si el número de eventos devueltos por género por un servicio es igual al número de eventos en la base de datos por un género.
		assertTrue(test.size() == listado.size());
	 }
	
}
