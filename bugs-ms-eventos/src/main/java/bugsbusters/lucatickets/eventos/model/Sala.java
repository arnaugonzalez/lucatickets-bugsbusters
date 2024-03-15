package bugsbusters.lucatickets.eventos.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Clase que representa una sala en el sistema LucaTickets.
 * Esta clase contiene información sobre una sala, como su nombre, ciudad, dirección, tipo de recinto, aforo, etc.
 */
@Entity
@Table(name = "sala")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sala {
	
    /**
     * Identificador único de la sala.
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sala")
	private Long id;
	
    /**
     * El nombre de la sala.
     */
	@NotEmpty(message = "El nombre no puede estar vacío")
	private String nombre;
	
    /**
     * La ciudad donde se encuentra la sala.
     */
	@NotEmpty(message = "Falta una ciudad establecida")
	private String ciudad;
	
    /**
     * La dirección de la sala.
     */
	@NotEmpty(message = "No se ha introducido una dirección")
	private String direccion;
	
    /**
     * El tipo de recinto de la sala.
     */
	@NotEmpty(message = "Tiene que haber un tipo de recinto")
	private String tipo_recinto;
	
    /**
     * El aforo de la sala.
     */
	@NotEmpty(message = "Aforo es nulo. Pon un valor correcto")
	@Positive(message = "El valor del aforo tiene que ser positivo")
	@Min(value = 1, message = "El aforo tiene que ser como mínimo 1")
	private int aforo;
}
