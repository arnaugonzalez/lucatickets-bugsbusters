package bugsbusters.lucatickets.pagos.model;

import javax.validation.constraints.NotEmpty;



import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Tarjeta del sistema LucaTickets

 */
@Entity
@Table(name="compras")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tarjeta {
	
	
	@NotEmpty(message = "El nombre del titular de la tarjeta no puede estar vacío")
	private String nombreTitular;
	
	@NotEmpty(message = "El numero de la tarjeta no puede estar vacío")
	private String numeroTarjeta;
	
	@NotEmpty(message = "El mes de caducidad de la tarjeta no puede estar vacío")
	private String mesCaducidad;
	
	@NotEmpty(message = "El año de caducidad de la tarjeta no puede estar vacío")
	private String añoCaducidad;
	
	@NotEmpty(message = "El CVV de la tarjeta no puede estar vacío")
	private String cvv;
	

}