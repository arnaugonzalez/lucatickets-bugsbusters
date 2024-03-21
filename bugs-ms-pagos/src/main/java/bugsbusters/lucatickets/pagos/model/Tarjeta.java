package bugsbusters.lucatickets.pagos.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Tarjeta del sistema LucaTickets

 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tarjeta {
	
	
	@NotEmpty(message = "El nombre del titular de la tarjeta no puede estar vacío")
	private String nombreTitular;
	
	@Pattern(regexp="\\d{4}-\\d{4}-\\d{4}-\\d{4}", message = "El numero de tarjeta debe tener este formato: 4444-4444-4444-4444")
	@NotEmpty(message = "El numero de la tarjeta no puede estar vacío")
	private String numeroTarjeta;
	
	@NotNull(message = "El mes de caducidad de la tarjeta no puede estar vacío")
	private int mesCaducidad;
	
	@NotNull(message = "El año de caducidad de la tarjeta no puede estar vacío")
	private int yearCaducidad;
	
	@NotNull(message = "El CVV de la tarjeta no puede estar vacío")
	private int cvv;
	

}
