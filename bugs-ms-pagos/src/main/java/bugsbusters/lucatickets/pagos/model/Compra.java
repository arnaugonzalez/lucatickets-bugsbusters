package bugsbusters.lucatickets.pagos.model;

import jakarta.validation.constraints.NotEmpty;

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
 * Compra del sistema LucaTickets

 */
@Entity
@Table(name="compra")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Compra {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_compra")
	private Long id_compra;

	@NotEmpty(message = "Debe haber un id para el usuario que compra")
	private Long id_usuario;
	
	@NotEmpty(message = "Debe haber un id para el evento del que se compran entradas")
	private Long id_evento;
	
	@NotEmpty(message = "El nombre del usuario no puede estar vacío")
	private String nombre_usuario;
	
	@NotEmpty(message = "El nombre del evento no puede estar vacío")
	private String nombre_evento;
	
	@NotEmpty(message = "El precio no puede estar vacío")
	private double precio;
	
	@NotEmpty(message = "La cantidad no puede estar vacía")
	private int cantidad;
		

}
