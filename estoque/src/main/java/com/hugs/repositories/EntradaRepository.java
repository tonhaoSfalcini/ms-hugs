package com.hugs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hugs.entities.Entrada;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long>{



}
