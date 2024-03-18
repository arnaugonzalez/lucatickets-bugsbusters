package bugsbusters.lucatickets.eventos.model.response;

import java.io.Serializable;

import bugsbusters.lucatickets.eventos.model.Sala;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa la respuesta de un evento.
 * <p>
 * Esta clase proporciona una estructura de datos para la respuesta de un
 * evento, que incluye información como el nombre, la descripción, la foto, la
 * fecha, etc.
 * </p>
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class EventoResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * El identificador de evento.
	 */
	
	private long id;
	
	/**
	 * El nombre del evento.
	 */
	private String nombre;

	/**
	 * La descripción corta del evento.
	 */
	private String descripcion_corta;

	/**
	 * La descripción extendida del evento.
	 */
	private String descripcion_extendida;

	/**
	 * La URL de la foto del evento.
	 */
	private String foto;

	/**
	 * La fecha del evento.
	 */
	private String fecha;

	/**
	 * La hora del evento.
	 */
	private String hora;

	/**
	 * El precio del evento.
	 */
	private double precio;
	
	/**
	 * La música del evento.
	 */
	private String musica;

	/**
	 * Las normas del evento.
	 */
	private String normas;

	/**
	 * La sala donde se realiza el evento.
	 */
	private Sala sala;

	/**
	 * La ciudad donde se realiza el evento.
	 */
	private String ciudad;

}
