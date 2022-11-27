package com.example.backend.services;

import com.example.backend.entity.CategoriaDespesaEntity;
import com.example.backend.repositories.CategoriaDespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaDespesaService {

    @Autowired
    private CategoriaDespesaRepository categoriaDespesaRepository;

    public CategoriaDespesaEntity adicionarCategoria(CategoriaDespesaEntity categoriaDespesa){
        return categoriaDespesaRepository.save(categoriaDespesa);
    }

    public List<CategoriaDespesaEntity> buscarCategorias() {
        return categoriaDespesaRepository.findAll();
    }

    public void excluirCategoria(Long id){
        categoriaDespesaRepository.deleteById(id);
    }

    public CategoriaDespesaEntity editarCategoria(CategoriaDespesaEntity categoriaDespesa) {
        Optional<CategoriaDespesaEntity> categoriaDespesaBase = categoriaDespesaRepository.findById(categoriaDespesa.getId());
        categoriaDespesaBase.ifPresent(c -> {
            c.setNome(categoriaDespesa.getNome());
            categoriaDespesaRepository.save(c);
        });
        return categoriaDespesaBase.orElse(null);
    }
}
