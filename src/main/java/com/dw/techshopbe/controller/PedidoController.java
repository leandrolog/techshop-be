package com.dw.techshopbe.controller;

import com.dw.techshopbe.entity.Pedido;
import com.dw.techshopbe.entity.Produto;
import com.dw.techshopbe.service.LojaService;
import com.dw.techshopbe.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private LojaService lojaService;


    @PostMapping("/pedido")
    public ResponseEntity<?> fazerPedido(@RequestBody Pedido pedido) {
        try {
            Pedido novoPedido = pedidoService.addPedido(pedido);
            return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>("Falha ao fazer pedido!", HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/pedidos")
    public ResponseEntity<?> buscarTodosPedidos() {
        try {
            List<Pedido> pedidos = pedidoService.pedidoList();
            if (pedidos != null) {
                return new ResponseEntity<>(pedidos, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Nenhum pedido encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception exception) {
            return new ResponseEntity<>("Erro ao buscar pedidos", HttpStatus.BAD_GATEWAY);
        }
    }

    @PutMapping("/pedido")
    public ResponseEntity<?> produtoEdit(@RequestBody Pedido pedido) {
        try {
            Pedido novoPedido = pedidoService.pedidoEdit(pedido);
            if (novoPedido != null) {
                return new ResponseEntity<>(novoPedido, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Pedido não encontrado ou contém produtos inválidos", HttpStatus.NOT_FOUND);
            }
        } catch (Exception exeption) {
            return new ResponseEntity<>("Falha ao editar pedido", HttpStatus.BAD_GATEWAY);
        }
    }

    @DeleteMapping("/pedido/{codigo}")
    public List<Pedido> deleteProduto(@PathVariable("codigo") Long codigo) {
        return pedidoService.removePedido(codigo);
    }

}
