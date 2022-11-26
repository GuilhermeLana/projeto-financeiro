package com.example.backend.repositories;

import com.example.backend.entity.Teste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TesteRepo extends JpaRepository<Teste, Integer> {
}
