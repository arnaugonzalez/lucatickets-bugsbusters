package bugsbusters.lucatickets.eventos.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa un evento en el sistema LucaTickets. Esta clase contiene
 * información sobre un evento, como su nombre, descripción, fecha, hora,
 * precio, etc.
 */

@Entity
@Table(name = "eventos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Evento {

	/**
	 * Identificador único del evento.
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_evento")
	private Long id;

	/**
	 * El nombre del evento.
	 */
	@NotEmpty(message = "El nombre no puede estar vacío")
	private String nombre;

	/**
	 * La descripción corta del evento.
	 */
	@NotEmpty(message = "Tiene que haber una descripción corta")
	private String descripcion_corta;

	/**
	 * La descripción extendida del evento.
	 */
	@NotEmpty(message = "Tiene que haber una descripción larga")
	private String descripcion_extendida;

	/**
	 * La URL de la imagen del evento.
	 */
	@NotEmpty(message = "Debe contener el link de una imagen")
	private String foto;

	/**
	 * La fecha del evento.
	 */
	@NotEmpty(message = "Debe ser una fecha en formato YYYY-MM-DD")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fecha;

	/**
	 * La hora del evento.
	 */
	@NotEmpty(message = "Debe ser una hora en formato HH:MM:ss")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime hora;

	/**
	 * El precio del evento.
	 */
	@NotEmpty(message = "Hay que tener beneficios o entramos en bancarrota")
	private double precio;

	/**
	 * La música del evento.
	 */
	@NotEmpty(message = "Debe haber un género de música en el evento")
	private String musica;
	
	/**
	 * Las normas del evento.
	 */
	@NotEmpty(message = "No hay unas normas establecidas para el evento")
	private String normas;

	/**
	 * La sala donde se realiza el evento.
	 */
	@NotEmpty(message = "Un evento tiene que poseer una sala donde poder realizarse")
	@OneToOne
	@JoinColumn(name = "id_sala", unique = true)
	private Sala sala;
}
