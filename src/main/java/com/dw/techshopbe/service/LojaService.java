package com.dw.techshopbe.service;

import com.dw.techshopbe.entity.Pedido;
import com.dw.techshopbe.entity.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LojaService {


    private List<Produto> produtos;
    private List<Pedido> pedidos;

    public LojaService() {
        this.produtos = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public Produto produtoDetail(Long codigo) {
        Produto produtoMatch = null;
        if (!produtos.isEmpty()) {
            for (Produto p : produtos) {
                if (p.getCodigo().equals(codigo)) {
                    produtoMatch = p;
                    break;
                }
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
        produtos.add(produto);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "produtos=" + produtos +
                '}';
    }

}
