package com.example.backend.controllers;

import com.example.backend.entity.CategoriaReceitaEntity;
import com.example.backend.services.CategoriaReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriaReceitaRestController {

    @Autowired
    private CategoriaReceitaService categoriaReceitaService;

    @GetMapping(value = "/categorias/receita")
    public ResponseEntity<List<CategoriaReceitaEntity>> buscarCategoria() {
        List<CategoriaReceitaEntity> categoriaReceitaList = categoriaReceitaService.buscarCategoria();
        return ResponseEntity.status(HttpStatus.OK).body(categoriaReceitaList);
    }

    @PostMapping(value = "/categorias/receita/adicionar")
    public ResponseEntity<CategoriaReceitaEntity> adicionarCategoria(@RequestBody CategoriaReceitaEntity categoriaReceita) {
        CategoriaReceitaEntity ret = categoriaReceitaService.adicionarCategoria(categoriaReceita);
        return ResponseEntity.status(HttpStatus.OK).body(ret);
    }

    @DeleteMapping(value = "/categorias/receita/excluir")
    public ResponseEntity<HttpStatus> excluirCategoria(@RequestParam Long id){
        categoriaReceitaService.excluirCategoria(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping(value = "/categorias/receita/editar")
    public ResponseEntity<CategoriaReceitaEntity> editarCategoria(@RequestBody CategoriaReceitaEntity categoriaReceita){
        CategoriaReceitaEntity ret = categoriaReceitaService.editarCategoria(categoriaReceita);
        return ResponseEntity.status(HttpStatus.OK).body(ret);
    }
}
