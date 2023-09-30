package com.dw.techshopbe.service;

import com.dw.techshopbe.entity.Pedido;
import com.dw.techshopbe.entity.Produto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LojaService {


    private List<Produto> produtos;
    private List<Pedido> pedidos;


    public void removePedido(Pedido pedido) {
        for (Pedido p : pedidos) {
            if (pedido.getCodigo().equals(p.getCodigo())) {
                pedidos.remove(p);
                break;
            }
        }
    }

    public Pedido pedidoEdit(Pedido pedido) {
        Pedido pedidoToEdit = null;
        for (Pedido p : pedidos) {
            if (p.getCodigo().equals(pedido.getCodigo())) {
                pedidoToEdit = pedido;
                break;
            }
        }
        return pedidoToEdit;
    }

    public Pedido addPedido(Pedido pedido) {
        pedidos.add(pedido);
        return pedido;
    }


    public Produto produtoDetail(Produto produto) {
        Produto produtoMatch = null;
        for (Produto p : produtos) {
            if (p.getNome().equals(produto)) {
                produtoMatch = produto;
                break;
            }
        }
        return produtoMatch;
    }

    public List<Produto> produtoList() {
        if (!produtos.isEmpty()) {
            return produtos;
        }
        return null;
    }

    public void addProduto(Produto produto) {
        if (!produtos.isEmpty()) {
            produtos.add(produto);
        }
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "produtos=" + produtos +
                '}';
    }

}
