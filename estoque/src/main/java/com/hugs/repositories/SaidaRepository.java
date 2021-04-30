package com.hugs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hugs.entities.Saida;

@Repository
public interface SaidaRepository extends JpaRepository<Saida, Long>{


}
