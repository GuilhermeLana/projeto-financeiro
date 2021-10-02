package com.example.backend.resources;

import com.example.backend.domain.Categoria;
import com.example.backend.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscarCategoria(@PathVariable Integer id) {
        Categoria categoria = categoriaService.buscarCategoria(id);
        return ResponseEntity.ok().body(categoria);
    }
}
