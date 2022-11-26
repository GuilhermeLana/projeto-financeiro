package com.example.backend.repositories;

import com.example.backend.entity.LancamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<LancamentoEntity, Long> {
}
