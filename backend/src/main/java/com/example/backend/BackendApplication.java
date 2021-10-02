package com.example.backend;

import com.example.backend.domain.Categoria;
import com.example.backend.domain.Lancamento;
import com.example.backend.enums.ETipoCategoria;
import com.example.backend.repositories.CategoriaRepository;
import com.example.backend.repositories.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

;
import java.text.SimpleDateFormat;
import java.util.Arrays;


@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public static void main(String[] args) {

        SpringApplication.run(BackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Categoria categoria1 = new Categoria(null, "Salário", ETipoCategoria.RECEITA);
        Categoria categoria2 = new Categoria(null, "Alimentação", ETipoCategoria.DESPESA);

        categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));

        Lancamento lancamento1 = new Lancamento(null, simpleDateFormat.parse("2021-10-10"),
                100d,"Angeloni",categoria2,simpleDateFormat.parse("2021-10-02"));
        Lancamento lancamento2 = new Lancamento(null, simpleDateFormat.parse("2021-10-10"),
                1000d,"Paytrack",categoria1,simpleDateFormat.parse("2021-10-02"));

        lancamentoRepository.saveAll(Arrays.asList(lancamento1,lancamento2));

    }
}
