package com.dw.techshopbe.controller;


import com.dw.techshopbe.entity.Produto;
import com.dw.techshopbe.service.LojaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LojaController {

    private LojaService lojaService;

    @PostMapping("/produto")
    public ResponseEntity<?> saveProduto(@RequestBody Produto produto){
        try{
            lojaService.addProduto(produto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao salvar produto", HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/produtos")
    public ResponseEntity<?> buscarTodosProdutos(){
        try{
            List<Produto> produtos = lojaService.produtoList();
            return new ResponseEntity<>(produtos, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao buscar produtos", HttpStatus.BAD_GATEWAY);
        }
    }

}
