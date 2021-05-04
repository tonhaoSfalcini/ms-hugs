package com.hugs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hugs.dto.CidadeIbgeDTO;
import com.hugs.entities.Cidade;
import com.hugs.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	CidadeRepository repository;
	
	public Cidade save(CidadeIbgeDTO dto) {
		Cidade cidade = new Cidade(dto);
		
		Cidade result = repository.save(cidade);
		
		return result;
 	}
}
