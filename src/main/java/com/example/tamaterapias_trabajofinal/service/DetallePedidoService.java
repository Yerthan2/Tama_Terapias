package com.example.tamaterapias_trabajofinal.service;

import com.example.tamaterapias_trabajofinal.DTO.DetallePedidoDTO;
import com.example.tamaterapias_trabajofinal.mapper.DetallePedidoMapper;
import com.example.tamaterapias_trabajofinal.modelo.DetallePedido;
import com.example.tamaterapias_trabajofinal.repository.DetallePedidoRepository;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class DetallePedidoService {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Autowired
    private DetallePedidoMapper detallePedidoMapper;

    /**
     * Sirve para listar todos los detallePedido
     * @return
     */
    public Set<DetallePedidoDTO> listarDetallePedido(){
        return detallePedidoRepository.findAll().stream()
                .map(detallePedidoMapper::toDto)
                .collect(Collectors.toSet());
    }

    /**
     * Sirve para buscar alguno en específico
     * @param id
     * @return
     */
    public DetallePedidoDTO obtenerPorId(Integer id) {
        DetallePedido detalle = detallePedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de pedido no encontrado con ID: " + id));
        return detallePedidoMapper.toDto(detalle);
    }


    /**
     * Sirve para eliminar un detalle pedido por su id
     * @param id
     */
    public void eliminarDetallePorId(Integer id){
        detallePedidoRepository.deleteById(id);
    }

}
