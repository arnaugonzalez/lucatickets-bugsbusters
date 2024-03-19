package bugsbusters.lucatickets.pagos.model.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UsuarioResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * El identificador de evento.
	 */
	
	private long id;
	
	private String nombre;
	private String apellido;
	private String email;
	private String contrasena;
	private String fecha_alta;

}
