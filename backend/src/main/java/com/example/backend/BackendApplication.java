package com.example.backend;

import com.example.backend.domain.Categoria;
import com.example.backend.enums.ETipoCategoria;
import com.example.backend.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public static void main(String[] args) {

        SpringApplication.run(BackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria categoria1 = new Categoria(null, "Salário", ETipoCategoria.RECEITA);
        Categoria categoria2 = new Categoria(null, "Alimentação", ETipoCategoria.DESPESA);

        categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));

    }
}
