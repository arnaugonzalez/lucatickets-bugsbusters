package bugsbusters.lucatickets.usuarios.model.response;

import java.io.Serializable;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UsuarioResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private String apellido;
	private String email;
	private String contraseña;
	private String fecha_alta;

}
