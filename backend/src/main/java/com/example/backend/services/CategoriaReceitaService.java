package com.example.backend.services;

import com.example.backend.entity.CategoriaReceitaEntity;
import com.example.backend.repositories.CategoriaReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaReceitaService {

    @Autowired
    private CategoriaReceitaRepository categoriaReceitaRepository;

    public CategoriaReceitaEntity adicionarCategoria(CategoriaReceitaEntity categoriaReceita){
        return categoriaReceitaRepository.save(categoriaReceita);
    }
}
