package com.hugs.services;

import java.util.List;

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
		
		return save(cidade);
 	}
	
	public Cidade getById(Long id) {
		return repository.getOne(id);
	}
	
	public List<Cidade> getAll(){
		return repository.findAll();
	}

	public List<Cidade> findByUfId(Long id) {
		return repository.findByEstadoIdEquals(id);
	}

	public Cidade save(Cidade obj) {

		Cidade result = repository.save(obj);
		
		return result;
	}

	public List<Cidade> saveAll(List<Cidade> obj) {
		
		return repository.saveAll(obj);
	}
}
