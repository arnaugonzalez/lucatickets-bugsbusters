package bugsbusters.lucatickets.eventos.model;

@Entity
@Table(name = "sala")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sala {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sala")
	private Long id;
	
	@NotEmpty(message = "El nombre no puede estar vacío")
	private String nombre;
	
	@NotEmpty(message = "Falta una ciudad establecida")
	private String ciudad;
	
	@NotEmpty(message = "No se ha introducido una dirección")
	private String direccion;
	
	@NotEmpty(message = "Tiene que haber un tipo de recinto")
	private String tipo_recinto;
	
	@NotEmpty(message = "Aforo es nulo. Pon un valor correcto")
	@Positive(message = "El valor del aforo tiene que ser positivo")
	@Min(value = 1, message = "El aforo tiene que ser como mínimo 1")
	private int aforo;
}
