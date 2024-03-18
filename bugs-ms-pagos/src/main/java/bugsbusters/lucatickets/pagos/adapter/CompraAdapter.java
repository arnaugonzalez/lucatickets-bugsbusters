package bugsbusters.lucatickets.pagos.adapter;

import bugsbusters.lucatickets.pagos.model.Compra;


public class CompraAdapter {
    public static Compra de(Compra compra) {
        Compra compraDTO = new Compra();
        compraDTO.setId_compra(compra.getId_compra());
        compraDTO.setId_usuario(compra.getId_usuario());
        compraDTO.setId_evento(compra.getId_evento());
        compraDTO.setNombre_usuario(compra.getNombre_usuario());
        compraDTO.setNombre_evento(compra.getNombre_evento());
        compraDTO.setPrecio(compra.getPrecio());
        compraDTO.setCantidad(compra.getCantidad());

        return compraDTO;
    }
}