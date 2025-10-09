package com.example.tamaterapias_trabajofinal.service;


import com.example.tamaterapias_trabajofinal.DTO.PedidoDTO;
import com.example.tamaterapias_trabajofinal.mapper.PedidoMapper;
import com.example.tamaterapias_trabajofinal.modelo.Pedido;
import com.example.tamaterapias_trabajofinal.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoMapper pedidoMapper;

    /**
     * Sirve para buscar un pedido en concreto
     * @param id
     * @return un pedidoDTO o lanza una excepcion
     */
    public PedidoDTO obtenerPedidoPorId(Integer id){
        Pedido p = pedidoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Pedido no encontrado con la id que me ha s dado " +id ));
        return pedidoMapper.pedidoToDTO(p);
    }

    /**
     * Lista los pedidos que tenermos
     * @return un set, con todos los pedidos
     */
    public Set<PedidoDTO> obtenerPedidos(){
        return pedidoRepository.findAll()
                .stream().map(pedidoMapper::pedidoToDTO)
                .collect(Collectors.toSet());
    }

    /**
     * Función para crear un Pedido que nos pasan por parámetro
     * @param pedido
     * @return el pedido una vez ya guardado
     */
    public Pedido crearPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    /**
     * Busca si existe, si existe, devuelve true y elimina el pedido
     * si no , devuelve false
     * @param id
     */
    public boolean eliminarPedido(Integer id){
        if(pedidoRepository.existsById(id)){
            pedidoRepository.deleteById(id);
            return true;
        }
        return  false;

    }


}
