package com.example.backend.controllers;

import com.example.backend.entity.LancamentoEntity;
import com.example.backend.services.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LancamentoRestController {

    @Autowired
    private LancamentoService lancamentoService;

    @GetMapping(value = "/lancamentos")
    public ResponseEntity<List<LancamentoEntity>> buscarLancamentos() {
        List<LancamentoEntity> lancamentos = lancamentoService.buscarLancamentos();
        return ResponseEntity.status(HttpStatus.OK).body(lancamentos);
    }

    @PostMapping(value = "/lancamentos/incluir")
    public ResponseEntity<LancamentoEntity> incluirLancamento(@RequestBody LancamentoEntity lancamento) {
        LancamentoEntity ret = lancamentoService.adicionarLancamento(lancamento);
        return ResponseEntity.status(HttpStatus.OK).body(ret);
    }

    @DeleteMapping(value = "/lancamentos/excluir")
    public ResponseEntity<HttpStatus> excluirLancamento(@RequestParam Long id){
        lancamentoService.excluirLancamento(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
