package com.example.backend.entity;

import com.example.backend.enums.ETipoLancamento;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@Entity
public class LancamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double valor;
    private LocalDateTime dataLancamento;
    private ETipoLancamento tipoLancamento;

    @ManyToOne
    private CategoriaDespesaEntity categoriaDespesa;

    @ManyToOne
    private CategoriaReceitaEntity categoriaReceita;

    private Boolean fixa;
}
