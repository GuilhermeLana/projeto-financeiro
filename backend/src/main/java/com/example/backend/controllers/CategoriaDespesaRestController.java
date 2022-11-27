package com.example.backend.controllers;

import com.example.backend.entity.CategoriaDespesaEntity;
import com.example.backend.services.CategoriaDespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriaDespesaRestController {

    @Autowired
    CategoriaDespesaService categoriaDespesaService;

    @GetMapping(value = "/categorias/despesa")
    public ResponseEntity<List<CategoriaDespesaEntity>> buscarCategorias() {
        List<CategoriaDespesaEntity> categoriaDespesaList = categoriaDespesaService.buscarCategorias();
        return ResponseEntity.status(HttpStatus.OK).body(categoriaDespesaList);
    }

    @PostMapping(value = "/categorias/despesa/adicionar")
    public ResponseEntity<CategoriaDespesaEntity> adicionarCategoria(CategoriaDespesaEntity categoriaDespesa) {
        CategoriaDespesaEntity ret = categoriaDespesaService.adicionarCategoria(categoriaDespesa);
        return ResponseEntity.status(HttpStatus.OK).body(ret);
    }

    @DeleteMapping(value = "/categorias/despesa/excluir")
    public ResponseEntity<HttpStatus> excluirCategoria(@RequestParam Long id) {
        categoriaDespesaService.excluirCategoria(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping(value = "/categorias/despesa/editar")
    public ResponseEntity<CategoriaDespesaEntity> editarCategoria(CategoriaDespesaEntity categoriaDespesa) {
        CategoriaDespesaEntity ret = categoriaDespesaService.editarCategoria(categoriaDespesa);
        return ResponseEntity.status(HttpStatus.OK).body(ret);
    }



}
