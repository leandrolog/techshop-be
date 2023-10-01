package com.dw.techshopbe.service;

import com.dw.techshopbe.entity.Pedido;
import com.dw.techshopbe.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private LojaService lojaService;
    private List<Pedido> pedidos;


    public PedidoService() {
        this.pedidos = new ArrayList<>();
    }

    public Pedido encontrarProdutosInvalidos(Pedido pedido) {

        List<Produto> produtosInvalidos = pedido.getProdutos().stream().filter(x -> lojaService.produtoDetail
                (x.getCodigo()) == null).toList();
        if (!produtosInvalidos.isEmpty()) {
            return null;
        } else {
            return pedido;
        }
    }


    public List<Pedido> removePedido(Long codigo) {

        List<Pedido> pedidoParaRemover = pedidos.stream().filter(x -> x.getCodigo().equals(codigo)).toList();
        pedidos.removeAll(pedidoParaRemover);
        return pedidos;
    }

    public Pedido pedidoEdit(Pedido pedido) {
        Pedido pedidoToEdit = pedidos.stream()
                .filter(x -> x.getCodigo().equals(pedido.getCodigo())).findFirst().orElseThrow(
                        () -> new RuntimeException("Pedido não encontrado"));
        return encontrarProdutosInvalidos(pedidoToEdit);
    }


    public Pedido addPedido(Pedido pedido) {
        List<Produto> produtoNaoCadastrados = pedido.getProdutos().stream()
                .filter(x -> lojaService.produtoDetail(x.getCodigo()) == null)
                .toList();

        if (!produtoNaoCadastrados.isEmpty()) {
            throw new IllegalArgumentException("Não foi possível adicionar o pedido. Produtos não cadastrados encontrados.");
        }

        pedidos.add(pedido);
        return pedido;
    }



    public List<Pedido> pedidoList() {
        if (!pedidos.isEmpty()) {
            return pedidos;
        }
        return null;
    }
}
