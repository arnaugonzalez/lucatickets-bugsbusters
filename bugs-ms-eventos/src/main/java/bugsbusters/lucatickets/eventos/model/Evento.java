package bugsbusters.lucatickets.eventos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "eventos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_evento")
	private Long id;
	
	@NotEmpty(message = "El nombre no puede estar vacío")
	private String nombre;
	
	@NotEmpty(message = "Tiene que haber una descripción corta")
	private String descripcion_corta;
	
	@NotEmpty(message = "Tiene que haber una descripción larga")
	private String descripcion_extendida;
	
	@NotEmpty(message = "El evento tiene que tener una imagen de visualización")
	private String foto;
	
	@NotEmpty(message = "No puede faltar la fecha del evento")
	private String fecha;
	
	@NotEmpty(message = "No puede faltar la hora del evento")
	private String hora;
	
	@NotEmpty(message = "Hay que tener beneficios o entramos en bancarrota")
	private double precio;
	
	@NotEmpty(message = "No hay unas normas establecidas para el evento")
	private String normas;
	
	@NotEmpty(message = "Un evento tiene que poseer una sala donde poder realizarse")
	@OneToOne
	@JoinColumn(name = "id_sala", unique = true)
	private Sala sala;
}
