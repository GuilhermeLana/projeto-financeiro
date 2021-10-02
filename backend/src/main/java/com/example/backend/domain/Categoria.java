package com.example.backend.domain;

import com.example.backend.enums.ETipoCategoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Categoria implements Serializable {
    private static final long serialVerionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private ETipoCategoria tipoCategoria;

    @OneToMany(mappedBy = "categoria")
    private List<Lancamento> lancamentos = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(Integer id, String nome, ETipoCategoria tipoCategoria) {
        this.id = id;
        this.nome = nome;
        this.tipoCategoria = tipoCategoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ETipoCategoria getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(ETipoCategoria tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return id.equals(categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
