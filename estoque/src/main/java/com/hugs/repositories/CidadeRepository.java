package com.hugs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hugs.entities.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{

	
}
