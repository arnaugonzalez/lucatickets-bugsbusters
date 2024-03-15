package bugsbusters.lucatickets.eventos.model.response;

import java.io.Serializable;

import bugsbusters.lucatickets.eventos.model.Sala;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class EventoResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private String descripcion_corta;
	private String descripcion_extendida;
	private String foto;
	private String fecha;
	private String hora;
	private double precio;
	private String normas;
	private Sala sala;
	private String ciudad;
	

}
