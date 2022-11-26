package com.example.backend.services;

import com.example.backend.entity.LancamentoEntity;
import com.example.backend.repositories.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public LancamentoEntity adicionarLancamento(LancamentoEntity lancamento){
        return lancamentoRepository.save(lancamento);
    }

    public List<LancamentoEntity> buscarLancamentos() {
        return lancamentoRepository.findAll();
    }

    public void excluirLancamento(Long id) {
        lancamentoRepository.deleteById(id);
    }

    public LancamentoEntity editarLancamento(LancamentoEntity lancamento){
        Optional<LancamentoEntity> lancamentoBase = lancamentoRepository.findById(lancamento.getId());
        lancamentoBase.ifPresent(l -> {
            l.setDataLancamento(lancamento.getDataLancamento());
            l.setTipoLancamento(lancamento.getTipoLancamento());
            l.setCategoriaDespesa(lancamento.getCategoriaDespesa());
            l.setFixa(lancamento.getFixa());
            l.setValor(lancamento.getValor());
            l.setCategoriaReceita(lancamento.getCategoriaReceita());
            l.setTipoLancamento(lancamento.getTipoLancamento());
            lancamentoRepository.save(l);
        });
        return lancamentoBase.orElse(null);
    }
}
