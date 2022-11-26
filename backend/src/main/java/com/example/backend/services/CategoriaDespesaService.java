package com.example.backend.services;

import com.example.backend.entity.CategoriaDespesaEntity;
import com.example.backend.repositories.CategoriaDespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaDespesaService {

    @Autowired
    private CategoriaDespesaRepository categoriaDespesaRepository;

    public CategoriaDespesaEntity adicionarCategoria(CategoriaDespesaEntity categoriaDespesa){
        return categoriaDespesaRepository.save(categoriaDespesa);
    }
}
