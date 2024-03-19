package bugsbusters.lucatickets.pagos.model.response;

import java.io.Serializable;
import java.util.List;

import bugsbusters.lucatickets.pagos.model.Pago;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa la respuesta de un pago.
 * Esta clase proporciona una estructura de datos para la respuesta de un pago, incluyendo información como la marca de tiempo, estado, mensaje de error, información adicional, etc.
 */

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ResultadoPagoResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	 /**
     * La marca de tiempo del pago.
     */
    private String timestamp;
    
    /**
     * El estado del pago.
     */
    private String status;
    
    /**
     * El mensaje de error del pago.
     */
    private String error;
 
    
    /**
     * El mensaje informativo del pago.
     */
    private List<String> message;
    
      
    /**
     * La información del pago.
     */
    private Pago info;
    
    
    /**
     * Información adicional del pago.
     */
    private String infoadicional;

}
