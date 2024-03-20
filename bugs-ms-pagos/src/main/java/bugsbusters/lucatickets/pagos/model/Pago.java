package bugsbusters.lucatickets.pagos.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
	
	@NotNull(message = "El mes de caducidad de la tarjeta no puede estar vacío")
	private int mesCaducidad;
	
	@NotNull(message = "El año de caducidad de la tarjeta no puede estar vacío")
	private int yearCaducidad;
	
	@NotNull(message = "El CVV de la tarjeta no puede estar vacío")
	private int cvv;
	
	@NotEmpty(message = "El emisor no puede estar vacío")
	private String emisor;
	
	@NotEmpty(message = "El concepto no puede estar vacío")
	private String concepto;
	
	@NotNull(message = "la cantidad no puede estar vacío")
	private double cantidad;

	
}
