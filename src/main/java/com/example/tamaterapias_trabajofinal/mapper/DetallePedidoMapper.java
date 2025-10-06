package com.example.tamaterapias_trabajofinal.mapper;

import com.example.tamaterapias_trabajofinal.DTO.DetallePedidoDTO;
import com.example.tamaterapias_trabajofinal.modelo.DetallePedido;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public class DetallePedidoMapper {

    public DetallePedidoDTO toDto(DetallePedido detallePedido){
        DetallePedidoDTO detallePedidoDTO = new DetallePedidoDTO();
        detallePedidoDTO.setNombreProducto(detallePedido.getProducto().getNombreProducto());
        detallePedidoDTO.setImagenProducto(detallePedido.getProducto().getImagen());
        detallePedidoDTO.setCantidad(detallePedido.getCantidad());
        detallePedidoDTO.setSubtotal(detallePedido.getSubtotal());
        return detallePedidoDTO;
    }
}
