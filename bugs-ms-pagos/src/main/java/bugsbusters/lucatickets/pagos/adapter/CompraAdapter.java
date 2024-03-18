package bugsbusters.lucatickets.pagos.adapter;

import org.springframework.stereotype.Component;

import bugsbusters.lucatickets.pagos.model.Compra;
import bugsbusters.lucatickets.pagos.model.response.EventoResponse;
import bugsbusters.lucatickets.pagos.model.response.UsuarioResponse;

@Component
public class CompraAdapter {
	
    public Compra de(UsuarioResponse usuario,
    							EventoResponse evento,
    							Integer cantidad,
    							double precio) {
    	
        Compra compraDTO = new Compra();
        compraDTO.setId_usuario(usuario.getId());
        compraDTO.setId_evento(evento.getId());
        compraDTO.setNombre_usuario(usuario.getNombre() + usuario.getApellido());
        compraDTO.setNombre_evento(evento.getNombre());
        compraDTO.setPrecio(precio);
        compraDTO.setCantidad(cantidad);

        return compraDTO;
    }
}
