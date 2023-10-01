package com.dw.techshopbe.controller;


import com.dw.techshopbe.entity.Produto;
import com.dw.techshopbe.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LojaController {

    @Autowired
    private LojaService lojaService;

    @PostMapping("/produto")
    public ResponseEntity<?> saveProduto(@RequestBody Produto produto) {
        try {
            lojaService.addProduto(produto);
            return new ResponseEntity<>("Produto salvo no sistema", HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>("Erro ao salvar produto", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/produtos")
    public ResponseEntity<?> buscarTodosProdutos() {
        try {
            List<Produto> produtos = lojaService.produtoList();
            if (produtos != null) {
                return new ResponseEntity<>(produtos, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Nenhum produto encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception exception) {
            return new ResponseEntity<>("Erro ao buscar produtos", HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/produto/{codigo}")
    public ResponseEntity<?> buscarUmProduto(@PathVariable("codigo") Long codigo) {
        try {
            Produto produto = lojaService.produtoDetail(codigo);
            if (produto != null) {
                return new ResponseEntity<>(produto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Produto não encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception exception) {
            return new ResponseEntity<>("Produto não encontrado", HttpStatus.NOT_FOUND);
        }
    }

}
