package bugsbusters.lucatickets.usuarios.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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
	@Column(unique = true)
	@Email(message="Formato incorrecto para el email")
	private String email;
	
	@NotEmpty(message = "Contrasena debe ser correcta")
	private String contrasena;
	
	@NotEmpty(message = "La fecha debe estar en formato correcto")
	@Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "La fecha debe estar en formato dd/MM/yyyy")
	private String fecha_alta;
}

