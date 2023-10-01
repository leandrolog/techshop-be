package com.dw.techshopbe.entity;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<Produto> produtos;
    private Long codigo;

    public Pedido(Long codigo) {
        this.produtos = new ArrayList<>();
        this.codigo = codigo;
    }

    public Pedido() {
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
}
