package com.hugs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hugs.dto.EstadoDTO;
import com.hugs.entities.Estado;
import com.hugs.repositories.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	EstadoRepository repository;
	
	public Estado save(EstadoDTO dto) {
		Estado estado = new Estado(dto);
		
		Estado result = repository.save(estado);
		
		return result;
 	}
	
	public Estado getById(Long id) {
		return repository.getOne(id);
	}

	public List<Estado> getAll(){
		return repository.findAll();
	}
}