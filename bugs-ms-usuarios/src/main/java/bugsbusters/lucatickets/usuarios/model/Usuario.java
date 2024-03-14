package bugsbusters.lucatickets.usuarios.model;

import bugsbusters.lucatickets.eventos.model.Column;
import bugsbusters.lucatickets.eventos.model.GeneratedValue;
import bugsbusters.lucatickets.eventos.model.Id;
import bugsbusters.lucatickets.eventos.model.NotEmpty;
import bugsbusters.lucatickets.eventos.model.Sala;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_evento")
	private Long id;
	
	@NotEmpty(message = "El nombre no puede estar vacío")
	private String nombre;
	
	@NotEmpty(message = "El apellido no puede estar vacío")
	private String apellido;
	
	@NotEmpty(message = "El email no puede estar vacío")
	private String email;
	
	@NotEmpty(message = "Contrasena debe ser correcta")
	private String contrasena;
	
	@NotEmpty(message = "La fecha debe estar en formato correcto")
	private String fecha_alta;
}
