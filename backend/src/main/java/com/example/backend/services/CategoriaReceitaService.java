package com.example.backend.services;

import com.example.backend.entity.CategoriaReceitaEntity;
import com.example.backend.repositories.CategoriaReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaReceitaService {

    @Autowired
    private CategoriaReceitaRepository categoriaReceitaRepository;

    public CategoriaReceitaEntity adicionarCategoria(CategoriaReceitaEntity categoriaReceita){
        categoriaReceitaRepository.save(categoriaReceita);
        return categoriaReceita;
    }

    public List<CategoriaReceitaEntity> buscarCategoria(){
        List<CategoriaReceitaEntity> categoriaReceitaList = categoriaReceitaRepository.findAll();
        return categoriaReceitaList;
    }

    public void excluirCategoria(Long id) {
        categoriaReceitaRepository.deleteById(id);
    }

    public CategoriaReceitaEntity editarCategoria(CategoriaReceitaEntity categoriaReceita) {
        Optional<CategoriaReceitaEntity> categoriaReceitaBase = categoriaReceitaRepository.findById(categoriaReceita.getId());
        categoriaReceitaBase.ifPresent(c -> {
            c.setNome(categoriaReceita.getNome());
            categoriaReceitaRepository.save(c);
        });
        return categoriaReceitaBase.orElse(null);
    }
}
