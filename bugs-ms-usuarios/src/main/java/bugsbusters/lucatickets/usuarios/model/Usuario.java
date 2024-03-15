package bugsbusters.lucatickets.usuarios.model;

import javax.validation.constraints.NotEmpty;

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
 * Usuario del sistema LucaTickets
 * @author adria
 */
@Entity
@Table(name="usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
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

