package com.example.backend.services;

import com.example.backend.domain.Categoria;
import com.example.backend.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscarCategoria(Integer id) {
        return categoriaRepository.findById(id).orElse(null);
    }
}
