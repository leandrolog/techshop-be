package com.dw.techshopbe.entity;

public class Produto {

    private String nome;
    private Integer quantity;

    public Produto(String nome, Integer quantity) {
        this.nome = nome;
        this.quantity = quantity;
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
