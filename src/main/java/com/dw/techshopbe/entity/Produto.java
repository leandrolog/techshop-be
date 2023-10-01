package com.dw.techshopbe.entity;

public class Produto {

    private String nome;
    private Integer quantity;
    private Long codigo;

    public Produto(String nome, Integer quantity, Long codigo) {
        this.nome = nome;
        this.quantity = quantity;
        this.codigo = codigo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
