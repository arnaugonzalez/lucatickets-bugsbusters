package bugsbusters.lucatickets.pagos.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class Credenciales {

	private String user;
	private String password;
}
