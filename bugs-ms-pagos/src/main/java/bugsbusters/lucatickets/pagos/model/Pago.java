package bugsbusters.lucatickets.pagos.model;

import jakarta.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Pago del sistema LucaTickets

 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pago {
	
	@NotEmpty(message = "El nombre del titular de la tarjeta no puede estar vacío")
	private String nombreTitular;
	
	@NotEmpty(message = "El numero de la tarjeta no puede estar vacío")
	private String numeroTarjeta;
	
	@NotEmpty(message = "El mes de caducidad de la tarjeta no puede estar vacío")
	private int mesCaducidad;
	
	@NotEmpty(message = "El año de caducidad de la tarjeta no puede estar vacío")
	private int yearCaducidad;
	
	@NotEmpty(message = "El CVV de la tarjeta no puede estar vacío")
	private int cvv;
	
	@NotEmpty(message = "El emisor no puede estar vacío")
	private String emisor;
	
	@NotEmpty(message = "El concepto no puede estar vacío")
	private String concepto;
	
	@NotEmpty(message = "la cantidad no puede estar vacío")
	private double cantidad;

	
}
