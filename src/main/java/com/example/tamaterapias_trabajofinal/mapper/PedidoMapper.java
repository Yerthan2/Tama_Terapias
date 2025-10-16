package com.example.tamaterapias_trabajofinal.mapper;

import com.example.tamaterapias_trabajofinal.DTO.DetallePedidoDTO;
import com.example.tamaterapias_trabajofinal.DTO.PedidoDTO;
import com.example.tamaterapias_trabajofinal.modelo.DetallePedido;
import com.example.tamaterapias_trabajofinal.modelo.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PedidoMapper {

    @Autowired
    private DetallePedidoMapper detallePedidoMapper;

    public PedidoDTO pedidoToDTO(Pedido pedido){
        PedidoDTO dto = new PedidoDTO();

        dto.setIdPedido(pedido.getIdPedido());
        dto.setNombreUsuario(pedido.getUsuario().getNombre() + " " +
                pedido.getUsuario().getApellido1() + " " +
                pedido.getUsuario().getApellido2());
        dto.setFechaPedido(pedido.getFechaPedido());
        dto.setTotal(pedido.getSubtotal());
        dto.setEstadoPedido(pedido.getEstadoPedido().toString());

        Set<DetallePedidoDTO> detalleDTOs = pedido.getDetalles().stream()
                .map(detallePedidoMapper::toDto)
                .collect(Collectors.toSet());

        dto.setDetalles(detalleDTOs);
        Integer productosTotal = pedido.getDetalles().stream()
                .mapToInt(DetallePedido::getCantidad)
                .sum();
        dto.setTotalProductos(productosTotal);
        return dto;
    }
}
